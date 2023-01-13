/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab08_task01;

/**
 *
 * @author 18101324
 */
//ARRAY-Based QUEUE
public class WRM1 {

    Patient[] a;
    int index;
    int size;
    int st;
    static int id;

    WRM1() {
        id = 1;
        st = 0;
        size = 0;
        index = st;
        a = new Patient[10];
    }

    void registerPatient(Patient p) {
        if (size == a.length) {
            Patient[] b = new Patient[a.length * 2];
            int x=st;
            int y=st;
            for (int i = 0; i < size; i++) {
                b[y] = a[x];
                x=(x+1)%a.length;
                y=(y+1)%b.length;
            }
            a = b;
        }
        a[index] = p;
        p.id = id++;
        size++;
        index = (index + 1) % a.length;
        System.out.println("A patient has been registered!");
    }

    void servePatient() {
        if (size == 0) {
            System.out.println("There are no more patients to serve!");
        } else {
            a[st] = null;
            st = (st + 1) % a.length;
            size--;
            System.out.println("A patient is served!");
        }
    }

    void cancelAll() {
        if (size == 0) {
            System.out.println("There are no patients to cancel!");
        } else {
            for (int i = 0; i < a.length; i++) {
                a[i] = null;
            }
            size = 0;
            index = st;
            id = 1;
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
            System.out.println("No patients left!");
        } else {
            Patient[] sorted = new Patient[a.length];
            int k=st;
            for (int i = 0; i < size; i++) {
                sorted[k] = a[k];
                k=(k+1)%sorted.length;
            }
            int index = st;
            for (int i = 0; i < size - 1; i++) {
                int nextIndex = (index + 1) % sorted.length;
                for (int j = (i + 1); j < size; j++) {
                    if ((sorted[index].name).compareToIgnoreCase(sorted[nextIndex].name) > 0) {
                        Patient icu = sorted[index];
                        sorted[index] = sorted[nextIndex];
                        sorted[nextIndex] = icu;
                    }
                    nextIndex = (nextIndex + 1) % sorted.length;
                }
                index = (index + 1) % sorted.length;
            }
            int i = st;
            for (int x = 0; x < size; x++) {
                System.out.println("Name: " + sorted[i].name + " Blood Group: " + sorted[i].bloodGroup + " Age: " + sorted[i].age + " ID: " + sorted[i].id);
                i = (i + 1) % sorted.length;
            }
        }
    }

}
