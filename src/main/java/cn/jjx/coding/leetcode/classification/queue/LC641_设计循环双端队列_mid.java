package cn.jjx.coding.leetcode.classification.queue;

public class LC641_设计循环双端队列_mid {

    public class MyCircularDeque {

        /**
         * 定义循环变量 front 和 rear 。一直保持这个定义，到底是先赋值还是先移动指针就很容易想清楚了。
         * front：指向队列头部第 11 个有效数据的位置；
         * rear：指向队列尾部（即最后 11 个有效数据）的 下一个位置，即下一个从队尾入队元素的位置。
         * 说明：这个定义是依据「动态数组」的定义模仿而来。
         *
         * 为了避免「队列为空」和「队列为满」的判别条件冲突，我们有意浪费了一个位置；
         * 浪费一个位置是指：循环数组中任何时刻一定至少有一个位置不存放有效元素。
         *
         * 判别队列为空的条件是：front == rear;；
         * 判别队列为满的条件是：(rear + 1) % capacity == front;。可以这样理解，
         * 当 rear 循环到数组的前面，要从后面追上 front，还差一格的时候，判定队列为满。
         * 因为有循环的出现，要特别注意处理数组下标可能越界的情况。
         * 指针后移的时候，下标 + 1+1，要取模；
         * 指针前移的时候，为了循环到数组的末尾，需要先加上数组的长度，然后再对数组长度取模。
         */


        // 1、不用设计成动态数组，使用静态数组即可
        // 2、设计 head 和 tail 指针变量
        // 3、head == tail 成立的时候表示队列为空
        // 4、tail + 1 == head

        private int capacity;
        private int[] arr;
        private int front;
        private int rear;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            capacity = k + 1;
            arr = new int[capacity];

            // 头部指向第 1 个存放元素的位置
            // 插入时，先减，再赋值
            // 删除时，索引 +1（注意取模）
            front = 0;
            // 尾部指向下一个插入元素的位置
            // 插入时，先赋值，再加
            // 删除时，索引 -1（注意取模）
            rear = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            // front 被设计在数组的开头，所以是 +1
            front = (front + 1) % capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            // rear 被设计在数组的末尾，所以是 -1
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            // 当 rear 为 0 时防止数组越界
            return arr[(rear - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            // 注意：这个设计是非常经典的做法
            return (rear + 1) % capacity == front;
        }
    }
}
