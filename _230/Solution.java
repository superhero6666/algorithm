package _230;

import dao.TreeNode;
/**
 * @author klhu03
 * @since 2024/12/10 14:09
 **/
class Solution {
    int leftNum = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        leftNum = 0;
        conNum(root.left);
        if(leftNum >= k){
            return kthSmallest(root.left, k);
        }
        if(leftNum + 1 == k){
            return root.val;
        }
        return kthSmallest(root.right, k - leftNum - 1);
    }

    public void conNum(TreeNode root){
        if(root == null) {
            return;
        }
        leftNum++;
        conNum(root.left);
        conNum(root.right);
    }
}
