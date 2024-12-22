
/**
 * Write a description of class caeserCipherProject here.
 *
 * @author Haidi Sayed
 * @version 20th of December 2024
 */

import java.io.*; 

public class caeserCipher
{
    public String caeserCipherEncryption(String inputmessage , int key){
        // the String message is the receieved message we want to encrypt , and the integer key is the encryption key
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encryptedMessage = new StringBuilder(inputmessage);
        //Compute the shipted alphabet with the given key
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
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
    
    public String caeserCipherEncryptionWith2Keys(String inputmessage , int key1, int key2){
        // the String message is the receieved message we want to encrypt , and the integer key is the encryption key
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encryptedMessage = new StringBuilder(inputmessage);
        //Compute the shipted alphabet with the given key1
        String shiftedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        //Compute the shipted alphabet with the given key1
        String shiftedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        //System.out.println(" encrypted Alphabet is " +shiftedAlphabet);
        // For loop to look through the charachters and encrypt them
        for( int i =0; i <encryptedMessage.length() ; i++){
            //getting the charchters one at a time and storing them in the character variable currChar
            char currChar = encryptedMessage.charAt(i);
            //converting any lower case to upper case because my reference is uppercase
            currChar= Character.toUpperCase(currChar);
            // getting the index of the charachter from the normal alphabet 
            int idx = alphabet.indexOf(currChar);
            char newChar;
            if( idx != -1){
                // getting the shifted character and storing it in the currChar
                if( (i % 2) == 0){
                    newChar = shiftedAlphabetKey1.charAt(idx);  
                    encryptedMessage.setCharAt(i, newChar);
                }else {
                    newChar = shiftedAlphabetKey2.charAt(idx);  
                    encryptedMessage.setCharAt(i, newChar);  
                }
            }
            // Do nothing if the character was not found, in that case it's going to be specialCharacter  
        }
        // converting the StringBuilder type EncryptedMessage to String to return it        
        return encryptedMessage.toString();
    }
    
    public void tester(){
        String message = "I am so excited to be divorced because i was pissed and disappointed my entire marriage period";
        System.out.println("Original Message is " + message);
        int key = 15;
        String Encmessage = caeserCipherEncryption(message , key);
        System.out.println("Encrypted Message is " + Encmessage);
        //key = 26-15;
        
        String Decmessage = caeserCipherEncryption(Encmessage , 26-key);
        System.out.println("Decrypted Message is " + Decmessage);
        
        int key2 = 11;
        Encmessage = caeserCipherEncryptionWith2Keys(message , key , key2 );
        System.out.println("Encrypted Message with 2 keys is " + Encmessage);
        
        Decmessage = caeserCipherEncryptionWith2Keys(Encmessage , 26-key , 26-key2 );
        System.out.println("Deccrypted Message with 2 keys is " + Decmessage);
        
        
    }
}

