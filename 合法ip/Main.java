package 合法ip;

/**
 * @author klhu03
 * @since 2024/12/11 17:28
 **/
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        String[] ips = line.split("\\.");
        if(ips.length != 4){
            System.out.println("NO");
            return;
        }
        for(String str : ips){
            if(str.equals("")){
                System.out.println("NO");
                return;
            }
            boolean flag = false;
            for(Character c : str.toCharArray()){
                if(!(c >= '0' && c <= '9')){
                    System.out.println("NO");
                    return;
                }
                if(c != '0'){
                    flag = true;
                }
            }
            if(flag && str.charAt(0) == '0'){
                System.out.println("NO");
                return;
            }
            long num = Long.parseLong(str);
            if(!(num >= 0 && num <= 255)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
