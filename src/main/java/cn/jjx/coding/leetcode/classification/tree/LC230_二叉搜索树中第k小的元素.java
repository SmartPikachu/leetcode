package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC230_二叉搜索树中第k小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }

    class MyBst {
        TreeNode root;
        Map<TreeNode, Integer> nodeNum;

        public MyBst(TreeNode root) {
            this.root = root;
            this.nodeNum = new HashMap<TreeNode, Integer>();
            countNodeNum(root);
        }

        // 返回二叉搜索树中第k小的元素
        public int kthSmallest(int k) {
            TreeNode node = root;
            while (node != null) {
                int left = getNodeNum(node.left);
                if (left < k - 1) {
                    node = node.right;
                    k -= left + 1;
                } else if (left == k - 1) {
                    break;
                } else {
                    node = node.left;
                }
            }
            return node.val;
        }

        // 统计以node为根结点的子树的结点数
        private int countNodeNum(TreeNode node) {
            if (node == null) {
                return 0;
            }
            nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
            return nodeNum.get(node);
        }

        // 获取以node为根结点的子树的结点数
        private int getNodeNum(TreeNode node) {
            return nodeNum.getOrDefault(node, 0);
        }
    }

}
