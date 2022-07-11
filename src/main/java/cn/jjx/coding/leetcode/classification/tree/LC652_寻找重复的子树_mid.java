package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC652_寻找重复的子树_mid {

    //采用深度优先的算法,官方题解
    class Solution {
        Map<String, Integer> count;
        List<TreeNode> ans;
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap<>();
            ans = new ArrayList<>();
            collect(root);
            return ans;
        }

        public String collect(TreeNode node) {
            if (node == null) return "#";
            String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
            count.put(serial, count.getOrDefault(serial, 0) + 1);
            if (count.get(serial) == 2)
                ans.add(node);
            return serial;
        }
    }


    //方法二：唯一标识符【通过】,具体参考官方题解。
    class Solution1 {
        int t;
        Map<String, Integer> trees;
        Map<Integer, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            t = 1;
            trees = new HashMap<>();
            count = new HashMap<>();
            ans = new ArrayList<>();
            lookup(root);
            return ans;
        }

        public int lookup(TreeNode node) {
            if (node == null) return 0;
            String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
            int uid = trees.computeIfAbsent(serial, x-> t++);
            count.put(uid, count.getOrDefault(uid, 0) + 1);
            if (count.get(uid) == 2)
                ans.add(node);
            return uid;
        }
    }

}
