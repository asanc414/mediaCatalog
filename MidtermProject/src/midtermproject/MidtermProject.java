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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author anama
 */
public class MidtermProject {
    
    Scanner kb = new Scanner(System.in);
    ArrayList<Media> myMedia = new ArrayList<Media>();
    String fileName;

    /**
     * Main method calls the methods to read the file, display the media an display the user menu. Depending on the option selected, it calls
     * the methods to search the media or the artist or to add media to the file. It continues looping till the option exit is selected
     */
    public static void main(String[] args) {
        
        int userChoice;
        MidtermProject myMidtermProject = new MidtermProject();
        myMidtermProject.readMedia();
        myMidtermProject.displayMedia();
            do
            {
            userChoice = myMidtermProject.displayMenu();

                switch(userChoice)
                {
                    case 1:
                        myMidtermProject.mediaSearch();
                        break;
                    case 2:
                        myMidtermProject.artistSearch();
                        break;
                    case 3:
                        myMidtermProject.addMedia();
                        break;
                    case 4:
                        System.out.println("Thanks for using the program!");
                        break;
                }
            }
            while(userChoice != 4);
            
        
        
        
        
        // TODO code application logic here
    }
    /**
     * This readMedia method opens a file entered by the user if it is the right file. Then, it loops throughout the file, and reads each of the media elements,
     * which will be stored in their corresponding objects (CD or DVD), and added to the global ArrayList of media objects.
     */
    public void readMedia() {
        
        boolean rightFile = false;
        while(!rightFile)
        {
        try
        {
            System.out.println("Enter catalog2.txt for the name of the file.");
            fileName = kb.nextLine();
            File aFile = new File(fileName);
            Scanner myFile = new Scanner(aFile);
            rightFile = true;
            String aRecord, mediaType, artistName, mediaName, year;

        while(myFile.hasNext())
        {
            aRecord = myFile.nextLine();
            String aRecArray[] = aRecord.split(" ");
            mediaType = aRecArray[0];
            artistName = aRecArray[1];
            mediaName = aRecArray[2];
            ArrayList<String> songs = new ArrayList<String>();
            if (mediaType.equals("C"))
            {
                for(int i = 3; i < aRecArray.length; i++)
                {
                    songs.add(aRecArray[i]);
                }
                Media aCDMedia = new CDMedia(songs, artistName, mediaName);
                myMedia.add(aCDMedia);
            }
            else if (mediaType.equals("D"))
            {
                year = aRecArray[3];
                Media aDVDMedia = new DVDMedia(year, artistName, mediaName);
                myMedia.add(aDVDMedia);
            }
        }   
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Wrong file!!");
        }
        

    }
    }
    /**
     * This displayMedia method sorts the global ArrayList by mediaName and displays each of its elements using a for loop.
     * Then it sorts it again using the ComparatorByArtistName and prints each element in the same way.
     */
    public void displayMedia() {
        
        System.out.println("**********Media by Media Name**********");
        Collections.sort(myMedia);
        for(int i = 0; i < myMedia.size(); i++)
        {
            System.out.println(myMedia.get(i));
        }
        System.out.println("\n***********Media by Artist Name**********");
        Collections.sort(myMedia, new ComparatorByArtistName());
        for(int i = 0; i < myMedia.size(); i++)
        {
            System.out.println(myMedia.get(i));
        }
        
    }
    /**
     * This displayMenu method shows to the user the options to interact with the catalog of media. It returns an int, which is the user choice and validates it.
     */
    public int displayMenu() {
        
        int userChoice = 4;
        boolean correctChoice = false;

        while(!correctChoice)
        {
            try
            {
                System.out.println("\nPlease, select one of the options:"
                + "\n1. Search by Media Title (movie name or album name)"
                + "\n2. Search by Artist (singer or actor)"
                + "\n3. Add media to catalog"
                + "\n4. Quit");

                userChoice = kb.nextInt();
                kb.nextLine();
                if(userChoice >= 1 && userChoice <= 4)
                {
                    correctChoice = true;
                }
                else
                {
                    System.out.println("Wrong Input. Try again!");
                }

            }
            catch(InputMismatchException e)
            {
                System.out.println("Wrong Input. Try again!");
                kb.nextLine();
            }
        }


        return userChoice;

        
    }
    /**
     * This mediaSearch method sorts the global ArrayList by mediaName first. Then, it prompts the user for the name of the media, and uses binarySearch to look for a media match 
     * in the ArrayList. Then it prints the object found using the index returned by the binarySearch method.
     */
    public void mediaSearch() {
        
        try
        {
        Collections.sort(myMedia);
        String userMedia;
        int index;
        System.out.println("What media are you searching for? (Fill all spaces with underscores if necessary)");
        userMedia = kb.next();
        Media searchMedia = new Media("Artist", userMedia);
        index = Collections.binarySearch(myMedia, searchMedia);
        System.out.println(myMedia.get(index));
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Media not found!");
        }
               

    }
    /**
     * This artistSearch method sorts the global ArrayList by artistName first. Then, it prompts the user for the name of the artist, and uses binarySearch to look for an artist match 
     * in the ArrayList. Since there is more than one object with the same artist name in most of the cases, it will loop backwards and forwards the index till it finds a different artist name.
     * This way it prints all the objects with the same artistName.
     */
    public void artistSearch() {
        
        try
        {
        Collections.sort(myMedia, new ComparatorByArtistName());
        String userArtist;
        int index;
        System.out.println("What artist are you searching for? (Fill all spaces with underscores if necessary)");
        userArtist = kb.nextLine();
        Media searchArtist = new Media(userArtist, "media");
        index = Collections.binarySearch(myMedia, searchArtist, new ComparatorByArtistName());
        System.out.println(myMedia.get(index));
        int i = index - 1;
        while( i >= 0 && myMedia.get(i).getArtistName().equals(myMedia.get(index).getArtistName()))
        {
            System.out.println(myMedia.get(i));
            i--;
        }
        i = index + 1;
        while(i < myMedia.size() && myMedia.get(i).getArtistName().equals(myMedia.get(index).getArtistName()))
        {
            System.out.println(myMedia.get(i));
            i++;
        }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Artist not found!");
        }
        
    }
    /**
     * This addMedia method opens the file again. Depending on the type of media the user selects, it will prompt the user for the corresponding info.
     * It will create the corresponding object and will use the toString method of each of them to append the info to the file. Then it closes the file.
     */
    public void addMedia(){
        
        String mediaType, artistName, mediaName, year, song;
        ArrayList<String> songs = new ArrayList<String>();
        boolean moreSongs = true;
        boolean correctInput;
        try
        {
        FileWriter writeFile = new FileWriter(fileName,true);
        PrintWriter printFile = new PrintWriter(writeFile);
        do
        {
        System.out.println("Do you want to add a CD Media or a DVD media? (Enter CD or DVD)");
        mediaType = kb.nextLine();
        if(!mediaType.equalsIgnoreCase("CD")&&!mediaType.equalsIgnoreCase("DVD")){
            System.out.println("Incorrect input. Try again!");
        }
        }
        while(!mediaType.equalsIgnoreCase("CD")&&!mediaType.equalsIgnoreCase("DVD"));
        System.out.println("What is the name of the artist? (Fill all spaces with underscores if necessary)");
        artistName = kb.nextLine();
        System.out.println("What is the name of the media (album or movie)(Fill all spaces with underscores if necessary)");
        mediaName = kb.nextLine();
        if(mediaType.equalsIgnoreCase("CD"))
        {
            do
            {
                System.out.println("What is the name of the song? (Fill all spaces with underscores if necessary)");
                songs.add(kb.nextLine());
                correctInput = false;
                while(!correctInput)
                {
                try
                {
                System.out.println("More songs in the album?(true or false)");
                moreSongs = kb.nextBoolean();
                kb.nextLine();
                correctInput = true;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Incorrect Input!");
                    kb.nextLine();
                    
                }
                }  
            }
            while(moreSongs);
            CDMedia newCD = new CDMedia(songs, artistName, mediaName);
            myMedia.add(newCD);
            printFile.println(newCD);
        }
        else if(mediaType.equalsIgnoreCase("DVD"))
        {
            System.out.println("What is the year of the movie?");
            year = kb.nextLine();
            DVDMedia newDVD = new DVDMedia(year, artistName, mediaName);
            myMedia.add(newDVD);
            printFile.println(newDVD);
        }
        printFile.close();
        }
        catch (IOException e)
        {
            e.getMessage();
        }

        
            

        
    }
    
}
