/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/

/*
二分查找答案的标准写法
*/

class Solution2 {
     /**
     * 情况一：target在数组中存在
     * return mid 返回 target在数组中实际的位置
     * 
     * 情况二：target在数组中不存在
     * 
     * 1. 若nums[i] < target < nums[i+1]
     * ---倒数第二轮循环---
     * 进循环前：low=i high=i+1
     * 循环体执行后：mid=i low=mid+1=i+1 high=i+1
     * ----最后一轮循环----
     * 进循环前：low=i+1 high=i+1
     * 循环体执行后：mid=i+1 low=mid+1=i+2 high=i+1
     * ------退出循环------
     * return low 返回i+1 为target应该插入的位置
     * 
     * 2. 若target < nums[0]
     * ----最后一轮循环----
     * 进循环前：low=0 high=1
     * 循环体执行后：mid=0 high=mid-1=-1 low=0
     * ------退出循环------
     * return low 返回0 为target应该插入的位置
     *
     * 3. 若target > nums[nums.length-1]
     * ---倒数第二轮循环---
     * 进循环前：low=nums.length-2 high=nums.length-1
     * 循环体执行后：mid=nums.length-2 low=mid+1=nums.length-1 high=nums.length-1
     * ----最后一轮循环----
     * 进循环前：low=nums.length-1 high=nums.length-1
     * 循环体执行后：mid=nums.length-1 low=mid+1=nums.length high=nums.length-1
     * ------退出循环------
     * return low 返回nums.length 为target应该插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;

            if (target < nums[mid]) //target落在左半区间
                high = mid - 1;
            else if (target > nums[mid]) //target落在右半区间
                low = mid + 1;
            else //target命中
                return mid;
        }
        return low;
    }
}