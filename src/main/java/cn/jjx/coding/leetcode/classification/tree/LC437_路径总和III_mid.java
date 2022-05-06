package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC437_路径总和III_mid {

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int ret=dfs(root,targetSum);
        ret+=pathSum(root.left,targetSum);
        ret+=pathSum(root.right,targetSum);
        return ret;
    }

    public int dfs(TreeNode node, int targetSum){
        int ret=0;
        if(node==null) return 0;
        if(node.val==targetSum) ret++;
        ret+=dfs(node.left,targetSum-node.val);
        ret+=dfs(node.right,targetSum-node.val);
        return ret;
    }
}
