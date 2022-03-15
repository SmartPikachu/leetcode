package cn.jjx.coding.leetcode.labuladong.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;

public class LC98_验证二叉搜索树 {
    //递归
    public boolean isValidBST(TreeNode root) {
        return isVaildBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isVaildBST(TreeNode node,long lower,long upper){
        if(node==null){
            return true;
        }
        if(node.val<=lower || node.val>=upper){
            return false;
        }
        return isVaildBST(node.left,lower,node.val) && isVaildBST(node.right,node.val,upper);
    }

    //非递归中序遍历
    public boolean isValidBST1(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inOrder = -Double.MAX_VALUE;
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
