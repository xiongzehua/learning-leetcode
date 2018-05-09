/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/

import java.util.LinkedList;
class Solution {
    public static void main(String[] args) {
        System.out.println(next("1112"));
    }
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = next(s);
        }
        return s;
    }
    public static String next(String s) {
        LinkedList<String> list = new LinkedList<String>();
        String pre = s.substring(0,1);
        list.add(pre);

        for (int i = 1; i < s.length(); i++) {
            String buf = s.substring(i, i+1);
            if (!buf.equals(pre)) {
                list.add(buf);
            } else {
                StringBuffer newStr = new StringBuffer();
                String oldStr = list.removeLast();
                newStr.append(oldStr).append(buf);
                list.add(newStr.toString());
            }
            pre = buf;
        }

        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(String.valueOf(str.length())).append(str.substring(0,1));
        }
        return sb.toString();
    }
}