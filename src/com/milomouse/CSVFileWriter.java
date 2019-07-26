package com.milomouse;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {


    public static void writeFile(List<List<String>> masterListOne,
                                 List<String> listOne,
                                 List<List<String>> masterListTwo,
                                 List<String> listTwo, String txtFilePath) {

        var textFile = "";  // String file to be written

        // DISPLAY BEGIN WRITING MESSAGE FOR BREWERY WITH DISTRIBUTORS FILE
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("  Begin writing file . . . . .");

        // ITERATE THROUGH THE breweries USING i
        // ITERATE THROUGH THE distributors USING j
        // IF A distributor CITY MATCHES THE brewery CITY,
        //     ADD THE DISTRIBUTOR RECORD TO THE FILE TO BE WRITTEN

        for (int i = 1; i < masterListOne.size(); i++){ // SKIP HEADER LINE IN DATA FILE
            listOne = masterListOne.get(i);             // LOAD A BREWERY RECORD
            textFile = textFile + listOne + ",";
            try {                                     //DISPLAY DISTRIBUTORS IN THE SAME CITIES AS THE BREWERIES
                for (int j = 1; j < masterListTwo.size(); j++) { // SKIP HEADER LINE IN DATA FILE
                    listTwo = masterListTwo.get(j);          // LOAD A DISTRIBUTOR RECORD
                    String dCityCompare = listTwo.get(4).toLowerCase();
                    String bCityCompare = listOne.get(2).toLowerCase();
                    if (dCityCompare.equals(bCityCompare)) {    // IF CITIES MATCH, DISPLAY DISTRIBUTOR AND STREET ADDRESS
                        textFile = textFile + listTwo.get(1) + "," + listTwo.get(3) + ",";
                    }
                }
            }  catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }  // try-catch;

        }

         // WRITE THE FILE TO txtFilePath
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(txtFilePath));
            bufferedWriter.write(textFile);
            bufferedWriter.close();
            System.out.printf("Your file %s is written.", txtFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // writeFile

}
