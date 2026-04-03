# Programming Assignment 3: Highest Value Longest Common Sequence
By: David Visbal Gomez (UFID: 11497647)

## Compile Instructions
1. Clone into a IntelliJ project.
2. Run the program in IntelliJ.

## Run Instructions
Placeholder.

## Assumptions
Placeholder.

## Written Response
Placeholder.

### Question 1: Empirical Comparison
Placeholder.

### Question 2: Recurrence Equation
OPT(s1, s2) is the highest value of the longest common
subsequence between two strings.

val(s) returns the value associated with the sum of
every character in string s.

Case 1: Either string is empty.
- Return 0.

Case 2: s1 and s2 are equal.
- Return Val(s1).

Case 3: s1 and s2 evict letter i and j.
- Remove letter i from s1.
- Remove letter j from s2.
- Recurse on the new substrings.

Case 4: s1 and s2 keep letter i and j.
- Recurse on the same strings but consider a different pair of letters. 

$$
OPT(s1, s2) = \begin{cases}
0 & \text{if } s1 = \emptyset | s2 = \emptyset\\
val(s1) & \text{if } s1 = s2 \\
_{0 \leq i \leq n, 0 \leq j \leq m}max\{OPT(s1 - i, s2 - j)\} & \text{else}
\end{cases}
$$

### Question 3: Big-Oh
Placeholder.
