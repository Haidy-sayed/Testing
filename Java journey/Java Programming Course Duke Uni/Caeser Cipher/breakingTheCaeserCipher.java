
/**
 * A code to break the caeserCipher [Workinnnnnnnnnnnnnnnnnnnnnnng] :)
 *
 * @author Haidi Sayed
 * @version 22nd of Dec. 2024
 */

import java.io.*;
import edu.duke.*; 

public class breakingTheCaeserCipher
{   
    
    public String breakCaeserCipher(String Encrypted){
        
        
        // initiating an ineteger array to store the occurances of each letter from the given encrypted message
        int[] lettersOccurances = countLetters(Encrypted);
        // finding the most occuring letter's indx
        int maxIdx = maxIndex(lettersOccurances);
        //subtracting the position in the alphabet from the eth position that is the 4th as e is the most occuring letter of the English language
        int deckey = 0;
        if ( maxIdx <= 4 ) {
            deckey = 4-maxIdx;
        }else{
            deckey = 26 - (maxIdx -4);
        }
        // making an instance of the caeseCipherClass
        caeserCipher cc = new caeserCipher(deckey);
        System.out.println("key is " + deckey);
        
        return cc.encrypt(Encrypted);
    }
    
    
    
    private int maxIndex( int[] occurances){
        int max = 1; 
        
        for(int k =1; k< occurances.length ; k++){
            if( occurances[max] < occurances[k]){
                max = k;
            }
        } 
        System.out.println("max idx is " + max);
        
        return max;
    }
    
    public int[] countLetters(String EncryptedMessage){
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];

        for(int i = 0; i< EncryptedMessage.length() ; i++){
            char letter = Character.toLowerCase(EncryptedMessage.charAt(i));
            int idx = Alphabet.indexOf(letter);
            if(idx != -1){
                count[idx] +=1;
                
            }
            
        }
        
        return count;
    }
    
    /*public void test(){
        FileResource fr = new FileResource();
        String EncryptedMessage = fr.asString();
        
        String dec = breakCaeserCipher(EncryptedMessage);
        System.out.println("Encryptes \t : \t " + EncryptedMessage + "\t" + "Decrypted \t : \t" + dec);
    }*/
    
}
