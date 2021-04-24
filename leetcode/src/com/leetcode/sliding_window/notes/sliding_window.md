# Sliding Window

## Most common pattern
***LC1438***
1. Have a counter or hash-map to count specific array input
2. two pointers - left, right.
3. outer loop for right until end.
4. inner loop for left;
	as long as either window condition and/or another condition is satisfied / not satisfied. - move the left pointer.
5. Check the minimum/max/find result.

## Take either from start or end -
***LC1423, LC1658***
1. Fit everything from start until the window condition is satisfied.
2. set right to end.
3. now remove left, increase right
4. Check the minimum/max/find result

## Things to worry about
1. If calculating a sum - always use a double
2. corner cases are very important - left < right, left <= right, left <= 0, right >= len - 1 etc.,

## Images
[1]: question_variants.png

## Reading links
1. https://leetcode.com/discuss/study-guide/657507/Sliding-Window-for-Beginners-Problems-or-Template-or-Sample-Solutions
2. https://medium.com/outco/how-to-solve-sliding-window-problems-28d67601a66
3. https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
