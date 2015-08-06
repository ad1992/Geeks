#Snake and Ladder Problem#

Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from source or 1st cell. Basically, the player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.

If the player reaches a cell which is base of a ladder, the player has to climb up that ladder and if reaches a cell is mouth of the snake, has to go down to the tail of snake without a dice throw.

<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/snakesladders-300x249.jpg" class="alignright size-full wp-image-1818" width="250" height="200">  

For example consider the board shown on right side (taken from here), the minimum number of dice throws required to reach cell 30 from cell 1 is 3. Following are steps.

a) First throw two on dice to reach cell number 3 and then ladder to reach 22
b) Then throw 6 to reach 28.
c) Finally through 2 to reach 30.

There can be other solutions as well like (2, 2, 6), (2, 4, 4), (2, 3, 5).. etc.

First line contain N(Number of ladders) and after that N line follow. Each of the N line contain 2 integer representing the starting point and the ending point of a ladder respectively.    

The next line contain interger M(Number of snakes) and after that M line follow. Each of the M line contain 2 integer representing the starting point and the ending point of a snake respectively.  
###Output Format###

Output one integer,which is the least number of moves (or rolls of the die) in which the player can reach the target square (Square Number 30) after starting at the base (Square Number 1). 
If there is no solution, print -1.  

###Sample Input###
```
4
3 22
5 8
11 26
20 29
4
27 1
21 9
17 4
19 7
```
###Sample Output###
```
3
```
