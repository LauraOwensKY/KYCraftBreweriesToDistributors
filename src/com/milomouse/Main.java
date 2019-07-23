package com.milomouse;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Variable Declarations
        String kyDistributors = "data/KYDistributors.txt";  // Identify the distributors' data file
        String breweryFile = "data/BreweryDataset.txt";  // Identify the brewery data file
        int menuChoice = 0;

        // Load the datasets into memory null;
        var textFileReader = new TextFileReader();
        var
            distributorRecords =
            textFileReader.readFile(kyDistributors); // Load the distributor records
        var
            breweryRecords =
            textFileReader.readFile(breweryFile);        // Load the brewery records

        do {
            // Display menu and process
//TODO: CREATE NEW OBJECT ==> Menus
//TODO: Add returnToMainOrQuit method to Menus Object
//TODO: Move the following code to the Menus Object
            System.out.println();
            System.out.println("=================================================================");
            System.out.println("            Kentucky Craft Breweries and Distributors            ");
            System.out.println("=================================================================");
            System.out.println();
            System.out.println("The following options are available:");
            System.out.println();
            System.out.println(
                " 1. Display brewery information with a list of distributors in the same city");
            System.out.println(
                " 2. Display distributor information with a list of breweries in the same city");
            System.out.println(" 3. Save a brewery-to-distributor report file");
            System.out.println(" 4. Save a distributor-to-brewery report file");
            System.out.println(" 0. Exit");
            System.out.println();

            try {
//TODO: fix error ==>> java.lang.NumberFormatException
                menuChoice = parseInt(readLine("Enter the number of your selection: "));
                if (menuChoice == 0) {
                    System.out.println("You have chosen to end the program. Have a nice day!");
                } else if (menuChoice == 1) {
                    new BreweryToDistributor()
                        .displayBreweryToDistributor(distributorRecords, breweryRecords);
                } else if (menuChoice == 2) {
                    new DistributorToBrewery()
                        .displayDistributorToBrewery(distributorRecords, breweryRecords);
                } else if (menuChoice == 3) {
                    new BreweryToDistributor()
                        .saveBreweryToDistributor(distributorRecords, breweryRecords);
                } else if (menuChoice == 4) {
                    new DistributorToBrewery()
                        .saveDistributorToBrewery(distributorRecords, breweryRecords);
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



