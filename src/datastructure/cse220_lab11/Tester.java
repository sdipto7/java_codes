/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab11;

/**
 *
 * @author DIPTO
 */
public class Tester {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        //we now manually build the first tree
        tree.root = new Node(10, null);
        tree.root.left = new Node(5, tree.root);
        tree.root.right = new Node(15, tree.root);
        tree.root.right.left = new Node(14, tree.root.right);
        tree.root.right.left.left = new Node(12, tree.root.right.left);
        tree.root.right.left.left.right = new Node(13, tree.root.right.left.left);

        tree.root.right.right = new Node(20, tree.root.right);
        tree.root.right.right.right = new Node(30, tree.root.right.right);
        tree.root.right.right.right.right = new Node(40, tree.root.right.right.right);
        tree.root.right.right.right.right.right = new Node(50, tree.root.right.right.right.right);

        tree.root.left.left = new Node(3, tree.root.left);
        tree.root.left.left.left = new Node(2, tree.root.left.left);
        tree.root.left.right = new Node(6, tree.root.left);
        tree.root.left.right.right = new Node(7, tree.root.left.right);

        //we now manually build the second tree
        tree2.root = new Node(10, null);
        tree2.root.left = new Node(5, tree.root);
        tree2.root.right = new Node(15, tree.root);
        tree2.root.right.left = new Node(14, tree.root.right);
        tree2.root.right.left.left = new Node(12, tree.root.right.left);
        tree2.root.right.left.left.right = new Node(13, tree.root.right.left.left);

        tree2.root.right.right = new Node(20, tree.root.right);
        tree2.root.right.right.right = new Node(30, tree.root.right.right);
        tree2.root.right.right.right.right = new Node(40, tree.root.right.right.right);
        tree2.root.right.right.right.right.right = new Node(50, tree.root.right.right.right.right);

        tree2.root.left.left = new Node(3, tree.root.left);
        tree2.root.left.left.left = new Node(2, tree.root.left.left);
        tree2.root.left.right = new Node(6, tree.root.left);
        tree2.root.left.right.right = new Node(7, tree.root.left.right);

        // form here we do test all the methods
        //task1
        System.out.println("Task 1-----------------------------------------");
        int h = tree.height(tree.root);
        System.out.println("height of the tree is " + h);

        //task2
        System.out.println("Task 2-----------------------------------------");
        int l = tree.level(tree.root.right.right.right.right);// level of 40
        System.out.println("level of the node is " + l);

        //task3
        System.out.println("Task 3-----------------------------------------");
        System.out.println("preOrder");
        tree.preOrderPrint(tree.root);
        System.out.println();

        //task4
        System.out.println("Task 4-----------------------------------------");
        System.out.println("postOrder");
        tree.postOrderPrint(tree.root);
        System.out.println();

        //task5
        System.out.println("Task 5-----------------------------------------");
        System.out.println("InOrder");
        tree.inOrderPrint(tree.root);
        System.out.println();

        //task6
        System.out.println("Task 6-----------------------------------------");
        System.out.println("checks whether two trees are identical");
        System.out.println(tree.equal(tree.root, tree2.root));

        //task7
        System.out.println("Task 7-----------------------------------------");
        Node copyRoot = tree.copy(tree.root);
        System.out.println("checks whether two trees are identical");
        System.out.println(tree.equal(tree.root, copyRoot));

        /*               10
         *            /      \
         *         5           15
         *       3   6  |    14   20
         *     2      7    12       30
         *               13           40
         */              //             50
    }
}
