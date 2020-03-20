/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;


import java.util.*;
import java.io.*;

public class Assignment3 {

    
    public static void main(String[] args) throws IOException {
        
        //passing in file with command line arguments, if none are passed, program exits
        if(args.length <= 0){
            System.exit(1);
        }
            
        //Create file and its pathway
        String fileName = args[0];
            
        
        //My old path
        //String fileName = "C:\\Users\\Admin\\Desktop\\3130 Assingments\\data for assignment 3\\movie data.csv";
        
        //Create file 
        File inputData = new File(fileName);
       
        
        //create scanner
        Scanner sc = new Scanner(inputData);
        
        
        //String that will hold the value from each line of our data.
        String line="";
        
        
        //This is the 2D array we will be putting all of our input data into.
        String[][] allDataArr = new String[9742][3]; 
        
        //this will be used in our for loop to place the data into the correct array indices
        int allDataArrRowIndex = 0;
        
        //While loop to read in our data and place into our 2D array
        while (sc.hasNextLine()){
            
            //This String holds a line of our data
            line = sc.nextLine();
            
            
            //This String array will take our line and split it up by the delimiter "," and place everything into between the commas into an array index
            String[] results = line.split(",");
            
            //This for loop takes our String array which has 3 elements, as there are 3 pieces of data in each line separated by commas,
            //and places them into our 2D array in a grid like fashion.
            for (int i = 0; i<3; i++){
                
                allDataArr[allDataArrRowIndex][i] = results[i];
                
            }
            
            //We use this variable to increment the row as we know we have 3 columns of data and only the row will be changing continusouly for each iteration.
            allDataArrRowIndex++;
    
        }//Exit while loop
        
        //putting the movie data into this array list
        ArrayList<String> allDataArrList = new ArrayList<String>();
        
        //This for loop will take our movie column and add it to our arraylist
        for (int i = 0; i<9742;i++){
            
         
          allDataArrList.add(allDataArr[i][1]);
        
        }
        
        //separating the year from the movie title
        ArrayList<String> movieArrList = new ArrayList<String>();
        ArrayList<String> yearArrList = new ArrayList<String>();
        
        //this loops for each line of data
        for (int i = 0; i<allDataArrList.size();i++){
            
            //this loops for each character in each line of data
            for(int a = 1; a<allDataArrList.get(i).length(); a++){
                
                //I look for a ( and then I look for a number after the parantheses. This tell me that I've hit where the year is located. Once I know that I can extract what I want
                if (allDataArrList.get(i).charAt(a)=='(' && Character.isDigit(allDataArrList.get(i).charAt(a+1))){
                    
                    //I add the year to an arraylist and I add the movie title to an array list
                    yearArrList.add(allDataArrList.get(i).substring(a+1, a+5));
                    movieArrList.add(allDataArrList.get(i).substring(0, a-1));
                    
                    
                }
            
            }
            
        }
        
        //I instantiate my BinarySearchTree object
        BinarySearchTree movieBST = new BinarySearchTree();
        
        //I add to my Binary Sear Tree from the movieArrList
        for (int i = 0; i<yearArrList.size(); i++){
            
            movieBST.addMovie(movieArrList.get(i), yearArrList.get(i));
            
        }
        

        
        System.out.println("First search");
        System.out.println();
        BinarySearchTree.subSet(movieBST.root, "Casino", "GoldenEye");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Second search");
        System.out.println();
        BinarySearchTree.subSet(movieBST.root, "Jade", "Street Fighter");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Third search");
        System.out.println();
        BinarySearchTree.subSet(movieBST.root, "Blockers", "Eichmann");
        
        
    }
    
}
