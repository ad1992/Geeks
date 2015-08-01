#Greedy Algorithms | Set 7 (Dijkstra’s shortest path algorithm)#

Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph.

###Input###

First Line will contain N-The number of vertices and M-The number of edges.  
The next M lines will contain v1,v2,w where v1,v2 represent an edge and w represents weight between them.  

###Output###

The table containing distance to all vertices from source

###Sample Input###
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
###Sample Output###
```
Vertex  Distance from Source
0		0
1		4
2		12
3		19
4		21
5		11
6		9
7		8
8		14

```

 