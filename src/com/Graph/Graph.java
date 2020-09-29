package com.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList; //存储顶点
    private int[][] edges; //存储图的对应的邻接矩阵
    private int numOfEdges; //边的个数
    private boolean[] isVisited;// 定义数组boolean,记录某个节点是否被访问

    public static void main(String[] args) {
    }

    /*** 构造器*/
    public Graph(int n) {
        edges = new int[n][n];//初始化边
        vertexList = new ArrayList<String>(n);//初始化顶点
        numOfEdges = 0;//初始化边的个数
        isVisited = new boolean[5];
    }

    // 根据前一个邻接节点的下标获取下一个邻接节点
    public int getFirstNeighbor(int index) {
        for (int j = index; j < vertexList.size(); j++)
            if (edges[index][j] > 0)
                return j;
        return -1;
    }

    // 根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited,int i){
        System.out.println(getValueByIndex(i)+"->");  //访问 该节点
        isVisited[i]=true;  //把已访问的节点设置为已访问
        int w=getFirstNeighbor(i);// 查找节点i的第一个邻接点w
        while (w!=-1){
            //有邻接节点
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w=getNextNeighbor(i,w); //如果w节点已经被访问过邻接节点的下一个节点
        }
    }

    public void dfs(){
        //遍历所有的节点进行dfs   //对 dfs进行重载，遍历所有的节点，并进行dfs
        for (int i = 0; i <getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    private void bfs(boolean[] isVisited,int i){
        int u,w;//u表示队列头结点对应下标,邻接点w
        //队列：节点访问顺序
       LinkedList queue=new LinkedList();
        System.out.println(getValueByIndex(i)+"=>");//访问节点，输出信息
        isVisited[i]=true;
        queue.addLast(i);//将节点加入队列
        while (!queue.isEmpty()){
            //取出队列的头结点
            u=(int)queue.removeFirst();
            w=getFirstNeighbor(u);//得到第一个邻接点的下标 w

        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);  //插入节点
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;//v1和v2是否相连，0不连，1相连
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();  //顶点个数
    }

    public int getNumOfEdge(String vertex) {
        return numOfEdges;  //得到边的个数
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);  //返回节点i下标对应的数据 0-"A" 1-"B" 2-"C"
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2]; //返回权值
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link)); //返回图
        }
    }
}
