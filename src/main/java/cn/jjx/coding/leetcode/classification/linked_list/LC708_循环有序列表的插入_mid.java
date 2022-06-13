package cn.jjx.coding.leetcode.classification.linked_list;

public class LC708_循环有序列表的插入_mid {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                // Case 1),新节点的值位于当前链表的最小值和最大值之间。
                toInsert = true;
            } else if (prev.val > curr.val) {
                // Case 2),新值超出了链表中的最小值和最大值，即小于最小值或大于最大值。
                if (insertVal >= prev.val || insertVal <= curr.val)
                    toInsert = true;
            }

            if (toInsert) {
                prev.next = new Node(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        // Case 3),链表的元素的值相同。
        prev.next = new Node(insertVal, curr);
        return head;
    }
}
