package theory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HandyUtils {

    public void integerArrayUtils(){
        IntStream.range(0, 10).forEach(i -> { /** from 0 to 10, do something for each i **/ });
        IntStream.generate(()->0).limit(10).toArray(); /** generate a int array with a pre filled value **/
    }

    public void integerArrayListUtils(){
        Arrays.asList(1, 2, 3, 4).stream().mapToInt(i -> i).toArray(); /** Convert an array list to array **/
    }

    public void characterArrayListUtils() {
        /** Convert an array list of characters to string **/
        Arrays.asList('H', 'e', 'l', 'l').stream().map(String::valueOf).collect(Collectors.joining());
    }

    public void intersectionSet() {
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        set1.add("Mat");
        set1.add("Sat");
        set1.add("Cat");
        System.out.println("Set1 = " + set1);
        set2.add("Mat");
        set2.add("Cat");
        set2.add("Fat");
        set2.add("Hat");
        System.out.println("Set2 = " + set2);
        set1.retainAll(set2);
        System.out.println("Intersection = " + set1);
    }

    /**
     * tailMap / headMap
     */
    public void findElementsGreaterThanKeyInTreeMap(){
        // Creating an empty TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

        // Mapping string values to int keys
        treeMap.put(10, "Geeks");
        treeMap.put(15, "4");
        treeMap.put(20, "Geeks");
        treeMap.put(25, "Welcomes");
        treeMap.put(30, "You");

        // Displaying the TreeMap
        System.out.println("The original map is: "
                + treeMap);

        // Displaying the submap
        System.out.println("The tailMap is " + treeMap.tailMap(15));
        /**
         * The original map is: {10=Geeks, 15=4, 20=Geeks, 25=Welcomes, 30=You}
         * The tailMap is {15=4, 20=Geeks, 25=Welcomes, 30=You}
         */
    }

    public void stringStartingAtCertainPosition(){
        String S = "foobar";
        String match = "bar";
        S.startsWith(match, 2); // returns true
    }

    /**
     * Sum of array util
     */
    public void findSumOfArray(){
        Arrays.stream(new int[]{1, 2, 3,4}).sum();
    }
}
