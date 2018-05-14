/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
*/

class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        int mid = (start + end) / 2;
        while (start <= end) {
            // if ((mid * mid) == x)
            //     return mid;
            if ((mid * mid) < x) 
                start = mid + 1;     
            else
                end = mid - 1;
            
            mid = (start + end) / 2;
        }
        return start - 1;
    }
}