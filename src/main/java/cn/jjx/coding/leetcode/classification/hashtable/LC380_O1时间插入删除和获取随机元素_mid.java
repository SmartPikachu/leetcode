package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.*;

public class LC380_O1时间插入删除和获取随机元素_mid {

    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> indices;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            indices = new HashMap<Integer, Integer>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            indices.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            indices.put(last, index);
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }
}
