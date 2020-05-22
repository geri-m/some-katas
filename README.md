# Code Katas

This is a collection of code katas with solutions in Java.

## Kata 01: Find Longest String of 2 different chars. 

Return the longest contiguous substring of 2 distinct characters from an input string.

Example 01
```
input: abbaacab
output : abbaa
```

Example 02
```
input: abcefabbabaabefghghfa 
return: abbabaab
```

Example 03
```
input: aabceddddcdccecabceftg 
return: ddddcdcc
```

Example 04
```
input: acbabbcbca 
return : bbcbc
````


## Kata 02: Arabic to Roman Numbers

Convert Arabic Numbers to Roman Numbers. If you need help: https://www.periodni.com/de/romische_zahlen_umwandeln.html

Example 01
```
input: 1
output : I
```

Example 02
```
input: 9 
return: IX
```

Example 03
```
input: 18 
return: XVII
```

Example 04
```
input: 44 
return : XLIV
````

## Kata 03: Eliminate Elements from List

Write a function to return a copy of a list of strings with duplicates removed. Preserve order in the original list as 
much as possible (keep first occurrence).

Example
```
input: ["foo", "bar", "baz", "foo", "bar"]
output: ["foo", "bar", "baz"]
```

## Kate 04: Shuffle List

Suppose you have a deck of cards represented as a linked list. You can perfectly shuffle that list by cutting it at the 
halfway point, then interleaving the two halves by alternating back and forth between the cards. For example, suppose 
you want to perfectly shuffle this sequence:
```
1 2 3 4 5 6 7 8 9 10
```

You'd start by splitting it into two halves, like this:
```
1 2 3 4 5 
```
```
6 7 8 9 10
```
Then, you'd interleave the halves, like this:
```
6 1 7 2 8 3 9 4 10 5
```
The resulting list is said to have been perfectly shuffled. Your job is to write a function that accepts as input a 
pointer to a linked list with an even number of elements, then re­ arranges the elements in that list so that they're 
perfectly shuffled.

