package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICAll {
    private static final String USER_AGENT = "Mozilla/5.0";
    public static long sendGET(int number) throws IOException {
        getHomePage();

        // Get word request
        long endTime = System.nanoTime();
        System.out.println("End nano time retrieved: " + endTime);
        return endTime;
    }

    public static void getHomePage() throws IOException {

        URL obj = new URL("http://bibleit.co");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
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
            System.out.println(response.toString());
            System.out.println("Response retrieved successfully");
        } else {
            System.out.println("GET request not worked");
        }
    }
}
