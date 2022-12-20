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

## 