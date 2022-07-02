package concurrency.mergesortmultithreaded;

import com.sun.jdi.IntegerType;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future; 

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer>  list = List.of(1,5,7,3,4,9);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> sortedListFuture = executorService.submit(new Sorter(list,executorService));
        List<Integer>  result = sortedListFuture.get();
        executorService.shutdown();
        System.out.println(result);
    }
}
