CHASE BADALATO
101072570

January 25th 2021

*****************
Assignment 1
*****************

There are 4 classes in this project.

Main:  Calls main function to run threads
Table: Ingredients to make sandwich's get placed and cleared on here
Agent: Creates ingredients and places them on the table
Chef:  Take ingredients from the table to make sandwich's

Program Progression:
1) The program gets run in the main() function.  This function makes a Table
   object, and then creates 4 threads (3 Chef's, 1 Agent) passing the Table 
   object into all threads.

2) The Agent generates 2 random ingredients and attempts to put these ingredients 
   into the table.  If the table already contains ingredients then it will wait
   until the table is free. It will be notified by the table when it is free.
   
3) When the Agent places two ingredients in the table, the table's Hashtable gets updated
   accordingly.  The Hashtable has the three ingredient names as keys.  The value is a boolean value 
   indicating whether the respective ingredient is currently on the table or not.
   
4) The Chef will check if there are any ingredients on the table.  If there are no ingredients on the table
   the thread will wait until there are.  Once ingredients are on the table, the table notifies all
   the threads that there are now ingredients. The Chef will check to see what the ingredients are. 
   This check will make the other Chef threads wait while the current thread checks the ingredients.  If the ingredients
   on the table are the one that the Chef want's then it will take them off the table.  This will cause the 
   tables sandwichCount to increase, and the table will be cleared.  This will notify the Agent that the table is 
   empty, and the process repeats.
   
5) This will continue to happen until 20 sandwich's are made
