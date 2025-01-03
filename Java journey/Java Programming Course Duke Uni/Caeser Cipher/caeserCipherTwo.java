
/**
 * Write a description of class caeserCipher2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class caeserCipherTwo
{   
    private int key1;
    private int key2;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    private String shiftedAlphabetKey1;
    private String shiftedAlphabetKey2;

    public caeserCipherTwo(int k1 , int k2){
        key1 = k1;
        key2 = k2;
        
        //Compute the shipted alphabet with the given key1
        shiftedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        //Compute the shipted alphabet with the given key1
        shiftedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0,key2);

    }
    
    public String EncryptTwo(String inputmessage){
        // the String message is the receieved message we want to encrypt , and the integer key is the encryption key
        StringBuilder encryptedMessage = new StringBuilder(inputmessage);
        
        //System.out.println(" encrypted Alphabet is " +shiftedAlphabet);
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
                if( (i % 2) == 0){
                    System.out.println(" idx of issue is " + idx);
                    char newChar = shiftedAlphabetKey1.charAt(idx);  
                    encryptedMessage.setCharAt(i, newChar);
                }else {
                    char newChar = shiftedAlphabetKey2.charAt(idx);  
                    encryptedMessage.setCharAt(i, newChar);  
                }
            }
            // Do nothing if the character was not found, in that case it's going to be specialCharacter  
        }
        // converting the StringBuilder type EncryptedMessage to String to return it        
        return encryptedMessage.toString();
    }
}
