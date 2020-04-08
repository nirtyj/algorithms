package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

    // 1 ms - update it on the same pass
    public String getHint(String secret, String guess) {
        int[] m = new int[]{0,0,0,0,0,0,0,0,0,0}; //frequency map for digits
        int countA = 0;
        int countB = 0;
        for(int i = 0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                countA++;
            }else{
                if(m[secret.charAt(i) - '0']++ < 0){
                    // this makes the values go positive. but if guess has negatived here before,
                    // then increase
                    countB++;
                }
                if(m[guess.charAt(i) - '0']-- > 0){
                    // this makes the values go negative. but if secret has plussed here,
                    // it will be positive. then increase
                    countB++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(countA);
        sb.append("A");
        sb.append(countB);
        sb.append("B");
        return sb.toString();
    }

    // hash map - 2 pass
    public String getHint2(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();
        int bull = 0;
        int cow = 0;
        for(int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g){
                bull++;
            }
            else{
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        for(int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s!=g && map.containsKey(g) && map.get(g)-1 >=0){
                cow++;
                map.put(g,map.get(g)-1);
            }
        }
        return bull + "A" + cow + "B";
    }

    // 2D map. with arr[digit]-> 0->freq, 1...index
    public String getHint3(String secret, String guess) {

        int[][] map = new int[10][(secret.length() + 1)];

        for(int i = 0; i<secret.length();i++){
            int rem = secret.charAt(i) - '0';
            map[rem][i + 1] = 1;
            map[rem][0] = map[rem][0] + 1;
        }

        int[] seen = new int[guess.length()];
        int bull = 0;
        for(int j = 0; j<guess.length();j++){
            int rem = guess.charAt(j) - '0';
            if (map[rem][j + 1] == 1){
                map[rem][0] = map[rem][0] - 1;
                map[rem][j + 1] = 0;
                bull++;
                seen[j] = 1;
            }
        }

        int cows = 0;
        for(int j = 0; j<guess.length();j++){
            if (seen[j] == 1)
                continue;
            int rem = guess.charAt(j) - '0';
            if (map[rem][0] > 0)
            {
                cows++;
                map[rem][0] = map[rem][0] - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}
