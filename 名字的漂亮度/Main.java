package 名字的漂亮度;

/**
 * @author klhu03
 * @since 2024/12/12 15:31
 **/
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int num = in.nextInt();
        in.nextLine();
        for(int i = 0; i < num; i ++){
            String line = in.nextLine();
            int res = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(Character c : line.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Integer> list = new ArrayList<>();
            map.keySet().forEach( t -> {
                list.add(map.get(t));
            });
            list.sort((o1, o2) -> {
                return o2 - o1;
            });
            for(int j = 0; j < list.size(); j++){
                res += (26 - j) * list.get(j);
            }
            System.out.println(res);
        }
    }
}
