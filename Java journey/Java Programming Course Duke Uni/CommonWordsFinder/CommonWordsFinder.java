/**
 * A program that reads a number of files and find the count of a given set of common words
 *
 * @author Haidi Sayed
 * @version 22/12/2024
 */

import edu.duke.*;

public class CommonWordsFinder
{   
    
    public String[] getCommon(){
    FileResource resource = new FileResource("data/common.txt");
    String[] common = new String[20];
    int index = 0;
    for(String s : resource.words()){
        common[index] = s;
        index += 1;
    }
    return common;
    }
    
    
    public int indexOf(String[] commonWords , String word){ // returning the index of the word if found, and -1 if not found
        
            for( int j=0; j<commonWords.length ; j++){
                if(commonWords[j].equals(word)){
                    return j;
                }
            }
        return -1;
    }
    
    public void countWords(FileResource file , String[] commonWords , int[] counter){
        for(String word : file.words()){
        word = word.toLowerCase();
        int index = indexOf(commonWords,word);
        if (index != -1) {
            counter[index] += 1;
        }
    }
    }
    
    
    public void countShakespere(){
        //reading the given texts
        String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
            "likeit.txt", "macbeth.txt", "romeo.txt"};
        // reading the common words file
        String[] common = getCommon();
        // initializing the counters
        int[] counter = new int[common.length];
        // looping to find the common words and update their recpective counters
        for ( int k =0; k< plays.length ; k++){
            // reading the play
                FileResource resource = new FileResource("data/" + plays[k]);
                countWords(resource,common,counter); 
                System.out.println("done with " + plays[k]);
        }
        
        for(int k=0; k < common.length; k++){
            System.out.println(common[k] + "\t" + counter[k]);
        }

    }
}
