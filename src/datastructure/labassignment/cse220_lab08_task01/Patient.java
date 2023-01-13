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
