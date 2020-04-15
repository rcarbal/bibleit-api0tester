package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class APICAll {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static long sendGET(int number, String wordSearch) throws IOException {
        String home = "http://bibleit.co";
        String word = "http://bibleit.co/word_search";
        String localHome = "http://localhost:8000";
        String localWord = "http://localhost:8000/word_search";

        getGetCall(home, number);

        // ?word=home
//        System.out.println(wordSearch);
        word += "?word=" + wordSearch;
        localWord += "?word=" + "god";

        getGetCall(word, number);


        // Get word request
        long endTime = System.nanoTime();
//        System.out.println("End nano time retrieved: " + endTime);
        return endTime;
    }

    public static void getGetCall(String urlToCall, int number) throws IOException {

        System.out.println("Calling URL: " + urlToCall + " on Number: " + number);
        URL obj = new URL(urlToCall);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
//        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
//            System.out.println(response.toString());
//            System.out.println("Response retrieved successfully");
        } else {
            System.out.println("GET request not worked");
        }
    }
}
