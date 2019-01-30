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

import java.util.ArrayList;

/**
 * This is the subclass CDMedia. It inherits the artistName and mediaName variables from its superclass media and creates a new instance variable, which is an ArrayList of Strings named songs.
 * It also has its corresponding constructor, setters, getters and toString methods.
 * @author anama
 */
public class CDMedia extends Media{
    
    private ArrayList<String> songs;

    public CDMedia(ArrayList<String> songs, String artistName, String mediaName) {
        super(artistName, mediaName);
        this.songs = songs;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "C " + super.toString() + " " + songs;
    }
    
    
    
    
    
}
