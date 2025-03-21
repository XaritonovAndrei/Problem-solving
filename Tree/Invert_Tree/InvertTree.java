package com.problem_solving.Tree.Invert_Tree;

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

import com.problem_solving.Tree.BinarySearchTree;
import com.problem_solving.Tree.Node;

public class InvertTree {
    public static void main(String[] args) {

        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(4);
        Node nodeE = new Node(5);
        Node nodeF = new Node(6);

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;

//                         A
//                  B             C
//              D       E         F

        System.out.println("Original:");
        System.out.println("Node A: " + nodeA.data
                                + ", Left child(B): " + nodeA.left.data
                                + ", Right child(C): " + nodeA.right.data);
        System.out.println("Node B: " + nodeB.data
                + ", Left child(D): " + nodeD.data
                + ", Right child(E): " + nodeE.data);
        System.out.println("Node C: " + nodeC.data
                + ", Left child(F): " + nodeF.data);


        invertTree(nodeA);

        System.out.println("Inverted:");
        System.out.println("Node A: " + nodeA.data
                + ", Left child(B): " + nodeA.left.data
                + ", Right child(C): " + nodeA.right.data);
        System.out.println("Node B: " + nodeB.data
                + ", Left child(D): " + nodeD.data
                + ", Right child(E): " + nodeE.data);
        System.out.println("Node C: " + nodeC.data
                + ", Left child(F): " + nodeF.data);

    }

    public static Node invertTree(Node root) {

        if (root == null) {
            return null;
        }

        Node right = invertTree(root.right);
        Node left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;
    }
}
