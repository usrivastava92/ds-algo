package com.leet.ds.utility;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class TestCaseUtils {

    private static final String BLANK = "";

    private TestCaseUtils() {

    }

    public static String extractTextFromWeb(String uri) {
        try {
            URL url = new URL(uri);
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return BLANK;
    }

    public static String extractTextFromFile(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BLANK;
    }

    public static int[] getIntArray(String line) {
        return Arrays.stream(line.replaceAll("[\\[]", BLANK).replaceAll("[\\]]", BLANK).split("[,]")).mapToInt(i -> Integer.parseInt(i.trim())).toArray();
    }

}
