package cn.jjx.coding.leetcode.classification.linked_list;

import cn.jjx.coding.leetcode.data_structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC382_链表随机节点_mid {

    //水塘抽样
    class Solution {
        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int i = 1, ans = 0;
            for (ListNode node = head; node != null; node = node.next) {
                if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                    ans = node.val;
                }
                ++i;
            }
            return ans;
        }
    }

    class Solution1 {
        List<Integer> list;
        Random random;

        public Solution1(ListNode head) {
            list = new ArrayList<Integer>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            random = new Random();
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
