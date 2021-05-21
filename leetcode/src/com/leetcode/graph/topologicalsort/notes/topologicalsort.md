# Topological Sort

## when to use

1. Used when the given graph is a DAG (Directed Acyclic graph). i .e Cannot be used when there is a cycle.
2. How to find if a graph is a DAG ? 
   - Use, use -1 as naive algorithm to track in current loop.
   - Use, result.size() == total nodes for loop check in Khan's algorithm.
3. There can be many Topological ordering (not unique)
4. Trees have topological order. Pick from the child one by one.
5. Find the single source shortest / longest path (by multiple each edge by -1, take result and * -1) from one node to all other nodes in the graph

## complexity

O(V + E)

## Applications
1. Program build dependencies
2. Course schedule ordering
3. Event/Job scheduling
4. Assembly instructions

## Basic Algorithm

1. Construct a map of node to outgoing edges (it is in-degree if its courses order / build dependencies)
2. Create a visited map with three states -> -1 currently visiting (loop detection), 0 - un visited, 1 - previously visited.
3. Keep a stack to push the last visited node.
4. Pop the stack until empty to add to the result list for final order

## Khan's Algorithm

### Pre-requisites
1. Need a Map of Node -> list of outgoing edges
2. Need to build an additional map with each node -> in degree count
3. Use a queue to track nodes to visit with nodes whose indegree == 0
4. Use a list to store the nodes visited for the result

### Algorithm
1. Add to the Queue, the nodes that has no incoming edges first
2. Once visited, Add that to result list
3. Visit its neighbors & reduce in-degree count
4. if in-degree count is 0, offer it to the queue

### Template
```java
    private List<Integer> topologicalSortUtil(Map<Integer, List<Integer>> graph, int[] indegree, int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (indegree[entry.getKey()] == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return result.size() == n ? result : new ArrayList<>();
    }
```