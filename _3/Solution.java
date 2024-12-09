package _3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author klhu03
 * @since 2024/12/09 10:42
 **/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        for(; left < s.length(); left++){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
