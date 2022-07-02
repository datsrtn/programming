package concurrency.mergesortmultithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    List<Integer> list;
    ExecutorService executorService;

    Sorter(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }


    @Override
    public List<Integer> call() throws Exception {

        if (list.size() <= 1) {
            return list;
        } else {
            int mid = list.size() / 2; // 2-> 1; 3-> 1 ; 4->2; 5->2
            List<Integer> left = new ArrayList<>();
            for (int i = 0; i < mid; i++) {  // < mid is needed.. or else it will go into the infinite loop
                left.add(list.get(i));
            }

            List<Integer> right = new ArrayList<>();
            for (int i = mid; i < list.size(); i++) {
                right.add(list.get(i));
            }

            Future<List<Integer>> sortedLeftFuture = executorService.submit(new Sorter(left, executorService));
            Future<List<Integer>> sortedRightFuture = executorService.submit(new Sorter(right, executorService));

            List<Integer> sortedLeft = sortedLeftFuture.get();

            List<Integer> sortedRight = sortedRightFuture.get();

            List<Integer> finalList = new ArrayList<>();

            int i = 0;
            int j = 0;
            while (i < sortedLeft.size() && j < sortedRight.size()) {
                if (sortedLeft.get(i) < sortedRight.get(j)) {
                    finalList.add(sortedLeft.get(i++));
                } else {
                    finalList.add(sortedRight.get(j++));
                }
            }
            while (i < sortedLeft.size()) {
                finalList.add(sortedLeft.get(i));
                i++;
            }

            while (j < sortedRight.size()) {
                finalList.add(sortedRight.get(j));
                j++;
            }
            return finalList;
        }
    }
}
