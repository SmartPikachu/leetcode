package cn.jjx.coding.leetcode.classification.two_pointers;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow=head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
