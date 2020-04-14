package StreamPractice;

import java.util.stream.IntStream;

public class mainStream {
    public static void main(String[] args) {
        IntStream.range(20, 30).
        forEach(System.out::println);
    }
}
