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

## Kata 04: Shuffle List

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

## Kata 05: Sum Sub Array list

A subarray of an array is a consecutive sequence of zero or more values taken out of that array. For example, the array 
[1, 3, 7] has seven subarrays:
[] [1] [3] [7] [1,3] [3,7] [1,3,7]
Notice that [1, 7] is not a subarray of [1, 3, 7], because even though the values 1 and 7 appear in the array, they're 
not consecutive in the array. Similarly, the array [7, 3] isn't a subarray of the original array, because these values
are in the wrong order.

The sum of an array is the sum of all the values in that array. Your task is to write a function that takes as input an 
array and outputs the sum of all of its subarrays. For example, given [1, 3, 7], you'd output 36, because


[ ] + [1] + [3] + [7] + [1, 3] + [3, 7] + [1, 3, 7] = 0 + 1 + 3 + 7 + 4 + 10 + 11 = 36

## Kata 06: Create a balanced Binary Search Tree. 

CS101.

Balanced:  The heights of the two child subtrees of any node differ by at most one. (Wikipedia: AVL-Tree) 

## Kata 07: Find smallest Range in a list of Int. 

You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists.

For example,
List 1: [4, 10, 15, 24, 26]
List 2: [0, 9, 12, 20]
List 3: [5, 18, 22, 30]

The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.

https://www.careercup.com/question?id=16759664

## Kata 08: Pot of Gold

Pots of gold game: Two players A & B. There are pots of gold arranged in a line, each containing some gold coins (the 
players can see how many coins are there in each gold pot - perfect information). They get alternating turns in which 
the player can pick a pot from one of the ends of the line. The winner is the player which has a higher number of coins 
at the end. The objective is to "maximize" the number of coins collected by A, assuming B also plays optimally. 
A starts the game.

https://www.careercup.com/question?id=15422849


## Kata 09: Diff between SubArray should be max

Given an array of integers. Find two disjoint contiguous sub-arrays such that the absolute difference between the sum 
of two sub-array is maximum. The sub-arrays should not overlap.

[2, -1, -2, 1, -4, 2, 8, -1] ans - (-1, -2, 1, -4) (2, 8), diff = 16
[4, -1, 7] (3), (7), diff = 4
[2,-1,-2,12,453,-9,2,8] (2,-1,-2,12,453), (-9), diff = 455

## Kata 10: Implement Push and Pop for a Min Heap.

## Kata 11: Implement a Addition without '+'

## Kata 12: Solve this problem

https://techdevguide.withgoogle.com/paths/advanced/compress-decompression/#code-challenge

## Kata 13: Mine Sweeper

https://techdevguide.withgoogle.com/resources/coding-question-minesweeper/?types=coding-interview-question#code-challenge

## Kata 14: Generate Sums

Given a number n, generate all distinct ways to write n as the sum of positive integers. For example, with n = 4, the 
options are 4, 3 + 1, 2 + 2, 2 + 1 + 1, and 1 + 1 + 1 + 1.