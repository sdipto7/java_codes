package datastructure.builtin;

import java.util.*;

public class ArrayListDT {
    public static void main(String[] args) {
        /*
        *Java ArrayList class can contain duplicate elements.
        *Java ArrayList class maintains insertion order.
        *Java ArrayList class is non synchronized.
        *Java ArrayList allows random access because array works at the index basis.
        *In ArrayList, manipulation is little bit slower than the LinkedList in Java,
        *because a lot of shifting needs to occur if any element is removed from the array list.*/

        ArrayList<String> avengersList = new ArrayList<>();
        avengersList.add("IronMan");
        avengersList.add("SpiderMan");
        avengersList.add("Thor");
        avengersList.add("CaptainAmerica");
        avengersList.add("Wanda");
        avengersList.add("Vision");

        System.out.println("The Avengers: " + avengersList);

        //check items in the list
        System.out.println("Is Wanda a member of avengersList ? " + avengersList.contains("Wanda"));
        System.out.println("Is Batman a member of avengersList ? " + avengersList.contains("Batman"));

        //Add items in a particular index
        avengersList.add(1, "Hulk");
        avengersList.add(6, "CaptainMarvel");
        System.out.println("The Avengers: " + avengersList);

        //set(index, newValue) -> replaces the previous value of the given index with given newValue
        avengersList.set(7, "DrStrange");
        System.out.println("The Avengers: " + avengersList);

        //indexOf(value) -> returns the index number of an element.
        System.out.println("The position of SpiderMan is: " + avengersList.indexOf("SpiderMan"));

        //get(index) -> returns the value of the given index
        System.out.println("The position 3 avenger is: " + avengersList.get(3));

        //size() -> returns the size of the arraylist
        System.out.println("The number of avengers is: " + avengersList.size());

        //ArrayList to array convert
        Object[] array = avengersList.toArray();
        System.out.print("Converted array from ArrayList:");
        for (Object hero:array) {
            System.out.print(" " + hero);
        }
        System.out.println();

        //remove(index) or remove(value) -> removes particular item with value or index number
        avengersList.remove(1); //index-1 is Hulk
        avengersList.remove("CaptainMarvel");
        System.out.println("The Avengers: " + avengersList);

        //Iterating over the arrayList using Iterator
        Iterator<String> iterator = avengersList.iterator();
        System.out.print("Iterating the ArrayList with Iterator:");
        while (iterator.hasNext()){
            System.out.print(" " + iterator.next());
        }
        System.out.println();

        /*Three ways to copy/clone a whole ArrayList into another ArrayList*/
        ArrayList<String> copiedAvengersList1 = new ArrayList<>(avengersList); // Using Constructor

        ArrayList<String> copiedAvengersList2 = new ArrayList<>();
        copiedAvengersList2.addAll(avengersList); // Using addAll() method

        ArrayList<String> clonedAvengersList = (ArrayList<String>) avengersList.clone(); //Using clone() Method, ordering may not be same

        System.out.println("Copied AvengersList1 : " + copiedAvengersList1);
        System.out.println("Copied AvengersList2 : " + copiedAvengersList2);
        System.out.println("Cloned AvengersList : " + clonedAvengersList);

        //Checking if two ArrayLists are equal or not [Sequence Must Match otherwise returns false]
        System.out.println("avengersList and copiedAvengersList1 are equal ?: "  + avengersList.equals(copiedAvengersList1));
        System.out.println("avengersList and copiedAvengersList2 are equal ?: "  + avengersList.equals(copiedAvengersList2));
        System.out.println("avengersList and clonedAvengersList are equal ?: "  + avengersList.equals(clonedAvengersList));

        /*Sorting the copiedAvengersList using the Collections.sort(list) method
        * Change the sequence of copiedAvengersList1 to check again if equal or not after change of sequence*/
        Collections.sort(copiedAvengersList1);
        System.out.println("The Avengers: " + avengersList);
        System.out.println("The sorted avengersList1: " + copiedAvengersList1);
        System.out.println("avengersList and sorted copiedAvengersList1 are equal ?: "  + avengersList.equals(copiedAvengersList1));

        //Sorting of List using Collections.sort(List) method
        Collections.sort(avengersList);
        System.out.println("The Avengers list sorted in ascending order: " + avengersList);
        Collections.sort(avengersList,Collections.reverseOrder());
        System.out.println("The Avengers list sorted in descending order: " + avengersList);


        String[] justiceLeagueArray = new String[]{"Batman", "Aquaman", "Superman", "Flash", "WonderWoman",
        "GreenLantern", "Cyborg", "GreenArrow", "Shazam"};

        //Convert Array into a List
        List<String> justiceLeagueList = Arrays.asList(justiceLeagueArray);
        System.out.println("Justice League: " + justiceLeagueList);

    }
}
