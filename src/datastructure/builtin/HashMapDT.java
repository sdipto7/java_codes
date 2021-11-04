package datastructure.builtin;

import java.util.*;

public class HashMapDT {
    public static void main(String[] args) {

        /*Java HashMap contains values based on the key.
        *Java HashMap contains only unique keys.
        *Java HashMap may have one null key and multiple null values.
        *Java HashMap is non synchronized.
        *Java HashMap maintains no order.
        *The initial default capacity of Java HashMap class is 16 with a load factor of 0.75. */

        /*HashMap object without generic type can store keys and values of different data type
        * in a single Map but not recommended to use*/
        HashMap hmap = new HashMap(); //basically: HashMap<Object,Object> hMap = new HashMap<>();
        hmap.put("Dipto",22);
        hmap.put("Priata","Oshru");
        hmap.put(10,"Oshru");
        hmap.put(10.98,11);
        hmap.put("Dipto",7);
        //the key "Dipto" is in the map twice, so it will replace the first one. both will not be added.
        //the keys must be unique in HashMap
        System.out.println("Without generic type HashMap: " + hmap);

        //First parameter is the key which should be unique
        //Second parameter is the value values can be similar
        //put(key, value) -> adds keys and values to the Map
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Dipto", 1);
        hashMap.put("Oshru", 2);
        hashMap.put("Fahim", 3);
        hashMap.put("Galib", 4);
        hashMap.put("John", 5);
        hashMap.put("Alex", 6);
        hashMap.put("Peter", 7);
        hashMap.put("Tony", 7);

        //printing the object hashMap prints the whole map with keys and values
        System.out.println("HashMap: " + hashMap);

        //values() -> returns all the values
        System.out.println("HashMap values: " + hashMap.values());

        //keySet() -> returns all the Keys
        System.out.println("HashMap keys: " + hashMap.keySet());

        //get(key) -> returns the value of a particular key, returns null if the key does not exist
        System.out.println("Value of Tony: " + hashMap.get("Tony"));

        //isEmpty() -> returns true if the hashmap is empty else return false
        System.out.println("Is the HashMap empty ? " + hashMap.isEmpty());

        //clone() -> creates an exact copy of the existing HashMap
        HashMap<String, Integer> clonedHashMap = (HashMap<String, Integer>) hashMap.clone();

        System.out.println("Cloned HashMap: " + clonedHashMap);

        //containsKey(key) -> check if the passed parameter key is in the hashmap or not
        System.out.println("Does the key 'Dipto' exists ? " + hashMap.containsKey("Dipto"));

        //containsValue(value) -> check if the passed parameter value is in the hashmap or not
        System.out.println("Does the values 7 exists ? " + hashMap.containsValue(7));

        //replace(key, newValue) -> replace the previous value of a key with a new value only if the key exists
        hashMap.replace("Dipto", 22);

        //replace(key, oldVal, newVal) -> replace the previous value of a key with a new value only if the key exists
        //and matches with the oldValue provided through the parameter.
        hashMap.replace("Oshru", 2, 10);

        System.out.println("HashMap after replacing values: " + hashMap);

        //remove(key) -> remove the key and value if the key exists
        hashMap.remove("Tony");

        //remove(key, value) -> remove the key and value if the key exists and value matches which was
        //provided through the parameter
        hashMap.remove("Alex", 6);

        System.out.println("HashMap after removing Entries: " + hashMap);

        //size() -> returns the number of entries in the hashmap
        System.out.println("The total number of entries in the HashMap: " + hashMap.size());

        //Iterating over the HashMap
        for(Map.Entry m: hashMap.entrySet()){
            System.out.println(m.getKey() + " --> " + m.getValue());
        }

        //Iterating over the HashMap keys with Iterator
        Iterator<String> iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //putAll(HashMap) -> to add all the entries from one hashmap to another
        HashMap<String, Integer> copyHashMap = new HashMap<>();
        copyHashMap.putAll(hashMap);
        System.out.println("Copied HashMap: " + copyHashMap);

        /*TreeMap is another class of the Map interface, which is similar like Hashmap
        * and has similar methods. The main difference is, HashMap does not maintain order
        * while iterating but TreeMap is sorted by keys therefore called sorted map.*/

        //We can use a TreeMap to sort a HashMap, with this technique it will be sorted by keys
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Sorted Map(by keys): " + treeMap);

        //AnagramCheck
        System.out.println("Are the words 'silent' and 'listen' anagram? : " + anagramCheck("silent", "listen"));
    }

    public static boolean anagramCheck(String string1, String string2){
        HashMap<Character, Integer> hmap1 = new HashMap<>();
        HashMap<Character, Integer> hmap2 = new HashMap<>();

        char[] ch1 = string1.toCharArray();
        char[] ch2 = string2.toCharArray();

//        for (int i = 0; i < ch1.length; ++i){
//            if(hmap1.get(ch1[i]) == null){
//                hmap1.put(ch1[i], 1);
//            }else{
//                int frequency = hmap1.get(ch1[i]);
//                hmap1.put(ch1[i], ++frequency);
//            }
//        }
        for (char c : ch1) {
            if (hmap1.get(c) == null) {
                hmap1.put(c, 1);
            } else {
                int frequency = hmap1.get(c);
                hmap1.put(c, ++frequency);
            }
        }

//        for (int j = 0; j < ch2.length; ++j){
//            if(hmap2.get(ch2[j]) == null){
//                hmap2.put(ch2[j], 1);
//            }else{
//                int frequency = hmap2.get(ch2[j]);
//                hmap2.put(ch2[j], ++frequency);
//            }
//        }
        for (char c : ch2) {
            if (hmap2.get(c) == null) {
                hmap2.put(c, 1);
            } else {
                int frequency = hmap2.get(c);
                hmap2.put(c, ++frequency);
            }
        }

        if (hmap1.equals(hmap2)){
            return true;
        }else{
            return false;
        }
    }
}
