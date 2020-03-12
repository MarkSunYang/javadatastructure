package com.company;

public class HeroNode {
        public int no;
        public String name;
        public String nickName;
        public HeroNode next; //默认为null
        public HeroNode pre; //双向链表 指向前一个节点 默认为null

        public HeroNode(int no, String name, String nickName) {
                this.no = no;
                this.nickName = nickName;
                this.name = name;
                }

        public String toString() {
                return "HeroNode [no=" + no + ",name=" + name + "nickname=" + nickName + "]";
                }
        }
