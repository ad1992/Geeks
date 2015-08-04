#Dynamic Programming | Set 37 (Boolean Parenthesization Problem)#

Given a boolean expression with following symbols.  

Symbols    
*    'T' ---> true     
*    'F' ---> false     

And following operators filled between symbols    

Operators    
*    &   ---> boolean AND    
*    |   ---> boolean OR    
*    ^   ---> boolean XOR     

Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
###Examples: ###
```
Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
and (T|((T&F)^T))  
```
###Input Format###

First line contains a string of symbols(T and F ony).Next line contains the string of operators(^,|,& only)

###Output Format###

Number of ways.

###Sample Input #1###
```
TFT
|&
```
###Sample Output #1###
```
2
```
###Sample Input #2###
```
TTFT
|&^
```
###Sample Output #2###
```
4
```
 