package cn.jjx.coding.leetcode.classification.divide_and_conquer;

import cn.jjx.coding.leetcode.data_structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23_合并k个排序链表_hard {

    //采用分治合并的方法
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    //这块的递归写法
    public ListNode mergeTwoLists1(ListNode a, ListNode b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.val<b.val){
            a.next=mergeTwoLists1(a.next,b);
            return a;
        }else{
            b.next=mergeTwoLists1(a,b.next);
            return b;
        }
    }


    //采用优先队列的方法，也很巧妙值得一看
    public ListNode mergeKLists1(ListNode[] lists){
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
                (o1, o2) -> {
                    if(o1.val<o2.val) return -1;
                    else if(o1.val==o2.val) return 0;
                    else return 1;
                });
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(ListNode node:lists){
            if(node!=null) queue.add(node);
        }
        while(!queue.isEmpty()){
            temp.next=queue.poll();
            temp=temp.next;
            if(temp.next!=null) queue.add(temp.next);
        }

        return dummy.next;
    }

}
