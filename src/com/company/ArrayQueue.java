package com.company;
import java.util.Scanner;


//普通队列
public class ArrayQueue {

    /*
    缺点：当数据去出来后空间被浪费
     */

    // 测试
    public static void main(String[] args) {
        ArrayQueue queue= new ArrayQueue(3);
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s：显示队列");
            System.out.println("e：退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("d：从队列中取出数据");
            System.out.println("h：查看队列头");

            key=scanner.next().charAt(0);// 接受字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value=scanner.nextInt();
                    queue.enQueue(value);
                    break;
                case 'd':
                    System.out.println("取出一个数");
                    try{
                        int res=queue.deQueue();
                        System.out.printf("取出的数据是 %d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头
                    try {
                        int res=queue.headQueue();
                        System.out.printf("队列头：%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    break;
            }
        }
    }

    private int maxSize;// 队列的最大长度
    private int rear; //队尾
    private int front; //队头
    private int[] arr; //用于存放数据

    public ArrayQueue(int arrMaxSize){
        maxSize= arrMaxSize;
        arr=new int[maxSize];
        front=-1; //指向队列头部，分析出front是指向队列头的一个位置
        rear=-1;  //指向队列尾，
    }

    // 入队列
    public void enQueue(int n){
        // 判断队列是否满
        if(IsFull()){
            System.out.println("Queue is full");
        }
        rear++; //rear 后移
        arr[rear]=n;
    }

    // 出队列
    public int deQueue(){
        if(IsEmpty()){
            throw  new RuntimeException("Queue is empty");
        }
        front++;
        return arr[front];
    }

    // 变量
    public void showQueue(){
        if(IsEmpty()){
            System.out.println("Queue is empty");
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d",i,arr[i]);
        }
    }

    // 显示队列的头部 ， 不是取数据
    public int headQueue(){
        if(IsEmpty()){
            System.out.println("Queue is empty");
        }
        return arr[front+1];
    }

    // 判断队列是否为空
    public boolean IsEmpty(){
        return rear==front;
    }

    // 判断队列是否满： 队列满的情况下
    public boolean IsFull(){
        return rear==maxSize-1;
    }

}

