
/**
 * Write a description of class wordPlay here.
 *
 * @author Haidi Sayed
 * @version 20 december 2024
 */

import java.io.*; 
public class wordPlay
{
    public Boolean isVowel(char ch){
        
        char temp = Character.toLowerCase(ch);
            if( (temp == 'a') || (temp == 'e') || (temp == 'i') || (temp == 'o') ||
            (temp == 'u') ) {
                return true ;
            }
        
        return false;
    }
    
    public String replaceVowel(String phrase , char ch){
        // using stringBuilder to be able to manipulate the String freely
        StringBuilder outPhrase = new StringBuilder(phrase);
        
        for( int i =0 ; i< outPhrase.length() ; i++){
            char temp = outPhrase.charAt(i);
            //System.out.println(" i = " + i + " char = " + temp);
            
            if( isVowel(temp)){ // if the loop comes face to face with a vowel character in the string it'll replace it with [*]
                outPhrase.setCharAt(i , ch);
            }
            
        }
        
        return outPhrase.toString();
    }
    
    public String emphasize(String inPhrase){
        StringBuilder outPhrase = new StringBuilder(inPhrase);
        
            for( int j = 0 ; j < outPhrase.length() ; j++){
                char temp = outPhrase.charAt(j);
                //System.out.println("j is " + j + " char at j is " + temp);
                if( isVowel(temp)){ // if the loop comes face to face with a vowel character in the string it'll check it's index
                    if ( (j%2) == 0 ){ // if the index ogf the vowel is even it replaces it with [*]
                        outPhrase.setCharAt(j , '*');
                        //System.out.println("j inside is " + j);
                    }else { // if the index ogf the vowel is odd it replaces it with [+]
                        outPhrase.setCharAt(j , '+');

                    }
                }
            
            }
    
        return outPhrase.toString();
    }
    
    public void tester(){
        char testCase = 'a' ;
        String result = "FALSE";
        /*if( isVowel(testCase)){
            result = "TRUE" ;
        }
        System.out.println("the testCase is " + testCase + " and the test result is " + result);
        */
        
        //testing the replaceVowel method
        
        String test = "I am so FUcking Frustrated";
        String replaceResult = replaceVowel(test , '*');
        
        String EmphasizeResult = emphasize(test);
        System.out.println("the testCase is " + test + " and the test result is " + EmphasizeResult);
        
    }
    
}
