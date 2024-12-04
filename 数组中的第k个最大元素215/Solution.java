package 数组中的第k个最大元素215;


/**
 * @author klhu03
 * @since 2024/12/03 15:51
 **/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return maxK(nums, k-1, 0, nums.length - 1);
    }

    public int maxK(int[] nums, int k, int left, int right) {
        if( left == right){
            return nums[k];
        }
        int i = left-1, j = right+1;
        int key = nums[left];
        while (i < j) {
            do {
                i++;
            } while (nums[i]>key);
            do {
                j--;
            } while (nums[j]<key);
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if(j < k){
            return maxK(nums, k, j+1, right);
        }else{
            return maxK(nums, k, left, j);
        }
    }
    public static void main(String[] args) {
        int[] nums = {99,99};
        System.out.println(new Solution().findKthLargest(nums, 1));
    }
}
    //超时
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(stack1.isEmpty()){
//                stack1.push(nums[i]);
//                continue;
//            }
//            while(!stack1.isEmpty() && stack1.peek() < nums[i]){
//                stack2.push(stack1.pop());
//            }
//            if(stack1.size() < k){
//                stack1.push(nums[i]);
//            }
//            while(!stack2.isEmpty() && stack1.size() < k){
//                stack1.push(stack2.pop());
//            }
//        }
//        return stack1.pop();
//    }
    //3 2 1 5 6 4

