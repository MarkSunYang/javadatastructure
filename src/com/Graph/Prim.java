package com.Graph;

import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int vertex=data.length;
        //使用二维数组表示连通关系 10000表示不连通
        int[][] weight=new int[][]{

                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };

        PrimGraph graph=new PrimGraph(vertex);
        MinTree minTree=new MinTree();
        minTree.createGraph(graph,vertex,data,weight);
        minTree.show(graph);
        Prim.Prim(graph,0);
    }

    // graph图；v从图的第几个顶点开始生成
    public static void Prim(PrimGraph graph,int v){
       int visited[]= new int[graph.vertexes];//表示标记顶点是否被访问过

        visited[v]=1; // 把当前节点标记为已访问
        int v1=-1;// 用h1 和h2记录顶点的下标
        int v2=-1;
        int minWeight=10000;//将minWeight初始化成一个大数，后面在遍历过程中会被替换

        // <A>  -> <A,G> -> <A,G,B> -> <A,G,B,E>
        //确定每次生成的子图和哪个节点的距离最近
        for (int i = 1; i <graph.vertexes ; i++) {
            // 第一层遍历：生成n-1条边（最小生成树的规则之一N个顶点有N-1条边）
            for (int j = 0; j <graph.vertexes ; j++) {
                // 第二层遍历 当前顶点的所有相邻边
                for (int k = 0; k < graph.vertexes; k++) {
                    //如果当前节点被访问了，且 对应的边未被访问，且边的权值比当前最小的值要小
                    //因为prim算法 是将顶点添加到集合，根据集合中的顶点找权值最小的边
                    if(visited[j]==1&& visited[k]==0 && graph.weight[j][k]<minWeight){
                        minWeight=graph.weight[j][k];
                        v1=j;
                        v2=k;
                    }
                }
            }
            System.out.println("生成第"+i+"条边"+"："+graph.data[v1]+graph.data[v2]+"权值为"+minWeight);
            visited[v2]=1;//当前找到的节点标记为已访问
            minWeight=10000;//重置
        }


    }

}


//创建树
class MinTree{

    // graph 图, vertexes 顶点, data[] 顶点的值, int[][] weight 矩阵
    public void createGraph(PrimGraph graph,int vertexes,char data[], int[][] weight){
        for (int k = 0; k <vertexes ; k++) {
            graph.data[k]=data[k];
            for (int l = 0; l <vertexes ; l++) {
                graph.weight[k][l]=weight[k][l];
            }
        }
    }

    public void show(PrimGraph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
}

class PrimGraph{
    int vertexes;//节点
    char[] data;
    int[][] weight; //存放边，邻接矩阵

    public PrimGraph(int vertexes){
        this.vertexes=vertexes;
        data=new char[vertexes];
        weight=new int[vertexes][vertexes];
    }
}