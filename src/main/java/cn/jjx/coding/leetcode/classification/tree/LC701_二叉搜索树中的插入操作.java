package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC701_二叉搜索树中的插入操作 {
    //非递归的方法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while(pos!=null){
            if(val<pos.val){
                if(pos.left == null){
                    pos.left = new TreeNode(val);
                    break;
                }else{
                    pos=pos.left;
                }
            }else{
                if(pos.right==null){
                    pos.right=new TreeNode(val);
                    break;
                }else{
                    pos=pos.right;
                }
            }
        }
        return root;
    }

    //递归取数
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        //找到空位置插入节点
        if(root==null) return new TreeNode(val);
        //如果存在，则不要重复插入了，直接返回
        if(root.val==val) return root;
        if(root.val<val){
            root.right=insertIntoBST1(root.right,val);
        }
        if(root.val>val){
            root.left=insertIntoBST1(root.left,val);
        }
        return root;
    }
}
