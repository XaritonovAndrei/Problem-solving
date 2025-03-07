package com.problem_solving.Tree.Maximum_Depth_of_Binary_Tree;

//leetcode link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

//Given the root of a binary tree, return its maximum depth.

//A binary tree's maximum depth
// is the number of nodes along the longest path
// from the root node down to the farthest leaf node.

//Example 1:
//Input: root = [3,9,20,null,null,15,7]
//Output: 3

//Example 2:
//Input: root = [1,null,2]
//Output: 2

class Solution {

    public int maxDepth(Node rootNode) {

        if(root == null){
            return 0;
        }
        else{
            int leftmax= maxDepth(root.left);
            int rightmax = maxDepth(root.right);
            return Math.max(leftmax, rightmax) + 1;
        }
    }
}
