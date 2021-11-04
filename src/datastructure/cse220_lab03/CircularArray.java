/*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
 */
package datastructure.cse220_lab03;

/**
 *
 * @author SDIPTO7
 */
public class CircularArray {

    private int start;
    private int size;
    private Object[] cir;

    /*
    * if Object [] lin = {10, 20, 30, 40, null}
    * then, CircularArray(lin, 2, 4) will generate
    * Object [] cir = {40, null, 10, 20, 30}
     */
    public CircularArray(Object[] lin, int st, int sz) {
        cir = new Object[lin.length];
        start = st;
        size = sz;
        for (int i = 0; i < size; i++) {
            cir[st] = lin[i];
            st = (st + 1) % cir.length;
        }
    }

    //Prints from index --> 0 to cir.length-1
    public void printFullLinear() {
        for (int i = 0; i < cir.length; i++) {
            System.out.print(cir[i] + " ");
        }
        System.out.println();
    }

    // Starts Printing from index start. Prints a total of size elements
    public void printForward() {
        int st = start;
        for (int i = 0; i < size; i++) {
            System.out.print(cir[st] + " ");
            st = (st + 1) % cir.length;
        }
        System.out.println();
    }

    public void printBackward() {
        int lastPos = (start + size - 1) % cir.length;
        for (int i = 0; i < size; i++) {
            System.out.print(cir[lastPos] + " ");
            lastPos--;
            if (lastPos == -1) {
                lastPos = cir.length - 1;
            }
        }
        System.out.println();
    }

    // With no null cells
    public void linearize() {
        int st = start;
        Object[] linearized = new Object[size];
        for (int i = 0; i < linearized.length; i++) {
            linearized[i] = cir[st];
            st = (st + 1) % cir.length;
        }
        cir = linearized;
    }

    // Do not change the Start index
    public void resizeStartUnchanged(int newcapacity) {
        Object[] a = new Object[newcapacity];
        int st = start;
        int k = start;
        for (int i = 0; i < size; i++) {
            a[k] = cir[st];
            k = (k + 1) % a.length;
            st = (st + 1) % cir.length;
        }
        cir = a;
    }

    // Start index becomes zero
    public void resizeByLinearize(int newcapacity) {
        int st = start;
        Object[] a = new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            a[i] = cir[st];
            st = (st + 1) % cir.length;
        }
        cir = a;
    }

    /* pos --> position relative to start. Valid range of pos--> 0 to size.
    * Increase array length by 3 if size==cir.length
    * use resizeStartUnchanged() for resizing.
     */
    public void insertByRightShift(Object elem, int pos) {
        if (size == cir.length) {
            resizeStartUnchanged(cir.length + 3);
        }
        int nShift = (size - pos);
        int index = (start + pos) % cir.length;
        int from = (start + size - 1) % cir.length;
        int to = (from + 1) % cir.length;
        for (int i = 0; i < nShift; i++) {
            cir[to] = cir[from];
            to = from;
            from--;
            if (from < 0) {
                from = cir.length - 1;
            }
        }
        cir[index] = elem;
        size++;
    }

    public void insertByLeftShift(Object elem, int pos) {
        if (size == cir.length) {
            resizeStartUnchanged(cir.length + 3);
        }
        int nShift = (pos + 1);
        int index = (start + pos) % cir.length;
        int from = start;
        int to = from - 1;
        if (to == -1) {
            to = cir.length - 1;
        }
        for (int i = 0; i < nShift; i++) {
            cir[to] = cir[from];
            to = from;
            from = (from + 1) % cir.length;
            if (to == -1) {
                to = cir.length - 1;
            }
        }
        cir[index] = elem;
        size++;
        start--;
        if (start == -1) {
            start = cir.length - 1;
        }
    }

    /* parameter--> pos. pos --> position relative to start.
    * Valid range of pos--> 0 to size-1
     */
    public void removeByLeftShift(int pos) {
        int nShift = (size - pos - 1);
        int index = (start + pos) % cir.length;
        int to = index;
        int from = (to + 1) % cir.length;
        for (int i = 0; i < nShift; i++) {
            cir[to] = cir[from];
            to = from;
            from = (to + 1) % cir.length;
        }
        int lastPos = (start + size - 1) % cir.length;
        cir[lastPos] = null;
        size--;
    }

    /* parameter--> pos. pos --> position relative to start.
    * Valid range of pos--> 0 to size-1
     */
    public void removeByRightShift(int pos) {
        int nShift = pos;
        int index = (start + pos) % cir.length;
        int to = index;
        int from = (to - 1);
        if (from == -1) {
            from = cir.length - 1;
        }
        for (int i = 0; i < nShift; i++) {
            cir[to] = cir[from];
            to = from;
            from = (to - 1);
            if (from == -1) {
                from = cir.length;
            }
        }
        cir[start] = null;
        start = (start + 1) % cir.length;
        size--;
    }

    //This method will check whether the array is palindrome or not
    public void palindromeCheck() {
        int st = start;
        int lastPos = (start + size - 1) % cir.length;
        boolean check = false;
        for (int i = 0; i < size / 2; i++) {
            if (cir[st] == cir[lastPos]) {
                st = (st + 1) % cir.length;
                lastPos--;
                check = true;
                if (lastPos == -1) {
                    lastPos = cir.length - 1;
                }
            } else {
                check = false;
                break;
            }
            if (check == true) {
                System.out.println("This array is a Palindrome");
            } else {
                System.out.println("This array is NOT a Palindrome");
            }
        }
    }

    //This method will sort the values by keeping the start unchanged
    public void sort() {
        int index = start;
        for (int i = 0; i < size; i++) {
            int nextIndex = (index + 1) % cir.length;
            for (int j = i + 1; j < size; j++) {
                if ((int) cir[nextIndex] < (int) cir[index]) {
                    Object icu = cir[index];
                    cir[index] = cir[nextIndex];
                    cir[nextIndex] = icu;
                }
                nextIndex = (nextIndex + 1) % cir.length;
            }
            index = (index + 1) % cir.length;
        }
    }

    //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
    public boolean equivalent(CircularArray k) {
        int st1 = start;
        int st2 = k.start;
        boolean check = false;
        if (size == k.size) {
            for (int i = 0; i < size; i++) {
                if ((int) cir[st1] == (int) k.cir[st2]) {
                    st1 = (st1 + 1) % cir.length;
                    st2 = (st2 + 1) % k.cir.length;
                    check = true;
                } else {
                    return false;
                }
            }
        }
        return check;
    }
}
