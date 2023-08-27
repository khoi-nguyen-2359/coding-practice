package leetcode_11_Container_With_Most_Water.attempt_1;

import static java.lang.Integer.min;
import static java.lang.System.out;

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = (j - i) * min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }

        return maxArea;
    }
}

class Main {
    public static void main(String[] args) {
        int result = new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        out.println(result);
    }
}