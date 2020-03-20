/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;


public class BinarySearchTree {
    protected Node root;
    
    
    
    
    public void addMovie(String movieKey, String year){
        
        
        //make a new node
        Node newMovie = new Node(movieKey, year);
        
        //if our root is null just add the newMovie as the root
        if (root == null){
            
            root = newMovie;
        }
        
        else{
            
            //node we use to traverse our tree
            Node traverseNode = root;
            
            //will use this further down
            Node parent;
            
            while(true){
                
                //parebt gets assigned to traverseNode or essenitally our root
                parent = traverseNode;
                
                
                //if the movie key entered when compared with our traverseNode turns out to be less than 0 (meaning the movie key comes before our traverseNode's movie key alphabetically
                //we then know to be checking the left side of the tree
                if(movieKey.compareToIgnoreCase(traverseNode.movieKey)<0){
                    
                    //now we are looking at the left child 
                    traverseNode = traverseNode.leftChild;
                    
                    //if there is no left child 
                    if (traverseNode == null){
                        
                        //we set parents (which points to where traverseNode points) equal to the new Node
                        parent.leftChild = newMovie;
                        return;
                    }
                }
                
                //if we get here it means the moviekey is going on the right side of the tree 
                else{
                    
                    //looking at the right child now
                    traverseNode = traverseNode.rightChild;
                    
                    //if its null
                    if (traverseNode == null){
                        
                        //we set parents right child equal to the new node
                        parent.rightChild = newMovie;
                        return;
                    }
    
                }
                
                
            }
            
            
            
        }
        
    }

    public static void subSet(Node node, String start, String end){
        
        // base case
        if (node == null){
            return;
        }
           
        
        //check the left side of the tree 
        if (start.compareToIgnoreCase(node.movieKey)<0){
            subSet(node.leftChild, start, end);
        }
        
        //if the movie key lies between our range we enter this if
        if (start.compareToIgnoreCase(node.movieKey)<=0 && end.compareToIgnoreCase(node.movieKey)>=0){
            System.out.println(node.movieKey);
        }
        
        //checks the right side of the tree
        if(end.compareToIgnoreCase(node.movieKey)>0){
            subSet(node.rightChild, start, end);
        }
        
        
    }
    
}




