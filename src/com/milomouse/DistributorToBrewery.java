package com.milomouse;

import static jdk.nashorn.internal.objects.NativeArray.lastIndexOf;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;

import java.io.IOException;
import java.util.List;

public class DistributorToBrewery {


    public void displayDistributorToBrewery(List<String> distributorRecords, List<String> breweryRecords)
        throws IOException {

        System.out.println(distributorRecords);
        String readLine = readLine("Press any key to continue:  ");
        System.out.println(breweryRecords);
    } // displayDistributorToBrewery


    public void saveDistributorToBrewery(List<String> distributorRecords, List<String> breweryRecords) {


    } // saveDistributorToBrewery

} // class DistributorToBrewery
