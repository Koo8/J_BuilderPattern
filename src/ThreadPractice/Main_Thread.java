package ThreadPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main_Thread {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> ListOfArrayList = new ArrayList<ArrayList<Integer>>();

        double startTime = System.currentTimeMillis();
        // add 10 list of arrayList into this LIST
        for (int i = 0; i < 10; i++) {
             ListOfArrayList.add(new ArrayList<>());
            ArrayList<Integer> inItArrayList = ListOfArrayList.get(i);
            for (int j = 0; j <100000 ; j++) {
                inItArrayList.add((int) (Math.random()*100));
            }
        }

        // start thread for each arraylist sorting process
        ArrayList<Thread> threadList = new ArrayList<>();
        int count = 0;
        for(ArrayList<Integer> arrayList: ListOfArrayList) {

            final int index = count;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Collections.sort(arrayList); // sort each arraylist
                    //arrayList.sort((a,b)->a-b); // sort each arraylist 2nd method
                    System.out.println("Finished sorting arraylist " + index); // this will show after start() message, the result will be randomly fully depending on which thread finished first.
                }
            });
            thread.start(); // thread will start from 0 to 9 sequentially.
            System.out.println("thread " + count + " is started"); // compare without join(). to wait for thread to finish, to with join().


            // add each thread into the thread arraylist
            threadList.add(thread);
           // adding this join(), all thread has to wait for each other to finish sequentially, then the main thread sout display, it takes 5 times of the time length to process, it will be the same as running all sort on the main thread all togethr.
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            count++;
        }

        // to make sure all thread finished b4 keeping on following main thread process
        for (Thread thread:threadList) {
            try {
                System.out.println("waiting.....");
                thread.join();
                System.out.println("finished....."
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // this is on main thread.
        double endTime = System.currentTimeMillis();
        System.out.println("Time used " + (endTime - startTime) ); // Time is changing depending on the quantity of j.
        // when j is very large, this sout will show b4 other thread can finished.


        // the takeaway:
        // put thread in the thread arraylist, then use join(), to make sure all thread finished b4 go back to main thread.
    }
}
