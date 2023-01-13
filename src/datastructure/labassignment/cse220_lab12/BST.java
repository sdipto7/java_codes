/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab12;

/**
 *
 * @author DIPTO
 */
public class BST {

    Node root;

    Node findLeftMost(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return findLeftMost(n.left);
        }
    }

    Node findRightMost(Node n) {
        if (n.right == null) {
            return n;
        } else {
            return findRightMost(n.right);
        }
    }

    Node findSuccessor(Node root, Object key, Node s) {
        if (root == null) {
            return null;
        }
        if (key.equals(root.data)) {
            if (root.right != null) {
                return findLeftMost(root.right);
            }
        } else if (((Comparable) key).compareTo(root.data) < 0) {
            s = root;
            return findSuccessor(root.left, key, s);
        } else {
            return findSuccessor(root.right, key, s);
        }
        return s;
    }

    Node findPredecessor(Node root, Object key, Node p) {
        if (root == null) {
            return null;
        }
        if (key.equals(root.data)) {
            if (root.left != null) {
                return findRightMost(root.left);
            }
        } else if (((Comparable) key).compareTo(root.data) > 0) {
            p = root;
            return findPredecessor(root.right, key, p);
        } else {
            return findPredecessor(root.left, key, p);
        }
        return p;
    }

    Node findNode(Object key, Node n) {
        if (n == null) {
            return null;
        } else if (key.equals(n.data)) {
            return n;
        } else if (((Comparable) key).compareTo(n.data) > 0) {
            return findNode(key, n.right);
        } else {
            return findNode(key, n.left);
        }
    }

    void printAscending(Node n) {
        if (n == null) {
            return;
        }
        printAscending(n.left);
        System.out.print(n.data + " ");
        printAscending(n.right);
    }

    void printDescending(Node n) {
        if (n == null) {
            return;
        }
        printDescending(n.right);
        System.out.print(n.data + " ");
        printDescending(n.left);
    }

    Node insert(Node root, Object key) {
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
}

class Node {

    Object data;
    Node parent, left, right;

    Node(Object key) {
        this(key, null, null, null);
    }

    Node(Object key, Node parent, Node left, Node right) {
        data = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
