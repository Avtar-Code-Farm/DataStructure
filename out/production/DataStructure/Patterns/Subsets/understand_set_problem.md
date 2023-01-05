# In the recursion function, we either continue with the current elemnet or include the next element.
  // wheneve we reaches length of index == nums.length we add the set into the ans list.
  [ 7, 8 ,9]
   0   1  2
 index                  [ 7, 8 ,9]
 0                  ""                    7
 1             ""        8            7            7 8
 2           ""  {9}  {8}  {8,9}   {7} {7,9}    {7,8}   {7,8,9}



Template
```aidl
 fun(list, templist, nums, start)
 {
    list.add(templist);
    for(int i = start; i< nums.size(); i++){
        templist.add(nums[i]);
        fun(list, templist, nums, start+1);
        templist.removs(templist.size() -1);
    }
 }
```
For set problem where we need to handle duplicated, understand the condition for continue
```
fun(list, templist, nums, start)
{
  list.add(templist);
  for(int i = start; i< nums.size(); i++){
     if(i != start && nums[i] == nums[i-1]) continue;
     templist.add(nums[i]);
     fun(list, templist, nums, start+1);
     templist.removs(templist.size() -1);
  }
}
```
` if(i != start && nums[i] == nums[i-1]) continue;`

We must process the ithe element even if it is duplicate when it is the starting element.
nums  = [1,2,2]
If we don't have this if condition then we will never get a set [1,2,2] 
and without i!=start condition we will get this output:

[[],[1],[1,2],[2]]

however expected is: 

[[],[1],[1,2],[1,2,2],[2],[2,2]]
