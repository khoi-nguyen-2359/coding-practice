package leetcode_217_Contains_Duplicate;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> exists = new HashSet<>();
        for (int num : nums) {
            if (exists.contains(num)) {
                return true;
            }
            exists.add(num);
        }

        return false;
    }
}