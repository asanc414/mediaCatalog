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
 * This is the superclass Media that implements the Comparable interface. It has the instance variables artistName and mediaName to be inherited
 * by the subclasses CDMedia and DVDMedia. It also has its corresponding getters and setters, constructors, and toString methods.
 * It overrides the compareTo method to compare the objects by mediaName.
 * @author anama
 */
public class Media implements Comparable<Object> {
    
    private String artistName, mediaName;

    public Media() {
        this.artistName = "";
        this.mediaName = "";
    }  
    
    public Media(String artistName, String mediaName) {
        this.artistName = artistName;
        this.mediaName = mediaName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }
    

    @Override
    public int compareTo(Object t) {
        
        Media aMedia = (Media) t;
        return this.mediaName.compareToIgnoreCase(aMedia.mediaName);

    }

    @Override
    public String toString() {
        return artistName + " " + mediaName;
    }
    
    
    
}
