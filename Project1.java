/**
 * A program that makes a new class called Clock, displays a list of valid clocks in a GUI, and organizes them by the hour
 * @author Michael Boodoosingh (12D)
 * 
 */
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;

public class Project1 {
   
   public static StringTokenizer clockTokens;
   static JFrame clock;
   static StringTokenizer myTokens;
   
   static ClockGUI myGUI;
   
   /**
    * Initializes a GUI while reading the text file. Essential for making the GUI visible at all.
    * @param args In this case, we are using project1.txt as a form of input. This program will be able to read and print the times unless stated otherwise
    * @throws IOException
    */
   public static void main(String[] args) throws IOException {
      
      ClockGUI.initialize(read(args[0]),myGUI);      //We want the textfile to be read already before initializing. 
                                                     //That way, the GUI would already be ready to print the array of clocks

   }
   /**
    * Checks for the valid clocks in the file and places them in a new array. Prints the invalid clocks into the console
    * @param myFile The text file that will be checked
    * @return Returns the array of valid clocks
    */
   public static Clock[] read(String myFile) {
      int amountOfLines = 0;              //The amount of lines used in the file regardless of validity
      int k = 0, newlistSize = 0;         //newListSize is the amount of lines that include a valid clock
      String hour,minute,second;           
      
      
      
      TextFileInput in = new TextFileInput(myFile);     //Necessary for reading each line in the file. This will be the first time doing so in the program
      String line = in.readLine();                      //Starts at the first line

      while(line != null) {                //!= null will indicate that each line read isn't a blank line
         StringTokenizer t = new StringTokenizer(line,":");     //We want to separate the hour,minute, and second values so we use a String tokenizer
         amountOfLines++;                                      
         
         if(t.countTokens() == 3)          //"Is the current line a valid clock? If so, the size of the clock array goes up
            newlistSize++;
          
         line = in.readLine();              //Go down the next line
         
      }
      
      
      Clock [] c = new Clock[newlistSize];  
      
      TextFileInput fileInfo = new TextFileInput(myFile);       //Second time reading the file from top to bottom. 
      String line2 = fileInfo.readLine();                       //This time, we will actually add onto the array

      for(int i = 0; i < amountOfLines; i++) {
         
         StringTokenizer u = new StringTokenizer(line2,":");
         
         if(u.countTokens() == 3) {                             //Once again checks for a valid clock. This time, we assign actual values for the parts of the clock
            
            hour = u.nextToken();                               //First token is hour, Second is minutes, Third is seconds
            minute = u.nextToken();
            second = u.nextToken();
            
            c[k++] = new Clock(hour,minute,second);             //c[k] will consist of the current values of the hour, minute, and second
                                                                //Post increment in order to prevent overwriting the current value of c[k]
         }
         
         else { 
            System.out.println(line2);          //If the line doesn't make for a valid clock, we print it to the console
         }
         
         line2 = fileInfo.readLine();       //next line
         
      } // for
      
      return c;     
   
      
   }
}