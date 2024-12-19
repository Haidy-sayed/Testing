
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
            ImageResource grayimg = new ImageResource(f);
            ImageResource Invertimg = new ImageResource(f);
            String fName = img.getFileName();
            String newName = "gray-"+fName;
            img.draw();
            grayimg = Convert2Gray(img);
            grayimg.setFileName(newName);
            grayimg.save();
            grayimg.draw();
            
            Invertimg = imageInverter(img);
            Invertimg.setFileName("Inverted-"+fName);
            Invertimg.save();
            Invertimg.draw();
        
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
    
    public ImageResource imageInverter(ImageResource inImage){
    ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
    for(Pixel pix : outImage.pixels()){
        Pixel inPix = inImage.getPixel(pix.getX(), pix.getY());
        // calculating the inverted pixel value for red and setting the value for the new image
        int tempInvert = 255 - (inPix.getRed()) ;
        pix.setRed(tempInvert);
        
        // calculating the inverted pixel value for blue and setting the value for the new image

        tempInvert = 255 - (inPix.getBlue()) ;
        pix.setBlue(tempInvert);
        
        // calculating the inverted pixel value for green and setting the value for the new image

        tempInvert = 255 - (inPix.getGreen()) ;
        pix.setGreen(tempInvert);
        
    }
    
    return outImage;
    }
}
