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
        gp.bfs();
    }

    public ArrayList<String> vertexList;//顶点
    public int numOfEdges;//边的数目
    public int[][] edges;//矩阵

    // region 图的创建
    /**
     * 参考：https://blog.csdn.net/qq_44973159/article/details/106355167
     * 邻接矩阵表示图
     *      0   1   2   3   4           表示顶点
     * 0    0   1   1   1   1
     * 1    1   0   1   1   0
     * 2    1   1   0   0   1           矩阵表示边 1表示两个
     * 3    1   1   0   0   1
     * 4    1   0   1   1   0
     *
     * 表示顶点
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

    // 这里顶点是可以用一维数组表示，而顶点和顶点的关系需要用二维数组表示
    public boolean[] isVisited;// 记录被访问的节点

    // 根据前一个节点下标，获取下一个节点
    public int getNextNodeIndex(int index,int next){
        for (int i = next+1; i < vertexList.size() ; i++) {
            if(edges[index][i]>0)
                return i;
        }
        return -1;
    }

    //根据当前节点获取下一个节点的下标
    public int getFirstNodeIndex(int index){
        //vertexList 是顶点 [顶点的下标][与顶点相连顶点的下标]
        for (int i = 0; i < vertexList.size() ; i++) {
            if(edges[i][index]>0)
                return i;
        }
        return -1;
    }

    public void dfs(boolean[] isVisited,int i){
        System.out.println(getValue(i)+" -> ");
        isVisited[i]=true;
        int nextNode=getFirstNodeIndex(i);//查找第一个邻接点
        while(nextNode!=-1){
            if(!isVisited[nextNode]){
                dfs(isVisited,nextNode);
            }
            //如果nextNode已经被访问过  比如 i为A，nextNode=B 如果B已经被访问过，我们需要查找C
            nextNode=getNextNodeIndex(i,nextNode);
        }
    }

    public void dfs(){
        for (int i = 0; i <vertexNum() ; i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    // endregion

    // region 图的广度优先遍历
    public void  bfs(){
        for (int i = 0; i <vertexNum() ; i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public void bfs(boolean[] isVisited, int i){
        int u;//头结点对应的下标
        int w;//邻接节点的下标
        LinkedList queue=new LinkedList();
        System.out.println(getValue(i)+" -> ");

        isVisited[i]=true; //标记为已访问
        queue.addLast(i);
        while (!queue.isEmpty())
        {
            u=(Integer)queue.removeFirst(); //取出队列的头结点
            w=getFirstNodeIndex(u);
            while (w!=-1){
                if(!isVisited[w]){
                    System.out.println(getValue(w)+" => ");
                    isVisited[w]=true;
                    queue.addLast(w);//入队
                }
                w=getNextNodeIndex(u,w);
            }
        }
    }

    // endregion

}
