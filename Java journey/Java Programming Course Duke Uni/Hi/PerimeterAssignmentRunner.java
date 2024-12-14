import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // get total number of points in a given shape 
            int i = 0;
            for (Point p : s.getPoints()){
                i++;
            }
            
        return i;
    }

    public double getAverageLength(Shape s) {
        // get average lengths of a given shape
        double avgLength = (getPerimeter(s) / getNumPoints(s));
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // get largest side of a given shape
        double largestSide = 0.0;
        Point prevP = s.getLastPoint();
        
        for( Point p : s.getPoints()){
            double dist = p.distance(prevP);
            if( largestSide < dist){
                largestSide = dist;
            }
            prevP = p ;
        }
    
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // get largest X co-ordinate in a given shape
        
        //Point pt = s.getLastPoint();
        double x = s.getLastPoint().getX();
        
        for (Point p : s.getPoints()){
            if( p.getX() > x ){
                x = p.getX();
            }
        
        }
        
        return x;
    }

    public double getLargestPerimeterMultipleFiles() {
        // get largest perimeter of multiple files selected
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if( largestPerimeter < currPerim){
                largestPerimeter = currPerim;
                
            }
        
        }
        
        System.out.println("Largest Perimeter = " + largestPerimeter);
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // get the name of the file with the largest perimeter
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if( largestPerimeter <= currPerim){
                largestPerimeter = currPerim;
                temp = f;
                
            }else {
            
            }
        
        }
        
        System.out.println("Largest Perimeter = " + largestPerimeter);
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        //prints the number of points in the selected file'
        int numPts = getNumPoints(s);
        System.out.println("num of pts = " + numPts);  
        // prints the average lengths in a shape from a selected file 
        double avgLength = getAverageLength(s);
        System.out.println(" Avg Length = " + avgLength);
        // prints the largest side in a shape from a selected file
        double largestSideSameShape = getLargestSide(s);
        System.out.println("largest side = "+ largestSideSameShape);
        
        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);
        
    }
    
    public void testPerimeterMultipleFiles() {
        // calling the getLargestPerimeterMultipleFiles and printing the result
        double parameterMFiles = getLargestPerimeterMultipleFiles();
        System.out.println("Largest parameter of the selected files = "+parameterMFiles);
        
        
    }

    public void testFileWithLargestPerimeter() {
        // printing the name of the file with the largest perimeter
        
        String FName = getFileWithLargestPerimeter();
        System.out.println("File Name with Largest Perimeter is " +FName);
        
        
    }

    
    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        
        pr.printFileNames();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
      
        
    }
}
