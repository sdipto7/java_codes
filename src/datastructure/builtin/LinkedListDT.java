package datastructure.builtin;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDT {
    public static void main(String[] args) {
        /*
         *Java LinkedList class can contain duplicate elements.
         *Java LinkedList class maintains insertion order.
         *Java LinkedList class is non synchronized.
         *In Java LinkedList class, manipulation is fast because no shifting needs to occur.
         *Java LinkedList class can be used as a list, stack or queue.*/

        /*Most of the working functionality and methods of LinkedList are same as ArrayList
        *Also, there are some methods of LinkedList class which are used to
        *work like Stack and Queue. I will try those methods in StackQueueDT class.
        * So, not trying all the methods here*/
        LinkedList<String> friendsList = new LinkedList<>();
        friendsList.add("Joey");
        friendsList.add("Chandler");
        friendsList.add("Ross");
        friendsList.add("Monica");
        friendsList.add("Pheobe");
        friendsList.add("Rachel");

        System.out.println("Friends: " + friendsList);
        //check items in the list
        System.out.println("Is Gunther a member of friendsList ? " + friendsList.contains("Wanda"));

        //Add item in the last node/index
        friendsList.add("Mike");
        //Add at first Index/node
        friendsList.addFirst("Dipto");
        System.out.println("Friends: " + friendsList);

        //Remove a node with a particular value
        friendsList.remove("Dipto");
        friendsList.remove("Mike");
        System.out.println("Friends: " + friendsList);

        //Add item in a desired index
        friendsList.add(5, "Mike");
        System.out.println("Friends: " + friendsList);

        System.out.println("First element of the friendsList: " + friendsList.getFirst());
        System.out.println("Last element of the friendsList: " + friendsList.getLast());

        //Sorting the friendsList in ascending order
        Collections.sort(friendsList);

        Iterator<String> iterator1 = friendsList.iterator();
        Iterator<String> iterator2 = friendsList.descendingIterator();
        Iterator<String> iterator3 = friendsList.listIterator();

        System.out.print("Iterating the LinkedList with iterator():");
        while(iterator1.hasNext()){
            System.out.print(" " + iterator1.next());
        }

        System.out.print("\nIterating the ArrayList with descendingIterator():");
        while (iterator2.hasNext()){
            System.out.print(" " + iterator2.next());
        }

        System.out.print("\nIterating the ArrayList with listIterator():");
        while (iterator3.hasNext()){
            System.out.print(" " + iterator3.next());
        }
    }
}
