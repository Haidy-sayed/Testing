
/**
 * Write a description of part1 here.
 * 
 * @author (Haidi Sayed) 
 * @version (15/12/2024)
 */
public class part1 {

    public String findSimpleGene (String dna){
        String seq = "";
        int startIndx = dna.indexOf("atg");
        System.out.println("start at " + startIndx);
        if (startIndx >= 0){
            int stopIndx = dna.indexOf("tta" , startIndx+3);
            System.out.println("stop at " + stopIndx);
            if (stopIndx >= 0){
                if ( (((stopIndx - startIndx) +3)%3) == 0 ){
                seq = dna.substring(startIndx , stopIndx+3);
                }
            }
        }
        return seq;
    }
    
    public void testSimpleGene (){
        // all good dna ex1
        String dna = "acatggtatcgttccaatgggagttacaacaa";
        
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findSimpleGene(dna));
        //no TTA ex2
        dna = "ctttgagtccggacgtgaccccgaggttacctatgtgactattcggggcg";
        
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findSimpleGene(dna));
        // no ATG  ex3
        dna = "gcgcgcatagcgcctccttcagcggctgaacatccaccatacgggctgcttcagccccacatagatagaga";
        
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findSimpleGene(dna));
        
        // ATG , TTA good, not a multiple of 3
        dna = "tccgcgatgacgttgcgcgtcaacttgaagtttatgttggaat";
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findSimpleGene(dna));
    
    }
}
