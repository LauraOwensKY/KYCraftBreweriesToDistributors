package com.milomouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFileReader {

    public List<String> readList(List<List<String>> inList){
        List<String> outList = new ArrayList<>();
        String line;                //AN INDIVIDUAL RECORD FROM records
        String csvSplitBy = ",";    // DEFINE THE FILE SEPARATOR

        for (int i = 0; i < inList.size(); i++) {

            try {
                outList = inList.get(i);

            } catch (Exception e) {
                System.err.format("Exception occurred trying to process '%s'.", inList);
                e.printStackTrace();
                return null;
            }
        }
        return outList;
    // ******************************************************************************



        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                // SEPARATE THE filename INTO EACH singleRecord -- USING csvSplitBy CHARACTER
                String[] singleRecord = line.split(csvSplitBy); // singleRecord CONTAINS THE ARRAY OF RECORDS IN filename
                //              System.out.println(Collections.singletonList(line));
                records.add(Collections.singletonList(line));   // ADD THE INDIVIDUAL RECORD TO records
            }
            reader.close();
            return records; // SEND BACK THE FILE filename RECORDS SEPARATED BY THE csvSplitBy CHARACTER
        }
        catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}
