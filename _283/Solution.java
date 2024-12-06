package _283;

/**
 * @author klhu03
 * @since 2024/12/06 16:46
 **/
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length){
            while(i < nums.length && nums[i] != 0){
                i++;
            }
            int j =i+1;
            while(j < nums.length && nums[j] == 0){
                j++;
            }
            if(j < nums.length){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
    }
}
