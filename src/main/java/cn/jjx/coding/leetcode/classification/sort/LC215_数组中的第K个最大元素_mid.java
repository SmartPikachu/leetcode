package cn.jjx.coding.leetcode.classification.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class LC215_数组中的第K个最大元素_mid {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,
                Comparator.comparingInt(a->a));
        for(int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }
        for(int i=k;i<len;i++){
            Integer topElement = minHeap.peek();
            if(nums[i]>topElement){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();

    }


    //利用快速排序的方法,这块我对官方的方法进行了修改，原来的不优雅。
    Random random = new Random();
    public int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = partition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int partition(int[] a, int l, int r) {
        int rand = random.nextInt(r - l + 1) + l;
        swap(a, rand, r);
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


    //利用堆排序的方法,堆其实是个完全二叉树，
    //下面是构建大根堆，注意构建堆的时候是从底向上的
    //除于2，是因为节点数是2^k-1,这块不用纠结加一减一
    //因为除2后已经确保初始的节点一定是在中后的
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void maxHeapify(int[] arr, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }



}
