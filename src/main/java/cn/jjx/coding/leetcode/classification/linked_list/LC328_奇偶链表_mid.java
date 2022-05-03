package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC328_奇偶链表_mid {

    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head,even=evenHead;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
