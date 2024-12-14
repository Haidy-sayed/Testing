package defaultpac;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perimeter_calculator {


	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Hello!!!, please insert the count of points you want calculations for!");
		int num_pts = myObj.nextInt();
		
		ArrayList<ArrayList<Integer>> xs = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ys = new ArrayList<Integer>();

		for (int i=0; i<num_pts;i++) {
			int j=0;
			System.out.println("Please insert the x co-ordinate of the "+ i + "th point");
			while(j<2) {
				ys.add(myObj.nextInt());
				System.out.println("Please insert the y co-ordinate of the "+ i + "th point");
				ys.add(myObj.nextInt());
				
				j++;

			}
			xs.add(ys);
			
		}
		
		System.out.println("size of pts is " + xs.size());
		
	}

}
