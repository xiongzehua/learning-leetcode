/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
/*
A sliding window is an abstract concept commonly used in array/string problems.
A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i, j)[i,j) (left-closed, right-open).
A sliding window is a window "slides" its two boundaries to the certain direction.
For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).

Back to our problem.
We use HashSet to store the characters in current window [start, end] (start = end=0 initially).
Then we slide the index end to the right.
If it is not in the HashSet, we slide end further.
Doing so until s[end] is already in the HashSet.
At this point, we found the maximum size of substrings without duplicate characters start with index start.
If we do this for all ii, we get our answer.
 */
import java.util.HashSet;

public class Solution3_1 {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("a"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<String> set = new HashSet<String>();
        //start为滑窗的左窗，end为滑窗的右窗，end滑到最后一个字符便算结束
        int start = 0, end = 0;

        while (true) {
            if (end == s.length())
                break;

            String str = s.substring(end, end+1);

            if(!set.contains(str)) {
                set.add(str);
                maxLen = Math.max((end -start +1), maxLen);
                end++;

            }
            else {
                set.remove(s.substring(start,start+1));
                start++;
            }
        }
        return maxLen;
    }
}
