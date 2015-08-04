#Dynamic Programming | Set 19 (Word Wrap Problem)#

Given a sequence of words, and a limit on the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that the lines are printed neatly. Assume that the length of each word is smaller than the line width.

The word processors like MS Word do task of placing line breaks. The idea is to have balanced lines. In other words, not have few lines with lots of extra spaces and some lines with small amount of extra spaces.

The extra spaces includes spaces put at the end of every line except the last one.    
The problem is to minimize the following total cost.  
Cost of a line = (Number of extra spaces in the line)^2    
Total Cost = Sum of costs for all lines  

For example, consider the following string and line width M = 15  
 "Geeks for Geeks presents word wrap problem"   
     
Following is the optimized arrangement of words in 3 lines
```
Geeks for Geeks
presents word
wrap problem 
```
The total extra spaces in line 1, line 2 and line 3 are 0, 2 and 3 respectively.   
So optimal value of total cost is 0 + 2*2 + 3*3 = 13  

###Input Format###
First line contains string to  be justified.Next line contains M
###Output Format###
Justified text
###Sample Input #1### 
```
aaa bb cc ddddd
6
```
###Sample Output #1### 
```
aaa 
bb cc 
ddddd 
```

