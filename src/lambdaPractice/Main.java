package lambdaPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> mInts = new ArrayList<>();
        mInts.addAll(Arrays.asList(2,3,5,5,8,2,10));
//        System.out.println(mInts.toString());

        // use stream package
        mInts.stream()
                .filter(i -> i %2==0)
                .sorted((a,b)->Integer.compare(b,a)) // descending order
                .forEach(i-> System.out.println(i));


        // Show filtered Person object in an arraylist

        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() { // for line 65, show the toString content as the name
                return name;
            }
        }

        Person[] people = {
                new Person("Williy", 30),
                new Person("Susan", 20),
                new Person("Joe", 10),
                new Person("Nancy", 30),
                new Person("Alice", 20),
                new Person("Henry", 10),
        };
        // convert the array to arraylist
        ArrayList<Person> personList = new ArrayList<>(Arrays.asList(people));
        // open stream, create a new arraylist with refined definition

        ArrayList<Person> personList2 = new ArrayList<>(personList.stream().filter((p)-> p.age >20).collect(Collectors.toList()));

        personList2.forEach(p-> System.out.println(p.name));

        System.out.println("-----------------");

        // Group the Person arraylist as different age groups.

        // create a Mapping, use Collectors.groupingBy method...
        Map<Integer, List<Person>> groupPeople = personList.stream()
                .collect(Collectors.groupingBy(p->p.age));

        System.out.println(groupPeople.toString()); // shows: {20=[Susan, Alice], 10=[Joe, Henry], 30=[Williy, Nancy]}


    }
}
