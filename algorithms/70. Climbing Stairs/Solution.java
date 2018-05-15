/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

class Solution {
    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int a = 0;
        if (cache.containsKey(n - 1)) {
            a = cache.get(n - 1);
        } else {
            a = climbStairs(n - 1);
            cache.put(n-1, a);
        }

        int b = 0;
        if (cache.containsKey(n - 2)) {
            b = cache.get(n - 2);
        } else {
            b = climbStairs(n - 2);
            cache.put(n-2, b);
        }

        return a + b;
    }
}