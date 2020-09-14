package com.algorithm;

/**
 * 非递归
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr={1,3,8,10,11,67,100};
        int index=binarySearch(arr,-8);
        System.out.println(index);
    }


    /**
     *
     * @param arr 待查找的数组,升序
     * @param target 需要找找的数
     * @return 返回对应的下标，-1表示未找到
     */
    public static int binarySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            //说明可以继续查找
            int mid=(left+right)/2;
            if(arr[mid]==target)
            {
                return mid;
            }else if(arr[mid]>target){
                right=mid-1;//需要向左边查找
            }else{
                left=mid+1;
            }
        } return -1;
    }
}
