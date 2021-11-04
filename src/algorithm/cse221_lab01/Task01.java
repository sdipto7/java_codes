/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.cse221_lab01;

/**
 *
 * @author DIPTO
 */
import java.util.*;

public class Task01 {

    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) throws EmptyStackException {
        Scanner input = new Scanner(System.in);
        System.out.println("To push press 1 and to pop press 2");
        while (input.hasNextInt()) {
            int x = input.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter a number");
                    int a = input.nextInt();
                    System.out.println("Pushing " + a + "...");
                    stack.push(a);
                    print();
                    break;
                case 2:
                    try {
                        System.out.println("Popping...");
                        stack.pop();
                        print();
                        break;
                    } catch (EmptyStackException e) {
                        System.out.println("The Stack is empty: " + e);
                    }

                default:
                    System.out.println("Wrong Command");        
            }
            System.out.println("To push press 1 and to pop press 2");
        }
    }

    static void print() throws EmptyStackException {
        if (!stack.isEmpty()) {
            System.out.println("Printing Top:\n" + stack.peek());
        } else {
            throw new EmptyStackException();
        }
    }
}
