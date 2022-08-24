public class Clock {
   private String hour;
   private String minute;
   private String second;
   
   /**
    * A new data type that will take three strings for the hour, minute, and second
    * We want the parameters to be String since we are using a list from an external source (project1.txt)
    * 
    * @param h Hour
    * @param m Minute
    * @param s Second
    */
   public Clock(String h, String m, String s) {
      hour = h;
      minute = m;
      second = s;
   }
   
   /**
    * Overloads the already existing toString method to allow any Clock convert to a String
    * We cannot append or print any clocks without this function
    * @param h Hour
    * @param m Minute
    * @param s Second
    * @return We will return the String in the same format as the times on the list (HH:MM:SS)
    */
   public String toString(String h, String m, String s) {
      String time;
      
      time = h + ":" + m + ":" + s;
      
      
      return time;
   }
   
   
   //In case we want to find a particular value for a clock like the hour or seconds, we can use the get functions. Likewise, if we want to change a value 
   //for a particular clock, we use the set functions
  
   /**
    * Get the current hour of the Clock
    * @return Current hour
    */
   public String getHour() {                        
      return hour;
   }
   
   /**
    * Get the current minute of the Clock
    * @return Current minute
    */
   public String getMinute() {
      return minute;
   }
   
   /**
    * Get the current hour of the Clock
    * @return Current second
    */
   public String getSecond() {
      return second;
   }
    
   /**
    * Set the hour of a clock to something new
    * @param h The new hour value the clock will possess
    */
   public void setHour(String h) {
       hour = h;
   }
    
   /**
    * Set the minutes of the clock to something new
    * @param m The new minute value the clock will possess
    */
   public void setMinute(String m) {
       minute = m;
   }
    
   /**
    * Set the seconds of the clock to something new
    * @param s The new second value the clock will possess
    */
   public void setSecond(String s) {
       second = s; 
   }
   
 

}
