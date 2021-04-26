# Sliding Window

![image alt <](question_variants.png)

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

## Types of Sliding Window:

1. Fast & Slow
   - Bit flip
   - Minimum Window substring
   - Consecutive subarray  sum
2. Fast & Catch up
   - Buy Sell stocks
   - Max consecutive sum
3. Fast & Lagging (constant slow)
   - House Robber
4. Front & Back
   - Rainwater
   - Sorted Two Sum

## Sliding Window Template - 1
**https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem**
- LC 3 - https://leetcode.com/problems/longest-substring-without-repeating-characters/
- LC 30 - https://leetcode.com/problems/substring-with-concatenation-of-all-words/
- LC 76 - https://leetcode.com/problems/minimum-window-substring/
- LC 159 - https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
- LC 340 - https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
- LC 424 - https://leetcode.com/problems/longest-repeating-character-replacement/
- LC 438 - https://leetcode.com/problems/find-all-anagrams-in-a-string/
- LC 567 - https://leetcode.com/problems/permutation-in-string/description/

## Sliding Window Template - 2
**https://leetcode.com/discuss/study-guide/657507/Sliding-Window-for-Beginners-Problems-or-Template-or-Sample-Solutions**
- LC 209 - https://leetcode.com/problems/minimum-size-subarray-sum/
- LC 239 - https://leetcode.com/problems/sliding-window-maximum/
- LC 424 - https://leetcode.com/problems/longest-repeating-character-replacement/
- LC 862 - https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
- LC 904 - https://leetcode.com/problems/fruit-into-baskets/
- LC 992 - https://leetcode.com/problems/subarrays-with-k-different-integers/
- LC 1004 - https://leetcode.com/problems/max-consecutive-ones-iii/
- LC 1208 - https://leetcode.com/problems/get-equal-substrings-within-budget/
- LC 1234 - https://leetcode.com/problems/replace-the-substring-for-balanced-string/
- LC 1248 - https://leetcode.com/problems/count-number-of-nice-subarrays/
- LC 1358 - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
- LC 1438 - https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

## Reading links
1. https://leetcode.com/discuss/study-guide/657507/Sliding-Window-for-Beginners-Problems-or-Template-or-Sample-Solutions
2. https://medium.com/outco/how-to-solve-sliding-window-problems-28d67601a66
3. https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
