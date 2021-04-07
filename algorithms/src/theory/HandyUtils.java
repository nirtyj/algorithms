package theory;

import java.util.Arrays;
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
}
