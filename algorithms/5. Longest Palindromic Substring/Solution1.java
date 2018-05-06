/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cabad"));
    }
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        Window max = new Window(s, 0, 0);

        for (int i = 1; i < s.length(); i++) {
            Window w1 = new Window(s, i, i);
            w1 = w1.expandToMax();
            Window w2 = new Window(s, i-1, i);
            w2 = w2.expandToMax();
            max = Window.maxWindow(w1, w2, max);
        }
        return s.substring(max.start, max.end + 1);
    }
    
}
class Window {
    Window(String s, int start, int end) {
        this.start = start;
        this.end = end;
        this.s = s;
    }
    String s;
    int start;//左实
    int end;//右实
    int getLength() {
        return end - start + 1;
    }
    Window expandToMax() {
        if(s.charAt(start) != s.charAt(end))
            return new Window(s, 0, 0);
        while(start >= 1 && end < s.length() - 1) {
            if (s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            } else 
                break;
            
        }
        return this;
    }
    static Window maxWindow(Window w1, Window w2, Window w3) {
        if (w1.getLength() > w2.getLength() && w1.getLength() > w3.getLength())
            return w1;
        else {
            if (w2.getLength() > w3.getLength())
                return w2;
            else
                return w3;
        }
    }
}