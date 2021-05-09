package general;

import java.util.Arrays;

public class test {

    public int maximumPopulation(int[][] logs) {

        Arrays.sort(logs);
        return 0;
    }

    public static void main(String[] args){
        int[][] log = {{1931, 1940}, { 1939, 1949}};
        test t = new test();
        t.maximumPopulation(log);
    }
}
