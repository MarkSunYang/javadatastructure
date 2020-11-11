package com.Graph;

import java.util.Arrays;

public class Kruskal {
    /**
     * 克鲁斯卡尔算法：求加权连通图的最小生成树
     * 按照权值从小到大生成N-1条边，边不构成回路
     * 构造一个含n个顶点的森林，然后按照权值从小到大从连通网中选择加入到森林中，并使用森林中不产生回路，直到森林变成树
     * 问题：1.对图的所有边按照权值大小进行排序 2.记录顶点在最小生成树的终点
     * @param args
     */
    public static void main(String[] args) {

        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int matrix[][]={
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,0},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0},
        };

        Kruskal k=new Kruskal(data,matrix);
        k.show();

        EdgeData[] edges=k.getEdge();
        k.sortEdge(edges);
        System.out.println("xx"+Arrays.toString(edges) );
        k.kruskal();
    }

    private int edgeNum;//边的个数
    private char[] vertexes;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static final int INF=Integer.MAX_VALUE;//两个顶点不能连通

    public Kruskal(char[] vertexes,int[][] matrix){
        //初始化顶点 和 边
        int vlen=vertexes.length;
        this.vertexes=new char[vlen];
        for (int i = 0; i <vlen ; i++) {
            this.vertexes[i]=vertexes[i];
        }
        this.matrix=new int[vlen][vlen];//初始化边
        for (int i = 0; i <vlen ; i++) {
            for (int j = 0; j <vlen ; j++) {
                this.matrix[i][j]=matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i <vlen ; i++) {
            for (int j = i+1; j <vlen ; j++) {
                if(this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal(){
        int index=0;//表示最后结果的索引
        int[] ends=new int[edgeNum];//用于保存“已有最小生成树”中每个顶点在最小生成树中的终点
        //创建结果数组，保存最小生成树
        EdgeData[] res=new EdgeData[vertexes.length];
        EdgeData[] edges=new  EdgeData[edgeNum];
        sortEdge(edges);

        //遍历边的数组，将边添加到最小生成树，判断是否构成回路
        for (int i = 0; i <edgeNum; i++) {
            int p1=getPosition(edges[i].start);//获取到第i条边的第一个顶点
            int p2=getPosition(edges[i].end);//获取到第i条边的第二个顶点
            //判断当前
            int m=getEnd(ends,p1);
            int n=getEnd(ends,p2);
            if(m!=n){
               ends[m]=n;  //没有构成回路
                res[index++]=edges[i];
            }
        }

        //统计并打印最小生成树
        System.out.println(Arrays.toString(res));

    }

    public void show(){
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边排序
    private void sortEdge(EdgeData[] edges){
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length-1-i; j++) {
                if(edges[j].weight>edges[j+1].weight){
                    EdgeData tmp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=tmp;
                }
            }
        }
    }

    //返回顶点下标
    private int  getPosition(char ch){
        for (int i = 0; i <vertexes.length ; i++) {
            if(vertexes[i]==ch)
                return i;
        }
        return -1;
    }

    //获取圈中边，后面我们需要遍历该数组
    private EdgeData[] getEdge(){
        int index=0;
        EdgeData[] edges=new EdgeData[edgeNum];
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = i+1; j < vertexes.length; j++) {
                if(matrix[i][j]!=INF){
                    edges[index++]=new EdgeData(vertexes[i],vertexes[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 功能：获取下标为i的顶点的终点。1.对边进行权值排序2.是否形成了回路，依据是，拥有共同最大顶点
     * ends是基于当前顶点找终点的
     * @param ends
     * @param i
     * @return
     */
    private int getEnd(int[] ends,int i){
        while(ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

}

class EdgeData{
    char start;//边的起点
    char end;//边的终点
    int weight;//边的权重
    public EdgeData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
    public String toString(){
        return "Edata=[start="+start+",end="+end+",weight="+weight+"]";
    }
}
