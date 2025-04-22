package com.problem_solving.BFS.Binary_Tree_Level_Order_Traversal;

//Given the root of a binary tree,
// return the level order traversal of its nodes' values.
//              (i.e., from left to right, level by level).


//Example 1:
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]

//Example 2:
//Input: root = [1]
//Output: [[1]]

//Example 3:
//Input: root = []
//Output: []


import com.problem_solving.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
//        TreeNode root = {3, 9, 20, null, null, 15, 7};
//        System.out.println(levelOrder());
    }

    TreeNode node = new TreeNode();
    static List<List<Integer>> ans = new ArrayList<>(); // should be non-static ?

    public static void order(TreeNode node, int level) {
        if(ans.size() == level){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(node.val);

        if(node.left != null){
            order(node.left, level+1);
        }
        if(node.right != null){
            order(node.right, level+1);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return ans;
        }
        order(root, 0);
        return ans;
    }

}
