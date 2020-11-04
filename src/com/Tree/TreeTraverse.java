package com.Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        TreeNode node= tree.CreateTree();
        TreeTraverse ts=new TreeTraverse();
        ts.preOrder(node);
        ts.midOrder(node);
    }

    //前序:中左右 方法1：递归方式
    public void preOrder(TreeNode node){
        if(node==null){
           return;
        }else{
            System.out.println(node+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //方法2：栈实现前序
    //这种实现类似于图的深度优先遍历
    //维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
    //这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用
    public void StackPreOrder(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()){
            node=stack.pop();
            System.out.println(node +" ");
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }

    //中序：左右中
    public void midOrder(TreeNode node){
        if(node==null){
            return;
        }else{
            midOrder(node.left);
            System.out.println(node+" ");
            midOrder(node.right);
        }
    }

    //后序：左右中
    public void postOrder(TreeNode node){
        if(node==null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node+" ");
    }

    //
    public void levelTravel(TreeNode node){
        if(node==null)return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            TreeNode treeNode=q.poll();
            System.out.println(treeNode+" ");
            if(node.left!=null) q.add(treeNode.left);
            if(node.right!=null) q.add(treeNode.right);
        }
    }
}

class BinTree{

}

