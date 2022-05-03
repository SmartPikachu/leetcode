package cn.jjx.coding.leetcode.classification.sort;

import java.util.Arrays;
import java.util.Random;

public class LC912_排序数组_mid {
    //堆排序
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    //这种是完全迭代的方法调整堆，可以参考215是采用递归的办法调整堆。
    public void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }



    //快速排序
    public int[] sortArray1(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = partition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }


    public int partition(int[] nums, int l, int r) {
        int rand = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, rand);
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * https://leetcode-cn.com/problems/sort-an-array/
     * solution/pai-xu-shu-zu-by-leetcode-solution/
     * 这个链接是李为为介绍的各种基础排序算法，下面的题解参考李为为
     */


    public class Solution {

        // 选择排序：每一轮选择最小元素交换到未排定部分的开头

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
            for (int i = 0; i < len - 1; i++) {
                // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
                int minIndex = i;
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(nums, i, minIndex);
            }
            return nums;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }


    public class Solution1 {

        // 插入排序：稳定排序，在接近有序的情况下，表现优异

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
            for (int i = 1; i < len; i++) {
                // 先暂存这个元素，然后之前元素逐个后移，留出空位
                int temp = nums[i];
                int j = i;
                // 注意边界 j > 0
                while (j > 0 && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
            return nums;
        }
    }


    public class Solution2 {
        // 归并排序

        /**
         * 列表大小等于或小于该大小，将优先于 mergeSort 使用插入排序
         */
        private static final int INSERTION_SORT_THRESHOLD = 7;

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            int[] temp = new int[len];
            mergeSort(nums, 0, len - 1, temp);
            return nums;
        }

        /**
         * 对数组 nums 的子区间 [left, right] 进行归并排序
         *
         * @param nums
         * @param left
         * @param right
         * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
         */
        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            // 小区间使用插入排序
            if (right - left <= INSERTION_SORT_THRESHOLD) {
                insertionSort(nums, left, right);
                return;
            }

            int mid = left + (right - left) / 2;
            // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
            // int mid = (left + right) >>> 1;

            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            // 如果数组的这个子区间本身有序，无需合并
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }
            mergeOfTwoSortedArray(nums, left, mid, right, temp);
        }

        /**
         * 对数组 arr 的子区间 [left, right] 使用插入排序
         *
         * @param arr   给定数组
         * @param left  左边界，能取到
         * @param right 右边界，能取到
         */
        private void insertionSort(int[] arr, int left, int right) {
            for (int i = left + 1; i <= right; i++) {
                int temp = arr[i];
                int j = i;
                while (j > left && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }

        /**
         * 合并两个有序数组：先把值复制到临时数组，再合并回去
         *
         * @param nums
         * @param left
         * @param mid   [left, mid] 有序，[mid + 1, right] 有序
         * @param right
         * @param temp  全局使用的临时数组
         */
        private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);

            int i = left;
            int j = mid + 1;

            for (int k = left; k <= right; k++) {
                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {
                    // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                    nums[k] = temp[i];
                    i++;
                } else {
                    // temp[i] > temp[j]
                    nums[k] = temp[j];
                    j++;
                }
            }
        }
    }


    public class Solution3 {

        // 希尔排序

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            int h = 1;

            // 使用 Knuth 增量序列
            // 找增量的最大值
            while (3 * h + 1 < len) {
                h = 3 * h + 1;
            }

            while (h >= 1) {
                // insertion sort
                for (int i = h; i < len; i++) {
                    insertionForDelta(nums, h, i);
                }
                h = h / 3;
            }
            return nums;
        }

        /**
         * 将 nums[i] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
         *
         * @param nums
         * @param gap
         * @param i
         */
        private void insertionForDelta(int[] nums, int gap, int i) {
            int temp = nums[i];
            int j = i;
            // 注意：这里 j >= deta 的原因
            while (j >= gap && nums[j - gap] > temp) {
                nums[j] = nums[j - gap];
                j -= gap;
            }
            nums[j] = temp;
        }
    }

    public class Solution4 {

        // 冒泡排序：超时

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            for (int i = len - 1; i >= 0; i--) {
                // 先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较，
                // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
                boolean sorted = true;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                        sorted = false;
                    }
                }
                if (sorted) {
                    break;
                }
            }
            return nums;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }


    public class Solution5 {

        // 计数排序

        private static final int OFFSET = 50000;

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            // 由于 -50000 <= A[i] <= 50000
            // 因此"桶" 的大小为 50000 - (-50000) = 10_0000
            // 并且设置偏移 OFFSET = 50000，目的是让每一个数都能够大于等于 0
            // 这样就可以作为 count 数组的下标，查询这个数的计数
            int size = 10_0000;

            // 计数数组
            int[] count = new int[size];
            // 计算计数数组
            for (int num : nums) {
                count[num + OFFSET]++;
            }

            // 把 count 数组变成前缀和数组
            for (int i = 1; i < size; i++) {
                count[i] += count[i - 1];
            }

            // 先把原始数组赋值到一个临时数组里，然后回写数据
            int[] temp = new int[len];
            System.arraycopy(nums, 0, temp, 0, len);

            // 为了保证稳定性，从后向前赋值
            for (int i = len - 1; i >= 0; i--) {
                int index = count[temp[i] + OFFSET] - 1;
                nums[index] = temp[i];
                count[temp[i] + OFFSET]--;
            }
            return nums;
        }
    }

    public class Solution6 {

        // 基数排序：低位优先

        private static final int OFFSET = 50000;

        public int[] sortArray(int[] nums) {
            int len = nums.length;

            // 预处理，让所有的数都大于等于 0，这样才可以使用基数排序
            for (int i = 0; i < len; i++) {
                nums[i] += OFFSET;
            }

            // 第 1 步：找出最大的数字
            int max = nums[0];
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }

            // 第 2 步：计算出最大的数字有几位，这个数值决定了我们要将整个数组看几遍
            int maxLen = getMaxLen(max);

            // 计数排序需要使用的计数数组和临时数组
            int[] count = new int[10];
            int[] temp = new int[len];

            // 表征关键字的量：除数
            // 1 表示按照个位关键字排序
            // 10 表示按照十位关键字排序
            // 100 表示按照百位关键字排序
            // 1000 表示按照千位关键字排序
            int divisor = 1;
            // 有几位数，外层循环就得执行几次
            for (int i = 0; i < maxLen; i++) {

                // 每一步都使用计数排序，保证排序结果是稳定的
                // 这一步需要额外空间保存结果集，因此把结果保存在 temp 中
                countingSort(nums, temp, divisor, len, count);

                // 交换 nums 和 temp 的引用，下一轮还是按照 nums 做计数排序
                int[] t = nums;
                nums = temp;
                temp = t;

                // divisor 自增，表示采用低位优先的基数排序
                divisor *= 10;
            }

            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = nums[i] - OFFSET;
            }
            return res;
        }

        private void countingSort(int[] nums, int[] res, int divisor, int len, int[] count) {
            // 1、计算计数数组
            for (int i = 0; i < len; i++) {
                // 计算数位上的数是几，先取个位，再十位、百位
                int remainder = (nums[i] / divisor) % 10;
                count[remainder]++;
            }

            // 2、变成前缀和数组
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 3、从后向前赋值
            for (int i = len - 1; i >= 0; i--) {
                int remainder = (nums[i] / divisor) % 10;
                int index = count[remainder] - 1;
                res[index] = nums[i];
                count[remainder]--;
            }

            // 4、count 数组需要设置为 0 ，以免干扰下一次排序使用
            for (int i = 0; i < 10; i++) {
                count[i] = 0;
            }
        }

        /**
         * 获取一个整数的最大位数
         *
         * @param num
         * @return
         */
        private int getMaxLen(int num) {
            int maxLen = 0;
            while (num > 0) {
                num /= 10;
                maxLen++;
            }
            return maxLen;
        }
    }


    public class Solution7 {

        // 桶排序
        // 1 <= A.length <= 10000
        // -50000 <= A[i] <= 50000

        // 10_0000

        private static final int OFFSET = 50000;

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            // 第 1 步：将数据转换为 [0, 10_0000] 区间里的数
            for (int i = 0; i < len; i++) {
                nums[i] += OFFSET;
            }

            // 第 2 步：观察数据，设置桶的个数
            // 步长：步长如果设置成 10 会超出内存限制
            int step = 1000;
            // 桶的个数
            int bucketLen = 10_0000 / step;

            int[][] temp = new int[bucketLen + 1][len];
            int[] next = new int[bucketLen + 1];

            // 第 3 步：分桶
            for (int num : nums) {
                int bucketIndex = num / step;
                temp[bucketIndex][next[bucketIndex]] = num;
                next[bucketIndex]++;
            }

            // 第 4 步：对于每个桶执行插入排序
            for (int i = 0; i < bucketLen + 1; i++) {
                insertionSort(temp[i], next[i] - 1);
            }

            // 第 5 步：从桶里依次取出来
            int[] res = new int[len];
            int index = 0;
            for (int i = 0; i < bucketLen + 1; i++) {
                int curLen = next[i];
                for (int j = 0; j < curLen; j++) {
                    res[index] = temp[i][j] - OFFSET;
                    index++;
                }
            }
            return res;
        }

        private void insertionSort(int[] arr, int endIndex) {
            for (int i = 1; i <= endIndex; i++) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }


}
