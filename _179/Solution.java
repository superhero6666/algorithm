package _179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author klhu03
 * @since 2024/12/13 15:49
 **/
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Comparator<Integer> c = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                long num1 = 10;
                long num2 = 10;
                while(num1 <= o1){
                    num1 *= 10;
                }
                while(num2 <= o2){
                    num2 *= 10;
                }
                return Long.compare(o2 * num1 + o1, o2 + o1 * num2) ;
            }
        };
        Arrays.sort(arr, c);
        if(arr[0] == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{10, 2}));
    }
}
