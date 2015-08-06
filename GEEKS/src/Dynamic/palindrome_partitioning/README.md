
#Dynamic Programming | Set 17 (Palindrome Partitioning)#

Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, then minimum n-1 cuts are needed.

###Input Format###
One line containing string
###Output Format###
An integer-minimum number of cuts.
###Sample Input #1###
```
ababbbabbababa
```
###Sample Output#1###
```
3
```
###Sample Input #2###
```
abcbm
```
###Sample Output#2###
```
2
```
 