package 三数之和15;

import java.util.*;

/**
 * @author klhu03
 * @since 2024/12/06 15:10
 **/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int f1 = -nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int f2 = f1 - nums[j];
                if(map.containsKey(f2)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(f2);
                    Collections.sort(list);
                    set.add(list);
                }
                map.put(nums[j], j);
            }
            map.clear();
        }
        return new ArrayList<>(set);
    }
}
