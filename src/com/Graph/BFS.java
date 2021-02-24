package com.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先算法
 */
public class BFS {
    private static boolean[] isVisited;
    private static Graph graph;

    public static void main(String[] args) {
        int n = 5;
        graph = new Graph(n);
        String vertex[] = {"A", "B", "C", "D", "E"};//初始化顶点
        for (String value : vertex)
            graph.insertVertex(value);
        //初始化边
        graph.insertEdge(0, 1, 1); //A-B
        graph.insertEdge(0, 2, 1); //A-C
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
        isVisited = new boolean[5];

        BFS bfs=new BFS();
        bfs.BFS(0);
    }

    /**
     * 这种写法比较简洁，但是如果节点过多的话 while中的for循环每次都要遍历整个
     * @param n
     */
    public void BFS(int n){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(n);//将当前的节点入队
        while (!queue.isEmpty()){
           int v= queue.poll();
           isVisited[n]=true;
            System.out.println(graph.getValueByIndex(v) +"->");
            for (int i = 0; i < graph.vertexList.size() ; i++) {
                if(graph.edges[v][i]==1 && isVisited[i]==false){
                    queue.add(i);
                    isVisited[i]=true;
                }
            }
        }
    }


}
