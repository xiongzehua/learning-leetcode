/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target) 
                return 0;
            else
                return -1;
        }
        
        //第一个正序数组：[0...point]
        //第二个正序数组：[point+1...nums-1]
        //例如[4,5,6,7,0,1,2], point=3
        int point = 0;

        int low = 0, high = nums.length - 1, mid = (low + high) / 2;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[mid+1]) { //命中
                point = mid;
                break;
            } else {
                if (nums[low] > nums[mid]) //array2在左区间
                    high = mid;
                else //array2在右区间
                    low = mid+1;
            }
        }

        if (nums[0] <= target && target <= nums[point]) { //target在左区间
            low = 0;
            high = point;
        } else if (nums[point + 1] <= target  && target <= nums[nums.length - 1]) { //target在右区间
            low = point + 1;
            high = nums.length - 1;
        } else { //不匹配
            return -1;
        }

        while (low <= high) {
            mid = (low + high) / 2;
            if (target < nums[mid]) //target落在左半区间
                high = mid - 1;
            else if (target > nums[mid]) //target落在右半区间
                low = mid + 1;
            else //target命中
                return mid;
        }

        return -1;
    }
}