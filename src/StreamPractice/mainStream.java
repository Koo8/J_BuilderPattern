package StreamPractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class mainStream {
    public static void main(String[] args) {
//        IntStream.range(20, 30).
//        forEach(System.out::println);

        // first way of show an array of numbers - stream  --- lambda expression
        List<Integer> numbers = Arrays.asList(1,3, 5, 7, 11);
        numbers.stream().forEach((n) -> System.out.println(n));

        System.out.println("_______________ & ______________");

        //**** use "******* Method reference ********" to print out each number
        numbers.forEach(System.out::println); // the format is class::method.
        numbers.forEach(mainStream::doubleIt); // doubleIt is a method of this class

        System.out.println("____________-______________");

        // second way of show an array of numbers - iterator
        Iterator<Integer> i = numbers.iterator(); // attah the list of number to iterator
        while(i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("____________*______________");

        // third way of showing an array of numbers - enhanced for loop
        for(int j: numbers) {
            System.out.println(j);
        }

    }

    private static void doubleIt(Integer integer) {
        System.out.println(integer * 2);
    }
}
