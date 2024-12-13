package _781;

import java.util.HashMap;
import java.util.Map;

/**
 * @author klhu03
 * @since 2024/12/13 10:18
 **/
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<answers.length; i++){
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res += (entry.getValue() + entry.getKey()) / (entry.getKey() + 1) * (entry.getKey() + 1);
        }
        return res;
    }
}
