package _46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author klhu03
 * @since 2024/12/13 10:58
 **/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        return res;
    }
    void dfs(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i=0; i<nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(nums, list);
                list.remove(list.size()-1);
            }
        }
    }
}
