package com.sortcode;

public class RadixSort {
    public static void main(String[] args) {
        int a[] = {9, 3, 2, 5, 14, };
        radixSort(a);    // 基数排序
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
    }

    //获取数组 a 中最大值
    private static int getMax(int arr[]){
        int i,max;
        max=arr[0];
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]>max)
                max=arr[j];
        }
        return max;
    }

    public static void  countSort(int arr[], int exp){
        int output[]=new int[arr.length];
        int buckets[] =new int[100];

        //将数据出现的次数存储在buckets中
        for (int i = 0; i <arr.length ; i++) {
            buckets[(arr[i]/exp%10)]++;
        }

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i <10 ; i++) {
            buckets[i]+=buckets[i-1];
        }

        // 将数据存储到临时数组output中
        for (int i = arr.length-1; i >=0 ; i--) {
            output[buckets[ (arr[i]/exp)%10 ] - 1] = arr[i];
            buckets[ (arr[i]/exp)%10 ]--;
        }

        //将排序号的数据赋给 a[]
        for (int i = 0; i < arr.length; i++) {
            arr[i]=output[i];
        }
        output=null;
        buckets=null;
    }
    public static void radixSort(int[] arr){
        int exp;
        int max=getMax(arr);
        for (exp = 1; max/exp > 0; exp *= 10)
            countSort(arr, exp);
    }

}
