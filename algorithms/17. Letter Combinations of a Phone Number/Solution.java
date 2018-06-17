/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
import java.util.*;

class Solution {
    HashMap<String, String> map;
    {
        map = new HashMap<String, ArrayList<String>>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = map.get(digits.substring(0,1));
        for (int i = 1; i < digits.length(); i++) {
            list = cartesianProduct(list, map.get(digits.substring(i,i + 1)));
        }
        return list;
    }
    public ArrayList<String> cartesianProduct(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                list.add(list1.get(i) + list2.get(j));
            }
        }
    }
}