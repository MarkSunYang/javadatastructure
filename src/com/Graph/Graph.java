package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    public int[][] edges;//邻接矩阵 顶点
    public ArrayList<String> vertexList;//边
    public int numOfEdges;//顶点的个数

    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<>();
        numOfEdges=0;
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    // 添加边
    public void insertEdge(int v1,int v2, int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //顶点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    public  void  showGraph(){
        for (int[] link:edges)
            System.out.println(Arrays.toString(link));
    }

}
