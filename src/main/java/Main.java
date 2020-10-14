import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Math.*;

public class Main {
    static int arrayLengh = 10000000;

    public static void main(String[] args) throws InterruptedException {
        MapTestingClass mapTestingClass = new MapTestingClass(arrayGenerate(arrayLengh));
        SynchronizedMapTest(mapTestingClass);
        ConcurrentMapTest(mapTestingClass);
    }

    public static Double[] arrayGenerate (int arrayLengh) {
        Double[] array = new Double[arrayLengh];
        for (int i = 0; i < arrayLengh; i++) {
            array[i] = random();
        }
        return array;
    }

    public static void SynchronizedMapTest (MapTestingClass mapTestingClass) throws InterruptedException {
        long start = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Callable<Object> task1 = new SynchronizedMapWriter(mapTestingClass, 1, arrayLengh);
        Callable<Object> task2 = new SynchronizedMapWriter(mapTestingClass, 1, arrayLengh);
        Callable<Object> task3 = new SynchronizedMapReader(mapTestingClass, 1, arrayLengh);
        Callable<Object> task4 = new SynchronizedMapReader(mapTestingClass, 1, arrayLengh);
        List<Callable<Object>> tasks = Arrays.asList(task1, task2, task3, task4);
        executor.invokeAll(tasks);
        executor.shutdown();
        long finish = System.nanoTime();
        System.out.println("> SynchronizedMapTest: " + (finish - start));
    }

    public static void ConcurrentMapTest (MapTestingClass mapTestingClass) throws InterruptedException {
        long start = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Callable<Object> task1 = new ConcurrentHashMapWriter(mapTestingClass, 1, arrayLengh);
        Callable<Object> task2 = new ConcurrentHashMapWriter(mapTestingClass, 1, arrayLengh);
        Callable<Object> task3 = new ConcurrentHashMapReader(mapTestingClass, 1, arrayLengh);
        Callable<Object> task4 = new ConcurrentHashMapReader(mapTestingClass, 1, arrayLengh);
        List<Callable<Object>> tasks = Arrays.asList(task1, task2, task3, task4);
        executor.invokeAll(tasks);
        executor.shutdown();
        long finish = System.nanoTime();
        System.out.println("> ConcurrentMapTest:   " + (finish - start));
    }
}
