#Check for balanced parentheses in an expression#

Given an expression string exp, write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”

###Input Format###

One line containg the string of parenthesis.

###Output Format###

**"Balanced"** if the parenthesis are balanced else **"Not Balanced"** without quotes.

###Sample Input #1### 
```
[(])
```
###Sample Output #1###
```
Not Balanced
```
###Sample Input #2### 
```
{{[]}([{}])}
```
###Sample Output #2###
```
 Balanced
```