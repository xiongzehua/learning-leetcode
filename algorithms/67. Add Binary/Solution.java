/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

import java.util.LinkedList;
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("111", "1"));
    }
    public String addBinary(String a, String b) {
        String longStr = null;
        String shortStr = null;

        if (a.length() >= b.length()) {
            longStr = a;
            shortStr = b;
        } else {
            longStr = b;
            shortStr = a;
        }

        LinkedList<String> list = new LinkedList<String>();
        int carry = 0;
        int total = 0;
        int longStrCurrent = longStr.length() - 1;
        int shortStrCurrent = shortStr.length() - 1;
        
        while (shortStrCurrent >= 0) {
            total = Integer.valueOf(shortStr.substring(shortStrCurrent, shortStrCurrent + 1)) 
                + Integer.valueOf(longStr.substring(longStrCurrent, longStrCurrent + 1)) + carry;
            carry = total / 2;
            //System.out.println("carry: " + carry + "   total: " + total);
            total = total % 2; 

            list.addFirst(String.valueOf(total));

            shortStrCurrent--;
            longStrCurrent--;
        }
        while (longStrCurrent >= 0) {
            total = Integer.valueOf(longStr.substring(longStrCurrent, longStrCurrent + 1)) + carry;
            carry = total / 2;
            //System.out.println("carry: " + carry + "   total: " + total);
            total = total % 2;

            list.addFirst(String.valueOf(total));

            longStrCurrent--;
        }
        
        if (carry == 1)
            list.addFirst(String.valueOf(carry));

        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }
}