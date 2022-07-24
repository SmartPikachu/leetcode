package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.*;

public class LC838_推多米诺_mid {


    /**
     * 采用模拟的方法，代码简单,这个才是这道题的最优解法，并且思路简单。
     * 如果两边的骨牌同向，那么这段连续的竖立骨牌会倒向同一方向。
     * 如果两边的骨牌相对，那么这段骨牌会向中间倒。
     * 如果两边的骨牌相反，那么这段骨牌会保持竖立。
     * 我们可以使用两个指针 i和 j来枚举所有连续的没有被推动的骨牌，
     * left和right表示两边骨牌的推倒方向。根据上述三种情况来计算骨牌的最终状态。
     *
     */

    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length, i = 0;
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && s[j] == '.') { // 找到一段连续的没有被推动的骨牌
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if (left == right) { // 方向相同，那么这些竖立骨牌也会倒向同一方向
                while (i < j) {
                    s[i++] = right;
                }
            } else if (left == 'R' && right == 'L') { // 方向相对，那么就从两侧向中间倒
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);

    }

    //广度优先搜索,说实话比较抽象，因为没有想到会用受力列表和翻转时间这
    //两个额外的结构，去模拟这个过程，感觉用这种做法有点麻烦。
    public String pushDominoes1(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        //记录翻倒或者不确定是否翻倒的时间。
        int[] time = new int[n];
        Arrays.fill(time, -1);
        //记录骨牌受力，记住只有单侧受力时骨牌才会翻倒，
        //注意一点，翻倒的骨牌不会对已经翻倒或者正在翻倒的骨牌施加力。
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; i++) {
            force[i] = new ArrayList<Character>();
        }
        //此处记录初始的时间和力，把这些受力的位置入队列。
        //从左到右，先进先出，记录受力。
        for (int i = 0; i < n; i++) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                queue.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '.');
        while (!queue.isEmpty()) {
            //先弹出一个受力的位置
            int i = queue.poll();
            //如果目前这个位置当前只受到一个力
            if (force[i].size() == 1) {
                char f = force[i].get(0);
                //只有受力了，并且当前只有一个力，才会记录结果。
                res[i] = f;
                //这个ni推测应该代表下一个位置
                int ni = f == 'L' ? i - 1 : i + 1;
                if (ni >= 0 && ni < n) {
                    //当前位置的时间
                    int t = time[i];
                    //-1表示还没受力
                    if (time[ni] == -1) {
                        //把下一个位置的坐标假如队列
                        queue.offer(ni);
                        //记录下一个位置受力的时间
                        time[ni] = t + 1;
                        //记录下一个位置即将受到的力
                        force[ni].add(f);

                        //如果下一个位置已经受力了,则不用更新时间，
                        // 只需要把受力加入到列表中。
                    } else if (time[ni] == t + 1) {
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(res);
    }




}
