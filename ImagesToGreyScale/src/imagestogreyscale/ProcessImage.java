package imagestogreyscale;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ProcessImage {
    private BufferedImage image;
    private BufferedImage output;
    private File imageAsFile;
    private File outputImage = new File("C:\\Downloads\\TestFolder\\output.png");
    private WritableRaster raster;
    public double[] pixels;
    
    public void convertToGreyscale(String path) throws IOException{
        imageAsFile = new File(path);
        image = ImageIO.read(imageAsFile);    
        raster = image.getRaster();
        
        int width = raster.getWidth();
        int height = raster.getHeight();
        
        //  read into array of pixels 
        double[] preArray = new double[(width * height) * 4];
        pixels = raster.getPixels(0, 0, width, height, preArray);
        
        // pixels = raster.getPixel(0, 0, preArray);
        
        
        // change colors
        
        for (int i = 2; i < pixels.length; i += 4) {
            
            // pixels[i - 3] = 100;
            pixels[i + 1] = 255 - pixels[i];
            
            pixels[i] = 0;
            pixels[i - 1] = 0;
            pixels[i - 2] = 0;
        }
        
        //  create new raster (changed colors)
       
        raster.setPixels(0, 0, width, height, pixels);
        
        // write output
        output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        output.setData(raster);
        
        ImageIO.write(output, "png", outputImage);
        
        
    }
    
    public String readPixelsArray(){
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < pixels.length; i++) {
            builder.append(pixels[i]);
            builder.append(", ");
        }
        
        return builder.toString();
    }
}
