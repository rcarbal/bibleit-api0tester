package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int times = 1000;
        for (int i = 0; i < times; i++){
            System.out.println("============== >>>>> Call: " + i);
            callThread(i);
        }
    }

    private static void callThread(int calNumber){
        Thread myNewThread = new Thread(new BibleAPICaller());
        myNewThread.setName("Thread# " + calNumber);
        myNewThread.start();
    }
}
