package com.Tree;

/**
 * 二叉排序树：对于二叉排序树的任意一个非叶子节点，要求左子节点的值比前节点的值小，右子节点的值别当前节点的值大
 * 如果有相同的值，可以将该节点放到左子节点或右子节点
 */
public class BSTTree {
    //插入节点
    public void add(TreeNode node, int value) {
        if (node == null) return;;

        if (value <= node.element) {
            //如果当前节点左子树为空，则将当前值赋给左子树，否则继续遍历
           if(node.left==null){
               node.left= node;
               node.element=value;
           }else{
               add(node,value);
           }
        } else {
            if(node.right==null){
                node.right= node;
                node.element=value;
            }else{
                add(node,value);
            }
        }
    }

    //删除节点

    /**
     * 1.删除叶子节点 （1.找到该节点；2.找到该节点的父节点 还需要考虑是否有父节点 3.判断该节点是父节点的左子树还是右子树 ）
     * 2.删除只有一颗子树的节点
     *     2.1. targetnode没有节点直接删除
     *     2.2. targetnode（可能是左右节点） 右节点（左或右）parent.left=target.left   parent.left=target.left 这里有四种情况
     * 3.删除有两颗子树的节点
     *    3.1. 找到该节点和该节点的父节点
     *    3.2。从target的右子树找到最小的节点
     *    3.3. 用一个临时变量，将最小的值保存 temp=12
     *    targetnode.value=temp
     */


}

