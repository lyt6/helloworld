package com.hello.leetcode.binarytree;

import java.util.*;

public class BinaryTreeForeach {

    /**
     * 层序遍历
     *
     * @param root
     */
    public List<List<Integer>> levelForeach(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (Objects.isNull(root)) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            //一层中有多少个元素
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levels.get(levels.size() - 1).add(node.val);
                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return levels;
    }

    public List<List<Integer>> levelForeach2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) return resList;
        Queue<TreeNode> queue  = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(Objects.nonNull(node.left)){
                    queue.offer(node.left);
                }
                if(Objects.nonNull(node.right)){
                    queue.offer(node.right);
                }
            }
            resList.add(levelList);
        }
        return resList;
    }



}
