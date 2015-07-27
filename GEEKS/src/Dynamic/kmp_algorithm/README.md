#Searching for Patterns | Set 2 (KMP Algorithm)#

Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

##Examples:##

###1) Input:###
```
  txt[] =  "THIS IS A TEST TEXT"
  pat[] = "TEST"
```
###Output:###
```
   Pattern found at index 10
```
###2) Input:###
```
  txt[] =  "AABAACAADAABAAABAA"
  pat[] =  "AABA"
```
###Output:###
```
   Pattern found at index 0
   Pattern found at index 9
   Pattern found at index 13
```
Pattern searching is an important problem in computer science. When we do search for a string in notepad/word file or browser or database, pattern searching algorithms are used to show the search results.

We have discussed Naive pattern searching algorithm in the previous post. The worst case complexity of Naive algorithm is O(m(n-m+1)). Time complexity of KMP algorithm is O(n) in worst case.

KMP (Knuth Morris Pratt) Pattern Searching
The Naive pattern searching algorithm doesn’t work well in cases where we see many matching characters followed by a mismatching character. Following are some examples.
```
   txt[] = "AAAAAAAAAAAAAAAAAB"
   pat[] = "AAAAB"

   txt[] = "ABABABCABABABCABABABC"
   pat[] =  "ABABAC" (not a worst case, but a bad case for Naive)
```
The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more than once in the pattern) of the pattern and improves the worst case complexity to O(n). The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches), we already know some of the characters in the text (since they matched the pattern characters prior to the mismatch). We take advantage of this information to avoid matching the characters that we know will anyway match.
KMP algorithm does some preprocessing over the pattern pat[] and constructs an auxiliary array lps[] of size m (same as size of pattern). Here name lps indicates longest proper prefix which is also suffix.. For each sub-pattern pat[0…i] where i = 0 to m-1, lps[i] stores length of the maximum matching proper prefix which is also a suffix of the sub-pattern pat[0..i].

```
   lps[i] = the longest proper prefix of pat[0..i] 
              which is also a suffix of pat[0..i]. 
```
###Examples:###

For the pattern “AABAACAABAA”, lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]  
For the pattern “ABCDE”, lps[] is [0, 0, 0, 0, 0]  
For the pattern “AAAAA”, lps[] is [0, 1, 2, 3, 4]  
For the pattern “AAABAAA”, lps[] is [0, 1, 2, 0, 1, 2, 3]  
For the pattern “AAACAAAAAC”, lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]  

