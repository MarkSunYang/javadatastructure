package com.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    // edges 边
    // vertex

    private ArrayList<String> vertexList; //存储顶点
    private int[][] edges; //存储图的对应的邻接矩阵
    private int numOfEdges; //边的个数

    // 定义数组boolean,记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        // 测试图是否创建成功
        int n = 5;// 节点个数
        String VertexValue[] = {"A", "B", "C", "D", "E"};

        // 创建图对象
        Graph graph = new Graph(n);
        for (String vertexValue : VertexValue)
            graph.insertVertex(vertexValue);

        //添加边
        // A 对应的连接
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);

        //B对应的连接
        //graph.insertEdge(1,0,1); //A已经连接
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(1, 3, 1);

        //C 对应的连接 C

        graph.showGraph();
    }

    /**
     * 构造器
     */
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    // 根据前一个邻接节点的下标获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2; j < vertexList.size(); j++)
            if (edges[v1][j] > 0)
                return j;

        return -1;
    }

    /**
     * 第一次为0
     *
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited, int i) {
        System.out.println(getValueByIndex(i) + "->");
        //将该节点设置为已访问
        isVisited[i] = true;
        int w = getFirstNeighbor(i); //查找节点的第一个邻接节点w
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w被访问过，查找下一个邻接点
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs 重载，遍历所有的节点进行dfs
    public void dfs()
    {
        // 遍历所有的节点，进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i])
                dfs(isVisited, i);
        }
    }


    /**
     * 如果存在返回对应的下标
     * 得到第一个邻接节点的下标 w
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0)
                return j;
        }
        return -1;
    }

    /**
     * 插入节点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     点的下标 A-B  A-0 B-1
     * @param v2
     * @param weight ：权值 ，边对应的值0或1
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // region 常用方法

    /**
     * 得到顶点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的个数
     *
     * @param vertex
     * @return
     */
    public int getNumOfEdge(String vertex) {
        return numOfEdges;
    }

    /**
     * 返回节点i下标对应的数据 0-"A" 1-"B" 2-"C"
     *
     * @param i
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 返回图
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    // endregion

}
