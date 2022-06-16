package cn.jjx.coding.leetcode.classification.queue;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC515_在每个树行中找最大值_mid {

    public List<Integer> largestValues(TreeNode root) {
        //LinkedList实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if (root != null)
            queue.add(root);//入队
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int levelSize = queue.size();//每一层的数量
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//出队
                max = Math.max(max, node.val);//记录每层的最大值
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            values.add(max);
        }
        return values;
    }
}
