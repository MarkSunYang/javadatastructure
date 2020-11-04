package com.Tree;

public class TreeEmpytCount {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        TreeNode node= tree.CreateTree();
        System.out.println(countFullNode(node));
    }

    //统计叶子节点
    public static int countEmpty(TreeNode node){
        if(node==null) return 0;
        if(node.left==null && node.right==null)
            return 1;
        return countEmpty(node.left)+countEmpty(node.right);
    }

    //统计一棵二叉树的有一个非空子树的节点的数量
    public static int countSingleNode(TreeNode node){
        int total=0;
        if(node==null) return 0;
        if((node.left==null && node.right!=null)||(node.left!=null && node.right==null))
            return 1;
        total=countSingleNode(node.left)+countSingleNode(node.right);
        return total;
    }

    public  static  int countFullNode(TreeNode node){
        int total=0;
        if(node==null) return 0;
        if(node.left!=null && node.right!=null)
            return 1;
        total=countSingleNode(node.left)+countSingleNode(node.right);
        return total;
    }

}
