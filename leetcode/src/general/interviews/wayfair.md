# Round 1 - Karat

## System Design

1. User ID - facebooks list of friends - number of friends.
2. Load balancer with google docs. Consistent hashing and round robin. keeping the mapping asyncronous
3. Eventual consistency vs Strong consistency scenarios
4. log files in 500 servers with DB state. sending missed notifications for docusign.

## Coding

```java
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] argv) {


        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber"};

        ArrayList<String> result = findContiguousHistory(user0, user1); // => ["/pink", "/register", "/orange"]
        System.out.println(Arrays.toString(result.toArray()));
        result = findContiguousHistory(user0, user2); // => [] (empty)
        System.out.println(Arrays.toString(result.toArray()));
        result = findContiguousHistory(user2, user1); // => ["a"] 
        System.out.println(Arrays.toString(result.toArray()));
        result = findContiguousHistory(user5, user2); // => ["a"]
        System.out.println(Arrays.toString(result.toArray()));
        result = findContiguousHistory(user3, user4); // => ["/plum", "/blue", "/tan", "/red"]
        System.out.println(Arrays.toString(result.toArray()));
        result = findContiguousHistory(user4, user3); // => ["/plum", "/blue", "/tan", "/red"]
        System.out.println(Arrays.toString(result.toArray()));
        result = findContiguousHistory(user3, user6); // => ["/tan", "/red", "/amber"]    
        System.out.println(Arrays.toString(result.toArray()));
    }

    // Your function here:
    static ArrayList<String> findContiguousHistory(String[] u1, String[] u2) {
        Map<String, String> map = new HashMap<>();
        String[] user1 = u1;
        String[] user2 = u2;
        // optimization to index the biggest length visits.
        if (u1.length <= u2.length) {
            user1 = u2;
            user2 = u1;
        } else {
            user1 = u1;
            user2 = u2;
        }
        for (int i = 0; i < user1.length; i++) {
            String val = i + 1 >= user1.length ? null : user1[i + 1];
            map.put(user1[i], val);
        }
        ArrayList<String> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < user2.length; i++) {
            if (map.containsKey(user2[i])) {
                int count = 1;
                int j = i;
                ArrayList<String> temp = new ArrayList<>();
                temp.add(user2[j]);
                String next = map.get(user2[j]);
                j++;
                while (j < user2.length && next != null && next.equals(user2[j])) {
                    temp.add(user2[j]);
                    next = map.get(user2[j]);
                    j++;
                    count++;
                }
                if (count > max) {
                    max = count;
                    result = temp;
                }
                i = j; // optimizing to move ahead to the place last matched so that we dont visit previously matched node
            }
        }
        return result;
    }
}
```

# Round 2 - Karat

## Coding

```java
/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, the earliest ancestor of 6 is 14, and the earliest ancestor of 15 is 2. 

         14
         |
  2      4
  |    / | \
  3   5  8  9
 / \ / \     \
15  6   7    11

Write a function that, for a given individual in our dataset, returns their earliest known ancestor -- the one at the farthest distance from the input individual. If there is more than one ancestor tied for "earliest", return any one of them. If the input individual has no parents, the function should return null (or -1).

Sample input and output:

parentChildPairs3 = [
    (2, 3), (3, 15), (3, 6), (5, 6), (5, 7),
    (4, 5), (4, 8), (4, 9), (9, 11), (14, 4),
]

findEarliestAncestor(parentChildPairs3, 8) => 14
findEarliestAncestor(parentChildPairs3, 7) => 14
findEarliestAncestor(parentChildPairs3, 6) => 14
findEarliestAncestor(parentChildPairs3, 15) => 2
findEarliestAncestor(parentChildPairs3, 14) => null or -1
findEarliestAncestor(parentChildPairs3, 11) => 14

Additional example:

  14
  |
  2      4    1
  |    / | \ /
  3   5  8  9
 / \ / \     \
15  6   7    11

parentChildPairs4 = [
    (2, 3), (3, 15), (3, 6), (5, 6), (5, 7),
    (4, 5), (4, 8), (4, 9), (9, 11), (14, 2), (1, 9)
]

findEarliestAncestor(parentChildPairs4, 8) => 4
findEarliestAncestor(parentChildPairs4, 7) => 4
findEarliestAncestor(parentChildPairs4, 6) => 14
findEarliestAncestor(parentChildPairs4, 15) => 14
findEarliestAncestor(parentChildPairs4, 14) => null or -1
findEarliestAncestor(parentChildPairs4, 11) => 4 or 1

n: number of pairs in the input


*/

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] argv) {
//     int[][] parentChildPairs1 = new int[][] {
//         {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
//         {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
//         {15, 13}
//     };
//     System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8)); // => false
//      System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8)); // => true
//      System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8)); // => true
//      System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9)); // => true
//      System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3)); // => false
//      System.out.println(hasCommonAncestor(parentChildPairs1, 3, 1)); // => false
//      System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11)); // => true
//      System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5)) ; //=> true
//      System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6)); // => true
//     int[][] parentChildPairs2 = new int[][] {
//         {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
//         {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
//     };
//      System.out.println(hasCommonAncestor(parentChildPairs2, 4, 12)); // => true
//      System.out.println(hasCommonAncestor(parentChildPairs2, 1, 6)); // => false
//      System.out.println(hasCommonAncestor(parentChildPairs2, 1, 12)); // => false
      int[][] parentChildPairs3 = new int[][] {
          {2, 3}, {3, 15}, {3, 6}, {5, 6}, {5, 7},
          {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}
      };

    System.out.println(findEarliestAncestor(parentChildPairs3, 8));// => 14
    System.out.println(findEarliestAncestor(parentChildPairs3, 7));// => 14
    System.out.println(findEarliestAncestor(parentChildPairs3, 6));// => 14
    System.out.println(findEarliestAncestor(parentChildPairs3, 15));// => 2
    System.out.println(findEarliestAncestor(parentChildPairs3, 14));// => null or -1
    System.out.println(findEarliestAncestor(parentChildPairs3, 11));// => 14

      int[][] parentChildPairs4 = new int[][] {
          {2, 3}, {3, 15}, {3, 6}, {5, 6}, {5, 7},
          {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 2}, {1, 9}
      };


    
  }
  
  static class Node{
    public int distance;
    public int val;
    
    public Node(int distance, int val){
      this.distance = distance;
      this.val = val;
    }
  }
  static int findEarliestAncestor(int[][] graph, int node){
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    for(int[] g : graph){
      ArrayList<Integer> parents = map.getOrDefault(g[1], new ArrayList<>());
      parents.add(g[0]);
      map.put(g[1], parents);
    }
    if (map.containsKey(node)){
      ArrayList<Integer> list =  map.get(node);
      
    }
    return -1;
  }
  
  static Node findFurthest(Map<Integer, ArrayList<Integer>> map, int node){
     if (map.containsKey(node)){
     }
  }
  
  static boolean hasCommonAncestor(int[][] graph, int node1, int node2){ 
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    for(int[] g : graph){
      ArrayList<Integer> parents = map.getOrDefault(g[1], new ArrayList<>());
      parents.add(g[0]);
      map.put(g[1], parents);
    }
    
    //System.out.println(map.toString());
    
    HashSet<Integer> node1Parents = new HashSet<Integer>();
    getParents(map, node1, node1Parents);
    //System.out.println(node1Parents.toString());
    
    HashSet<Integer> node2Parents = new HashSet<Integer>();
    getParents(map, node2, node2Parents);
    //System.out.println(node2Parents.toString());
    
    for(Integer node1p : node1Parents){
      if (node2Parents.contains(node1p)){
        return true;
      }
    }
    return false;
  }
  
  static void getParents(Map<Integer, ArrayList<Integer>> map, int node, HashSet<Integer> parents) {
     if (map.containsKey(node)){
        ArrayList<Integer> parent =  map.get(node);
        parents.addAll(parent);
        for(Integer p: parent){
          getParents(map, p, parents);
        }
     }
  }
  
  
}

```