package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC285_二叉搜索树的中序后继_mid {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p==null||root==null) return null;
        if(root.val<=p.val){
            return inorderSuccessor(root.right,p);
        }
        TreeNode res=inorderSuccessor(root.left,p);
        if(res!=null){
            return res;
        }else{
            return root;
        }
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if(p==null || root==null) return null;
        TreeNode cur=root;
        TreeNode res=null;
        while(cur!=null){
            if(cur.val<=p.val){
                cur=cur.right;
            }else{
                if(res==null || res.val>cur.val){
                    res=cur;
                }
                cur=cur.left;
            }
        }
        return res;
    }

}
