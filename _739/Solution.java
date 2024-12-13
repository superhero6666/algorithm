package _739;

import java.util.Stack;

/**
 * @author klhu03
 * @since 2024/12/13 10:42
 **/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                res[stack.pop()] = i - stack.peek();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
