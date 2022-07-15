package cn.jjx.coding.leetcode.classification.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC406_根据身高重建队列_mid {

    //官方题解方法二
    //从高到低考虑，首先按照身高从高到底排队，如果身高相同，按照前面比自己高的人由少到多排序
    //这样话就只考虑前面有多少比自己高的就行，利用list.add(index,value)
    //如果index位置存在元素，则从index开始往后，所有元素都向后移位一次。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    //官方题解方法一
    //从低到高考虑，身高是从低到高排列，如果身高相同，按照前边比自己高的人从多到少排列
    //本质从小到大排序，i元素前面的i-1个元素对i是没有影响的，类似于插空的方法。
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
