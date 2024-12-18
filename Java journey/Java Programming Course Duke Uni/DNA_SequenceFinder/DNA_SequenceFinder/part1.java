
/**
 * Write a description of part2 here.
 * 
 * @author (Haidi Sayed) 
 * @version (18/12/2024)
 */
import edu.duke.*;
import java.io.File;
public class part1{

    public String findAGene (String dna, String startCodon, int start){
        String seq = "";
        int startIndx = dna.indexOf(startCodon , start);
        System.out.println("start at " + startIndx);
        
        int TAAindx = findStopCodon( dna, "TAA" , startIndx);
        System.out.println("TAA index is " +TAAindx);
        int TGAindx = findStopCodon( dna, "TGA" , startIndx);
        System.out.println("TGA index is " +TGAindx);
        int TAGindx = findStopCodon( dna, "TAG" , startIndx);
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
    
    public StorageResource findAllGenes (String dna, String StartCodon){
        String geneSeq = "";
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        int genesCount = 0;
        
        while (true){
            geneSeq = findAGene(dna, "ATG" , startIndex);
            
            if( geneSeq.isEmpty()){
                break;
            }else{
                genesCount++;
                geneList.add(geneSeq);
                startIndex = dna.indexOf(geneSeq,startIndex) + geneSeq.length();
            }
        }
        
        System.out.println("# of genes is " + genesCount);
        return geneList;
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
    
    public int findOccurances(String letter, String dna){
        int count =0;
        int index = 0;
        while(true){
            index = dna.indexOf(letter, index); //"acatggtatcgttccaatgggagtaacaacaatccgcgatgacgttgcgcgtcaacgttacgt";
            if(index == -1){
                break;
            }else {
                count++;
                index++;
            }
        }
        
        return count;
    }
    
    public double cgRatio(String dna){
        double ratio = 0.0;
        int countC = findOccurances("C" , dna);
        int countG = findOccurances("G" , dna);
        ratio = countC+countG;
        
        return (ratio / dna.length());
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
    
    public void testGenericFindAllGenes(){
        // all good dna ex1
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();

        String startCode ="ATG";
        //String stopCode = "taa";
        System.out.println("DNA seqence is " + dna);
        //System.out.println("Gene seqence is ");
        StorageResource genes = new StorageResource();
        genes =findAllGenes(dna,startCode);
        for (String s : genes.data()){
            System.out.println("Gene is " + s);
        }
        double ratio = cgRatio(dna);
        System.out.println("CG ratio is " + ratio);
        
        processGenes(genes);
        
        int CTGcount = findOccurances("CTG" , dna);
        System.out.println("CTG occurances are " + CTGcount);
        
    }
    
    
    public void processGenes(StorageResource sr){
        int genesLongerThan9Count=0;
        int genesWithCGRatioCount=0;
        int longestgeneFlag = 0 ;
        
        for(String gene : sr.data()){
            if(gene.length() > 60 ){
                genesLongerThan9Count++;
                System.out.println("Gene longer than 9 charachters is " + gene);
                if(gene.length() > longestgeneFlag){
                    longestgeneFlag = gene.length();
                }
            }
            
            if(cgRatio(gene) > 0.35){
                genesWithCGRatioCount++;
                System.out.println("Gene with C-G ratio is " + gene);
            }
        
        }
        System.out.println("Count of genes longer than 9 = " + genesLongerThan9Count);
        System.out.println("Count of genes with C-G ratio more than 0.35 = " + genesWithCGRatioCount);
        System.out.println("longest gene is " + longestgeneFlag + " characters in length");
    
    }
}
