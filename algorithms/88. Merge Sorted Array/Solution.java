/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexTotal = m + n -1;
        int[] total = nums1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums2[index2] > nums1[index1]) {
                total[indexTotal--] = nums2[index2--];
            } else {
                total[indexTotal--] = nums1[index1--];
            }
        }

        while (index2 >= 0) {
            total[indexTotal--] = nums2[index2--];
        }
        
        //其实下面这种情况不用写，当nums2已经全部按顺序插入到nums1后，nums1剩下的元素本身就是排好序的了。
        while (index1 >= 0) {
            total[indexTotal--] = nums1[index1--];
        }
    }
}