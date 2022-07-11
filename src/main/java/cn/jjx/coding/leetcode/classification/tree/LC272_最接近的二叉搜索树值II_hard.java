package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC272_最接近的二叉搜索树值II_hard {
    /**
     * 中序遍历。因为是BST，所以中序遍历可确保元素从小到大访问
     * 普通队列。在保证遍历顺序的前提下，普通队列的队列头，即是离target最远的节点
     * 剪枝。当队列长度已经到达k，且队列头q.peek()的相比当前元素root离target更近，则没必要再继续遍历了(继续就更远了)。
     * 时间复杂度O(N), 空间复杂度O(k)
     */

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> q = new LinkedList();
        inorder(q, root, target, k);
        return new ArrayList(q);
    }
    private void inorder(Queue<Integer> q, TreeNode root, double target, int k) {
        if (root == null) return;
        inorder(q, root.left, target, k);
        if (q.size() == k) {
            if (Double.compare(Math.abs(q.peek() - target), Math.abs(root.val - target)) > 0) {
                q.poll();
                q.offer(root.val);
            } else return;
        } else {
            q.offer(root.val);
        }
        inorder(q, root.right, target, k);
    }

}
