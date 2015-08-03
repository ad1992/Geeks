#Greedy Algorithms | Set 5 (Prim’s Minimum Spanning Tree (MST))#

###Input Format###

First Line will contain N-The number of vertices and M-The number of edges.  
The next M lines will contain v1,v2,w where v1,v2 represent an edge and w represents weight between edges.  

###Output Format###
The tables consisting of edges in MST and the total weight of spanning tree.

###Sample Input #1###
```
9 14
0 1 4
0 7 8
1 2 8
1 7 11
7 8 7
7 6 1
2 3 7
2 5 4
2 8 2
6 8 6
6 5 2
3 4 9
3 5 14
4 5 10
```
###Sample Output#1###
```
Following are the edges in the constructed Prim MST
Edge1	Edge2	Weight
0		1		4
1		2		8
2		3		7
3		4		9
2		5		4
5		6		2
6		7		1
2		8		2
The weight of MST is 37
```
###Sample Input #2###
```
5 7
0 1 2
1 2 3
0 3 6
3 4 9
4 2 7
4 1 5
1 3 8
```
###Sample Output#2###
```
Following are the edges in the constructed Prim MST
Edge1	Edge2	Weight
0		1		2
1		2		3
0		3		6
1		4		5
The weight of MST is 16
```
