package cn.jjx.coding.leetcode.classification.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC117_填充每个节点的下一个右侧节点指针II_mid {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    //方法一，采用层序遍历的方式，这道题与116的差别就是这棵树不是一个完美二叉树
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                Node last = null;
                for (int i = 1; i <= n; ++i) {
                    Node f = queue.poll();
                    if (f.left != null) {
                        queue.offer(f.left);
                    }
                    if (f.right != null) {
                        queue.offer(f.right);
                    }
                    if (i != 1) {
                        last.next = f;
                    }
                    last = f;
                }
            }
            return root;
        }
    }


    //方法二，采用next指针的方式，在上一层为下一层创建next指针。这道题与116的差别就是这棵树不是一个完美二叉树
    class Solution1 {

        Node last = null, nextStart = null;

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node start = root;
            while (start != null) {
                last = null;
                nextStart = null;
                for (Node p = start; p != null; p = p.next) {
                    if (p.left != null) {
                        handle(p.left);
                    }
                    if (p.right != null) {
                        handle(p.right);
                    }
                }
                start = nextStart;
            }
            return root;
        }

        public void handle(Node p) {
            if (last != null) {
                last.next = p;
            }
            if (nextStart == null) {
                nextStart = p;
            }
            last = p;
        }
    }

}
