package com.Graph;

//深度优先遍历
public class DFS {


    private static boolean[] isVisited;
    private static Graph graph;

    /**
     * 1.访问初始节点v，并标记已访问
     * 2.查找节点v的第一个邻接点w  getFirstNeighbour
     * 3.若存在w，则继续执行4，如果不存在回到第一步，将从v的下一个节点继续
     * 4.若w未被访问，对w进行深度优先遍历
     * 5.查找节点v的w邻接点的下一个邻接点
     *
     * @param args
     */


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

        DFS s=new DFS();
        s.DFS(0);
    }

    //遍历当前的节点
    public void DFS(int i) {
        isVisited[i]=true;
        System.out.println(graph.getValueByIndex(i) +"->");
        for (int j = 0; j <graph.vertexList.size() ; j++) {
            if(graph.edges[i][j]==1 && isVisited[j]==false){
                DFS(j);
            }
        }
    }

    
}
