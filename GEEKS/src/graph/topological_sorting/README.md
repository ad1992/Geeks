#Topological Sorting#

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

For example, a topological sorting of the following graph is “5 4 2 3 1 0″. There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0″. The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no in-coming edges).

<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/graph.png" class="alignleft size-full wp-image-117681" width="282" height="232">    

###Input Format###

First Line will contain N-The number of vertices and M-The number of edges.    
The next M lines will contain v1,v2 where v1,v2 represent an edge.   

###Output Format###
The topological ordering
###Sample Input #1###
```
6 6
5 2
5 0
4 0
2 4
0 1
1 3
```
###Sample Output #1###
```
5 2 4 0 1 3 
```
###Sample Input #2###
```
6 6
5 2
5 0
4 0
4 1
2 3
3 1
```
###Sample Output #2###
```
5 4 0 2 3 1
```