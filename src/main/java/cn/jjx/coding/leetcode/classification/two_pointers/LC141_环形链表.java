package cn.jjx.coding.leetcode.classification.two_pointers;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast,slow;
        fast=slow=head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
