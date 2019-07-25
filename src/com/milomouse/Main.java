package com.milomouse;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {

        // VARIABLE DECLARATIONS
        int menuChoice = 0;
        String kyDistributors = "data/DistributorData.csv";     // SOURCE CSV DATA FILE (file #1)
        String breweryFile = "data/BreweryData.csv";            // SOURCE CSV DATA FILE (file #2}
        String breweryWithDistributorsReport = "data/BreweryWithDistributorsReport.txt";    // DESTINATION .TXT file #1
        String distributorWithBreweriesReport = "data/DistributorWithBreweriesReport.txt";  // DESTINATION .TXT file #2

        // CREATE INSTANCES OF THE DATA FILES AND LOAD THEM INTO MEMORY
        var textFileReader = new TextFileReader();
        var distributors = textFileReader.readFile(kyDistributors);   // LOAD THE DISTRIBUTOR RECORDS
        var breweries = textFileReader.readFile(breweryFile);          // LOAD THE BREWERY RECORDS
// ************************************

// **************************************
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
                    displayBreweryWithDistributors(distributors, breweries)
                } else if (menuChoice == 2) {
                    displayDistributorWithBreweries(distributors, breweries);
                } else if (menuChoice == 3) {
                    saveBreweryWithDistributors(distributors, breweries, breweryWithDistributorsReport);
                } else if (menuChoice == 4) {
                    saveDistributorWithBreweries(distributors, breweries, distributorWithBreweriesReport);
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
    private static void displayBreweryWithDistributors(List<List<String>> distributors, List<List<String>> breweries) throws IndexOutOfBoundsException {
//TODO: Call a displayReport method???

        System.out.println();
        System.out.println("=================================================================");
        System.out.println("       Kentucky Craft Breweries with Distributors Report         ");
        System.out.println("=================================================================");
        System.out.println();

        // ITERATE THROUGH THE breweries USING i
        // ITERATE THROUGH THE distributors USING j
        // IF A distributor CITY MATCHES THE brewery CITY,
        //     DISPLAY THE DISTRIBUTOR BENEATH THE BREWERY

        for (int i = 0; i < breweries.size(); i++){

            try {
                String breweryCity = breweries.get(i).get(2);

                //DISPLAY BREWERY AND SET UP REPORT HEADING
                System.out.println();
                System.out
                    .println("=================================================================");
                System.out.println();
                System.out.println("BREWERY: " + breweries.get(i).get(0));
                System.out.println(
                    "         " + breweries.get(i).get(1) + "," + breweryCity + ", " + breweries
                        .get(i).get(3) + breweries.get(i).get(4));
                System.out.println();
                System.out.printf("Distributors available in %s: %n", breweryCity);
                System.out.println("    NAME                                          ADDRESS");

                for (int j = 0; j < distributors.size(); j++) {
                    //DISPLAY DISTRIBUTORS IN THE SAME CITIES AS THE BREWERIES
                    String
                        distributorsCityState =
                        distributors.get(j).get(4) + distributors.get(j).get(5);
                    if (distributors.get(j).get(4).contains(breweries.get(i).get(2))) {
                        System.out.println(distributors.get(j)
                            .get(1));  //TODO: FORMAT OUTPUT TO PRINT NAME AND ADDRESS
                    }

                }
            }  catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }  // try-catch;
        }
            System.out.println(breweries); //TESTING WHAT IS BEING LOADED ==>> REMOVE LATER

    }

    private static void displayDistributorWithBreweries(List<List<String>> distributorRecords, List<List<String>> breweryRecords) {
//TODO: Call a displayReport method???


        System.out.println();
        System.out.println("=================================================================");
        System.out.println("       Kentucky Distributors with Craft Breweries Report         ");
        System.out.println("=================================================================");
        System.out.println();

    }

    private static void saveBreweryWithDistributors(List<List<String>> distributorRecords,
                                                    List<List<String>> breweryRecords,
                                                    String txtFilePath) {

        System.out.println();
        System.out.println("=================================================================");
        System.out.println("    Saving Kentucky Craft Breweries with Distributors Report     ");
        System.out.println("=================================================================");
        System.out.println();

    }

    private static void saveDistributorWithBreweries(List<List<String>> distributorRecords,
                                                     List<List<String>> breweryRecords,
                                                     String txtFilePath) {
//TODO: Call a writeToFile method???

        System.out.println();
        System.out.println("=================================================================");
        System.out.println("    Saving Kentucky Distributors with Craft Breweries Report     ");
        System.out.println("=================================================================");
        System.out.println();

    }


} // class Main



