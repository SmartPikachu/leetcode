package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC250_统计同值子树_mid {

    //深度优先搜索，官方题解。
    public class Solution {
        int count = 0;
        boolean is_uni(TreeNode node) {
            //base case - if the node has no children this is a univalue subtree
            if (node.left == null && node.right == null) {

                // found a univalue subtree - increment
                count++;
                return true;
            }

            boolean is_unival = true;

            // check if all of the node's children are univalue subtrees and if they have the same value
            // also recursively call is_uni for children
            if (node.left != null) {
                is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
            }

            if (node.right != null) {
                is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
            }

            // return if a univalue tree exists here and increment if it does
            if (!is_unival) return false;
            count++;
            return true;
        }

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) return 0;
            is_uni(root);
            return count;
        }
    }

    //传父值的深度优先搜索，官方题解。
    public class Solution1 {
        int count = 0;
        boolean is_valid_part(TreeNode node, int val) {

            // considered a valid subtree
            if (node == null) return true;

            // check if node.left and node.right are univalue subtrees of value node.val
            // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
            if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val)) return false;

            // if it passed the last step then this a valid subtree - increment
            count++;

            // at this point we know that this node is a univalue subtree of value node.val
            // pass a boolean indicating if this is a valid subtree for the parent node
            return node.val == val;
        }
        public int countUnivalSubtrees(TreeNode root) {
            is_valid_part(root, 0);
            return count;
        }
    }


}
