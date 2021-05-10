# Binary Search

## When to Use
1. There exists a ***defined search space where the answer lie within the range of left min and right max*** and a ***function/condition that can split elements in the search space with left half to True, and the other half to False***, or vice versa
2. If we can discover some kind of monotonicity, for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.

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
4. If using left = mid; then use the condition middle = (left + right + 1)/2; https://leetcode.com/problems/divide-chocolate/. 
   This is because, you are increasing the right = mid, you need to use the left lower mid for middle. left + (right - left) / 2;
   if you are using left = mid, you need to use the right upper mid for middle.  (left + right + 1)/2;

## Sample Code
```
def binary_search(array): # int
    
    // Handle corner cases 
    i.e input of 0 or 1 or null
    
    left = min(search_space)
    right = max(search_space)
    
    // use long if there is overflow possibility
    while left < right:
        mid = left + (right - left) / 2 // change to middle = left + right + 1
        if condition(mid):
            right = mid // if you need to use left = mid
        else:
            left = mid + 1 // right = mid - 1;
    return left
    
    def condition(value): # a funtion to split the search space to true / false.
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
### Basic Application - given left, right, and an easy condition
- LC 35 - https://leetcode.com/problems/search-insert-position/
- LC 69 - https://leetcode.com/problems/sqrtx/
- LC 278 - https://leetcode.com/problems/first-bad-version/

### Intermediate Applications - define a search space with left & right, and implement a custom condition
#### custom condition can use n * n algorithm or a heap or sliding window or even a binary search
- LC 410 - https://leetcode.com/problems/split-array-largest-sum/
- LC 668 - https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
- LC 719 - https://leetcode.com/problems/find-k-th-smallest-pair-distance/
- LC 774 - https://leetcode.com/problems/minimize-max-distance-to-gas-station/  
- LC 875 - https://leetcode.com/problems/koko-eating-bananas/
- LC 1011 - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
- LC 1201 - https://leetcode.com/problems/ugly-number-iii/
- LC 1283 - https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
- LC 1482 - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

## TODO
- https://leetcode.com/problems/divide-chocolate/
