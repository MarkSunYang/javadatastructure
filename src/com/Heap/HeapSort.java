package com.Heap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={4,6,8,5,9};

        //most important 把子树调整成大顶堆
    }

    /**
     *
     */
    public static void heapSort(int arr[]){
        System.out.println("堆排序");

    }

    /**
     *   将一个数组（调整成一个大顶堆）
     *   {4,6,8,5,9}
     *   {4,9,8,5,6}
     *   再次调用adjust传入i=0{9,6,8,5,4}
     * @param arr   待调整的数组
     * @param i     非叶子节点在数组中的索引
     * @param length    表示多少个元素在调整，length在逐渐减少
     */
    public static void  adjustHeap(int arr[],int i, int length ){
        int tmp=arr[i];
        //开始调整

        //1.k指向i节点的左子节点
        for (int k=i*2+1;i<length;k=i*2+1){
            //找到最大值,左子节点值小于右子节点的值
            if(k+1 <length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>tmp){

            }
        }

    }

}
