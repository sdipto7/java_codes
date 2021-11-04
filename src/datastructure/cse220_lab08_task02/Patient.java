/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructure.cse220_lab08_task02;

/**
 *
 * @author 18101324
 */
public class Patient {
   String name, bloodGroup;
    int age;
    int id;

    Patient(String name, int age, String bloodGroup) {
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
    }
}
