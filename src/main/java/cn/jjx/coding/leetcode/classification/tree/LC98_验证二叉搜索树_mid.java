package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC98_验证二叉搜索树_mid {
    //递归
    public boolean isValidBST(TreeNode root) {
        return isVaildBST(root,Integer.MIN_VALUE-1L,Integer.MAX_VALUE+1L);
    }

    public boolean isVaildBST(TreeNode node,long lower,long upper){
        if(node==null){
            return true;
        }
        if(node.val<=lower || node.val>=upper){
            return false;
        }
        return isVaildBST(node.left,lower,node.val) &&
                isVaildBST(node.right,node.val,upper);
    }

    //非递归中序遍历
    public boolean isValidBST1(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        long inOrder = Integer.MIN_VALUE-1L;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            //如果中序遍历的值小于前一个inOrder那么说明不是二叉搜索树
            if(root.val<=inOrder){
                return false;
            }
            inOrder=root.val;
            root=root.right;
        }
        return true;
    }
}
