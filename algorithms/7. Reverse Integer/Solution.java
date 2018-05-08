/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-2^31, 2^31-1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public static void main(String[] args) {
        int a = -17;
        System.out.println(a % 10);//-7
    }
    public static int reverse(int x) {
        long result = 0;

        while (x != 0) {
            int tail = x % 10;
            x = x / 10;
            result = result * 10 + tail;
        }
        
        if (result > (long)Integer.MAX_VALUE || result < (long)Integer.MIN_VALUE)
            return 0;
        else 
            return (int)result;
    }
}