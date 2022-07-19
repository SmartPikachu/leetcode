package cn.jjx.coding.leetcode.classification.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC146_LRUCache_mid {

    //采用labuladong的方法，利用java内置LinkedHashMap来实现。
    //代码简洁，但是没有自己定义链表，还是有些取巧的成分。
    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }


    //官方题解，自己定义链表来实现。
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key,int value){
            this.key =key;
            this.value=value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LC146_LRUCache_mid(int capacity){
        this.size=0;
        this.capacity=capacity;
        //使用伪头部和尾部节点
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node==null){
         return -1;
        }
        //如果key存在，想通过哈希表定位，在再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node==null){
            //如果key不存在，则创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key,value);
            //添加进哈希表
            cache.put(key,newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            size++;
            if(size>capacity){
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = remvoeTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            //如果key存在，先通过哈希表定位，然后修改value,并且移动到头部
            node.value=value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev = node;
        head.next=node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode remvoeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


}
