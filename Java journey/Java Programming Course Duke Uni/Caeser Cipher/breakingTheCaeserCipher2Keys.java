
/**
 * breakingTheCaeserCipher2Keys
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import edu.duke.*; 
public class breakingTheCaeserCipher2Keys
{
    public String cipher2KeysBreaker(String encryptedMessage ) {
        StringBuilder String1st = new StringBuilder();
        StringBuilder String2nd = new StringBuilder();
        // making an instance of the breaking caeser cipher with one key class to use it within this code
        
        
        for(int i = 0; i< encryptedMessage.length() ; i++){ 
            // even indexed letters are stored in the 1st String
            if( (i%2) == 0){
                String1st.append(encryptedMessage.charAt(i));
            }else if ( (i%2) == 1){
                String2nd.append(encryptedMessage.charAt(i));
            }
        }
        
        breakingTheCaeserCipher bCC = new breakingTheCaeserCipher();
        // decrypting the String of the even indexed letters of the iriginal message placed in String1st 
        String decrypted1st = bCC.breakCaeserCipher(String1st.toString());
        // decrypting the String of the odd indexed letters of the iriginal message placed in String2nd 
        String decrypted2nd= bCC.breakCaeserCipher(String2nd.toString());
        
        return unitString(decrypted1st , decrypted2nd) ;
    }
    
    
    public String unitString( String EvenLetters , String OddLetters){
        StringBuilder outMessage = new StringBuilder();
        
        for(int i =0 ; i < (EvenLetters.length()) ; i++){
            if( i < EvenLetters.length() ) {
                outMessage.append(EvenLetters.charAt(i));
            }
            
            if( i < OddLetters.length()){
                outMessage.append(OddLetters.charAt(i));
            }
        }
        
        return outMessage.toString();
    }
    
    public void testBreak2keys(){
        FileResource file = new FileResource();
        String text = file.asString();
        
        String decryptedMessage = cipher2KeysBreaker(text);
        
        System.out.println("Encrypted message is " + text + "\n decrypted Message is " + decryptedMessage);
    }
}
