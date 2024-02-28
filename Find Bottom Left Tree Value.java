/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int leftmost = 0;
    int leftmostrow = -1;
    void visit(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > leftmostrow) {
            leftmost = root.val;
            leftmostrow = depth;
        }
        visit(root.left, depth+1);
        visit(root.right, depth+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        visit(root, 0)    ;
        return leftmost;
    }
}
