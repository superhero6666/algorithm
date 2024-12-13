package _1190;

import java.util.Stack;

/**
 * @author klhu03
 * @since 2024/12/12 17:16
 **/
class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if(c.equals('(')){
                stack.push(str.toString());
                str.setLength(0);
                continue;
            }
            if(c.equals(')')){
                str.reverse();
                str.insert(0, stack.pop());

            }else{
                str.append(c);
            }
        }
        return str.toString();
    }
}
