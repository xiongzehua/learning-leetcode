 /*
 Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
/

import java.util.Arrays;

/**
 * Created by 31339 on 2018/5/29.
 * 分析： 像这种时间复杂度超过 O(N^2) 的问题，一般都是多个指针，嵌套遍历多次。
 * 这时候可以考虑如下两种思路：
 * 1. 利用HashSet来替代一层查找，降低一个阶层的时间复杂度。（1.2Sum 15.3sum）
 * 2. 可以考虑先将元素进行排序，很多问题在顺序的情况下能简单很多。（15.3sum 16.3sum Closest）
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int deviation = Math.abs(sum - target);
        for (int current = 1; current < nums.length - 1; current++) {
            int start = 0;//head向右走一位，sum增大
            int end = nums.length - 1;//end向左走一位，sum减小
            while (start != current && end != current) {
                int thisSum = nums[start] + nums[current] +nums[end];
                int thisDeviation = Math.abs(thisSum - target);
                if (thisDeviation < deviation) {
                    deviation = thisDeviation;
                    sum = thisSum;
                }

                /* debug
                System.out.println("------------");
                for (int i = 0; i < nums.length; i++) {
                    if (i == start) {
                        System.out.print(nums[i] + "*,");
                    } else if (i == current ) {
                        System.out.print(nums[i] + "*,");
                    } else if (i == end) {
                        System.out.print(nums[i] + "*,");
                    } else
                        System.out.print(nums[i] + ",");
                }
                System.out.println();
                System.out.println("thisSum: " + thisSum + " sum: " + sum + " thisDeviation: " + thisDeviation + " deviation: " + deviation);
                */

                if (thisSum < target)
                    start++;
                else
                    end--;
            }
        }
        return sum;
    }
}
