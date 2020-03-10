package com.company;

public class SingleLinkedList {

    //测试
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");

        // 没有排序版本
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNoByOrder(heroNode);
        singleLinkedList.addNoByOrder(heroNode3);
        singleLinkedList.addNoByOrder(heroNode1);
        singleLinkedList.addNoByOrder(heroNode2);


        singleLinkedList.list();
    }

    /*
     1. 先创建一个head头节点，作用就是表示单链表的头
     2. 后面我们没添加一个节点，就直接加入到链表的
     3. 遍历：通过辅助变量，帮助变量整个链表
     */

    // 初始化头结点，节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    /*
        当不考虑编号的顺序时，找到链表的最后节点，将最后节点的next指向新的节点
        这种方式是尾部添加
     */
    public void addNode(HeroNode heroNode) {
        HeroNode temp = head; //头结点
        while (true) {
            if (temp.next == null) break;
            temp = temp.next; //如果不是尾节点那么继续定位尾节点
        }
        temp.next = heroNode;
    }

    /*
        需要按照编号的顺序添加：
        1. 首先找到新添加节点的位置，是通过辅助变量（指针）
        2. 让新的节点的域.netx=temp.next
        3. 让tem.next=新的节点
     */
    public void addNoByOrder(HeroNode heroNode) {
        // 因为头节点不能动，通过辅助
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) break;

            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            System.out.println("编号已存在");
        } else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    //更新
    public void uopdate(HeroNode newHeroNode){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点，定义一个辅助变量
        HeroNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){
                break; //链表已经遍历完
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;
        }else {
            System.out.printf("没有找到 编号 %d \n",newHeroNode.no);
        }



    }

    /*
    从单链表中删除元素
    1. 先找到待删除节点前一个节点
    */
    public void delete(int no){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(head.next==null){
                break;
            }
            if(temp.next.no==no)
            {
                flag=true;
                break;
            }
            temp=temp.next; //后移指针实现遍历
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.println("未找到元素");
        }


    }


    /*
    显示遍历
     */
    public void list() {
        if (head.next == null)
            System.out.println("链表为空");
        //头结点不能动，我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) break;

            //输出节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

// 定义节点，每个HeroNode都是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.nickName = nickName;
        this.name = name;
    }

    public String toString() {
        return "HeroNode [no=" + no + ",name=" + name + "nickname=" + nickName + "]";
    }
}