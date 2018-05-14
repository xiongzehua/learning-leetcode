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

/*
用乘法做性能极差，而且还必须要用long，不然就溢出了。换成除法能避免这些问题。
*/
class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        //int mid = (start + end) / 2;    可能溢出
        int mid = start + (end - start) / 2;
        while (start <= end) {
            int i = x / mid;
            if (i == mid)
                return mid;
            else if (i > mid) 
                start = mid + 1;     
            else
                end = mid - 1;
            
            mid = (start + end) / 2;
        }
        return start - 1;
    }
}