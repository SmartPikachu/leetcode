package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.*;

public class LC270_最接近的二叉搜索树值_easy {

    //二分搜索的方法，效率最高
    class Solution {
        public int closestValue(TreeNode root, double target) {
            int val, closest = root.val;
            while (root != null) {
                val = root.val;
                closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
                root =  target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }


    //迭代的方法
    class Solution1 {
        public int closestValue(TreeNode root, double target) {
            LinkedList<TreeNode> stack = new LinkedList();
            long pred = Long.MIN_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.removeLast();

                if (pred <= target && target < root.val)
                    return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;

                pred = root.val;
                root = root.right;
            }
            return (int)pred;
        }
    }


    //递归+线性搜索
    class Solution2 {
        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) return;
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public int closestValue(TreeNode root, double target) {
            List<Integer> nums = new ArrayList();
            inorder(root, nums);
            return Collections.min(nums, (o1, o2) -> Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1);
        }
    }

}
