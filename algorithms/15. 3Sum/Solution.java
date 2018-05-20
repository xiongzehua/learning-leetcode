/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int newCnt = map.get(nums[i]) + 1;
                map.put(nums[i], newCnt);
            } else
                map.put(nums[i], 1);
        }


        for (Integer a :map.keySet()) {
            for (Integer b :map.keySet()) {
                int c = 0 - a - b;
                if (map.containsKey(c)) {
                    //saa

                } else
                    continue;
            }
        }
    }
}