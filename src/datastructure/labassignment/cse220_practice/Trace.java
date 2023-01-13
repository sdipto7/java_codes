/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_practice;

/**
 *
 * @author DIPTO
 */
public class Trace {

    public static void main(String[] args) {
        System.out.println("Finally " + hMB(5));
    }

    static int hMB(int h) {
        switch (h) {
            case 0:
                System.out.println("Stop: " + h);
                return 0;
            case 1:
                System.out.println("Stop: " + h);
                return h;
            default:
                System.out.println("Continue: " + h);
                return h + hMB(h - 1);
        }
    }
}
