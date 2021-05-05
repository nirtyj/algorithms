# Binary Search

## When to Use
1. If we can discover some kind of monotonicity, for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.
2. There exists a function that can map elements in left half to True, and the other half to False, or vice versa

## Template 
1. **https://leetcode.com/discuss/study-guide/786126/python-powerful-ultimate-binary-search-template-solved-many-problems**
2. **https://leetcode.com/problems/binary-search/discuss/423162/Binary-Search-101-The-Ultimate-Binary-Search-Handbook**

# Steps

1. Design the condition function. This is the most difficult and most beautiful part. Needs lots of practice.
   -  E.g Square root - minimal k satisfying condition k^2 > x, then k - 1 is the answer.
   -  E.g Search Insert position - minimal k value satisfying nums[k] >= target
2. Correctly initialize the boundary variables left and right to specify search space. **Only one rule: set up the boundary to include all the possible answers should be included.**
   -   E.g Search Insert position - notice that the input target might be larger than all elements in nums and therefore needs to placed at the end of the array. That's why we should initialize right = len(nums) instead of right = len(nums) - 1
3. Choose the mid correctly. Care about overflow
   ```java
        let mid = lo + Math.floor((hi - lo) / 2); // left/lower mid
        let mid = lo + Math.floor((hi - lo + 1) / 2); // right/upper mid
   ```
4.  Shrinking logic has to work together in a way that every time, at least 1 element is excluded.
    ```java
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    ```
3. Decide return value. Is it return left or return left - 1? Remember this: after exiting the while loop, ***left is the minimal k satisfying the condition function***;

## Sample Code
```
def binary_search(array): # int
    
    // Handle corner cases 
    i.e input of 0 or 1 or null
    
    left, right = min(search_space), max(search_space) # could be [0, n], [1, n] etc. Depends on problem
    // use long if there is overflow possibility
    while left < right:
        mid = left + (right - left) / 2
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    return left
    
    def condition(value): # boolean
        pass
```

## Things to worry about
1. Include ALL possible answers when initialize lo & hi
2. Don't overflow the mid calculation
   - Changing the input range by Adding 1, etc.
   - Calculating Multiplications & Sums
   - Use long for overflow
3. Shrink boundary using a logic that will exclude mid
4. Avoid infinity loop by picking the correct mid and shrinking logic
5. Always think of the case when there are 2 elements left


## Handy Utils

1. Built in binary Search - if the return value is negative, it is insert position when (-val -1)
```java
    public int searchInsert(int[] nums, int target) {
        int val = Arrays.binarySearch(nums, target);
        return (val < 0) ? -val - 1 : val;
     }
```

## Problems
- LC 35 - https://leetcode.com/problems/search-insert-position/
- LC 69 - https://leetcode.com/problems/sqrtx/
- LC 278 - https://leetcode.com/problems/first-bad-version/

## TODO
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
https://leetcode.com/problems/split-array-largest-sum/
https://leetcode.com/problems/koko-eating-bananas/
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
https://leetcode.com/problems/find-k-th-smallest-pair-distance/
https://leetcode.com/problems/ugly-number-iii/
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/