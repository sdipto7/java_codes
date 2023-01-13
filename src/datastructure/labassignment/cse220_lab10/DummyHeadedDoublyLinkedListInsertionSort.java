package datastructure.labassignment.cse220_lab10;

/**
 *
 * @author SDIPTO7
 */
class Main {

    public static void main(String[] args) {
        int[] a = {2, 4, 7, -4, -22, -5, 1, 3, 6};
        Node head = todoublyList(a);
        print(head);
        insertionSort(head);
        print(head);
    }

    static void insertionSort(Node head) {
        for (Node n = head.next.next; n != null; n = n.next) {
            int key = n.data;
            Node j = n.prev;
            while (j != head && key < j.data) {
                j.next.data = j.data;
                j = j.prev;
            }
            j.next.data = key;
        }
//        for (Node m = head; m != null; m = m.next) {
//            int key = m.data;
//            Node j = m.prev;
//            while (j != null && key < j.data) {
//                j.next.data = j.data;
//                if (j.prev != null) {
//                    j = j.prev;
//                } else {
//                    break;
//                }
//            }
//            j.data = key;
//        }
    }

    static Node todoublyList(int[] a) {
        Node head = new Node(0, null, null);
        Node tail = head;

        for (int i = 0; i < a.length; i++) {
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev = tail;
            tail = tail.next;
        }
        return head;
    }

    static void print(Node head) {
        for (Node n = head.next; n != null; n = n.next) {
            System.out.print(n.data + " ");
        }
        System.out.println();
    }
}