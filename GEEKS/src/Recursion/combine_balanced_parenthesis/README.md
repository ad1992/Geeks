#Print all combinations of balanced parentheses#

Write a function to generate all possible n pairs of balanced parentheses.

For example, if n=1
{}
for n=2
{}{}
{{}}

Algorithm:
Keep track of counts of open and close brackets. Initialize these counts as 0. Recursively call the _printParenthesis() function until open bracket count is less than the given n. If open bracket count becomes more than the close bracket count, then put a closing bracket and recursively call for the remaining brackets. If open bracket count is less than n, then put an opening bracket and call _printParenthesis() for the remaining brackets.
###Sample Input###
```
4
```
###Sample Output###
```
{}{}{}{} 
{}{}{{}} 
{}{{}}{} 
{}{{}{}} 
{}{{{}}} 
{{}}{}{} 
{{}}{{}} 
{{}{}}{} 
{{}{}{}} 
{{}{{}}} 
{{{}}}{} 
{{{}}{}} 
{{{}{}}} 
{{{{}}}} 
```