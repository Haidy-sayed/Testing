/**
 * Write a description of class grayScaleConverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class grayScaleConverter
{
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
    
    
    /*public void test(){
        //Reading an RGB image
        ImageResource ir = new ImageResource();
        // creating a gray-scale version of the read RGB image through calling the Convert2Gray function
        ImageResource grayImage = Convert2Gray(ir);
        grayImage.draw();
    }*/
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
        // creating a gray-scale version of the read RGB image through calling the Convert2Gray function
            ImageResource grayImage = Convert2Gray(ir);
            grayImage.draw();
        }
    }

    
}
