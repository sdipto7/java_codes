/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_practice;

/**
 *
 * @author SDIPTO7
 */
public class Node {
    public Student student;
    public Node next;
    Node(Student s,Node n)
    {
        student=s;
        next=n;
    }
}
