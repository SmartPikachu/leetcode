package cn.jjx.coding.leetcode.classification.aatest;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(0,0);
        list.add(0,1);
        list.add(0,2);
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
