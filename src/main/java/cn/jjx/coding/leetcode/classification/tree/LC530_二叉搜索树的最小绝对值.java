package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.Stack;

public class LC530_二叉搜索树的最小绝对值 {

    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    //广度优先搜索
    TreeNode pre1;
    Stack<TreeNode> stack;
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) return 0;
        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left; // 左
            }
            cur = stack.pop();
            if (pre1 != null) { // 中
                result = Math.min(result, cur.val - pre1.val);
            }
            pre1 = cur;
            cur = cur.right; // 右

        }
        return result;
    }

}
