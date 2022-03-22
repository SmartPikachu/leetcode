package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC450_删除二叉搜索树中的节点 {

    //寻找中序遍历的下一个节点
    public int successor(TreeNode root){
        root=root.right;
        while(root.left!=null) root=root.left;
        return root.val;
    }

    //寻找中序遍历的前一个节点
    public int predecessor(TreeNode root){
        root=root.left;
        while(root.right != null) root=root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else{
            if(root.left==null && root.right==null){
                root=null;
            }else if(root.right != null){
                //先把root节点赋值成找到的后驱节点
                root.val=successor(root);
                //然后删除这个后驱节点
                root.right=deleteNode(root.right,root.val);
            }else{
                //注意这里其实root.right是为空
                //先把root节点赋值成找到的前驱节点，然后在删除前驱节点
                root.val=predecessor(root);
                //然后删除前驱节点
                root.left=deleteNode(root.left,root.val);
            }
        }

        return root;
    }


}
