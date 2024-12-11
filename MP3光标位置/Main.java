package MP3光标位置;

/**
 * @author klhu03
 * @since 2024/12/11 16:14
 **/
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        int index = 1;
        int left = 1;
        int right = 4;
        if(n < 4){
            right = n;
        }

        for(Character c : input.toCharArray()){
            if(c.equals('U')){
                if(index - 1 < left){
                    if(left - 1 == 0){
                        if(n > 4){
                            left = n - 3;
                        }else{
                            left = 1;
                        }

                        right = n;
                        index = n;
                    }else{
                        left --;
                        right --;
                        index --;
                    }
                }else{
                    index --;
                }
            }else{
                if(index + 1 > right){
                    if(right == n){
                        if(n > 4){
                            right = 4;
                        }else{
                            right = n;
                        }
                        left = 1;
                        index = 1;
                    }else{
                        left ++;
                        right ++;
                        index ++;
                    }
                }else{
                    index++;
                }
            }
        }
        for(; left <= right; left++){
            System.out.print(left + " ");
        }
        System.out.println("\n" + index);
    }
}
