package com.helloworld.demo.leetcode.tree;

import java.util.*;

public class BinaryTreeForeach {

    /**
     * 层序遍历
     * @param root
     */
    public List<List<Integer>> levelForeach(BinaryTreeReverse.TreeNode root){
        List<List<Integer>> levelValuesList = new ArrayList<>();
        if(Objects.isNull(root)){
            return levelValuesList;
        }
        Queue<BinaryTreeReverse.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            levelValuesList.add(new ArrayList<>());
            //一层中有多少个元素
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeReverse.TreeNode node = queue.poll();
                levelValuesList.get(levelValuesList.size()-1).add(node.val);
                if(Objects.nonNull(node.left)){
                    queue.offer(node.left);
                }
                if(Objects.nonNull(node.right)){
                    queue.offer(node.right);
                }
            }
        }
        return levelValuesList;
    }

}
