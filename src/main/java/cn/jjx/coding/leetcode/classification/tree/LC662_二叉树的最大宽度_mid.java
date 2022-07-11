package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC662_二叉树的最大宽度_mid {

    /**
     * 这个不是官方题解，可以看看下面的官方题解，感觉这个写的就不错。
     * 因为每个节点原本的值是没有用处的，所以我们可以用其来保存节点的位置信息
     * 所用的算法知识点（完全二叉树的性质）：对于一颗完全二插树，如果按照从上至下，从左往右对所有节点从零开始顺序编号
     * 则父节点的左孩子节点的序号：2*i+1   父节点的左孩子节点的序号：2*i+2;
     * 所以每层的宽度就可以使用：每层最后一个节点的值减去最后一个节点的值+1
     */
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            // 避免异常的产生
            if(root==null){
                return 0;
            }
            // 创建一个队列来进行广度优先遍历,注意这个地方就不要使用Queue<TreeNode> queue=new LinkedList<TreeNode>();
            // 因为父类不能调用子类的方法：getLast getFirst
            LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
            // 创建一个变量来保存最大宽度
            int maxwidth=0;
            // 将根节点入队列
            queue.offer(root);
            // 改变根结点的值
            root.val=0;
            while(!queue.isEmpty()){
                // 记录当前队列中的个数
                int cout=queue.size();
                //创建一个变量来计算每层的宽度
                int width=queue.getLast().val-queue.getFirst().val+1;
                for(int i=0;i<cout;i++){
                    TreeNode temp=queue.poll();
                    if(temp.left!=null){
                        queue.offer(temp.left);
                        temp.left.val=temp.val*2+1;
                    }
                    if(temp.right!=null){
                        queue.offer(temp.right);
                        temp.right.val=temp.val*2+2;
                    }
                }
                // 求出每一层的宽度
                // 通过比较找除最大宽度
                if(width>maxwidth){
                    maxwidth=width;
                }
            }
            return maxwidth;
        }
    }


    //官方题解，广度优先搜索
    class Solution1 {
        public int widthOfBinaryTree(TreeNode root) {
            Queue<AnnotatedNode> queue = new LinkedList();
            queue.add(new AnnotatedNode(root, 0, 0));
            int curDepth = 0, left = 0, ans = 0;
            while (!queue.isEmpty()) {
                AnnotatedNode a = queue.poll();
                if (a.node != null) {
                    queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                    queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                    if (curDepth != a.depth) {
                        curDepth = a.depth;
                        left = a.pos;
                    }
                    ans = Math.max(ans, a.pos - left + 1);
                }
            }
            return ans;
        }
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }


    //官方题解，深度优先算法。
    class Solution2 {
        int ans;
        Map<Integer, Integer> left;
        public int widthOfBinaryTree(TreeNode root) {
            ans = 0;
            left = new HashMap<>();
            dfs(root, 0, 0);
            return ans;
        }
        public void dfs(TreeNode root, int depth, int pos) {
            if (root == null) return;
            left.computeIfAbsent(depth, x-> pos);
            ans = Math.max(ans, pos - left.get(depth) + 1);
            dfs(root.left, depth + 1, 2 * pos);
            dfs(root.right, depth + 1, 2 * pos + 1);
        }
    }


}
