package datastructure.builtin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetDT {
    public static void main(String[] args) {

        /*
        *HashSet stores the elements by using a mechanism called hashing.
        *HashSet contains unique elements only.
        *HashSet allows null value.
        *HashSet class is non synchronized.
        *HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
        *HashSet is the best approach for search operations.
        *The initial default capacity of HashSet is 16, and the load factor is 0.75.*/

        /*HashSet object without generic type can store values of different data type
         * in a single set but not recommended to use*/
        HashSet hSet = new HashSet(); //basically: HashSet<Object> hSet = new HashSet<>();
        hSet.add("Dipto");
        hSet.add(2);
        hSet.add(22.77);
        hSet.add(false);
        System.out.println("Without generic type HashSet: " + hSet);

        //add(value) -> adds values to the Set
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(7);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(9);
        hashSet.add(1);
        //the value 2 is in the set thrice, Only one will be added as in hashSet values must be unique
        //Prints the whole set
        System.out.println("Hashset: " + hashSet);

        //size() -> returns the number of elements in the HashSet
        System.out.println("Total number of values is the HashSet: " + hashSet.size());

        //isEmpty() -> returns true if the hashSet is empty else return false
        System.out.println("Is the HashSet empty ? " + hashSet.isEmpty());

        //contains(value) -> check if the passed parameter value is in the hashSet or not
        System.out.println("Does the values 5 exist in the HashSet ? " + hashSet.contains(5));

        //remove(value) -> remove the value if it exists
        hashSet.remove(5);
        hashSet.remove(3);
        System.out.println("HashSet after removing value: " + hashSet);

        /*Three ways to copy/clone a whole HashSet into another Hashset*/
        HashSet<Integer> copiedHashSet1 = new HashSet<>(hashSet); // Using Constructor

        HashSet<Integer> copiedHashSet2 = new HashSet<>();
        copiedHashSet2.addAll(hashSet); // Using addAll() method

        HashSet<Integer> clonedHashSet = (HashSet<Integer>) hashSet.clone(); //Using clone() Method, ordering may not be same

        System.out.println("Copied HashSet1 : " + copiedHashSet1);
        System.out.println("Copied HashSet2 : " + copiedHashSet2);
        System.out.println("Cloned HashSet : " + clonedHashSet);

        //Checking if two HashSets are equal or not
        System.out.println("hashSet and copiedHashSet1 are equal ?: "  + hashSet.equals(copiedHashSet1));
        System.out.println("hashSet and copiedHashSet2 are equal ?: "  + hashSet.equals(copiedHashSet2));
        System.out.println("hashSet and clonedHashSet are equal ?: "  + hashSet.equals(clonedHashSet));

        //Iterating over the HashSet values with Iterator
        Iterator<Integer> iterator = hashSet.iterator();
        System.out.print("Iterating the HashSet with Iterator:");
        while (iterator.hasNext()){
            System.out.print(" " + iterator.next());
        }
        System.out.println();

        //Converting HashSet into an Array using toArray() method
        Object[] array = hashSet.toArray();
        System.out.print("Converted Array from the HashSet: " );
        for (Object item: array) {
            System.out.print(item + " ");
        }
        System.out.println();

        HashSet<String> friendsHashSet = new HashSet<>();
        friendsHashSet.add("Joey");
        friendsHashSet.add("Chandler");
        friendsHashSet.add("Ross");
        friendsHashSet.add("Monica");
        friendsHashSet.add("Pheobe");
        friendsHashSet.add("Rachel");
        friendsHashSet.add("Mike");
        friendsHashSet.add("Richard");
        friendsHashSet.add("Gunther");
        System.out.println("Unsorted Set: " + friendsHashSet);
        
        TreeSet<String> friendsTreeSet = new TreeSet<>(friendsHashSet);
        System.out.println("Sorted Set: " + friendsTreeSet);

        /*checking if the TreeSet and HashSet are equal or not,
        *they are different in terms sorting but the equal() method checks
        *if both the Set contains same values or not*/
        System.out.println("friendsHashSet(Unsorted) and friendsTreeSet(Sorted) are equal ? : " + friendsHashSet.equals(friendsTreeSet));

    }
}
