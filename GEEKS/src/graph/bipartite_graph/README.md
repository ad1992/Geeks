#Check whether a given graph is Bipartite or not#

A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices of same set.
<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/Bipartite1.png" class="aligncenter size-full wp-image-117121" width="190" height="163">  
A bipartite graph is possible if the graph coloring is possible using two colors such that vertices in a set are colored with the same color. Note that it is possible to color a cycle graph with even cycle using two colors. For example, see the following graph.
<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/Bipartite2.png" class="aligncenter size-full wp-image-117122" width="150" height="150">   

It is not possible to color a cycle graph with odd cycle using two colors.
 <img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/Bipartite3.png" class="aligncenter size-full wp-image-117123" width="150" height="150">  
 ###Input Format###

First Line will contain N-The number of vertices and M-The number of edges.    
The next M lines will contain v1,v2 where v1,v2 represent an edge.   

###Output Format###
**"The graph is Bipartite"** if graph is bipartite else **"The graph is not Bipartite"** without quotes and also the colour assigned to the vertices(black or white).

###Sample Input###
```
6 6
0 1
1 2
2 3
3 4
4 5
5 0
```
###Sample Output###
```
0 black
1 white
5 white
2 black
4 black
3 white
The graph is Bipartite
```
