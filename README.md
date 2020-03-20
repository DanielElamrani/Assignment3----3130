# Assignment3----3130
Daniel Elamrani

I commented pretty heavily throughout my code. Here I will explain my design desicions. The csv file, of course, contained commas
in the movie title column. To solve this issue, I used find and replace and removed the commas. This was a quick and easy solution to the 
problem and worked well. I extracted the movie title column and then placed that into an arraylist.
This of course had the movie year as well so I had to parse through each line and extract the movie title and the year 
and place each in their own respective arraylists. I then created my Binary Search Tree object and added to it by looping through
the arraylists I made. 

Each time I added to the list a node was created. The instance variables for the nodes were movie title which was also our key, year,
Leftchild node and rightchild node. The challenge of this project was figuring out how to add nodes in the appropriate manner and 
subsequently search through them given a specific key range. The search given a key range required recursion to essentially go down the tree
one by one looking for the correct range. The comments in the code explain my thought process well. 
Additionally, files are accepted via command line arguments rather than hard coded in. 
