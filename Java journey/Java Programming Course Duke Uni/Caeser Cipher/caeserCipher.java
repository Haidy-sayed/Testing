
/**
 * Write a description of class caeserCipherProject here.
 *
 * @author Haidi Sayed
 * @version 20th of December 2024
 */

import java.io.*; 

public class caeserCipher
{   
    private String alphabet;
    private String shiftedAlphabet;
    private int decryptKey;
    
    public caeserCipher(int key){
        
        alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    
    }
    
    public String encrypt(String inputmessage){
        // the String message is the receieved message we want to encrypt , and the integer key is the encryption key
        
        StringBuilder encryptedMessage = new StringBuilder(inputmessage);
        //Compute the shipted alphabet with the given key
        
        System.out.println(" encrypted Alphabet is " +shiftedAlphabet);
        // For loop to look through the charachters and encrypt them
        for( int i =0; i <encryptedMessage.length() ; i++){
            //getting the charchters one at a time and storing them in the character variable currChar
            char currChar = encryptedMessage.charAt(i);
            //converting any lower case to upper case because my reference is uppercase
            currChar= Character.toUpperCase(currChar);
            // getting the index of the charachter from the normal alphabet 
            int idx = alphabet.indexOf(currChar);
            
            if( idx != -1){
                // getting the shifted character and storing it in the currChar
                char newChar = shiftedAlphabet.charAt(idx);  
                encryptedMessage.setCharAt(i, newChar);
            }
            // Do nothing if the character was not found, in that case it's going to be specialCharacter  
        }
        // converting the StringBuilder type EncryptedMessage to String to return it        
        return encryptedMessage.toString();
    }
    
    public String decrypt(String Encrypted){
        
        
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
        
        decryptKey = deckey;
        // making an instance of the caeseCipherClass
        caeserCipher cc = new caeserCipher(decryptKey);
        
        //System.out.println("key is " + deckey);
        
        return cc.encrypt(Encrypted);
    }
    
    private int[] countLetters(String EncryptedMessage){
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
    
    private int maxIndex( int[] occurances){
        int max = 1; 
        
        for(int k =1; k< occurances.length ; k++){
            if( occurances[max] < occurances[k]){
                max = k;
            }
        } 
        //System.out.println("max idx is " + max);
        
        return max;
    }
    
}

