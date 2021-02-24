package com.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t21 = new TreeNode(21);
        TreeNode t22 = new TreeNode(22);
        TreeNode t31 = new TreeNode(31);
        TreeNode t32 = new TreeNode(32);
        TreeNode t211 = new TreeNode(211);
        TreeNode t212 = new TreeNode(211);

        root.left = t2;
        root.right = t3;
        t2.left = t21;
        t2.right = t22;
        t3.left = t31;
        t3.right = t32;
//        t21.left=t211;
//        t21.right=t212;
        System.out.println();
    }

    public boolean IsAVL(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }


}