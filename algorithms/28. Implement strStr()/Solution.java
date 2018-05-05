/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

class Solution {
    public int strStr(String haystack, String needle) {
        //制作一个滑窗
        int start = 0;//滑窗开始左实端
        int end = start + needle.length();//滑窗开始右虚端

        int ret = -1;

        while(true) {
            if (end > haystack.length())
                break;

            if (haystack.substring(start, end).equals(needle)) {
                ret = start;
                break;
            }        
            start++;
            end++;
        }
        return ret;
    }
}