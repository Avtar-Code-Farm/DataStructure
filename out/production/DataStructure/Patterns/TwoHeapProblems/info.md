### Two Heap problems

- Given a list of numbers which we can devide into two part.
- Lets say part A(smallNumList) contain the small number and part B(LargetNumList) contain large number
- To solve the problem, we have to find the max in part A and Min in Part.
- i.e The median of all the numbers will either be the largest number in the smallNumList or the smallest number in the largNumList. If the total number of elements is even, the median will be the average of these two numbers.

The best data structure that comes to mind to find the smallest or largest number among a list of numbers is a Heap. Let’s see how we can use a heap to find a better algorithm.

We can store the first half of numbers (i.e., smallNumList) in a Max Heap. We should use a Max Heap as we are interested in knowing the largest number in the first half.
We can store the second half of numbers (i.e., largeNumList) in a Min Heap, as we are interested in knowing the smallest number in the second half.
Inserting a number in a heap will take O(logN)O(logN), which is better than the brute force approach.
At any time, the median of the current list of numbers can be calculated from the top element of the two heaps.

So there are two heap

1) max heap
2) min heap
```
PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b) -> b-a);
PriorityQueue<Integer> min_heap = new PriorityQueue<>((a,b) -> a-b);
```
There are two major operation
1) add num
2) find meadian

```aidl
private double findMedian(maxHeap, minHeap) {
    if( (maxHeap.size() + minHeap.size())%2 == 0 ) {
        return ((double)maxHeap.peek()/2 + (double)minHeap.size()/2);
    }
    else {
        return (double)minHeap.size();
    }
}
```

Adding number is bit tricky there are few cases we need to take care.
1) We have to manage the balance between two heap. For this, we manage two rule
a) Either the both the heap has equal number or max heap can have one more element than min heap

So with this understanding, if maxHeap > minHeap it means we need to move element from max heap to min heap
```aidl
// understand this condition. Here we are checking if the diff is greate then 1
if(maxHeap.size() - minHeap.size() >= 2) minHeap.add(maxHeap.pool())
// here we simply pull from the minHeap if maxHeap is lower than the minHeap
if(maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll()); 
```




## 