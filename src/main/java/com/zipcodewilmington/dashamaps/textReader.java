package com.zipcodewilmington.dashamaps;

import java.io.*;
import java.util.Scanner;

public class textReader {

    private DashaMapOne mapOne;
    private DashaMapTwo mapTwo;
    private DashaMapThree mapThree;

    public void readFile(){
        mapOne = new DashaMapOne();
        mapTwo = new DashaMapTwo();
        mapThree = new DashaMapThree();
        String filePath = "word-list.txt";
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(" ");
                if (parts.length >= 2){
                    String key = parts[0];
                    Integer value = Integer.parseInt(parts[1]);
                    mapOne.set(key, value);
                    mapTwo.set(key, value);
                    mapThree.set(key, value);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public DashaMapOne getMapOne() {
        return mapOne;
    }

    public DashaMapTwo getMapTwo() {
        return mapTwo;
    }

    public DashaMapThree getMapThree() {
        return mapThree;
    }
}
