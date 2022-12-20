package Patterns.TwoHeapProblems;

import java.util.PriorityQueue;

public class MedianFinder {

    static PriorityQueue<Integer> max_heap = new PriorityQueue<>((a ,b) -> b-a);
    static PriorityQueue<Integer> min_heap = new PriorityQueue<>((a ,b) -> a-b);
    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        System.out.println("find median  "+ findMedian());
        addNum(3);
        System.out.println("find median  "+ findMedian());
    }

    public static void addNum(int num) {
        if(max_heap.size() == 0 || max_heap.peek() >= num) max_heap.add(num);
        else min_heap.add(num);

        // Either both the heaps will have equal numbe of elements or max heap will have one more element than min heap
        if((max_heap.size() - min_heap.size()) > 1) min_heap.add(max_heap.poll());
        else if (max_heap.size() < min_heap.size()) max_heap.add(min_heap.poll());
    }

    public static double findMedian() {
        if((max_heap.size() + min_heap.size()) % 2 == 0) {
            return ((double)(max_heap.peek() + min_heap.peek())/2);
        } else {
            return ((double)min_heap.peek());
        }
    }
}
