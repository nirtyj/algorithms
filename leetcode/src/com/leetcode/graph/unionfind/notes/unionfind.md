# Union-Find

## Template

```java
class Solution {

    int[] parent;
    int find(int x){ // find
        if (parent[x] == x){
            return x;
        } else {
            return find(parent[x]);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[] result = null;
        for (int i = 0; i < n; i++) {
            int group1 = find(edges[i][0]);
            int group2 = find(edges[i][1]);
            if (group1 != group2){
                parent[group2] = group1; // union
            } else {
                // there is a loop
                result = new int[] {edges[i][0], edges[i][1]};
            }
        }
        return result;
    }
}
```
## Things to Note
1. If it is a Adjacency matrix, check if ``` matrix[i][j] = 1 ```  (**connected**) && ``` i != j``` (**not same node**)

## Problems
- LC 547 - https://leetcode.com/problems/number-of-provinces/
- LC 684 - https://leetcode.com/problems/redundant-connection/
- LC 721 - https://leetcode.com/problems/accounts-merge/  
- LC 947 - https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
- LC 990 - https://leetcode.com/problems/satisfiability-of-equality-equations/
- LC 1319 - https://leetcode.com/problems/number-of-operations-to-make-network-connected/
