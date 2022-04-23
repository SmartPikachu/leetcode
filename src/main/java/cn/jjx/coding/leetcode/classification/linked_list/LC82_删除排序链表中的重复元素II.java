package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC82_删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x = cur.next.val;
                while(cur.next!=null && cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
