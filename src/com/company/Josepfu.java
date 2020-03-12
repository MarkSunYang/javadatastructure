package com.company;


/**
 * 约瑟夫环形链表
 */
public class Josepfu {

    public static void main(String[] args) {
        // 测试
        CircleSingleList circleSingleList=new CircleSingleList();
        circleSingleList.addChild(5);

        circleSingleList.list();

    }

}

class CircleSingleList{
    // 1.创建一个first 节点，没有当前编号

    private  Child first=new Child(-1);

    /**
     * 添加
     * @param nums 要是正整数
     */
    public void addChild(int nums){
        if(nums<0){
            System.out.println("请输入正确数据");
            return ;
        }

        Child curChild=null; //辅助变量
        //使用for循环创建环形链表
        for(int i=1;i<=nums;i++)
        {
            // 根据编号，创建节点；使用辅助变量
            Child child=new Child(i); // 创建的新节点
            if(i==1){
                 first=child;
                 first.setNext(first);//构成环
                 curChild=first; //当前指针指向第一个
             }else{
                curChild.setNext(child);//
                child.setNext(first); //构成环
                curChild=child;//指针指向当前节点
            }

        }

    }

    /**
     * 遍历
     */
    public void  list(){
        //判断是否为空
        if(first==null) {
            System.out.println("链表为空！");
            return;
        }

        Child curChild=first;
        // 因为first 不能动，因此任然使用辅助指针
        while (true){
            System.out.printf(" 当前小孩编号 %d\n", curChild.getNo());
            if(curChild.getNext()==first){
                //已经遍历完毕
                break;
            }
            curChild =curChild.getNext();//后移
        }
    }

    //出圈
    // 1. 创建辅助指针 helper,事先指向环形链表的最后一个节点

}

class Child{
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    public Child getNext() {
        return next;
    }

    public void setNext(Child next) {
        this.next = next;
    }
    private int no;
    private Child next;//指向下一个小朋友
    public Child(int no){
        this.no=no;
    }
}
