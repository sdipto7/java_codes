/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab12;

/**
 *
 * @author DIPTO
 */
public class Main {
    public static void main(String[] args){
        int a[] = {4,2,6,5,3,1,7};
        BST tree=new BST();
        for(int x:a){
            tree.root=tree.insert(tree.root,x);
        }
        tree.printAscending(tree.root);
        System.out.println();
        tree.printDescending(tree.root);
    }
}
