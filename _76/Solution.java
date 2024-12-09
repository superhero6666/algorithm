package _76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author klhu03
 * @since 2024/12/09 15:59
 **/
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 1){
            if(s.equals(t)){
                return s;
            }else{
                return "";
            }
        }
        if(t.length() == 1){
            for(Character c : s.toCharArray()){
                if(c.equals(t.charAt(0))){
                    return t;
                }
            }
            return "";
        }
        String res = "";
        int length = Integer.MAX_VALUE;
        Map<Character, Integer> mapT = new HashMap<>();
        for(Character c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> mapS = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            mapS.put(entry.getKey(), 0);
        }
        int left = 0, right = 0;
        while(!mapS.containsKey(s.charAt(left))) {
            left++;
            if(left >= s.length()){
                return "";
            }
        }
        right = left + 1;
        mapS.put(s.charAt(left), mapS.getOrDefault(s.charAt(left), 0) + 1);
        while(right < s.length()) {
            if(!mapS.containsKey(s.charAt(right))) {
                right++;
                continue;
            }
            mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0) + 1);
            while(mapS.get(s.charAt(left)) > mapT.get(s.charAt(left))) {
                mapS.put(s.charAt(left), mapS.getOrDefault(s.charAt(left), 0) - 1);
                left++;
                while(!mapS.containsKey(s.charAt(left))) {
                    left++;
                }
            }
            right++;
            if(compare(mapS, mapT)){
                if(right - left < length){
                    res = s.substring(left, right);
                    length = res.length();
                }
            }
        }
        return res;
    }
    public boolean compare(Map<Character, Integer> mapT1, Map<Character, Integer> mapT2) {
        for(Map.Entry<Character, Integer> entry : mapT1.entrySet()) {
            if(entry.getValue() < mapT2.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ab", "a"));
    }
}
