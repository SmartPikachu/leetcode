package cn.jjx.coding.leetcode.classification.two_pointers;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC142_环形链表II_mid {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast,slow;
        fast=slow=head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        if(fast == null || fast.next == null) return null;
        slow=head;
        while(slow != fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
