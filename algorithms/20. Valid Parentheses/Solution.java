/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer flag = charToFlag(c);

            if (list.size() == 0) {
                list.addLast(flag);
            } else {
                Integer preFlag = list.getLast();
                if (flag + preFlag == 0) {
                    list.removeLast();
                } else {
                    list.addLast(flag);
                }
            }
        }
        if (list.size() == 0)
            return true;
        else
            return false;
    }
    public Integer charToFlag (Character c) {
        if (c.equals('{'))
            return 1;
        if (c.equals('}'))
            return -1;
        if (c.equals('['))
            return 2;
        if (c.equals(']'))
            return -2;
        if (c.equals('('))
            return 3;
        if (c.equals(')'))
            return -3;
        return 0;
    }
}
