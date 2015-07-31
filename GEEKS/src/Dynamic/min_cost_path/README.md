
#Dynamic Programming | Set 6 (Min Cost Path)#

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?
<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/dp.png" alt="" title="dp" class="aligncenter size-full wp-image-14954" width="179" height="162">  

The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2).  
 The cost of the path is 8 (1 + 2 + 2 + 3).  
<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/dp2.png" alt="" title="dp2" class="aligncenter size-full wp-image-14955" width="179" height="162">  