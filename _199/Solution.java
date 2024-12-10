package _199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dao.TreeNode;
/**
 * @author klhu03
 * @since 2024/12/10 14:26
 **/
class Solution {
    TreeNode temp = null;
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node == null){
                    if(temp == null){
                        continue;
                    }else{
                        node = temp;
                    }
                }
                queue.add(node.left);
                queue.add(node.right);
                if(queue.peek() == null){
                    temp = new TreeNode(node.val);
                }else{
                    temp = null;
                }
                if(i == size - 1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
