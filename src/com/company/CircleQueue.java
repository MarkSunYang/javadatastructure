package com.company;

public class CircleQueue {

    /*
    问题： 普通队列用完就不能再用，解决空间不能重复使用问题

    分析：
    1. front： 就指向数组的第一个元素arr[front]就是队列的第一个元素
    2. rear：  指向队列的最后一个元素
    3. 当队列满时： (rear + 1) % maxSize=front
    4. 队列为空的条件 rear = front =0
    5. rear= front 的初始值=0
    会有一个预留空间
    6. 队列中有效的数据的个数 ： (rear+maxSize-front)%maxSize
     */

    public static void main(String[] args) {

    }

    private int maxSize;// 队列的最大长度
    private int rear; //队尾
    private int front; //队头
    private int[] arr; //用于存放数据

    public CircleQueue(int arrMaxSize){
        maxSize= arrMaxSize;
        arr=new int[maxSize];
    }

    // 入队列
    public void enQueue(int n){
        // 判断队列是否满
        if(IsFull()){
            System.out.println("Queue is full");
        }
        arr[rear]=n; //rear 直接将数据加入
        rear=(rear+1)%maxSize;
    }

    // 出队列
    public int deQueue(){
        if(IsEmpty()){
            throw  new RuntimeException("Queue is empty");
        }
        int tempfront=arr[front];//保存front对应的值到临时变量再后移
        front=(front+1)%maxSize;
        return tempfront;
    }

    // 变量
    public void showQueue(){
        if(IsEmpty()){
            System.out.println("Queue is empty");
        }
        //从front开始变量，遍历多少元素
        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d",i%maxSize,arr[i]);
        }
    }

    public   int size(){
        return (rear+maxSize-front)%maxSize;
    }

    // 显示队列的头部 ， 不是取数据
    public int headQueue(){
        if(IsEmpty()){
            System.out.println("Queue is empty");
        }
        return arr[front];
    }

    // 判断队列是否为空
    public boolean IsEmpty(){
        return rear==front;
    }

    // 判断队列是否满： 队列满的情况下
    public boolean IsFull(){
        return  (rear + 1) % maxSize==front;
    }

}
