package com.Tree;

public class TreeSave {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrbinaryTree arrtree=new ArrbinaryTree(arr);
        arrtree.preOrder(0);

    }

}

class  ArrbinaryTree{
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void preOrder(int index){
        // arr为空或者arr.length=0 提示：数组为空不能按照二叉树前序遍历
        if(arr==null ||arr.length==0){
            System.out.println("数组为空！");
        }
        System.out.println(arr[index]);

        //向左递归
        if((index*2+1)<arr.length)
            preOrder(2*index+1);

        //向右递归
        if((index*2+2)<arr.length)
            preOrder(2*index+2);
    }


    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public ArrbinaryTree(int[] arr) {
        this.arr = arr;
    }
}
