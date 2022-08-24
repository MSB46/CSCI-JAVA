import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.StringTokenizer;

import javax.swing.JFrame;


public class ClockGUI extends JFrame {
   
   static JFrame clock;
   public static StringTokenizer clockTokens;
   /**
    * @param list The array of clocks that will be referred to and printed
    * @param gui The GUI that will be brought out
    */
   public static void initialize(Clock[] list, ClockGUI gui) {
      clock = new ClockGUI();
      TextArea clockList = new TextArea();
      TextArea clockOrder = new TextArea();                 //We want to create two TextAreas for our layout.
      Container myContentPane = clock.getContentPane();
      
          
      clock.setLayout(new GridLayout(1,2));                 //Grid Layout of 1 row and 2 columns (clockList and clockOrder)
      
      clock.setSize(600, 400);
      clock.setLocation(100, 100);
      clock.setTitle("Clock");
      clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      
      myContentPane.add(clockList);
      myContentPane.add(clockOrder);                    //Allows each TextArea to appear on one of the columns

      
      Clock [] ordered = new Clock[list.length];        //We make a new Clock array that will represent the array of clocks given in ordered form
                                                        //The size will represent the amount of valid clocks inside the array which is list.length
      for(int i = 0; i < list.length; i++) {
         
         ordered[i] = list[i];                          //We should first put each value inside the newly made array. We will change the order later
         clockList.append(list[i].toString(list[i].getHour(), list[i].getMinute(), list[i].getSecond())+"\n");  
         //Display each clock inside the array. 
         //We convert the current clock represented to the overloaded toString function (3 parameters of hour,minute,second) in order the properly display the time.
         //Because the hour, minute, and second values are private, we use a get function for each of them as parameters
         
      }
      
      selectionSort(ordered,ordered.length);
      
      for(int i = 0; i < ordered.length; i++) 
         clockOrder.append(ordered[i].toString(ordered[i].getHour(), ordered[i].getMinute(), ordered[i].getSecond())+"\n");


      clock.setVisible(true);   //sets visibility to the updated GUI
         

   }

   private static void selectionSort(Clock[] array, int length) { 
      
      
      for ( int i = 0; i < length - 1; i++ ) { 
         int indexLowest = i;                   //The lowest index will start at the last possible spot in order to properly compare to the indexes before it
      
         for ( int j = i + 1; j < length; j++ ) {         

            if (Integer.parseInt(array[j].getHour()) <  Integer.parseInt(array[indexLowest].getHour()) )               //If the newest index value is lower than the recorded lowest
               indexLowest = j;
         
            if (Integer.parseInt(array[j].getHour()) == Integer.parseInt(array[indexLowest].getHour()) ) {
            
               if(Integer.parseInt(array[j].getMinute()) < Integer.parseInt(array[indexLowest].getMinute()) )          //If Hours are equal but minutes are not
                  indexLowest = j;
         
               if(Integer.parseInt(array[j].getMinute()) == Integer.parseInt(array[indexLowest].getMinute()) )         //If Minutes (and hours) are equal but seconds are not

                  if(Integer.parseInt(array[j].getSecond()) < Integer.parseInt(array[indexLowest].getSecond()) )
                     indexLowest = j;
            }
         
         
      }//for j
      
      if ( array[indexLowest] != array[i] ) { 
         Clock temp = array[indexLowest];
         array[indexLowest] = array[i]; 
         array[i] = temp;
         
      } 
     } // for i 
      
      
   } // method selectionSort 

} //ClockGUI