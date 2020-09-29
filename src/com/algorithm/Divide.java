package com.algorithm;



public class Divide {
    public static void main(String[] args) {

    }

    /**
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void move(int num,char a,char b,char c){
        //如果只有一个塔
        if(num==1){
            System.out.println("第一个盘子 "+a+"->"+c );
        }else {
            //总是看成两个盘子
            //1.先把最上面A-B,移动会使用到C
            move(num-1,a,b,c);
            System.out.println("第"+num+"盘从"+a+"->"+c);
            move(num-1,b,a,c);
        }

    }
}
