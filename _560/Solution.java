package _560;

/**
 * @author klhu03
 * @since 2024/12/09 11:19
 **/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{-1,-1,1}, 0));
    }
}
