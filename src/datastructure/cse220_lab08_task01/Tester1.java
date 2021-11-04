/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab08_task01;

/**
 *
 * @author 18101324
 */
public class Tester1 {

    public static void main(String[] args) {
        WRM1 q = new WRM1();
        Patient p1 = new Patient("DIPTO", 22, "AB+");
        Patient p2 = new Patient("GALIB", 52, "A+");
        Patient p3 = new Patient("FAHIM", 62, "O+");
        q.registerPatient(p1);
        q.registerPatient(p2);
        q.registerPatient(p3);
        q.showAllPatient();
        q.servePatient();
        q.canDoctorGoHome();
        q.servePatient();
        q.showAllPatient();
        q.cancelAll();
        q.canDoctorGoHome();
    }
}
