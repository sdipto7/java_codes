/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_practice;

/**
 *
 * @author SDIPTO7
 */
public class Tester {
    public static void main(String[] args)
    {
        Student s1=new Student("DIPTO","12",3.3);
        Student s2=new Student("PRIATA","11",3.56);
        Student s3=new Student("FAHIM","15",3.29);
        Student s4=new Student("GALIB","14",3.4);
        Student s5=new Student("AHNAF","19",3.56);
        Student[] array1={s1,s2,s3,s4,s5};
        Student s6=new Student("A","1",2.3);
        Student s7=new Student("B","2",2.5);
        Student s8=new Student("C","3",2.69);
        Student[] array2={s6,s7,s8};
        LinkedList list1=new LinkedList(array1);
        LinkedList list2=new LinkedList(array2);
//        list1.print();
//        list1.sort();
//        list1.print();
        LinkedList merge1=new LinkedList(array1,array2);
        LinkedList merge2=new LinkedList(array2,array1);
//        merge1.print();
//        merge2.print();
        merge1.sort();
       merge1.print();
    }
}
