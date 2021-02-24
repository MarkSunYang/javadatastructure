package com.Graph;

/**
 * 迪杰斯特拉：用于计算一个节点(A)到其他节点的最短路径
 * 引进两个集合 S 和 U， S的作用是记录已求出最短路径的顶点，而U则记录还未求出最短路径的顶点
 * Step1. 初始时，S中只有起点s；U中是除s之外的顶点，并且U中顶点的路径是"起点s到该顶点的路径"
 * Step2. 从U中选出"距离最短的顶点k"，并将顶点k加入到S中；同时，从U中移除顶点k
 * Step3. 更新U中各个顶点到起点s的距离。
 * Step4. 重复步骤(2)和(3)，直到遍历完所有顶点。
 */

public class Dijkdtra {

    public static int M = 100000;//此路不通

    /**
     * ABCDE
     * A-B:4 A-D:2 ; B-C:4 B-D:1 ; C-D:1 C-E:3; D-E:7
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] weight = {
                {0,10,M,30,100},
                {M,0,50,M,M},
                {M,M,0,M,10},
                {M,M,20,0,60},
                {M,M,M,M,0}
        };
        int start=0;
        int[] shortPath = Dijkdtra(weight,start);

        for(int i = 0;i < shortPath.length;i++)
            System.out.println("从"+start+"出发到"+i+"的最短距离为："+shortPath[i]);
    }

    public static int[] Dijkdtra(int[][] weight, int start) {

        // region Prepare
        int n = weight.length; //顶点的个数
        int[] shortPath = new int[n];// 存放从start到其他各点的最短路径

        String[] path = new String[n]; //存放从start到其他各点的最短路径的字符串表示
        for (int i = 0; i < n; i++)
            path[i] = new String(start + "-->" + i);

        int[] visited = new int[n];   //标记当前该顶点的最短路径是否已经求出,1表示已访问
        // endregion

        //初始化，第一个顶点求出
        shortPath[start] = 0;
        visited[start] = 1;

        //要加入n-1个顶点
        for (int count = 1; count <= n - 1; count++) {
            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;//start 的 最小距离的点
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }

            shortPath[k] = dmin;//将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            visited[k] = 1;
            //比如 1-2：10 2-3 20 1-3：40 那么1-3最短路径=10+20而不是40
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }

        }
        return shortPath;
    }
}
