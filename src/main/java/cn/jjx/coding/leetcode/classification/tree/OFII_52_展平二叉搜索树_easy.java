package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class OFII_52_展平二叉搜索树_easy {

    //中序遍历生成新的树
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode curNode = dummyNode;
        for(int value:res){
            curNode.right=new TreeNode(value);
            curNode=curNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res){
        if(node==null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }


    private TreeNode resNode;

    //在中序遍历中改变节点指向
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode=dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);

        //在中序遍历中改变节点指向
        resNode.right=node;
        node.left=null;
        resNode=node;

        inorder(node.right);
    }

}
