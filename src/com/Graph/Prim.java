package com.Graph;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最小生成树算法：普利姆算法(用顶点找出最小生成树)
 */
public class Prim {

    /**
     * 1. 在一个加权连通图中，顶点集合V，边集合为E
     * 2. 任意选出一个点作为初始顶点,标记为visit,计算所有与之相连接的点的距离，选择距离最短的，标记visit.
     * 3. 重复以下操作，直到所有点都被标记为visit：
     *
     * prim算法的时间复杂度为O^2
     */

    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int vertex=data.length;
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        MGraph mGraph=new MGraph(vertex);
        MinTree minTree=new MinTree();
        minTree.createGraph(mGraph,vertex,data,weight);
        //输出
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,6);
    }

}

class MinTree{

    /**
     * @param graph 图对象
     * @param vertex 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int vertex,char data[],int[][] weight ){
        for (int i = 0; i < vertex ; i++) {
            graph.data[i]=data[i];
            for (int j = 0; j <vertex ; j++) {
                graph.weight[i][j]=weight[i][j];
            }
        }
    }
    
    public void showGraph(MGraph graph){
        for (int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *  //prim 算法
     * @param graph 图
     * @param v 图的第几个顶点
     */
    public void prim(MGraph graph, int v){
        int[] visited=new int[graph.vertex];//表示已访问的
        for (int i = 0; i <graph.vertex ; i++) {
            visited[i]=0;
        }
        //当前节点标记为已访问
        visited[v]=1;
        int h1=-1;
        int h2=-1;
        int minWeight=10000;//

        //遍历每个顶点，有n-1个条边，这里是为了寻找 n-1条边
        for (int i = 1; i <graph.vertex ; i++) {

            //判断生成子图和哪个节点的距离最近，j 表示已访问，k 表示未访问
            for (int j = 0; j < graph.vertex; j++) {
                for (int k = 0; k < graph.vertex; k++) {
                    //已访问和未访问的节点 且 两个节点之间的距离比minweight小
                    if(visited[j]==1 && visited[k]==0 && graph.weight[j][k]<minWeight){
                        minWeight=graph.weight[j][k];
                        h1=j;
                        h2=k;
                    }
                }
            }
            //找到了一条最小边
            System.out.println("edge:"+graph.data[h1]+","+graph.data[h2]+",权值"+minWeight);
            //将当前找到的节点标记为已访问
            visited[h2]=1;
            minWeight=10000;//重置minWeight
        }
    }
}

   class MGraph{
       int vertex; //表示
       char[] data; //存放结点数量
       int[][] weight; //存放边，邻接矩阵

       //初始化
       public MGraph(int vertex){
           this.vertex=vertex;
           data=new char[vertex];
           weight=new int[vertex][vertex];
       }
   }