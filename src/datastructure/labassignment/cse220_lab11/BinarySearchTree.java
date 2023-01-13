/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab11;

/**
 *
 * @author DIPTO
 */
public class BinarySearchTree {

    Node root;
    // write all the static methods here

    //task01
    public static int height(Node r) {
        if (r == null) {
            return -1;
        }
        return 1 + Math.max(height(r.left), height(r.right));
    }

    //task2
    public static int level(Node r) {
        if (r.parent == null) {
            return 0;
        }
        return 1 + level(r.parent);
    }

    //task3
    public static void preOrderPrint(Node r) {
        if (r == null) {
            return;
        }
        System.out.print(r.element + " ");
        preOrderPrint(r.left);
        preOrderPrint(r.right);
    }

    //task4
    public static void postOrderPrint(Node r) {
        if (r == null) {
            return;
        }
        postOrderPrint(r.left);
        postOrderPrint(r.right);
        System.out.print(r.element + " ");
    }

    //task5
    public static void inOrderPrint(Node r) {
        if (r == null) {
            return;
        }
        inOrderPrint(r.left);
        System.out.print(r.element + " ");
        inOrderPrint(r.right);
    }
    //task6

    public static boolean equal(Node r1, Node r2) {
        if (r1 == null || r2 == null) {
            if (r1 == null && r2 == null) {
                return true;
            } else {
                return false;
            }
        }
        return r1.element.equals(r2.element) && equal(r1.left, r2.left) && equal(r1.right, r2.right);
    }

    //task7
    //better if you go to allnotes and see that code
    public static Node copy(Node n) {
        if (n == null) {
            return null;
        }
        Node d = new Node(n.element, n.parent);
        d.left = copy(n.left);
        d.right = copy(n.right);
        return d;
    }
}
