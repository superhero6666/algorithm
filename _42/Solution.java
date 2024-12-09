package _42;

import java.util.Comparator;

/**
 * @author klhu03
 * @since 2024/12/06 17:26
 **/
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]) {
                result += leftMax - height[left];
                left++;
            }else{
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}