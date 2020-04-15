package com.company;

import java.io.IOException;

import static java.lang.Thread.currentThread;

public class BibleAPICaller implements Runnable {
    @Override
    public void run() {
        System.out.println("Calling Bibleit home Page");
        System.out.println("Start: " + currentThread().getName());
        try {
            APICAll.sendGET();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("End: " + currentThread().getName());
    }
}
