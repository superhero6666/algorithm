package 合并区间56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author klhu03
 * @since 2024/12/04 13:54
 **/
class Solution {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        for(;length>0;length--){
            adjust(intervals, length-1, 0);
            int temp = intervals[length-1][0];
            intervals[length-1][0] = intervals[0][0];
            intervals[0][0] = temp;
            temp = intervals[length-1][1];
            intervals[length-1][1] = intervals[0][1];
            intervals[0][1] = temp;
        }
        List<int[]> result = new ArrayList<>();
        result.add(intervals[intervals.length-1]);
        int size = 0;
        for(int i = intervals.length-2; i >= 0; i--){
            if(intervals[i][1] > result.get(size)[1]){
                if(intervals[i][0] <= result.get(size)[1]){
                    result.get(size)[1] = intervals[i][1];
                }else{
                    result.add(intervals[i]);
                    size++;
                }
            }
        }
        System.out.println(result.size());
        int[][] res = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }

    public void adjust(int[][] intervals, int length, int i) {
        if(i*2+1 > length){
            return;
        }
        adjust(intervals, length, i*2+1);
        adjust(intervals, length, i*2+2);
        if(i*2+2 > length){
            if(intervals[i][0] > intervals[i*2+1][0] ){
                int temp = intervals[i*2+1][0];
                intervals[i*2+1][0] = intervals[i][0];
                intervals[i][0] = temp;
                temp = intervals[i*2+1][1];
                intervals[i*2+1][1] = intervals[i][1];
                intervals[i][1] = temp;
            }
            return;
        }
        if(intervals[i*2+1][0] < intervals[i*2+2][0]){
            if(intervals[i][0] > intervals[i*2+1][0]){
                int temp = intervals[i*2+1][0];
                intervals[i*2+1][0] = intervals[i][0];
                intervals[i][0] = temp;
                temp = intervals[i*2+1][1];
                intervals[i*2+1][1] = intervals[i][1];
                intervals[i][1] = temp;
            }
        }else{
            if(intervals[i][0] > intervals[i*2+2][0]){
                int temp = intervals[i*2+2][0];
                intervals[i*2+2][0] = intervals[i][0];
                intervals[i][0] = temp;
                temp = intervals[i*2+2][1];
                intervals[i*2+2][1] = intervals[i][1];
                intervals[i][1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] in = new int[][]{{1,4}, {0,4}};
        Solution solution = new Solution();
        solution.merge(in);
    }

        //超时
//        Stack<int[]> stack1 = new Stack<>();
//        Stack<int[]> stack2 = new Stack<>();
//        for (int[] interval : intervals) {
//            if(stack1.isEmpty()){
//                stack1.push(interval);
//                continue;
//            }
//            while(!stack1.isEmpty() && stack1.peek()[0] < interval[0]){
//                stack2.push(stack1.pop());
//            }
//            stack1.push(interval);
//            while(!stack2.isEmpty()){
//                stack1.push(stack2.pop());
//            }
//        }
//        stack2.push(stack1.pop());
//        while(!stack1.isEmpty()){
//            if(stack1.peek()[0] <= stack2.peek()[1]){
//                if(stack1.peek()[1] <= stack2.peek()[1]){
//                    stack1.pop();
//                }else{
//                    stack2.peek()[1] = stack1.peek()[1];
//                }
//            }else{
//                stack2.push(stack1.pop());
//            }
//        }
//        int[][] res = new int[stack2.size()][2];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = stack2.pop();
//        }
//        return res;

}