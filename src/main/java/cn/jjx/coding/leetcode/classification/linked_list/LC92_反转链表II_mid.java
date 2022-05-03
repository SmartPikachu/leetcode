package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC92_反转链表II_mid {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法(头插法穿针引线)
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode pre = dummyNode;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i=0;i<right-left;i++){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummyNode.next;
    }
}
