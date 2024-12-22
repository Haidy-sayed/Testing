
/**
 * Write a description of class randomDiceRolling here.
 *
 * @author Haidi Sayed
 * @version 22nd of December year of 2024
 */
import java.util.Random;

public class randomDiceRolling
{
    public void randomDiceRoll(int numRoll){
        int [] counters = new int [13];
        // randomizing variable
        Random rand = new Random();
        // for loop to roll numRoll times
        for( int i = 0 ; i < numRoll ; i++){
            int d1 = rand.nextInt(6)+1;
            int d2 = rand.nextInt(6)+1;
            //System.out.println(" Dice 1 is : " + d1 + " Dice 2 is : " +d2);
            counters[d1+d2]++;
        }
        double sum = 0.0;
        for (int k=2; k <=12; k++) {
		    System.out.println(k + "'s=\t" + counters[k] + "\t" + 100.0 * counters[k]/numRoll);
		    sum+= 100.0 * counters[k]/numRoll ;
	}
	
	System.out.println("Total possibilites = " + sum);
    }
}
