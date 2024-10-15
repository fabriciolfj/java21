package com.github.fabriciolfj.randonvalues;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main3 {

    private static final Logger logger = Logger.getLogger(Main3.class.getName());

    public static void main(String[] args) {
        List<Integer> listOfInts = new CopyOnWriteArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        RandomGenerator.SplittableGenerator splittableGenerator =
                RandomGeneratorFactory.<RandomGenerator.SplittableGenerator>of("L128X256MixRandom").create();

        splittableGenerator.splits(10)
                .forEach((anotherSplittableGenerator) -> {
                    executorService.submit(() -> {
                        int nextInt = anotherSplittableGenerator.nextInt(1_000);
                        Main3.logger.info(() ->
                                STR."Added in list \{nextInt} by generator \{anotherSplittableGenerator.hashCode()} running in thread\{Thread.currentThread().getName()}");
                        listOfInts.add(nextInt);
                    });
                });

        shutdownExecutor(executorService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(1_000, TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }
        return false;
    }

}

