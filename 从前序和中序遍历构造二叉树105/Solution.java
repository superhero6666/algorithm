package 从前序和中序遍历构造二叉树105;

import dao.TreeNode;
/**
 * @author klhu03
 * @since 2024/12/04 11:15
 **/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int head = preorder[0];
        //左子树节点数量
        int num =0;
        while(head != inorder[num]) {
            num++;
        }
        int[] newPreorderl = new int[num];
        int[] newPreorderr = new int[preorder.length - num -1];
        int[] newInorderl = new int[num];
        int[] newInorderr = new int[preorder.length - num -1];
        for(int i =0; i <newPreorderl.length; i++) {
            newPreorderl[i] = preorder[i+1];
        }
        for(int i =0; i <newPreorderr.length; i++) {
            newPreorderr[i] = preorder[i+num+1];
        }
        for(int i =0; i <newInorderl.length; i++) {
            newInorderl[i] = inorder[i];
        }
        for (int i =0; i<newInorderr.length; i++) {
            newInorderr[i] = inorder[i+num+1];
        }
        return new TreeNode(head, buildTree(newPreorderl, newInorderl), buildTree(newPreorderr, newInorderr));
    }
}