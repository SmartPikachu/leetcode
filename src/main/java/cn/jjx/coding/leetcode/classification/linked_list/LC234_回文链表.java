package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC234_回文链表 {
    /**
     * 找到前半部分链表的尾节点。
     * 反转后半部分链表。
     * 判断是否回文。
     * 恢复链表。
     * 返回结果。
     */

    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1=head;
        ListNode p2=secondHalfStart;
        boolean result = true;
        while(result && p2!=null){
            if(p1.val!=p2.val){
                result=false;
            }
            p1=p1.next;
            p2=p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next=reverseList(secondHalfStart);
        return result;

    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode nextTemp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

}
