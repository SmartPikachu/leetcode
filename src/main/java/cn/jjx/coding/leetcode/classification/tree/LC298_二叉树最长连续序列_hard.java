package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC298_二叉树最长连续序列_hard {

    //自顶向下的深度优先搜索，以maxLength作为全局变量
    private int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }

    private void dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) return;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }


    //自顶向下的深度优先搜索，不用maxLength作为全局变量
    class Solution{
        public int longestConsecutive(TreeNode root) {
            return dfs(root, null, 0);
        }

        private int dfs(TreeNode p, TreeNode parent, int length) {
            if (p == null) return length;
            length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
            return Math.max(length, Math.max(dfs(p.left, p, length),
                    dfs(p.right, p, length)));
        }
    }


    //采用自底向上的深度优先搜索
    class Solution1{
        private int maxLength = 0;
        public int longestConsecutive(TreeNode root) {
            dfs(root);
            return maxLength;
        }

        private int dfs(TreeNode p) {
            if (p == null) return 0;
            int L = dfs(p.left) + 1;
            int R = dfs(p.right) + 1;
            if (p.left != null && p.val + 1 != p.left.val) {
                L = 1;
            }
            if (p.right != null && p.val + 1 != p.right.val) {
                R = 1;
            }
            int length = Math.max(L, R);
            maxLength = Math.max(maxLength, length);
            return length;
        }
    }

}
