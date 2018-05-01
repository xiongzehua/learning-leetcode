/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Solution3 {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("ad"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals(""))
            return 0;
        int head = 0;
        int last = 1;//字符串下一个的索引
        int maxLen = 1;

        while (true) {
            last = head +1;
            while (true) {
                if(last == s.length())
                    break;
                System.out.println("-------------------------------");
                System.out.println("head:" + head + " last:" + last);
                String str = s.substring(head, last);
                if (str.contains(s.substring(last, last + 1))) {
                    if ((last - head) > maxLen)
                        maxLen = last - head;
                        System.out.println(" maxLen: " + maxLen + " last - head:" + (last - head));
                    head = head + str.indexOf(s.substring(last, last + 1)) + 1;
                    break;
                }

                last++;
            }
            if(last == s.length()) {
                if ((last - head) > maxLen)
                    maxLen = last - head;
                break;
            }
        }
        return maxLen;
    }
}
