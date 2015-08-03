#Union-Find Algorithm | Set 1 (Detect Cycle in a an Undirected Graph)#

A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. A union-find algorithm is an algorithm that performs two useful operations on such a data structure:

Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.

###Input Format###

First Line will contain N-The number of vertices and M-The number of edges.  
The next M lines will contain v1,v2,where v1,v2 represent an edge  between vertices.  

##Output Format###
Print whether graph contains a cycle.

###Sample Input #1###
```
4 3
0 1
1 2
2 3
```
###Sample Output###
```
The graph does not contains a cycle
```
###Sample Input###
```
3 3
0 1
1 2
2 0
```
###Sample Output #2###
```
The graph contains a cycle
```