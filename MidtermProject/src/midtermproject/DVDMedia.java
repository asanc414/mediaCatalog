/**

  Title:           Midterm Project: CD & DVD Media 
  Semester:        COP3804 – Spring 2018
  @author          6058389
   Instructor:     C. Charters
  
   Due Date:      03/11/2018

    Description of program, & explanation of programming concept(s) being  applied in program:
    * Read a file with a catalog of CDs or DVDs, and create an ArrayList of media objects with either CDMedia or DVDMedia objects.
    * Implement the Comparable and Comparator interfaces to organize the media objects by mediaName or artistName.
    * Use binarySearch to find the media or the artist given by the user.
    * Add new media to the catalog file.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

/**
 *This is the subclass DVDMedia. It inherits the artistName and mediaName variables from its superclass media and creates a new variable year.
 * It also has its corresponding constructor, setters, getters and toString methods.
 * @author anama
 */
public class DVDMedia extends Media{
    
    private String year;

    public DVDMedia(String year, String artistName, String mediaName) {
        super(artistName, mediaName);
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "D " + super.toString() +  " " + year;
    }
    
    
    
    
    
}
