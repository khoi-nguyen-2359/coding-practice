package leetcode_31_Next_Permutation;

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // find first decreased num
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // find first num larger than nums[i]
            while (nums[j] <= nums[i]) {
                --j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        for (int i = start; i < (nums.length + start) / 2; ++i) {
            swap(nums, i, nums.length - 1 - i + start);
        }
    }

    private void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextPermutation(new int[]{5,1,1});
    }
}
/*
Input: nums = [1,1,5,4,3,2]
result = [1,5,1]
 */