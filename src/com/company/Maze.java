package com.company;

public class Maze {

    //v45
    public static void main(String[] args) {
        //初始化一个二维数组 模拟迷宫
        int[][] map =new int[8][7];

        //region 模拟墙

        // 模拟出墙
        for (int i=0;i<7;i++) {
            map[0][i]=1;
            map[7][i]=1;
        }

        //左右置为1
        for (int i=0;i<8;i++) {
            map[i][0]=1;
            map[i][6]=1;
        }

        //endregion

        //region 输出地图
        map[3][1]=1;
        map[3][2]=1;
        for (int i=0;i<8;i++) {
            for (int j=0;j<7;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //endregion
        System.out.println();
        //使用递归回溯
        setWay(map,1,1);
        for (int i=0;i<8;i++) {
            for (int j=0;j<7;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    // 当map[i][j] 0 表示未走，1表示已走
    // 需要制定一个策略，下 右 上 左
    /**
     *
     * @param map 地图
     * @param i 从哪儿开始找
     * @param j
     * @return 如果找到路则返回
     */
    public static boolean setWay(int[][] map, int i,int j){
        if(map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j]=2;//假定该点是可以走通的
                if(setWay(map,i+1,j)){
                    return true; //向下走
                }else if(setWay(map,i,j+1)){
                    return true;//向右走
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,1,j-1)){
                    return true;
                }else{
                   map[i][j]=3;  //死路，走不通
                   return false;
                }
            }else{
                return false;
                // 如果map[i][j]！=0 可能是1，2，3
            }
        }

    }
}
