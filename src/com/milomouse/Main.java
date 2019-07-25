package com.milomouse;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // VARIABLE DECLARATIONS
        int menuChoice = 0;
        String kyDistributors = "data/DistributorData.csv"; // SOURCE CSV DATA FILE (file #1)
        String breweryFile = "data/BreweryData.csv";        // Source CSV DATA FILE (file #2}
        String breweryWithDistributorsReport = "data/BreweryWithDistributorsReport.txt"; // DESTINATION .TXT file #1
        String distributorWithBreweriesReport = "data/DistributorWithBreweriesReport.txt"; // DESTINATION .TXT file #2


        // CREATE INSTANCES OF THE DATA FILES AND LOAD THEM INTO MEMORY
        var textFileReader = new TextFileReader();
        var
            distributorRecords =
            textFileReader.readFile(kyDistributors);        // LOAD THE DISTRIBUTOR RECORDS
        var
            breweryRecords =
            textFileReader.readFile(breweryFile);           // LOAD THE BREWERY RECORDS


        // DISPLAY MAIN MENU AND PROCESS USER INPUT
        do {
            System.out.println();
            System.out.println("=================================================================");
            System.out.println("            Kentucky Craft Breweries and Distributors            ");
            System.out.println("=================================================================");
            System.out.println();
            System.out.println("Create a report showing Brewery and Distributor data based on the location.");
            System.out.println("The following options are available:");
            System.out.println();
            System.out.println(" 1. Display a Brewery with Distributors Report");
            System.out.println(" 2. Display Distributor with Breweries Report");
            System.out.println(" 3. Save a Brewery with Distributors Report");
            System.out.println(" 4. Save a Distributor with Breweries Report");
            System.out.println(" 0. Exit");
            System.out.println();


//TODO: fix error ==>> java.lang.NumberFormatException ==>> non-numeric entered for menu choice

            try {
                menuChoice = parseInt(readLine("Enter the number of your selection: "));
                if (menuChoice == 0) {
                    System.out.println("You have chosen to end the program. Have a nice day!");
                } else if (menuChoice == 1) {
                    displayBreweryWithDistributors(distributorRecords, breweryRecords);
                } else if (menuChoice == 2) {
                    displayDistributorWithBreweries(distributorRecords, breweryRecords);
                } else if (menuChoice == 3) {
                    saveBreweryWithDistributors(distributorRecords, breweryRecords, breweryWithDistributorsReport);
                } else if (menuChoice == 4) {
                    saveDistributorWithBreweries(distributorRecords, breweryRecords, distributorWithBreweriesReport);
                } else {
                    System.out
                        .println("You entered " + menuChoice + ". That is not a valid entry.");
                    System.out.println(
                        "To generate a report, enter a menu choice between 1 and 4. Enter 0 to quit.");
                } // if-else

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }  // try-catch

        } while (menuChoice != 0);

    } // main


    // METHODS TO CREATE REPORTS
    private static void displayBreweryWithDistributors(List<List<String>> distributors, List<List<String>> breweries) {
//TODO: Call a displayReport method???

        System.out.println();
        System.out.println("=================================================================");
        System.out.println("       Kentucky Craft Breweries with Distributors Report         ");
        System.out.println("=================================================================");
        System.out.println();
        for (int i = 0; i < breweries.size(); i++){
            //DISPLAY BREWERY AND SET UP REPORT HEADINGS
            String breweryCity = breweries.get(i, 2);
            System.out.println();
            System.out.println("=================================================================");
            System.out.println();
            System.out.println("BREWERY: " + breweries.get([i][0]);
            System.out.println("         " +  breweries.get([i][1]) + "," + breweryCity + ", " + breweries.get([i][3]) + breweries.get([i][4]));
            System.out.println();
            System.out.printf("Distributors available in %s: %n", breweryCity);
            System.out.println("    NAME                                          ADDRESS");

            for (int j = 0; j < distributors.size(); j++){
                //DISPLAY DISTRIBUTORS IN THE SAME CITIES AS THE BREWERIES
                String distributorsCityState = distributors.get([j][4]) + distributors.get([j][5]);
                if (distributors.contains(breweryCity))
                    System.out.println(distributors.get([j]));
            }
        }
            System.out.println(breweries); //TESTING WHAT IS BEING LOADED ==>> REMOVE LATER

    }

    private static void displayDistributorWithBreweries(List<List<String>> distributorRecords, List<List<String>> breweryRecords) {
//TODO: Call a displayReport method???
    }

    private static void saveBreweryWithDistributors(List<List<String>> distributorRecords,
                                                    List<List<String>> breweryRecords,
                                                    String txtFilePath) {
//TODO: Call a writeToFile method???
    }

    private static void saveDistributorWithBreweries(List<List<String>> distributorRecords,
                                                     List<List<String>> breweryRecords,
                                                     String txtFilePath) {
//TODO: Call a writeToFile method???
    }


} // class Main



