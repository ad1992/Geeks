#Dynamic Programming | Set 16 (Floyd Warshall Algorithm)#

The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.

###Input Format###

First Line will contain N-The number of vertices and M-The number of edges.  
The next M lines will contain v1,v2,w where v1,v2 represent an edge and w represents weight between edges.  

###Output Format###
The Shortest distance matrix.

###Sample Input#1:###
```
4 4
0 3 10
0 1 5
1 2 3
2 3 1
```
which represents the following graph
```
             10
       (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
       \|/         |
       (1)------->(2)
              3       
              
```
Note that the value of graph[i][j] is 0 if i is equal to j 
And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.

###Sample Output#1:###
```
Shortest distance matrix

0	5	8	9	
INF	0	3	4	
INF	INF	0	1	
INF	INF	INF	0
```
