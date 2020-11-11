package com.Graph;


import java.util.Arrays;

/**
 * 计算图中（各个）顶点的最短路径；弗洛伊德顶点，每个顶点都是出发顶点
 * 设置顶点vi-vk的最短路径为length(ik),vk-vj的路径为 length(kj);min(length(ik),length(kj))
 */
public class Floyd {
    public static void main(String[] args) {
        char[] vertexes=new char[]{'A','B','C','D','E','F','G'};
        //创建邻接矩阵
        int[][] matrix=new int[vertexes.length][vertexes.length];
        final int N=65535;
        matrix[0]=new int[]{0,5,7,N,N,N,2};
        matrix[1]=new int[]{5,0,N,9,N,N,3};
        matrix[2]=new int[]{7,N,0,N,8,N,N};
        matrix[3]=new int[]{N,9,N,0,N,4,N};
        matrix[4]=new int[]{N,N,8,N,0,5,4};
        matrix[5]=new int[]{N,N,N,4,5,0,6};
        matrix[6]=new int[]{2,3,N,N,4,6,0};
        FloydGraph fg= new FloydGraph(vertexes.length,matrix,vertexes);
        fg.show();
    }
}

class FloydGraph{
    private char[] vertexes;//存放顶点的数组
    private int[][] dis;//保存，从各个顶点出发到其他顶点的距离
    private int[][] pre;//保存到大目标顶点的前驱顶点

    //构造器
    public FloydGraph(int length,int[][] matrix,char[] vertexes){
        this.vertexes=vertexes;
        this.dis=matrix;
        this.pre=new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void show(){
        char[] vertexes=new char[]{'A','B','C','D','E','F','G'};
        for (int i = 0; i < dis.length; i++) {
            //先输出pre数组的第一行
            for (int j = 0; j < dis.length; j++) {
                System.out.print(vertexes[pre[i][j]]+" ");
            }
            //输出dis数组的第一行
            System.out.println();

            for (int j = 0; j < dis.length; j++) {
                System.out.print(vertexes[i]+"到"+vertexes[j]+"的最短路径"+dis[i][j]);
            }
            System.out.println();
        }
    }

    public void floyd(){
        int len;
        for (int i = 0; i <dis.length ; i++) {
            for (int j = 0; j < dis.length; j++) {
                for (int k = 0; k < dis.length; k++) {
                    len=dis[j][k]+dis[k][j];//从i 顶点出发，经过k中间顶点到j顶点距离
                    if(len<dis[j][k]){
                        dis[j][k]=len;//更新距离
                    }
                }
            }
        }
    }
}
