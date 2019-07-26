package com.milomouse;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {

        // VARIABLE DECLARATIONS
        int menuChoice = 0;
        String kyDistributors = "data/DistributorData.csv";     // SOURCE CSV DATA FILE (file #1)
        String breweryFile = "data/BreweryData.csv";            // SOURCE CSV DATA FILE (file #2}
        String breweryWithDistributorsReport = "data/BreweryWithDistributorsReport.csv";    // DESTINATION .TXT file #1
        String distributorWithBreweriesReport = "data/DistributorWithBreweriesReport.csv";  // DESTINATION .TXT file #2

        // CREATE INSTANCES OF THE DATA FILES AND LOAD THEM INTO MEMORY
        var textFileWriter = new CSVFileWriter();
        var textFileReader = new CSVFileReader();
        var distributors = textFileReader.readFile(kyDistributors);   // LOAD THE DISTRIBUTOR RECORDS
        var breweries = textFileReader.readFile(breweryFile);          // LOAD THE BREWERY RECORDS
        List<String> brewery = new ArrayList<>();
        List<String> distributor = new ArrayList<>();

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
            System.out.println("Choose one of the stunning options below:");
            System.out.println();
            System.out.println(" 1. Display a Brewery with Distributors Report");
            System.out.println(" 2. Display Distributor with Breweries Report");
            System.out.println(" 3. Save a Brewery with Distributors Report");
            System.out.println(" 4. Save a Distributor with Breweries Report");
            System.out.println(" 0. Exit");
            System.out.println();


//TODO: Change menu entry processing to switch/case statement

            try {
                String menuChoiceInput = readLine("Enter the number of your selection: ");
                if (Pattern.matches("\\d+", menuChoiceInput)) { // CHECK FOR NUMERIC ENTRY
                    menuChoice = parseInt(menuChoiceInput);           // CONVERT TO NUMERIC FOR BOOLEAN COMPARISON
                    if (menuChoice == 0) {
                        System.out.println("You have chosen to end the program. Have a nice day!");
                    } else if (menuChoice == 1) {
                        displayBreweryWithDistributors(distributors, distributor, breweries, brewery);
                    } else if (menuChoice == 2) {
                        displayDistributorWithBreweries(distributors, distributor, breweries, brewery);
                    } else if (menuChoice == 3) {
                        saveBreweryWithDistributors(distributors, distributor, breweries, brewery, breweryWithDistributorsReport);
                    } else if (menuChoice == 4) {
                        saveDistributorWithBreweries(distributors, distributor, breweries, brewery,
                            distributorWithBreweriesReport);
                    } else {
                        System.out.println("@@@");
                        System.out.println("@#%#@#%#@#%@ WUZZZAT? @#%#@#%#@#%@");
                        System.out.printf("Although %s IS a number, it's not a valid menu choice!%n", menuChoiceInput);
                        System.out.println("Don't get snippy. Just pick a report, any report, as long as it's 1 thru 4.");
                        System.out.println("Or, if you've really had enough, and it's time to EXIT ====>> enter 0.");
                        System.out.println();
                    }
                } else {
                    System.out
                        .println("You entered " + menuChoiceInput + ". That is not a valid entry.");
                    System.out.println(
                        "To generate a report, enter a menu choice between 1 and 4. Enter 0 to quit.");
                    System.out.println("If you entered a bad menu choice the first time through,");
                    System.out.println("the program terminates. BUT, if you've already entered a proper");
                    System.out.println("menu choice, you'll probably go back to the main menu.");
                    System.out.println("For now, BLNT ====>> Better Luck Next Time!");
                } // if-else
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid entry. You need to enter a menu option.");
                System.out.println("Enter a menu choice between 1 and 4. Enter 0 to quit.");
                System.out.println("BLNT ====>> Better Luck Next Time! Clearly");
            }  // try-catch

        } while (menuChoice != 0);

    } // main


    // METHODS TO CREATE REPORTS
//TODO: MAKE displayBreweryWithDistributors & displayDistributorWithBreweries CALL THE ReportDisplay method

    private static void displayBreweryWithDistributors(List<List<String>> distributors, List<String> distributor,
                                                       List<List<String>> breweries, List<String> brewery) throws IndexOutOfBoundsException {

 //TODO: Move Headings to a displayReport method with String reportTitle parameter
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("       Kentucky Craft Breweries with Distributors Report         ");
        System.out.println("=================================================================");
        System.out.println();

        // ITERATE THROUGH THE breweries USING i
        // ITERATE THROUGH THE distributors USING j
        // IF A distributor CITY MATCHES THE brewery CITY,
        //     DISPLAY THE DISTRIBUTOR BENEATH THE BREWERY

        for (int i = 1; i < breweries.size(); i++){ // SKIP HEADER LINE IN DATA FILE
            brewery = breweries.get(i);             // LOAD A BREWERY RECORD
                                                    // DISPLAY BREWERY AND SET UP REPORT HEADING
            System.out.println();
            System.out.println("=================================================================");
            System.out.println();
            System.out.println("BREWERY: " + brewery.get(0));
            System.out.printf("        %s, %s, %s %s%n", brewery.get(1), brewery.get(2), brewery.get(3), brewery.get(4));
            System.out.println();
            System.out.printf("DISTRIBUTORS AVAILABLE IN %s: %n%n", brewery.get(2).toUpperCase());
            System.out.println("    NAME      STREET ADDRESS");

            try {                                     //DISPLAY DISTRIBUTORS IN THE SAME CITIES AS THE BREWERIES
                for (int j = 1; j < distributors.size(); j++) { // SKIP HEADER LINE IN DATA FILE
                    distributor = distributors.get(j);          // LOAD A DISTRIBUTOR RECORD
                    String dCityCompare = distributor.get(4).toLowerCase();
                    String bCityCompare = brewery.get(2).toLowerCase();
                    if (dCityCompare.equals(bCityCompare)) {    // IF CITIES MATCH, DISPLAY DISTRIBUTOR AND STREET ADDRESS
                        System.out.printf("%s, %s%n", distributor.get(1), distributor.get(3));
                    }
                }
            }  catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }  // try-catch;
        }
     }

    private static void displayDistributorWithBreweries(List<List<String>> distributors,
                                                        List<String> distributor,
                                                        List<List<String>> breweries,
                                                        List<String> brewery) {
//TODO: Move Headings to a displayReport method with String reportTitle parameter
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("       Kentucky Distributors with Craft Breweries Report         ");
        System.out.println("=================================================================");
        System.out.println();

        // ITERATE THROUGH THE breweries USING i
        //   ITERATE THROUGH THE distributors USING j
        //     IF A distributor CITY MATCHES THE brewery CITY,
        //       DISPLAY THE DISTRIBUTOR BENEATH THE BREWERY

        for (int i = 1; i < distributors.size(); i++){ // SKIP HEADER LINE IN DATA FILE
            distributor = distributors.get(i);             // LOAD A BREWERY RECORD
            // DISPLAY BREWERY AND SET UP REPORT HEADING
            System.out.println();
            System.out.println("=================================================================");
            System.out.println();
            System.out.println("DISTRIBUTOR: " + distributor.get(1));
            System.out.printf("        %s, %s, %s %s%n", distributor.get(3), distributor.get(4), distributor.get(5), distributor.get(4));
            System.out.println();
            System.out.printf("BREWERIES OPERATING IN %s: %n%n", distributor.get(4).toUpperCase());
            System.out.println("    NAME        STREET ADDRESS");

            try {                                     //DISPLAY DISTRIBUTORS IN THE SAME CITIES AS THE BREWERIES
                for (int j = 1; j < breweries.size(); j++) { // SKIP HEADER LINE IN DATA FILE
                    brewery = breweries.get(j);          // LOAD A DISTRIBUTOR RECORD
                    String dCityCompare = distributor.get(4).toLowerCase();
                    String bCityCompare = brewery.get(2).toLowerCase();
                    if (dCityCompare.equals(bCityCompare)) {    // IF CITIES MATCH, DISPLAY DISTRIBUTOR AND STREET ADDRESS
                        System.out.printf("%s, %s%n", brewery.get(0), brewery.get(1));
                    }
                }
            }  catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }  // i-LOOP

    } // displayDistributorWithBreweries METHOD



    private static void saveBreweryWithDistributors(List<List<String>> distributors,
                                                    List<String> distributor,
                                                    List<List<String>> breweries,
                                                    List<String> brewery,
                                                    String txtFilePath) {

        System.out.println();
        System.out.println("=================================================================");
        System.out.println("    Saving Kentucky Craft Breweries with Distributors Report     ");
        System.out.println("=================================================================");
        System.out.println();

        CSVFileWriter.writeFile(breweries, brewery, distributors, distributor, txtFilePath);
    }

    private static void saveDistributorWithBreweries(List<List<String>> distributors,
                                                     List<String> distributor,
                                                     List<List<String>> breweries,
                                                     List<String> brewery,
                                                     String txtFilePath) {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("    Saving Kentucky Distributors with Craft Breweries Report     ");
        System.out.println("=================================================================");
        System.out.println();

        CSVFileWriter.writeFile(distributors, distributor, breweries, brewery, txtFilePath);

    }


} // class Main



