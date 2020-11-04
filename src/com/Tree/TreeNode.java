package com.Tree;

//树节点的公共类
public class TreeNode {
    public int getElement() {
        return element;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    int element;
    TreeNode left;
    TreeNode right;

    public TreeNode(int element){
        this.element=element;
        this.left=null;
        this.right=null;
    }

    public String toString(){
        return String.valueOf(element);
    }
}
