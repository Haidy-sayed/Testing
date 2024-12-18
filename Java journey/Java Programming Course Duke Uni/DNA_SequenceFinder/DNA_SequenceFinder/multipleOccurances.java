
/**
 * Write a description of multipleOccurances here.
 * 
 * @author (Haidi Sayed) 
 * @version (16/12/2025)
 */
public class multipleOccurances {
    
    public Boolean twoOccurances(String stringb , String stringa){
        // sets a default returnable value into false
        Boolean result = false;
        //System.out.println("stringA is "+ stringa + " -- stringB is "+stringb); 
        // initializing a first occurance index into the index found if not -1
        int firstOccuranceIndx = stringb.indexOf(stringa);
        // testing if there is a first occurance at all
        if( firstOccuranceIndx >= 0){
            // initializing the index for the second occurance 
            int secondOccuranceIndx = stringb.indexOf(stringa , (firstOccuranceIndx+stringa.length()) );
            // testing if there is a second occurance at all
            if (secondOccuranceIndx > 0){
                //result value set to true as there are 2 occurances of stringA in stringB
                result = true;
            }
        }
        
        
    return result;
    }
    
    public String lastPart(String stringb , String stringa){
        String remainingPrt = "";
    
        // initializing a first occurance index into the index found if not -1
        int firstOccuranceIndx = stringb.indexOf(stringa);
        // testing if there is a first occurance at all
        if( firstOccuranceIndx < 0){
            remainingPrt = stringb;
            
        }else{
            remainingPrt = stringb.substring(firstOccuranceIndx+stringa.length() , stringb.length() );
        }
        
        return remainingPrt;
    }
    public void testOccurances(){
        // test case results in true
        String testString = "TQgMZVTxCRipQcFQFjEuCMZVdKHDXpuZj";
        String caseString = "MZV";
        
        Boolean result = twoOccurances(testString , caseString);
        System.out.println("Test String is --> " + testString);
        System.out.println("Looking for ( " + caseString + ") and result is "+ result);
            // yeilds FALSE
         testString = "iDYnKkrycHEhZQuTAuFwMCgaihYxWd";
         caseString = "gaih";
        
         result = twoOccurances(testString , caseString);
        System.out.println("Test String is --> " + testString);
        System.out.println("Looking for ( " + caseString + ") and result is "+ result);
        
        /////////////////////////////////
        
        
        System.out.println("----------------------------------------------------------------------------------------------------------");
        testString = "Yes! Feel free to use any of the random sentences for any project that you may be doing.";
        caseString = "random";
        
        String seq = lastPart(testString , caseString);
        System.out.println("Test String is --> " + testString);
        System.out.println("Looking for (" + caseString + ") and Remaining sequence is "+ seq);
        
    }
}
