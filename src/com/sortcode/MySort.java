package com.sortcode;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
//        insertSort(arr);
//
//        //排序后时间
//        Date date2=new Date();
//        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat2.format(date2));

        //endregion

        //region 写代码用

        int[] arr=new int[]{8,9,1,7,2,3,5,4,6,0};
        HillSort1(arr);
//        for (int i=0;i< arr.length;i++) {
//            System.out.print(arr[i] + "  ");
//        }

        System.out.println(Arrays.toString(arr));
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
     *选择排序
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

    //region 插入排序

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){

        for (int i=1;i<arr.length;i++) {
            int insertValue=arr[i];// 定义待插入的数
            int insertValueIndex=i;//arr[1]的前面一个数的下标
            //insertValue>=0 保证不越界 ,insertValue<arr[insertValue] 待插入的数还没有适当的位置 ，让arr[insertValue]后移
            while(insertValueIndex>0 && insertValue<arr[insertValueIndex-1]){
                arr[insertValueIndex]=arr[insertValueIndex-1];
                insertValueIndex--;
            }
            //退出循环，说明已经找到插入位置
           // if(insertValue+1==i)
           arr[insertValueIndex]=insertValue;
        }
    }

    //endregion

    //region 希尔排序

    /**
     * 交换法
     * @param arr
     */
    public static void HillSort1(int[] arr){

        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                // 遍历各组中的所有元素（共五组，每组2个元素），步长5
                for (int j=i-gap;j>=0;j-=gap){
                    //如果当前元素大于加上步长后的元素，说明交换
                    if(arr[j]>arr[j+gap]){
                        int temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }

        //第一轮排序，将10个数分成了5组

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 移动法 ⭐
     * @param arr
     */
    public static void HillSort2(int[] arr){

        //增量gap，并足部缩小增量
        for (int gap=arr.length/2;gap>0;gap/=2){
            //从gap个元素
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //退出while，temp找到了插入的位置
                    arr[j]=temp;
                }
            }
        }
    }

    //endregion

    //region
    public static void QuickSort(int[] arr)
    {

    }
    //endregion
}
