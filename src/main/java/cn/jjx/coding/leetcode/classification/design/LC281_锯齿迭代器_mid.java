package cn.jjx.coding.leetcode.classification.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC281_锯齿迭代器_mid {

    //使用队列和迭代器来实现交替迭代。
    class ZigzagIterator {
        Queue<Iterator<Integer>> queue = new LinkedList<>();
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            Iterator<Integer> it1 = v1.iterator();
            Iterator<Integer> it2 = v2.iterator();
            if (it1.hasNext()) {
                queue.add(it1);
            }
            if (it2.hasNext()) {
                queue.add(it2);
            }
        }

        public int next() {
            Iterator<Integer> it = queue.poll();
            int v = it.next();
            if (it.hasNext()) {
                queue.add(it);
            }
            return v;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }


}
