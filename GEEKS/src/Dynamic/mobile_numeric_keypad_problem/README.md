#Mobile Numeric Keypad Problem#

Given the mobile numeric keypad. You can only press buttons that are up, left, right or down to the current button. You are not allowed to press bottom row corner buttons (i.e. * and # ).
Given a number N, find out the number of possible numbers of given length.  
<img src="http://d2dskowxfbo68o.cloudfront.net/wp-content/uploads/mobile1.png" alt="mobile1" class="alignright size-full wp-image-131516" width="208" height="155">  
Examples:
For N=1, number of possible numbers would be 10 (0, 1, 2, 3, …., 9)
For N=2, number of possible numbers would be 36
Possible numbers: 00,08 11,12,14 22,21,23,25 and so on.
If we start with 0, valid numbers will be 00, 08 (count: 2)
If we start with 1, valid numbers will be 11, 12, 14 (count: 3)
If we start with 2, valid numbers will be 22, 21, 23,25 (count: 4)
If we start with 3, valid numbers will be 33, 32, 36 (count: 3)
If we start with 4, valid numbers will be 44,41,45,47 (count: 4)
If we start with 5, valid numbers will be 55,54,52,56,58 (count: 5)
………………………………
………………………………

We need to print the count of possible numbers.

###Input Format###
An Integer N
###Output Format###
Count of possible numbers

###Sample Input #1###
```
5
```
###Sample Output #1###
```
2062
```
###Sample Input #2###
```
10
```
###Sample Output #2###
```
1806282
```