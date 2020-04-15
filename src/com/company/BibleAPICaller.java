package com.company;

import java.io.IOException;

import static java.lang.Thread.currentThread;

public class BibleAPICaller implements Runnable {

    private int number;

    public BibleAPICaller(int calNumber) {
        number = calNumber;
    }

    @Override
    public void run() {
        System.out.println("Calling Bibleit home Page");
        System.out.println("Start: " + currentThread().getName());
        System.out.println("Start: Number of CallNumber is " + number);
        long startTime = System.nanoTime();
        System.out.println("Start: Start time of thread# " + number + " is " + startTime);
        long endTime = 0;


        try {
            endTime = APICAll.sendGET(number);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("End: " + currentThread().getName());
        long timeElapsed = endTime - startTime;
        double convertedTime = (double) timeElapsed / 1000000000;
        System.out.println("Nano elapsed time: " + timeElapsed);


        System.out.println("\n=== The thread# " + number+" took " + convertedTime + " seconds ===\n");
    }
}
