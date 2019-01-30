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

import java.util.Comparator;

/**
 *This ComparatorByArtistName class implements the Comparator interface, which allows the user to organize the objects by artistName.
 * @author anama
 */
public class ComparatorByArtistName implements Comparator<Object>{
    
    public int compare(Object obj1, Object obj2)
    {
        Media media1 = (Media) obj1;
        Media media2 = (Media) obj2;
        return media1.getArtistName().compareToIgnoreCase(media2.getArtistName());
    }
    
}
