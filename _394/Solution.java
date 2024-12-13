package _394;

import java.util.Stack;

/**
 * @author klhu03
 * @since 2024/12/13 15:31
 **/
class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '['){
                stringStack.push(sb.toString());
                sb.setLength(0);
                continue;
            }
            if('0' <= c && c <= '9'){
                integerStack.push(c - '0');
                while('0' <= s.charAt(i+1) && '9' >= s.charAt(i+1)){
                    i++;
                    integerStack.push(integerStack.pop() * 10 + (s.charAt(i) - '0'));
                }
                continue;
            }
            if(c == ']'){
                int num = integerStack.pop();
                String str = sb.toString();
                for(int j = 1; j < num; j++){
                    sb.append(str);
                }
                str = stringStack.pop();
                sb.insert(0, str);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}