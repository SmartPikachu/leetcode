package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class OF_26_树的子结构_mid {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) &&
                (dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if(B==null) return true;
        if(A==null || A.val!=B.val) return false;
        return dfs(A.left,B.left)&&dfs(A.right,B.right);
    }
}

