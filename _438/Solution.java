package _438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author klhu03
 * @since 2024/12/09 11:07
 **/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        p = new String(chars);
        for(int i = 0; i <= s.length()-p.length(); i++){
            String sub = s.substring(i, i+p.length());
            char[] ch = sub.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(sorted.equals(p)){
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("eklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsni", "yqrbgjdwtcaxzsnifvhmou"));
    }
}
