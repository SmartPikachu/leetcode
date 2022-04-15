package cn.jjx.coding.leetcode.classification.dynamic_programming;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC337_打家劫舍III {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }




    //仅仅是优化了没有使用hashmap而已
    public int rob1(TreeNode root) {
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs1(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs1(node.left);
        int[] r = dfs1(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }

}
