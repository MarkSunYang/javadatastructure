package com.sortcode;

public class MySort {
    public static void main(String[] args) {

        int[] arr=new int[]{3,9,-1,10,20};
        BubbleSort(arr);
        for (int i=0;i< arr.length;i++) {
            System.out.print(arr[i] + "  ");
        }

    }


    public static void BubbleSort(int[] arr){
        int temp;
        for (int i=0;i<arr.length;i++){
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

}
