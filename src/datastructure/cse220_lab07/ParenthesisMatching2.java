/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab07;

/**
 *
 * @author 18101324
 */
import java.util.Scanner;

public class ParenthesisMatching2 {

    static boolean pairMatch(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '{' && close == '}') {
            return true;
        } else if (open == '[' && close == ']') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws StackUnderflowException, StackOverflowException {
        boolean check = false;
        int y = 0;
        Scanner input = new Scanner(System.in);
        char[] ch = input.nextLine().toCharArray();
        ListStack stack = new ListStack();
        ListStack eStack = new ListStack();
        for (int x = 0; x < ch.length; x++) {
            if (ch[x] == '(' || ch[x] == '{' || ch[x] == '[') {
                stack.push(ch[x]);
                eStack.push(x + 1);
            } else if ((ch[x] == ')' || ch[x] == '}' || ch[x] == ']') && (!stack.isEmpty())) {
                check = pairMatch((char) stack.peek(), ch[x]);
                if (check) {
                    stack.pop();
                    eStack.pop();
                } else {
                    y = 1;
                    System.out.println("This expression is not correct!");
                    System.out.println("error at #" + eStack.pop() + ". " + stack.pop() + " is not closed");
                    break;
                }
            } else if ((ch[x] == ')' || ch[x] == '}' || ch[x] == ']') && (stack.isEmpty())) {
                y = 1;
                System.out.println("This expression is not correct!");
                System.out.println("error at #" + (x + 1) + ". " + ch[x] + " is not opened");
                break;
            }

        }
        if (y == 0) {
            if (stack.isEmpty()) {
                System.out.println("This expression is correct!");
            } else {
                System.out.println("This expression is not correct!");
                System.out.println("error at #" + eStack.pop() + ". " + stack.pop() + " is not closed");
            }
        }
    }
}
