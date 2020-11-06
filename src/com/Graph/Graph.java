package com.Graph;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    public static void main(String[] args) {
        int n=5;
        String vertexString[] = { "A", "B", "C", "D", "F" };
        Graph gp = new Graph(5);
        for (String value : vertexString) {
            gp.addVertex(value);
        }

        gp.addEdge(0, 1, 1);
        gp.addEdge(0, 2, 1);
        gp.addEdge(0, 3, 1);
        gp.addEdge(0, 4, 1);
        gp.addEdge(1, 2, 1);
        gp.addEdge(1, 3, 1);
        gp.addEdge(2, 4, 1);
        gp.addEdge(3, 4, 1);

        gp.show();

        gp.DFS();
    }

    public ArrayList<String> vertexList;//顶点
    public int numOfEdges;//边的数目
    public int[][] edges;//矩阵

    // region 图的创建
    /**
     * 参考：https://blog.csdn.net/qq_44973159/article/details/106355167
     * 邻接矩阵表示图
     *      0   1   2   3   4
     * 0    0   1   1   1   1
     * 1    0   1   1   0   1
     * 2    1   1   0   0   1
     * 3    1   1   0   0   1
     * 4    1   0   1   1   0
     */

    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
        isVisited=new boolean[n];//用于图的dfs遍历
    }

    // 插入节点
    public void addVertex(String vertex){
        vertexList.add(vertex);
    }

    // 添加边
    public void addEdge(int v1,int v2,int weight){
       edges[v1][v2]=weight;
       edges[v2][v1]=weight;
       numOfEdges++;
    }

    // 返回节点个数
    public int vertexNum(){
        return vertexList.size();
    }

    // 返回边的个数
    public int edgeNum(){
        return numOfEdges;
    }

    // 返回v1 v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    // 通过索引返回值
    public String getValue(int i) {
        return vertexList.get(i);
    }

    // 显示矩阵
    public void  show(){
        for (int[] item :edges) {
            System.out.println(Arrays.toString(item));
        }
    }

    // endregion

    // region 图的深度优先遍历  Depth First Search

    public boolean[] isVisited;// 记录被访问的节点

    // 获取第一个邻接点的下标
    public int getFirstNode(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i]>0){
                return i; //
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标获取下一个邻接节点的下标
    public int getNextNode(int v1,int v2){
        for (int i = v2+1; i <vertexList.size() ; i++) {
            if(edges[v1][i]>0)
                return i;
        }
        return -1;
    }

    public void DFS(boolean[] isVisited,int i)
    {
        System.out.println(getValue(i)+ " -> ");// 先进行访问i
        isVisited[i]=true;
        int w=getFirstNode(i);//获得当前节点的第一个邻接点
        while (w!=-1){
            if(!isVisited[w]){
                DFS(isVisited,w);//如果当前节点没被访问过，把当前节点设置为根节点，继续访问
            }
            w=getNextNode(i,w);//如果w被访问过了，则获取它的下一个节点
        }
    }

    //回到第一步
    public void DFS(){
        //遍历所有节点进行DFS
        for (int i = 0; i <vertexNum() ; i++) {
            if(!isVisited[i])
                DFS(isVisited,i);
        }
    }

    // endregion

    // region 图的广度优先遍历  Broad First Search

    public void BFS(boolean[] isVisited, int i){
        int u;//队列的头节点
        int w;//邻接节点
        LinkedList queue =new LinkedList();// 使用队列记录访问顺序
        System.out.println(getValue(i)+" -> ");
        isVisited[i]=true;
        queue.addLast(i);
        while(!queue.isEmpty()){
            //取出队列头节点下标
            u=(Integer) queue.removeFirst();
            w=getFirstNode(u);
            while (w!=-1){
                if(!isVisited[w]){
                    System.out.println(getValue(w)+" -> ");
                    isVisited[w]=true;
                    queue.addLast(w);
                }
                w=getNextNode(u,w);//继续找下一个节点
            }
        }
    }

    public void BFS(){
        for (int i = 0; i <vertexNum() ; i++) {
            if(!isVisited[i])
                BFS(isVisited,i);
        }
    }

    // endregion
}
