package com.milomouse;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Variable Declarations

        int menuChoice = 0;
        String kyDistributors = "data/DistributorData.csv"; // Source CSV data file #1
        String breweryFile = "data/BreweryData.csv";        // Source CSV data file #2
        String breweryWithDistributorsReport = "data/BreweryWithDistributorsReport.txt"; // Destination .TXT file #1
        String distributorWithBreweriesReport = "data/DistributorWithBreweriesReport.txt"; // Destination .TXT file #2


        // Create instances of the data files and Load them into memory

        var textFileReader = new TextFileReader();
        var
            distributorRecords =
            textFileReader.readFile(kyDistributors);        // Load the distributor records
        var
            breweryRecords =
            textFileReader.readFile(breweryFile);           // Load the brewery records


        // Display main menu and process user input

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


//TODO: fix error ==>> java.lang.NumberFormatException
//TODO: Add returnToMainOrQuit method to Menus Object

            try {
                menuChoice = parseInt(readLine("Enter the number of your selection: "));
                if (menuChoice == 0) {
                    System.out.println("You have chosen to end the program. Have a nice day!");
                } else if (menuChoice == 1) {
                    new BreweryWithDistributors()
                        .displayBreweryWithDistributor(distributorRecords, breweryRecords);
                } else if (menuChoice == 2) {
                    new DistributorWithBreweries()
                        .displayDistributorWithBreweries(distributorRecords, breweryRecords);
                } else if (menuChoice == 3) {
                    new BreweryWithDistributors()
                        .saveBreweryWithDistributor(distributorRecords, breweryRecords);
                } else if (menuChoice == 4) {
                    new DistributorWithBreweries()
                        .saveDistributorWithBreweries(distributorRecords, breweryRecords);
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
} // class Main



