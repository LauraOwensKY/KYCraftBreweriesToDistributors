package com.milomouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFileReader {

    public List<List<String>> readFile(String filename){
        List<List<String>> records = new ArrayList<>(); //TWO DIMENSIONAL TABLE

        String line;
        String csvSplitBy = ",";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                // use comma as separator
                String[] singleRecord = line.split(csvSplitBy);


                records.add(Collections.singletonList(line));
            }

            reader.close();
            return records;
        }
        catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

} // class TextFileReader
