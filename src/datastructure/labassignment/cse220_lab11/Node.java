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
public class Node {

    public Object element;
    public Node parent;
    public Node left, right;

    public Node(Object e) {
        this(e, null);
    }

    public Node(Object e, Node p) {
        element = e;
        parent = p;
        left = right = null;
    }
}
