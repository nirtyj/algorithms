# Sliding Window
Sliding Window problems are a subset of dynamic programming problems, though the approach to solving them is quite 
different from the one used in solving tabulation or memoization problems.

## Hints for Identifying Sliding Window problems :
1. The problem will involve a data structure that is ordered and iterable like an array or a string
2. You are looking for some subrange (subsequence / substring / sub range) in that array/string, like a longest, shortest or target value.
3. There is an apparent naive or brute force solution that runs in O(N²), O(2^N) or some other large time complexity.
4. Biggest giveaway is that the thing you are looking for is often some kind of optimal, like the longest sequence or shortest sequence of something that satisfies a given condition exactly.

## Types of Sliding Window:

1. Fast & Slow (slow pointer moves incrementally independently to the fast based on a condition)
   - LongestSubstringWithoutRepeatingCharacters_LC3
   - MinimumWindowSubstring_LC76
   - LongestSubstringWithAtMostTwoDistinctChars_LC159
   - MinSizeSubarraySum_LC209
   - LongestSubstringWithAtMostKDistinctCharacters_LC340
   - LongestRepeatingCharacterReplacement_LC424
   - FindAllAnagramsInAString_LC438
   - FruitIntoBacketsSlidingWindow_LC904
   - MaxConsecutiveOnesIII_LC1004
   - NumberOfSubstringsContainingAllThreeChar_LC1358
   - LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit_LC1438
2. Fast & Catch up (slow pointer jumps & resets independently to the fast based on a condition)
   - SubstringWithConcatenationOfAllWords_LC30
3. Fast & Lagging (slow pointer moves along with the fast based on a constant window size)
   - PermutationsInAString_LC567
4. Front & Back

## Sliding Window Template
1. **https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem**
2. **https://leetcode.com/discuss/study-guide/657507/Sliding-Window-for-Beginners-Problems-or-Template-or-Sample-Solutions**

### Steps
1. Have a counter and/or hash-map or (2 deques/treeset) to count/max/min in the specific array input range
2. two pointers - begin, end.
3. outer for end until the end of the string / array.
4. inner while loop for moving begin;
   as long as either window condition and/or another condition is satisfied / not satisfied. - move the begin pointer.
5. Check the minimum/max/find result.

### Code Example

```java
public class LongestSubstringWithAtMostKDistinctCharacters_LC340 {
   public int lengthOfLongestSubstringKDistinct(String s, int k) {
      HashMap<Character, Integer> map = new HashMap<>();
      int begin = 0;
      int result = 0;
      int counter = 0;
      for (int end = 0; end < s.length(); end++) {
         char c = s.charAt(end);
         map.put(c, map.getOrDefault(c, 0) + 1);
         if (map.get(c) == 1)
            counter++;

         while (counter > k) {
            char beginC = s.charAt(begin);
            map.put(beginC, map.get(beginC) - 1);
            if (map.get(beginC) == 0) {
               counter--;
            }
            begin++;
         }
         // update max
         result = Math.max(end - begin + 1, result);
      }
      return result;
   }
}
```
### Problems
- LC 3 - https://leetcode.com/problems/longest-substring-without-repeating-characters/
- LC 30 - https://leetcode.com/problems/substring-with-concatenation-of-all-words/
- LC 76 - https://leetcode.com/problems/minimum-window-substring/
- LC 159 - https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
- LC 209 - https://leetcode.com/problems/minimum-size-subarray-sum/
- LC 340 - https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
- LC 424 - https://leetcode.com/problems/longest-repeating-character-replacement/
- LC 438 - https://leetcode.com/problems/find-all-anagrams-in-a-string/
- LC 567 - https://leetcode.com/problems/permutation-in-string/description/
- LC 904 - https://leetcode.com/problems/fruit-into-baskets/
- LC 1004 - https://leetcode.com/problems/max-consecutive-ones-iii/
- LC 1358 - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
- LC 1438 - https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

### TODO:
- LC 239 - https://leetcode.com/problems/sliding-window-maximum/
- LC 862 - https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
- LC 992 - https://leetcode.com/problems/subarrays-with-k-different-integers/
- LC 1208 - https://leetcode.com/problems/get-equal-substrings-within-budget/
- LC 1234 - https://leetcode.com/problems/replace-the-substring-for-balanced-string/
- LC 1248 - https://leetcode.com/problems/count-number-of-nice-subarrays/

## Things to worry about
1. If calculating a sum - always use a double
2. Corner cases are very important - end < length, end - begin + 1 = length

## Other Reading links
1. https://medium.com/outco/how-to-solve-sliding-window-problems-28d67601a66

## Example Image link
![image alt <](question_variants.png)
