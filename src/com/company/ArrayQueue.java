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

    /**
     * 获取链表有效节点的个数
     * @param head 链表头
     * @return
     */
    public static int getLength(HeroNode head){
        if(head.next==null)
        {
            return 0;
        }
        int length=0;
        HeroNode cur=head.next;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个节点
     * 先把链表从头到尾遍历，得到链表的总的长度 getLength()
     * 得到size后，我们从链表中的第一个开始遍历(size-index)个
     * 如果找到了，返回该节点，否则返回null
     * @param
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next==null){
            return null;
        }
        //第一次遍历得到链表长度
        int size=getLength(head);
        //第二次变量 size - index 位置，
        if(index<=0 || index>size){
            return null;
        }
        HeroNode cur=head.next;
        for (int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;

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

