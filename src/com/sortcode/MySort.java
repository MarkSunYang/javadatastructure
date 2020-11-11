package com.sortcode;
import java.util.Arrays;

public class MySort {
    public static void main(String[] args) {
        //region 写代码用

        int[] arr=new int[]{8,9,1,7,7,2,3,5,4,6,0};
        bubblingSort(arr);
        System.out.println(Arrays.toString(arr));
        //endregion
    }


    /**
     * 简单插入排序
     * 1.从第一个元素开始，该元素可以认为已经排好序。
     * 2.取出下一个元素，在已经排好序的元素序列中从后往前扫描进行比较。
     * 3. 如果该元素(已排序) 大于新元素，则将该元素移到下一位置。
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置。
     */
    public static void insertSort(int[] arr) {
        int i, j,temp;
        for (i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                temp=arr[i];
                for (j=i-1;j>=0 && arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }

    }

    /**
     * 希尔排序
     * 1.把记录按步长gap分组，对每组记录采用直接插入排序方法进行排序；
     * 2.随着步长逐渐减小，所分成的组包含的记录越来越多；当步长值减小到1时，整个数据合成一组，构成一组有序记录，完成排序；
     */
    public static void hillSort(int[] arr){
        for (int step = arr.length/2;step >0 ; step/=2) {
            for (int i = step; i <arr.length ; i++) {
                int value=arr[i];
                int k;
                for ( k = i-step; k >=0&& arr[k]>value ; k-=step) {
                    arr[k+step]=arr[k];
                }
                arr[k+step]=value;
            }
        }
    }

    /**
     * 选择排序
     * 简单选择排序是最简单直观的一种算法，每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止，
     * 简单选择排序是不稳定排序。
     */
    public static void selectSort(int[] arr){

        for (int i =0; i <arr.length ; i++) {
            int minIndex=i;//最小元素的下标
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex=j; //如果当前的数比最小数要小，则交换下标
                }
            }
            //如果下标被交换了，则值也要交换
            if(minIndex!=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
    }

    //TODO 大顶堆小顶堆

    /**
     * 冒泡排序
     */
    public static void bubblingSort(int[] arr){
        int temp;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-1 ; j++) {
                if(arr[i]<arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    /**
     * 基数排序
     * 基数排序是非比较排序算法，,算法的时间复杂度是O(n).
     */

}
