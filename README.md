# KYCraftBreweriesToDistributors
**_A demonstration package examining the relationship between Kentucky craft breweries and same-city distributors._** 

The intent of this exercise is to demonstrate how to process external files utilizing principles of Object Oriented Programming.

~~~~                                                                       
DATA
~~~~

* The brewery data was collected from the Brewers Association website* and contains the brewery name, physical address, and phone number.

* A subset of the Department of the Treasury's alcohol distributors database was extracted to create a data file of Kentucky alcohol distributors. The federal permit number, owner name, operating name if applicable, and physical address are included in this file.

~~~~
PROCESS
~~~~

1. Two external data files are read into memory. 
2. The user selects a menu option.
3. A report is generated based on city data contained in the two external data files.
4. Based on user input, the report is either displayed on the console or written to a third file for later use.

~~~~
MENUS
~~~~
After the files are read into memory, a console menu instructs the user to choose from the following options: 
1. Display brewery information with same-city distributors,
2. Display distributor information with same-city breweries,
3. Save a brewery-to-distributor report,
4. Save a distributor-to-brewery report,
0. Exit.
~~~~
REFERENCES
~~~~

* (https://www.brewersassociation.org/directories/breweries/?location=KY)
** (https://www.ttb.gov/foia/xls/frl-alcohol-wholesalers-ks-to-me.htm)

 
