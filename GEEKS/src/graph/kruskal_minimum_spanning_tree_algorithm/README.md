#Greedy Algorithms | Set 2 (Kruskal’s Minimum Spanning Tree Algorithm)#

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
###Sample Output#2###
```
Following are the edges in the constructed Krushkal MST
Edge1	Edge2	Weight
7		6		1
2		8		2
6		5		2
0		1		4
2		5		4
2		3		7
0		7		8
3		4		9
The weight of MST is 37
```
###Sample Input#2###
```
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
```
###Sample Output#2###
```
Following are the edges in the constructed Krushkal MST
Edge1	Edge2	Weight
2		3		4
0		3		5
0		1		10
The weight of MST is 19

```

