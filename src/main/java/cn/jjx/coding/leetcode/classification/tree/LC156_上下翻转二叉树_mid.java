package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC156_上下翻转二叉树_mid {

    //这个没有官方题解，不过看下面的注释也能完全看懂，有点类似链表的处理。
    //写的非常简练优美。
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode right = null, father = null;
        while(root != null){
            //为了继续遍历，先记录下原来的左子节点防止丢失
            TreeNode left = root.left;
            //当前节点的左子节点更新为父节点的右子节点
            root.left = right;
            //记录下当前节点的右子节点
            right = root.right;
            //当前节点的右子节点更新为原父节点
            root.right = father;
            //记录下当前节点作为下一个待遍历节点的父节点（新右子节点）
            father = root;
            root = left;
        }
        //最终root=null,father指向的是最终的根节点
        return father;
    }

}
