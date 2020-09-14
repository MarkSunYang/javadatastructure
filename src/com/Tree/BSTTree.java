package com.Tree;

import java.util.ArrayList;

public class BSTTree {
    public static void main(String[] args) {
        int[] arr={7,3,10,12,5,1,9};
        BST bst=new BST();

        for (int i=0;i<arr.length;i++){
            bst.add(new Node(arr[i]));
        }

        //中序遍历
        bst.infixOrder();
    }




}
class Node{
    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node [Value="+value+"]";
    }

    public Node(int value){
        this.value=value;
    }

    /**
     * 添加节点
     * 递归的形式添加节点，注意需要满足二叉排序树的要求
     */
    public  void  add(Node node){
        if(node==null){
            return;
        }

        //判断传入节点的值,和当前子树的根节点的值关系
        if(node.value<this.value){
            //当前节点左子节点为null
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);//递归的向左子树添加
            }
        }else {
            //添加节点的值大于当前节点的值
            if (this.right==null){
                this.right=node;
            }else{
                this.right.add(node);
            }
        }

    }

    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
}

class  BST{
    private Node root;

    public  void add(Node node){
        if(root==null){
            root=node;//root为空，root指向node
        }else{
            root.add(node);
        }
    }

    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else{
            System.out.println("当前为空");
        }
    }
}
