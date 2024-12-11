package 密码验证合格程序;

/**
 * @author klhu03
 * @since 2024/12/11 15:31
 **/
import java.util.Scanner;

import java.util.Set;
import java.util.HashSet;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            if (line.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            boolean flag = true;
            Set<Character> set = new HashSet<>();
            for (Character c : line.toCharArray()) {
                if (c.equals(" ") || c.equals("\n")) {
                    flag = false;
                    break;
                }
                if ('a' <= c && c <= 'z') {
                    set.add('a');
                } else if ('A' <= c && c <= 'Z') {
                    set.add('A');
                } else if ('0' <= c && c <= '9') {
                    set.add('0');
                } else {
                    set.add('#');
                }
            }
            if (set.size() < 3) {
                flag = false;
            }
            if (!flag) {
                System.out.println("NG");
                continue;
            }
            if(isValid(line, 0, 3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
    static boolean isValid(String str, int l, int r){
        if(r >= str.length()){
            return false;
        }
        if(str.substring(r).contains(str.substring(l, r))){
            return true;
        }else{
            return isValid(str, l+1, r+1);
        }
    }
}