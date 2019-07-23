package com.milomouse;

public class Main {

    public static void main(String[] args) {

        // Variable Declarations
        String kyDistributors = "data/KYDistributors.txt";  // Identify the distributors' data file
        String breweryFile = "data/BreweryDataset.txt";  // Identify the brewery data file


        // Load the datasets into memory
        var textFileReader = new TextFileReader();
        var distributorRecords = textFileReader.readFile(kyDistributors); // Load the distributor records
        var breweryRecords = textFileReader.readFile(breweryFile);        // Load the brewery records

        // Display menu and process
//TODO: Move menus to separate method???
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("            Kentucky Craft Breweries and Distributors            ");
        System.out.println("=================================================================");
        System.out.println();
        System.out.println("The following options are available:");
        System.out.println();
        System.out.println(" 1. Display brewery information with a list of distributors in the same city");
        System.out.println(" 2. Display distributor information with a list of breweries in the same city");
        System.out.println(" 3. Save a brewery-to-distributor report file");
        System.out.println(" 4. Save a distributor-to-brewery report file");
        System.out.println(" 0. Exit");
        System.out.println("What would you like to do today? Enter the option number:  ");

//TODO: Accept menu choice input and process it


    } // main
} // class Main
