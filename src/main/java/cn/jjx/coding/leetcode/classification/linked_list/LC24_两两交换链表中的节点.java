package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC24_两两交换链表中的节点 {

    //使用递归的方法
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next=swapPairs(newHead.next);
        newHead.next=head;
        return newHead;
    }

    public ListNode swapPairs1(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;
        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummyHead.next;
    }
}
