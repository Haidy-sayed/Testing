
/**
 * Write a description of Q1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Q1 {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           System.out.println("index is at " + index );
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           System.out.println("updated index is at " + index);
       }
   }

   public void test() {
    // findAbc("abcd");
    findAbc("abcabcabcabca");
}
}
