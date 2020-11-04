package com.Tree;

/**
 * 为了解决二叉排序树的问题：
 * 问题 https://www.bilibili.com/video/BV1B4411H76f?p=135
 * 1 左子树全部为空，从形式上看，更像一个单链表
 * 2 插入速度没有影响
 * 3 查询的速度明显降低，不能发挥bst的优势，因为每次需要比较左子树，查询速度比单链表要慢
 * 平衡二叉树(AVL)：左右两个子树的高度差的绝对值不超过1
 * 左右旋转：为了降低高度，
 * 1.创建一个新节点，值等于当前根节点的值 newnode=new Node()
 * 2.把新节点的左子树设置为当前节点的左子树 newnode.left=left;
 * 3.把当前节点的值转换为右子节点的值 newnode.right=right.left
 * 4.把当前节点的右子树设置成右子树的右子树  value=right.value
 * 5.吧当前节点的右子树设置为新节点 left=newleft
 */
public class AVLTree {

    public void add(TreeNode node,int value){

    }
}


class  AVLNode<T>{

}