/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

/*
核心思想：一个完全逆序序列的下一个，就是把这个序列颠倒
任一序列nums可以拆分为两个序列array1和array2
使得array1 + index2 = nums
其中array2是完全逆序序列

则nums的下个序列为：
1. 将array2完全颠倒，颠倒后的array2完全正序
2. array1的末尾进位（即将array1的末尾a与array2中刚刚好比a大的b，做交换）
3. 将新的array1和array2拼接就是nums的下一个序列了
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = 0; //array1的最后一个元素在nums中的角标
        int index2 = 0; //array2的第一个元素在nums中的角标
        int current = nums.length - 1;
        while(current >= 1) {
            if (nums[current] <= nums[current - 1])
                current--;
            else {
                index2 = current;
                index1 = current - 1;
                break;
            }          
        }

        if (index2 == 0) {
            //若没有找到array2, 则nums既是完全逆序, 下一个序列是nums完全颠倒
            reverse(nums, 0 , nums.length - 1);
        } else {
            //若找到array2

            //将array2完全颠倒
            reverse(nums, index2 , nums.length - 1);
            //array1的末位元素进位
            while(index2 < nums.length) {
                if (nums[index2] > nums[index1]) {
                    swap(nums, index1, index2);
                    break;
                }
                index2++;
            }
        }      
    }

    /**
	 * 将数组array中的[start, end]完全颠倒
	 */
    public void reverse(int[] array, int start, int end) {
        while(start < end) {
            swap(array, start++, end--);
        }
    }
    /**
	 * 将数组array中角标a和角标b的元素交换
	 */
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}