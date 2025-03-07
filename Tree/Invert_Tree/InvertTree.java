
//Given the root of a binary tree, invert the tree, and return its root.
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//
//Example 2:
//Input: root = [2,1,3]
//Output: [2,3,1]
//
//Example 3:
//Input: root = []
//Output: []

class Solution {
    public Node invertTree(Node root) {

        if (root == null){
            return null;
        }

        Node right = invertTree(root.right);
        Node left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;

    }
}