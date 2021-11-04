package datastructure.builtin;

import java.util.*;

public class StackQueueDT {
    public static void main(String[] args) {

        //STACK ==>
        System.out.println("Stack implementation with Stack class\n");

        Stack<String> stack = new Stack<>();

        /*add(),remove() are inherited from the vector class which the Stack extends.
        * But it is recommended to use push(), pop() methods for better readability.
        * But, using any of the add() or push(), remove() or pop() will not be a problem*/
        /*
        stack.add("TonyStark");
        stack.add("PeterParker");
        stack.add("ClarkKent");
        stack.add("BruceWayne");
        */

        stack.push("TonyStark");
        stack.push("BruceWayne");
        stack.push("PeterParker");
        stack.push("OliverQueen");
        stack.push("BarryAllen");
        stack.push("ClarkKent");
        stack.push("WandaMaximoff");

        System.out.println("Stack: " + stack);
        System.out.println(stack.pop() + " is popped/removed from the stack");
        System.out.println(stack.pop() + " is popped/removed from the stack");
        System.out.println(stack.pop() + " is popped/removed from the stack");
        System.out.println(stack.peek() + " is the top element of the stack");
        System.out.println("Stack: " + stack);
        System.out.println("The Stack is empty ? : " + stack.isEmpty());
        //Sorting the stack
        Collections.sort(stack);
        System.out.println("Stack: " + stack);


        //QUEUE ==>
        System.out.println("\nQueue implementation with Queue interface\n");

        /*Queue is an interface. if we create object of ArrayDeque() or LinkedList() of type Queue
        * then it can be used only as a queue data structure(FIFO)*/
        /*Both ArrayDeque and LinkedList can be used as Queue and works same. Just the structure of the queue is different
        * ArrayDeque uses a dynamic array at the backend and LinkedList uses Node and links at the backend*/
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.add(100);
        q1.add(200);
        q1.add(300);
        q1.add(400);
        System.out.println("Queue1: " + q1);
        System.out.println("First element of Queue1: " + q1.peek());
        System.out.println(q1.poll() + " is popped from Queue1");
        System.out.println("Queue1: " + q1);

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(100);
        q2.add(200);
        q2.add(300);
        q2.add(400);
        System.out.println("Queue2: " + q2);
        System.out.println("First element of Queue2: " + q2.peek());
        System.out.println(q2.poll() + " is popped from Queue2");
        System.out.println("Queue2: " + q2);


        //DEQUE ==> both STACK and QUEUE
        /*Deque is also an interface. if we create object of ArrayDeque() or LinkedList() of type Deque
        * then it can be used as both queue data structure(FIFO) and stack data structure(LIFO).
        * Deque is the acronym for double ended queue.
        * Both ArrayDeque and LinkedList can be used as deque and works same. Just the structure of the queue is different
        * ArrayDeque uses a dynamic array at the backend and LinkedList uses Node and links at the backend*/

        System.out.println("\nStack with Deque interface\n");

        Deque<Integer> dequeStack = new LinkedList<>();
        //When we start using push(), pop() method from the object, the object acts as a stack
        dequeStack.push(100);
        dequeStack.push(200);
        dequeStack.push(300);
        dequeStack.push(400);
        System.out.println("Stack: " + dequeStack);
        System.out.println(dequeStack.peek() + " is the top of the stack");
        System.out.println(dequeStack.pop() + " is popped from the stack");
        System.out.println(dequeStack.peek() + " is the top of the stack");
        System.out.println(dequeStack.pop() + " is popped from the stack");
        System.out.println("Stack: " + dequeStack);

        System.out.println("\nQueue with Deque interface\n");

        Deque<Integer> dequeQueue = new LinkedList<>();
        //When we start using add(), poll() method from the object, the object acts as an queue
        dequeQueue.add(700);
        dequeQueue.add(800);
        dequeQueue.add(900);
        dequeQueue.add(1000);
        System.out.println("Queue: " + dequeQueue);
        System.out.println(dequeQueue.peek() + " is the first element of the queue");
        System.out.println(dequeQueue.poll() + " is removed from the queue");
        System.out.println(dequeQueue.peek() + " is the first element of the queue");
        System.out.println(dequeQueue.poll() + " is removed from the queue");
        System.out.println("Queue: " + dequeQueue);

    }
}
