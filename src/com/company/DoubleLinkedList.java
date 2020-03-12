package com.company;

/**
 * 双向链表
 * 单链表的问题：1.查找只能单方向 2. 不能实现自我删除（需要靠辅助节点）
 *
 * 双向链表的  遍历，添加，修改，删除的操作思路
 */
public class DoubleLinkedList {

    public static void main(String[] args) {

        System.out.println("双向链表测试...");
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.addNode(heroNode);
        doubleLinkedList.addNode(heroNode1);
        doubleLinkedList.addNode(heroNode2);
        doubleLinkedList.addNode(heroNode3);

        doubleLinkedList.list();
        System.out.println("修改节点...");
        HeroNode heroNode4 =new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(heroNode4);
        System.out.println("修改后...");
        doubleLinkedList.list();

        System.out.println("删除节点...");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();
    }

    private HeroNode head=new HeroNode(0,"","");

    public DoubleLinkedList(){

    }

    // 获取头结点
    public HeroNode getHead(){
        return head;
    }

    // 1. 遍历： 和单链表一样可以向前查找，也可以向后查找
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

    /**
     * 添加节点
     * 添加： 默认添加到最后 先找到双向链表的最后节点  temp.next=newNode, 新节点的pre反向指向temp
     * @param heroNode
     */
    public void addNode(HeroNode heroNode) {
        HeroNode temp = head; //头结点
        while (true) {
            if (temp.next == null) break;
            temp = temp.next; //如果不是尾节点那么继续定位尾节点
        }
        temp.next = heroNode;
        heroNode.pre=temp;
    }

    /**
     *
     * 对于双向链表可以直接删除的节点，找到以后自我删除即可
     * @param no
     */
    public void delete(int no){
        //判断当前链表是否为空

        if(head.next==null){
            System.out.println("链表为空，不能删除！");
            return;
        }

        HeroNode temp=head.next; //指针，辅助变量
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
            temp.pre.next=temp.next;
            //这里有风险，加入是删除最后的节点，那么temp.next=null;会报空引用，所以，最后一个节点不需要执行以下操作
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.println("未找到元素");
        }
    }

    // 4. 更新：
    public void update(HeroNode newHeroNode){
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

}
