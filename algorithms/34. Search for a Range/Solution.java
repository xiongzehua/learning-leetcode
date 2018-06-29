/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < nums[mid])
                high = mid - 1;
            else if (target > nums[mid])
                low = mid + 1;
            else {
                if (mid == 0 || nums[mid - 1] != target) {
                    result[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            }
        }

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < nums[mid])
                high = mid - 1;
            else if (target > nums[mid])
                low = mid + 1;
            else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    result[1] = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }
}