package 只出现一次的数字136;

/**
 * @author klhu03
 * @since 2024/12/04 10:36
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            //^异或
            result ^= i;
        }
        return result;

    }
}
