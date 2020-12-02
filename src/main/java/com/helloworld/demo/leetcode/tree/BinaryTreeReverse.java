package com.helloworld.demo.leetcode.tree;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;


/**
 * 二叉树反转
 */
public class BinaryTreeReverse {

    /**
     * TreeNode
     */
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 栈-翻转二叉树
     * @param root
     * @return
     */
    public TreeNode reverseByStack(TreeNode root){
        if(Objects.isNull(root)) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right= left;
            if(Objects.nonNull(node.left)){
                stack.push(node.left);
            }
            if(Objects.nonNull(node.right)){
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 队列-翻转二叉树
     * @param root
     * @return
     */
    public TreeNode reverseByQueue(TreeNode root){
        if(Objects.isNull(root)){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(Objects.nonNull(node.left)){
                queue.offer(node.left);
            }
            if(Objects.nonNull(node.right)){
                queue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 递归-翻转二叉树
     * 1、先互换左手节点
     * 2、然后分别互换左右子节点
     * @param root
     * @return
     */
    public TreeNode reverseByRecursion(TreeNode root){
        if(Objects.isNull(root)){
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        reverseByRecursion(root.left);
        reverseByRecursion(root.right);
        return root;
    }

    /**
     * 翻转二叉树
     * 1、先转换左右子节点
     * 2、然后互换左右节点
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
