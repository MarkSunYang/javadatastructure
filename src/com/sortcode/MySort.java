package com.sortcode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySort {
    public static void main(String[] args) {

        //region 测试8w条数据用

        //测试8w条数据的时间复杂度
//        int[] arr=new int[80000];
//        for (int i=0;i< 80000;i++) {
//            arr[i]=(int)(Math.random()*80000);
//        }
//
//        //排序前时间
//        Date date1=new Date();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date1));
//        BubbleSort(arr);
//
//        //排序后时间
//        Date date2=new Date();
//        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat2.format(date2));

        //endregion

        //region 写代码用

        int[] arr=new int[]{3,9,-1,10,20};
        selectedSort(arr);
        for (int i=0;i< arr.length;i++) {
            System.out.print(arr[i] + "  ");
        }

        //endregion

    }

    //region 冒泡排序及优化

    //时间复杂度n^2
    /**
     *
     * @param arr
     */
    public static void BubbleSort(int[] arr){
        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<i;j++){
                //如果arr[i]比arr[j]小 则互换位置，大的往后移动
                if(arr[i]<arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }

            }
        }
    }

    /**
     * 优化版本
     * @param arr
     */
    public static void BubbleSortOptimize(int[] arr){
        boolean flag=false;//表示是否进行交换
        int temp=0;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                //如果arr[i]比arr[j]小 则互换位置，大的往后移动
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            //一次没有发生
            if(flag==false){
                break;
            }else{
                flag=false;
            }
        }
    }

    //endregion

    //region 选择排序

    /**
     *
     * @param arr
     */
    public static void selectedSort(int[] arr){
        for (int i=0;i<arr.length;i++) {
            int minIndex=i;//假设最小的值得索引为0
            int min=arr[i];//最小值

            for (int j=i+1;j<arr.length;j++){
                 if(min>arr[j]) //如果假设的最小值比后面的数大那么交换位置
                 {
                     min=arr[j];//重置最小值
                     minIndex=j;//重置minIndex
                 }
             }

            //将最小值 放在arr[0],
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }

        }
    }

    //endregion


}
