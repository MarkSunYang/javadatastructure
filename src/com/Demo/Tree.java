package com.Demo;

import com.company.HeroNode;

public class Tree {
    public static void main(String[] args) {
        //创建一颗二叉树
       BinaryTree bst=  new BinaryTree();
        Node root=new Node(1,"1");
        Node node2=new Node(2,"2");
        Node node3=new Node(3,"3");
        Node node4=new Node(4,"4");
        Node node5=new Node(5,"5");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);

        bst.setRoot(root);
        bst.preOrder();
    }
}

class BinaryTree{
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序
    public void preOrder(){
        if(this.root==null)
            System.out.println("empty tree");
        else
            this.root.preOrder();
    }

    public void midOrder(){
        if(this.root==null)
            System.out.println("empty tree");
        else
            this.root.midOrder();
    }

    public void postOrder(){
        if(this.root==null)
            System.out.println("empty tree");
        else
            this.root.postOrder();
    }

    public void delNode(){
        //

    }

}

class  Node{
    private int no;
    private String name;
    private Node left;
    private  Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void delNode(int no){

        //
        if(this.left!=null && this.left.no!=no){
            this.no=no;
            return;
        }
        if(this.right!=null && this.right.no!=no){
            this.no=no;
            return;
        }

        if(this.left!=null)
            this.left.delNode(no);

        if(this.right!=null)
            this.right.delNode(no);
    }

    //前
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //递归向左子树 前序遍历
        if(this.left!=null)
            this.left.preOrder();

        //递归向右子树前序遍历
        if(this.right!=null)
            this.right.preOrder();
    }

    /**
     * 找到返回node找不到返回null
     * @return
     */
    public Node preOrderSearch(int node){
        if(this.no==no){
            return null;
        }
        Node resNo=null;
        if(this.left!=null){
            resNo=this.left.preOrderSearch(no);
        }
        if(resNo!=null)
            return resNo;
        if(this.right!=null){
            resNo=this.right.preOrderSearch(no);
        }
        return resNo;
    }

    //中
    public void midOrder(){
        //递归向左子树中序遍历
        if(this.left!=null)
            this.left.midOrder();

        System.out.println(this);

        if(this.right!=null)
            this.right.midOrder();
    }

    //后
    public void postOrder(){
        if(this.left!=null)
            this.left.postOrder();
        if(this.right!=null)
            this.right.postOrder();
        System.out.println(this);
    }



    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
