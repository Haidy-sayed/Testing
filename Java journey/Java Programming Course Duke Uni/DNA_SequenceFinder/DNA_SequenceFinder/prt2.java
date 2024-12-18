
/**
 * Write a description of part2 here.
 * 
 * @author (Haidi Sayed) 
 * @version (15/12/2024)
 */
public class prt2{

    public String findAGene (String dna, String startCodon, int start){
        String seq = "";
        int startIndx = dna.indexOf(startCodon , start);
        System.out.println("start at " + startIndx);
        
        int TAAindx = findStopCodon( dna, "taa" , startIndx);
        System.out.println("TAA index is " +TAAindx);
        int TGAindx = findStopCodon( dna, "tga" , startIndx);
        System.out.println("TGA index is " +TGAindx);
        int TAGindx = findStopCodon( dna, "tag" , startIndx);
        System.out.println("TAG index is " +TAGindx);
        int smallestIndx = -1;
        if (TAAindx == -1 || (TGAindx != -1 && TGAindx < TAAindx)){
            smallestIndx = TGAindx;
        }else {
            smallestIndx = TAAindx;
        }
        if (smallestIndx == -1 || (TAGindx != -1 && TAGindx < smallestIndx)){
            smallestIndx = TAGindx;
        }
        
        if (smallestIndx == -1 ){
            return seq;
        }else {
            seq = dna.substring(startIndx , smallestIndx+3);
        }
        
        return seq;
    }
    
    public void findAllGenes (String dna, String StartCodon){
        String geneSeq = "";
        int startIndex = 0;
        
        while (true){
            geneSeq = findAGene(dna, "atg" , startIndex);
            
            if( geneSeq.isEmpty()){
                break;
            }else{
                System.out.println("Gene is " + geneSeq);
                startIndex = dna.indexOf(geneSeq,startIndex) + geneSeq.length();
            }
        }
        
        
    }
    
    public int findStopCodon(String dna , String stopCodon, int startIndx){
        int currIndx = -1;
        
        if (startIndx >= 0){
             currIndx = dna.indexOf(stopCodon , startIndx+3);
            //System.out.println("stop at " + currentIndx);
            while (currIndx != -1){
                if ( (((currIndx - startIndx) +3)%3) == 0 ){
                    return currIndx;
                }else{
                currIndx = dna.indexOf(stopCodon , currIndx+1);
                    }
            }
            
        }
        return currIndx;
    }
    
    public void testSimpleGene (){
        // all good dna ex1
        String dna = "acatggtatcgttccaatgggagtaacaacaatccgcgatgacgttgcgcgtcaacgttacgttaatgttggaattgctttaacagccccacatagatagaga";
        String startCode ="atg";
        //String stopCode = "taa";
        System.out.println("DNA seqence is " + dna);
        //System.out.println("Gene seqence is ");
        findAllGenes(dna,startCode);
        //no TAA ex2
        dna = "ctttgagtccggacgtgaccccgaggttacctatgtgactattcggggcg";
        
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findAGene(dna,startCode, 0));
        // no ATG  ex3
        dna = "gcgcgcatagcgcctccttcagcggctgaacatccaccatacgggctgcttcagccccacatagatagaga";
        
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findAGene(dna,startCode, 0));
        
        // ATG , TTA good, not a multiple of 3
        dna = "tccgcgatgacgttgcgcgtcaacttgaagtttatgttggaat";
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findAGene(dna,startCode, 0));
        
        // ATG , TTA good, far multiple of 3
        dna = "tccgcgatgacgttgcgcgtcaacgttaagttaatgttggaattgctttaacagccccacatagatagaga";
        System.out.println("DNA seqence is " + dna);
        System.out.println("Gene seqence is " + findAGene(dna,startCode, 0));
        
        
    
    }
}
