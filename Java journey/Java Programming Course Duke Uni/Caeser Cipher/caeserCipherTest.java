
/**
 * Write a description of class caeserCipherTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class caeserCipherTest
{
    public void tester(){
        String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        System.out.println("Original Message is " + message);
        int key = 21;
        int key2 = 8;
        caeserCipherTwo cc = new caeserCipherTwo(12 , 2);
        String Encmessage = cc.EncryptTwo(message);
        System.out.println("Encrypted Message is " + Encmessage);
        //key = 26-15;
        
        //String Decmessage = cc.decrypt(Encmessage);
        //System.out.println("Decrypted Message is " + Decmessage);

    }
}
