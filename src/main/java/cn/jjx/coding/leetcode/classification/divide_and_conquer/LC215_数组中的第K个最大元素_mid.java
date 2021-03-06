package cn.jjx.coding.leetcode.classification.divide_and_conquer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class LC215_数组中的第K个最大元素_mid {

    //基于快速排序的方法
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1,
                nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) :
                    quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, i++, j);
            }
        }
        swap(a, i, r);
        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //下面的方法是基于堆排序的方法
    public int findKthLargest1(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    //基于优先队列
    public int findKthLargest2(int[] nums,int k){
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,
                Comparator.comparing(a->a));
        for(int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }
        for(int i=k;i<len;i++){
            Integer element = minHeap.peek();
            if(nums[i]>element){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

}
