package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class OF_34_二叉树中和为某一值的路径_mid {

    Deque<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return ans;
    }

    public void dfs(TreeNode root, int target){
        if(root==null) return;
        path.offerLast(root.val);
        target-=root.val;
        if(root.left==null&&root.right==null&&target==0){
            ans.add(new LinkedList<>(path));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        path.pollLast();
    }


}
