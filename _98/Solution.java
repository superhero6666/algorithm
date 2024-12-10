package _98;

import dao.TreeNode;

/**
 * @author klhu03
 * @since 2024/12/10 13:18
 **/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return nb(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean nb(TreeNode root, long low, long up) {
        if (root == null) {
            return true;
        }
        if(root.val <= low || root.val >= up) {
            return false;
        }
        return nb(root.left, low, root.val) && nb(root.right, root.val, up);
    }
}
