package com.Hash;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab=new HashTab(7);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add:添加");
            System.out.println("list:列表");
            System.out.println("exit:退出");
            key=scanner.next();
            switch (key){
                case"add":
                    System.out.println("输入 id");
                    int id =scanner.nextInt();
                    System.out.println("输入姓名");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case"list":
                    hashTab.list();
                    break;
                case"exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}

//创建hashtable
class HashTab{
    private EmpLinkedList[] empListArr;
    private int size;//表示多少天链表

    //构造器
    public HashTab(int size){
        this.size=size;
        //初始化
        empListArr=new EmpLinkedList[size];

        //初始化每条链表
        for (int i=0;i<size;i++){
            empListArr[i]=new EmpLinkedList();
        }
    }

    //添加 雇员
    public void add(Emp emp){
        //根据emp的id得到该员工应该加到哪条链表
        int emplinkedNo=hasFun(emp.id);
        empListArr[emplinkedNo].add(emp);
    }

    //遍历哈希表
    public void list(){
        for (int i=0;i<size;i++){
            empListArr[i].list();
        }
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hasFun(int id){
        return id%size;
    }
}


//表示雇员
class Emp{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    public int id;
  public String name;
  public Emp next;
  public Emp(int id,String name){
      super();
      this.name=name;
      this.id=id;
  }
}

class EmpLinkedList{
    //头指针，执行第一个Emp,
    private Emp  head;//默认为空

    //添加雇员，假设添加雇员时，id自增长，
    public void add(Emp emp){
        //如果是添加第一个
        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个，使用辅助指针，定位
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null)
                break;
            curEmp=curEmp.next;
        }
        //退出直接将emp加入链表
        curEmp.next=emp;
    }

//    public Emp findEmpById(int id){
//        //empty?
//
//    }

    //遍历链表
    public void list(){
        if(head==null) {
            System.out.println("list is null");
            return;
        }
        System.out.println("current list info:");
        Emp curEmp=head;
        while (true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null)
                break;
            curEmp=curEmp.next;
        }
    }

}