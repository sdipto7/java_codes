package datastructure.cse220_lab10;

/**
 *
 * @author SDIPTO7
 */
public class Node {

    int data;
    Node prev;
    Node next;

    Node(int data,Node prev,Node next) {
        this.data = data;
        this.prev=prev;
        this.next = next;
    }
}
