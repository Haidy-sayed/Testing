
/**
 * Write a description of class wordLengths here.
 *
 * @author Haidi Sayed
 * @version 23rd of Dec. 2024
 */

import edu.duke.*;
import java.util.*;
public class wordLengths
{
    public void countWordLength(FileResource file, int[] counts){
        
        for(String word : file.words()){
            //System.out.println("length of counts array is " + counts.length + "length of word is " + word.length() );
            if( word.length() < counts.length ){
                counts[word.length()] +=1;
                
            }else if ( word.length() >= counts.length){
                counts[counts.length - 1] +=1;
            }
            
        }
        
        for(int i =0 ; i< counts.length ; i++){
            System.out.println("Words of length " + i + " are " + counts[i]);
        }

    }
    
    public void tester(){
        FileResource file = new FileResource();
        int [] letterCounts = new int[50];
        countWordLength(file , letterCounts);
        
        
        
        
    }
}
