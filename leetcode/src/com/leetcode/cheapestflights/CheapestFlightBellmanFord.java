package com.leetcode.cheapestflights;

import java.util.Arrays;

// 4 ms
public class CheapestFlightBellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE); // infinity
        // need to initialize to 0.
        cost[src]=0;
        for (int i=0;i<=K;i++) {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],
                        next=f[1],
                        price=f[2];
                if(cost[curr]==Integer.MAX_VALUE) // cant reach to this node yet.
                    continue;
                // price to reach is min of this step's price  / cost of previous step + this step
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
