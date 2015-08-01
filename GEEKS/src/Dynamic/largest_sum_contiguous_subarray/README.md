#Largest Sum Contiguous Subarray#

Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

**Kadane’s Algorithm:**
```
Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
```
###Input###

```
8
-2, -3, -4, -1, -2, -1, -8, -1
```
###Output###
```
Maximum contiguous sum is -1
```
###Input###
```
8
-2, -3, 4, -1, -2, 1, 5, -3
```
###Output###
```
Maximum contiguous sum is 7
```
