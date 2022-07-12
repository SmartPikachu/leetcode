package cn.jjx.coding.leetcode.classification.aatest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>((s1,s2)->s1.length()-s2.length());
        set.add("aaa");
        set.add("bbb");
        Iterator<String > iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
