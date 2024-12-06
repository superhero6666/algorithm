package 金牌排列榜;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author klhu03
 * @since 2024/12/06 17:33
 **/
class Con{
    int gold;
    int si;
    int tong;
    String name;
}
public class Solution {
    public void select(Con[] c){
        Comparator comparator = new Comparator<Con>() {

            @Override
            public int compare(Con o1, Con o2) {
                if(o1.gold == o2.gold){
                    if(o1.si == o2.si){
                        if(o1.tong == o2.tong){
                            return o2.name.compareTo(o1.name);
                        }
                        return o2.tong - o1.tong;
                    }
                    return o2.si - o1.si;
                }
                return o2.gold - o1.gold;
            }
        };
        Arrays.sort(c, comparator);

    }
}
