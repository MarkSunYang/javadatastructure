package com.Demo;

public class BinaryTreeStore {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        //创建一个arrbinarytree

        ArrayBinaryTree arrayBinaryTree=new ArrayBinaryTree(arr);

        arrayBinaryTree.preOrder(0);
    }
}

class ArrayBinaryTree{
    private int[] arr;//存储数据

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //完成顺序存储二叉树的前序遍历
    public void preOrder(int index){
        //如果数组为空，index, arr.length=0
        if(arr==null||arr.length==0){
            System.out.println("empty arr!");
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if(index*2+1<arr.length){
            preOrder(2*index+1);
        }
        if(index*2+2<arr.length){
            preOrder(2*index+2);
        }
    }
}
