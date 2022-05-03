package cn.jjx.coding.leetcode.classification.design;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC460_LFUCache_hard {

    class Node{
        int key,val,freq;
        Node(int key,int val,int freq){
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    int minFreq,capacity;
    Map<Integer,Node> keyTable;
    Map<Integer, LinkedList<Node>> freqTable;

    public LC460_LFUCache_hard(int capacity){
        this.minFreq=0;
        this.capacity=capacity;
        keyTable=new HashMap<Integer,Node>();
        freqTable=new HashMap<Integer, LinkedList<Node>>();
    }

    public int get(int key){
        if(capacity==0){
            return -1;
        }
        if(!keyTable.containsKey(key)) return -1;
        Node node = keyTable.get(key);
        int val=node.val,freq=node.freq;
        freqTable.get(freq).remove(node);
        //如果当前链表为空，我们需要在哈希表中删除，且更新minFreq
        if(freqTable.get(freq).size()==0){
            freqTable.remove(freq);
            if(minFreq==freq){
                minFreq+=1;
            }
        }
        //插入到freq+1中
        LinkedList<Node> list = freqTable.getOrDefault(freq+1,new LinkedList<Node>());
        list.offerFirst(new Node(key,val,freq+1));
        freqTable.put(freq+1,list);
        keyTable.put(key,freqTable.get(freq+1).peekFirst());
        return val;
    }

    public void put(int key,int value){
        if(capacity==0){
            return;
        }
        if(!keyTable.containsKey(key)){
            //缓存已满，需要进行删除操作
            if(keyTable.size()==capacity){
                //通过minFreq拿到freqTable[minFreq]链表的末尾节点
                Node node = freqTable.get(minFreq).peekLast();
                keyTable.remove(node.key);
                freqTable.get(minFreq).pollLast();
                if(freqTable.get(minFreq).size()==0){
                    freqTable.remove(minFreq);
                }
            }
            LinkedList<Node> list =freqTable.getOrDefault(1,new LinkedList<Node>());
            list.offerFirst(new Node(key,value,1));
            freqTable.put(1,list);
            keyTable.put(key,freqTable.get(1).peekFirst());
            minFreq=1;
        }else{
            //与get操作基本一致，除了需要更新缓存的值
            Node node = keyTable.get(key);
            int freq=node.freq;
            freqTable.get(freq).remove(node);
            if(freqTable.get(freq).size()==0){
                freqTable.remove(freq);
                if(minFreq==freq){
                    minFreq+=1;
                }
            }
            LinkedList<Node> list = freqTable.getOrDefault(freq+1,new LinkedList<Node>());
            list.offerFirst(new Node(key,value,freq+1));
            freqTable.put(freq+1,list);
            keyTable.put(key,freqTable.get(freq+1).peekFirst());
        }
    }

}
