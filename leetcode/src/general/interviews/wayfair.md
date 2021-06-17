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