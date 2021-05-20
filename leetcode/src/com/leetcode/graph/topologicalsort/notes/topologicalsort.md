# Topological Sort

## when to use

1. Cannot be used when there is a cycle.
2. Used when the given graph is a DAG (Directed Acyclic graph).
3. How to find if a graph is a DAG ? Use, tarzan's strongly connected components or use -1 as below to track loops.
4. There can be many Topological ordering (not unique)
5. Trees have topological order. Pick from the child one by one.

## complexity

O(V + E)

## Algorithm

1. Construct a map of node to outgoing edges (it is in-degree if its courses order / build dependencies)
2. Create a visited map with three states -> -1 currently visiting (loop detection), 0 - un visited, 1 - previously visited.
3. Keep a stack to push the last visited node.
4. Pop the stack until empty to add to the result list for final order

## Khan's Algorithm

1. Use the nodes that has no incoming edges first.
2. Once visited, remove the incoming edge. 
3. Add those next nodes, that has no incoming edges. then go to step 1.