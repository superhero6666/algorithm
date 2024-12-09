package _239;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author klhu03
 * @since 2024/12/09 15:01
 **/
class Node{
    int num;
    int index;
    public Node(int num, int index){
        this.num = num;
        this.index = index;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k, (o1, o2) -> {
            if(o1.num == o2.num){
                return o1.index - o2.index;
            }
            return o2.num - o1.num;
        });
        for(int i = 0; i < k; i++){
            pq.add(new Node(nums[i], i));
        }
        res[0] = pq.element().num;
        for(int i = 1; i < nums.length - k + 1; i++){
            pq.add(new Node(nums[i+k-1], i+k-1));
            while(pq.element().index < i){
                pq.remove();
            }
            res[i] = pq.element().num;
        }
        return res;
    }
}
