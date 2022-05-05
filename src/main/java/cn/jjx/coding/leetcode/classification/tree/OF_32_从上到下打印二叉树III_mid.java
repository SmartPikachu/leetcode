package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.*;

public class OF_32_从上到下打印二叉树III_mid {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        boolean isOrderLeft=true;
        while(!nodeQueue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for(int i=0;i<size;i++){
                TreeNode curNode = nodeQueue.poll();
                if(isOrderLeft){
                    levelList.offerLast(curNode.val);
                }else{
                    levelList.offerFirst(curNode.val);
                }
                if(curNode.left!=null){
                    nodeQueue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft=!isOrderLeft;
        }
        return ans;
    }
}
