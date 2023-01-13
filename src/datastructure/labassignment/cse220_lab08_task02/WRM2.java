/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab08_task02;

/**
 *
 * @author 18101324
 */
//LINKED-LIST BASED QUEUE
public class WRM2 {

    Node head;
    Node tail;
    int size;
    static int id;

    WRM2() {
        id = 1;
        size = 0;
    }

    void registerPatient(Patient p) {
        if (head == null) {
            head = new Node(p, null);
            tail = head;
        } else {
            Node n = new Node(p, null);
            tail.next = n;
            tail = n;
        }
        size++;
        tail.p.id = id++;
        System.out.println("A patient has been registered!");
    }

    void servePatient() {
        if (size == 0) {
            System.out.println("There are no patients to serve");
        } else {
            Node q = head;
            head = head.next;
            q.p = null;
            q.next = null;
            size--;
            System.out.println("A patient is served!");
        }
    }

    void cancelAll() {
        if (size == 0) {
            System.out.println("There are no patients left to CANCEL!");
        } else {
            size = 0;
            id = 1;
            head = null;
            System.out.println("All appointments are cancelled");
        }
    }

    void canDoctorGoHome() {
        if (size == 0) {
            System.out.println("Yes! The doctor can go home now!");
        } else {
            System.out.println("No! Patients are waiting");
        }
    }

    void showAllPatient() {
        if (size == 0) {
            System.out.println("No Patients left!");
        } else {
            Node newHead = new Node(head.p, null);
            Node newTail = newHead;
            for (Node n = head.next; n != null; n = n.next) {
                Node newNode = new Node(n.p, null);
                newTail.next = newNode;
                newTail = newNode;
            }
            for(Node h=newHead;h.next!=null;h=h.next)
            {
                for(Node g=h.next;g!=null;g=g.next)
                {
                    if((h.p.name).compareToIgnoreCase(g.p.name)>0)
                    {
                        Patient icu=h.p;
                        h.p=g.p;
                        g.p=icu;
                    }
                }
            }
           for(Node x=newHead;x!=null;x=x.next)
           {
               System.out.println("Name: "+x.p.name+" Age: "+x.p.age+" BloodGroup: "+x.p.bloodGroup+" ID: "+x.p.id);
           }
        }
    }
}
