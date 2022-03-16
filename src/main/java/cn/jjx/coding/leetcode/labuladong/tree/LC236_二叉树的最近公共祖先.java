package cn.jjx.coding.leetcode.labuladong.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC236_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        if(left==null && root==null) return null;

        return left==null?right:left;

    }
}
