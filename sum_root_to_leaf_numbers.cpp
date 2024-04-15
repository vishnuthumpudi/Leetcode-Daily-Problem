/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    int sumRec(TreeNode* root, int last)
    {
        if(root->left==NULL && root->right==NULL)
            return root->val + last;
        int res = 0;
        if(root->left)
        {
            res += sumRec(root->left, (root->val+last)*10);
        }
        if(root->right)
        {
            res += sumRec(root->right, (root->val+last)*10);
        }
        return res;
    }

    int sumNumbers(TreeNode* root) {
        return sumRec(root, 0);
    }
};
