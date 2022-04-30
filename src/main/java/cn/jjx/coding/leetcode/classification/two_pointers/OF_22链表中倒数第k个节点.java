package cn.jjx.coding.leetcode.classification.two_pointers;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class OF_22链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow=head;
        fast=slow=head;
        while(k>0){
            fast=fast.next;
            k--;
        }
        while(fast != null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;

    }

}
