package 搜索旋转排序数组33;

/**
 * @author klhu03
 * @since 2024/12/03 15:09
 **/
public class Solution {
    public int search(int[] nums, int target) {
        return compare(nums, 0, nums.length - 1, target);
    }

    public int compare(int[] nums, int left, int right, int target) {
        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        if(left == right) {
            if(nums[left] == target) {
                return left;
            }else {
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        //true代表左边是有序数组
        boolean flag = true;
        if(nums[mid] < nums[left]){
            flag = false;
        }
        if(flag){
            if(nums[left] < target && nums[mid] > target){
                return compare(nums, left, mid - 1, target);
            }else{
                return compare(nums, mid + 1, right, target);
            }
        }else{
            if(nums[mid] < target && nums[right] > target){
                return compare(nums, mid+1,  right, target);
            }else{
                return compare(nums, left, mid-1, target);
            }
        }
    }
}
