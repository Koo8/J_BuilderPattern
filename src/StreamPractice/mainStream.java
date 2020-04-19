package StreamPractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class mainStream {
    public static void main(String[] args) {
//        IntStream.range(20, 30).
//        forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(15,33, 55, 71, 115,42,66, 20);
        // first way of show an array of numbers - stream  --- lambda expression

        numbers.stream().forEach((n) -> System.out.println(n));

        System.out.println("***************");


        // get total using stream, map each number to its double, reduce them to total sum
        System.out.println(numbers.stream().map(i->i*2).reduce(0,(a,b)->a+b));
        //this above can also be written use Integer.sum(a,b) method, therefore, we can use the Method Reference for this
        System.out.println("Method reference " + numbers.stream().map(i->i*2).reduce(0,Integer::sum));

        System.out.println("_______________ & ______________");

        // stream filter --- add all numbers that is divisible by 5
        System.out.println(numbers.stream().filter(i->i%5==0).reduce(0,Integer::sum));

        System.out.println("&&&&&&&&&&&&&&&&");

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
