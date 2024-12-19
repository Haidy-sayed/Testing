
/**
 * Write a description of class imageSaver here.
 *
 * @author Haidi Sayed
 * @version December, 19th , 2024
 */
import edu.duke.*;
import java.io.*;

public class imageSaver
{
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        
        for( File f : dr.selectedFiles()){
            ImageResource img = new ImageResource(f);
            String fName = img.getFileName();
            String newName = "gray-"+fName;
            img.draw();
            img = Convert2Gray(img);
            img.setFileName(newName);
            img.save();
            img.draw();
        
        }
        
    }
    
    public ImageResource Convert2Gray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth() , inImage.getHeight());
        
        for( Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX() , pixel.getY());
            int Avg = ( inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen() )/ 3 ;
            
            //Setting the outImage pixels' values into the newley calculated inImage Average
            pixel.setRed(Avg);
            pixel.setBlue(Avg);
            pixel.setGreen(Avg);
        }
        return outImage;
    }
}
