package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC236_二叉树的最近公共祖先_mid {

    //DFS不是官方的题解，是热度最高的。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null) return null;
        if(root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        //这块注意，p,q本来就不一定在二叉树中，所以这个合理。
        if(left==null && root==null) return null;

        return left==null?right:left;

    }
}
