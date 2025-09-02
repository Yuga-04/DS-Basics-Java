# 🚀 LeetCode 334: Increasing Triplet Subsequence

## 📌 Problem Statement
Given an integer array `nums`, return **true** if there exists a triple of indices `(i, j, k)` such that:

- `i < j < k`
- `nums[i] < nums[j] < nums[k]`

Otherwise, return **false**.

---

## ✨ Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
```

**Example 2:**
```
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
```

**Example 3:**
```
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One valid triplet is (0,4,6).
```

---

## ⚡ Constraints
- `1 <= nums.length <= 5 * 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## 💡 Intuition
Instead of storing all possible subsequences, we only track **two minimum numbers**:

1. `min1` → the **smallest number** seen so far.  
2. `min2` → the **second smallest number** (greater than `min1`).  

👉 If we ever find a number **greater than both**, that means we found a **triplet subsequence**.

---

## 📝 Code Implementation (Java)

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE; 
        int min2 = Integer.MAX_VALUE; 

        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
```

---

## 🔎 Dry Run Example

### Input: `[2, 1, 5, 0, 4, 6]`

| Step | num | min1 | min2 | Action |
|------|-----|------|------|--------|
| 1    | 2   | 2    | ∞    | `min1` updated |
| 2    | 1   | 1    | ∞    | `min1` updated |
| 3    | 5   | 1    | 5    | `min2` updated |
| 4    | 0   | 0    | 5    | `min1` updated |
| 5    | 4   | 0    | 4    | `min2` updated |
| 6    | 6   | 0    | 4    | ✅ Found `6 > min2` → triplet exists |

Output: **true**

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(n)` → iterate array once  
- **Space Complexity:** `O(1)` → only two variables used  

---

## 🎯 Key Takeaways for Presentation
- Track **two increasing numbers** (`min1` and `min2`).  
- If a third number is found greater than `min2`, answer is **true**.  
- Elegant **O(n) time, O(1) space** solution.  
- Works well for large inputs up to `5 * 10^5`.

---
