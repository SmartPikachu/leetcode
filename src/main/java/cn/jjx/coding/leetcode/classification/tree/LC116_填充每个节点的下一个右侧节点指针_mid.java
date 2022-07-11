package cn.jjx.coding.leetcode.classification.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC116_填充每个节点的下一个右侧节点指针_mid {

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


    //方法一，采用层序遍历的方法
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            // 初始化队列同时将第一层节点加入队列中，即根节点
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);

            // 外层的 while 循环迭代的是层数
            while (!queue.isEmpty()) {

                // 记录当前队列大小
                int size = queue.size();

                // 遍历这一层的所有节点
                for (int i = 0; i < size; i++) {

                    // 从队首取出元素
                    Node node = queue.poll();

                    // 连接
                    if (i < size - 1) {
                        node.next = queue.peek();
                    }

                    // 拓展下一层节点
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            // 返回根节点
            return root;
        }
    }


    //方法二，使用已建立的next 指针，这个参考官方题解，写的很清晰了。
    class Solution1 {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            // 从根节点开始
            Node leftmost = root;

            while (leftmost.left != null) {

                // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
                Node head = leftmost;

                while (head != null) {

                    // CONNECTION 1
                    head.left.next = head.right;

                    // CONNECTION 2
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }

                    // 指针向后移动
                    head = head.next;
                }

                // 去下一层的最左的节点
                leftmost = leftmost.left;
            }

            return root;
        }
    }

}
