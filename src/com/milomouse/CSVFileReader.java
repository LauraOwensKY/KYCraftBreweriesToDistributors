package com.milomouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CSVFileReader {

    public List<List<String>> readFile(String filename){
        List<List<String>> records = new ArrayList<>(); //TWO DIMENSIONAL TABLE
        String line;                //AN INDIVIDUAL RECORD FROM records
        String csvSplitBy = ",";    // DEFINE THE FILE SEPARATOR

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                // SEPARATE THE filename INTO EACH singleRecord -- USING csvSplitBy CHARACTER
                String[] singleRecord = line.split(csvSplitBy); // singleRecord CONTAINS THE ARRAY OF RECORDS IN filename
                records.add(Arrays.asList(singleRecord));   // ADD THE INDIVIDUAL RECORD TO records
            }
            reader.close();
            return records;         // SEND BACK THE FILE filename RECORDS SEPARATED BY THE csvSplitBy CHARACTER
        }
        catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

} // class CSVFileReader
