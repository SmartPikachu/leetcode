package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

public class LC25_K个一组翻转链表_hard {


    //先将模拟的方法
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next != null){
            for(int i=0;i<k && end!=null;i++) end=end.next;
            if(end==null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;

    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }


    //递归的方法，当然方法很多，这里只介绍一种
    //区间是[a,b)
    private ListNode reverse(ListNode a,ListNode b){
        ListNode pre,cur,next;
        pre=null;cur=a;
        while(cur!=b){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if(head==null) return null;
        ListNode a = head,b=head;
        for(int i=0;i<k;i++){
            //不足k个不需要反转，base case
            if(b==null) return head;
            b=b.next;
        }
        //反转前k个元素
        ListNode newHead = reverse(a,b);
        a.next=reverseKGroup1(b,k);
        return newHead;

    }




}
