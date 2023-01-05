Algorithm👨‍🎓

 
Algorithm👨‍🎓

    The Naive Approach is to sort the entire array and return the K elements from the end of an array. 
    But we have a constraint it has to perform better than O(N log N)
    Create a hashmap and store the Element and the Frequency of it in the array as a Key-Value Pair.
    Create a Priority queue, with the default condition to sort by descending order. 
    The catch here is to sort by the values rather than the key itself.
    ** So a = map.get(a), b =map.get(b) **
    Now, add the keys of the hashmap into the priority queue. The keys will be sorted based on their values in the queue.
    All you have got to do now is to poll the first K elements of the Queue. Put it into a list/array.
    Return the list/array
 
    