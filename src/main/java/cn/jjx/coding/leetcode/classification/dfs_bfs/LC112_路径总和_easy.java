package cn.jjx.coding.leetcode.classification.dfs_bfs;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC112_路径总和_easy {

    //广度优先搜索
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    //深度优先搜索
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return targetSum==root.val;
        }
        return hasPathSum1(root.left,targetSum-root.val) ||
                hasPathSum1(root.right,targetSum-root.val);
    }

}
