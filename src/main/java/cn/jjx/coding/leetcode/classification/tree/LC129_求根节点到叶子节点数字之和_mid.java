package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC129_求根节点到叶子节点数字之和_mid {

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode node, int sum){
        if(node==null) return 0;
        sum=sum*10+node.val;
        if(node.left==null&&node.right==null){
            return sum;
        }else{
            return dfs(node.left,sum)+dfs(node.right,sum);
        }

    }
}
