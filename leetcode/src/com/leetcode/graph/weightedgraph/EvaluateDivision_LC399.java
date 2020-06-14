package com.leetcode.graph.weightedgraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
public class EvaluateDivision_LC399 {

    /**
     * Leetcode verified -
     * https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            result[i] =  getEquationValue(graph, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    double getEquationValue(Map<String, Map<String, Double>> graph, HashSet<String> visited, String x, String y){
        if (!graph.containsKey(x)){
            return -1;
        }
        if (graph.get(x).containsKey(y)){
            return graph.get(x).get(y);
        }
        visited.add(x);
        for(Map.Entry<String, Double> neighbourEntry : graph.get(x).entrySet()){
            if (visited.contains(neighbourEntry.getKey())){
                continue;
            }
            double neival = getEquationValue(graph, visited, neighbourEntry.getKey(), y);
            if (neival != -1){
                return neighbourEntry.getValue() * neival;
            }
        }
        return -1;
    }

    Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            Map<String, Double> mapx = graph.getOrDefault(x, new HashMap<>());
            mapx.put(y, values[i]);
            graph.put(x, mapx);
            Map<String, Double> mapy = graph.getOrDefault(y, new HashMap<>());
            mapy.put(x, 1/values[i]);
            graph.put(y, mapy);
        }
        return graph;
    }
}
