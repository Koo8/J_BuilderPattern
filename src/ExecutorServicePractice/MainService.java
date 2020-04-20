package ExecutorServicePractice;

import java.util.Random;
import java.util.concurrent.*;

public class MainService {
    public static void main(String[] args) {
        /**** for cpu intensive operation threads,
            * the ideal  pool size is the CPU core  count */

        /*
         this part is for runnable
         */
        // find how many cores you have
//        int coreCount = Runtime.getRuntime().availableProcessors();
////        System.out.println(coreCount); // 4 is the output
//        //create thread pool
//        ExecutorService service = Executors.newFixedThreadPool(coreCount);
//
//        // submit 100 task for execute
//        for (int i = 0; i <100 ; i++) {
//            service.execute(new CpuIntensiveTask()); // parameter is runnable, this will not return any value.
//
//        }
//
//        /*
//         * for I/O intensive operation, such as database, HTTP, or network calls, you can have the thread pool size to be a large one,
//         * because all threads are passed to waiting for IO operation response from the OS.
//         * too many threads will increae memory consumption         *
//         */
//        ExecutorService serviceIo = Executors.newFixedThreadPool(100);
//        for (int i = 0; i <100 ; i++) {
//            serviceIo.execute(new IOtask());
//        }

        /*
        this part is for callable
         */

        // use callable method for returning values
        ExecutorService singleService = Executors.newSingleThreadExecutor();
        Future<Integer> future = singleService.submit(new Task<Integer>());
        int result = 0;
        try {
            System.out.println("waiting....");
             result= future.get(1,TimeUnit.SECONDS); // by changing timeout from 1 to 4, you can see the result is 0 for 1 and random int for 4, because the thread call is forfeited in the middle.
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("result is " + result);
    }

    private static class CpuIntensiveTask implements Runnable {
        @Override
        public void run() {
            // some cpu intensive operation
        }
    }


    private static class IOtask implements Runnable {
        @Override
        public void run() {
            // some i/o intensive task
        }
    }
//  callable method can return value, this is not possible for runnable method. They both run on seperate thread.
    private static class Task<Integer> implements Callable<java.lang.Integer> {
        @Override
        public java.lang.Integer call() throws Exception {
            System.out.println("starting Call......");
            Thread.sleep(3000);
            System.out.println("finish call.....");
            return new Random().nextInt();

        }
    }
}
