package com.Graph;
import java.util.Arrays;

public class PrimAg {
    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int vertex=data.length;
        int [][]weight=new int[][]{
                {100,5,7,100,100,100,2},
                {5,100,100,9,100,100,3},
                {7,100,100,8,100,100,100},
                {100,9,100,100,4,100,3100},
                {100,100,100,4,5,100,100},
                {2,3,100,100,4,6,100}
        };//100表示不连通
        Mgraph mgraph=new Mgraph(vertex);
        MinTree minTree=new MinTree();
        minTree.createGraph(mgraph,vertex,data,weight);
        minTree.show(mgraph);
    }
}
//创建最小生成树
class MinTree{
    //graph:图对象, vertex:顶点, data:图的各个顶点的值 ,weight:邻接矩阵
    public void createGraph(Mgraph graph,int vertex, char data[],int[][] weight){
        for (int i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < data.length; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //graph：图 vertex：从哪个顶点开始
    public void prim(Mgraph graph,int vertex){
        int visited[]=new int[graph.vertex];//标记节点是否被访问过
        //把当前节点标记为已访问
        visited[vertex]=1;
        int h1=-1,h2=-1;//h1和h2记录两个顶点下标
        int minWeight=100;//

        for (int i = 1; i <graph.vertex; i++) {
            //确定每次生成的子图和哪个节点的距离最近
            for (int j = 0; j < graph.vertex; j++) {//j节点表示被访问过的节点
                for (int k = 0; k < graph.vertex; k++) { //k表示未被访问的节点
                   if(visited[j]==1 && visited[k]==0 && graph.weight[j][k]<minWeight){
                       minWeight=graph.weight[j][k];//寻找已经访问的节点和未访问节点之间访问的权值最小的边
                       h1=j;
                       h2=k;
                   }
                }
            }
            System.out.println("边 <" +graph.data[h1]+","+graph.data[h2]+">权值："+minWeight);   //找到一条边最小
            visited[h2]=1;
        }
    }

    public void show(Mgraph graph){
        for (int[] datum : graph.weight) {
            System.out.println(Arrays.toString(datum));    //显示图的邻接矩阵
        }
    }
}

class Mgraph{
    int vertex;//节点
    char[] data;//存放节点数据
    int[][] weight;//存放边，邻接矩阵

    public Mgraph(int vertex){
        this.vertex=vertex;
        data=new char[vertex];
        weight=new int[vertex][vertex];
    }
}