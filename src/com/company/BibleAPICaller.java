package com.company;

import java.io.IOException;
import java.util.Random;

import static java.lang.Thread.currentThread;

public class BibleAPICaller implements Runnable {

    private int number;
    private static String[] searchesArr = new String[]{"home", "david", "dog", "jesus", "lamb", "arrow", "sheep", "sin",
            "armor", "kill", "murder", "angel", "devil", "god"};

    public BibleAPICaller(int calNumber) {
        number = calNumber;
    }

    @Override
    public void run() {
//        System.out.println("Calling Bibleit home Page");
//        System.out.println("Start: " + currentThread().getName());
//        System.out.println("Start: Number of CallNumber is " + number);
        long startTime = System.nanoTime();
//        System.out.println("Start: Start time of thread# " + number + " is " + startTime);
        long endTime = 0;
        String wordSearch = getRandom(searchesArr);


        try {
            endTime = APICAll.sendGET(number, wordSearch);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("End: " + currentThread().getName());
        long timeElapsed = endTime - startTime;
        double convertedTime = (double) timeElapsed / 1000000000;
//        System.out.println("Nano elapsed time: " + timeElapsed);


        System.out.println("\n=== The thread# " + number+" with " +wordSearch+" -took-- " + convertedTime + " seconds ===\n");
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
