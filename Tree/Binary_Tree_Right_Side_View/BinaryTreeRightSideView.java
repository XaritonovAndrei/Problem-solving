package com.problem_solving.Tree.Binary_Tree_Right_Side_View;


import com.problem_solving.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root of a binary tree,
// imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }
}