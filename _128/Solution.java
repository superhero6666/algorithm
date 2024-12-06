package _128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author klhu03
 * @since 2024/12/06 15:48
 **/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for(Integer num : set) {
            if (!set.contains(num - 1)) {
                int cuNum = num;
                int count = 1;
                while(set.contains(cuNum + 1)) {
                    cuNum++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
