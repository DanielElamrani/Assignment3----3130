package assignment3;


public class Node {
    protected String movieKey; //this is our key
    protected String year; // this is our data
    protected Node leftChild; //binary trees have 2 children. a left and right child stems from each parent
    protected Node rightChild;
    
    
    public Node(String movieKey, String year){
        
        this.movieKey = movieKey;
        this.year= year;
        
    }
    
    //toString that can be called should I want the year included in my report I print
    public String toString(){
        return movieKey + " released in " + year; 
    }
    
    
    
    
    
    
    
    
    
}
