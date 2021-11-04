/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_finalPrep;

/**
 *
 * @author DIPTO
 */
public class BST {

    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else {
            if (((Comparable) key).compareTo(root.data) > 0) {
                root.right = insert(root.right, key);
                root.right.parent = root;
            } else {
                root.left = insert(root.left, key);
                root.left.parent = root;
            }
            return root;
        }
    }

    Node findSuccessor(Node root, int key, Node p) {
        if (root == null) {
            return null;
        }
        if (((Comparable) key).equals(root.data)) {
            if (root.right != null) {
                return findLeftMost(root.right);
            }
        } else if (((Comparable) key).compareTo(root.data) > 0) {
            return findSuccessor(root.right, key, p);
        } else {
            p = root;
            return findSuccessor(root.left, key, p);
        }
        return p;
    }

    Node findLeftMost(Node root) {
        if (root.left == null) {
            return root;
        } else {
           return findLeftMost(root.left);
        }
    }
}

class Node {

    int data;
    Node left, right, parent;

    Node(int x) {
        this(x, null, null, null);
    }

    Node(int x, Node l, Node r, Node p) {
        data = x;
        left = l;
        right = r;
        parent = p;
    }
}
