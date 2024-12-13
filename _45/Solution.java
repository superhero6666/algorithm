package _45;

/**
 * @author klhu03
 * @since 2024/12/12 16:52
 **/
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int res = 0;
        int i =0;
        while(true){
            if(i + nums[i] >= nums.length-1){
                return ++res;
            }
            int temp = i;
            int max = Integer.MIN_VALUE;
            for(int j=i+1;j<=i+nums[i];j++){
                if(nums[j] + j - i>=max){
                    temp = j;
                    max = nums[j] + j - i;
                }
            }
            i = temp;
            res++;

        }
    }
}
