package cn.jjx.coding.leetcode.classification.binary_search.寻找位置;

public class LC1095_山脉数组中查找目标值_hard {

    //题目给的api是没有实现的接口
    interface MountainArray{
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        //首先通过二分法找到山峰
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int peak = l;
        //先查找左半峰
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        //左半峰没有找到，去查找右半峰
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    public int binarySearch(MountainArray mountainArr, int target, int l, int r, boolean flag) {
        //这块的改变斜率的，用正负号来求的太牛了，服气。
        if (!flag) {
            target *= -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountainArr.get(mid) * (flag ? 1 : -1);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
