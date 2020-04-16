package com.Tree;

public class Tree {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();

        HeroNode root= new HeroNode(1,"mark");
        HeroNode node1=new HeroNode(2,"malik");
        HeroNode node2=new HeroNode(3,"jane");
        HeroNode node3=new HeroNode(4,"matt");
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);

        tree.setRoot(root);

        //前序 中左右
        tree.preOrder();//1234

        //中序 左中右
        tree.infixOrder();//
    }


    //前序

    //后序

    //中序

}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root=root;
    }

    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

}

class HeroNode {
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int no;
    private String name;
    private HeroNode left;//默认null
    private  HeroNode right;//默认null

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序:中左右
     */
    public void preOrder(){
        System.out.println(this);//先输出父节点
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    /**
     * 前序查找
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no){
        if(this.no==no){
            return this;
        }
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=infixOrderSearch(no);
        }
        if(this.no==no){
            return this;
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 左中右
     */
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    /**
     *
     */
    public void postOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }

        if(this.right!=null){
            this.right.infixOrder();
        }
        System.out.println(this);
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}









