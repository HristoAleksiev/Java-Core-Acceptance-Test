package imagestogreyscale;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ProcessImage {
    private BufferedImage image;
    private BufferedImage outputImage;
    private File imageAsFile;
    private WritableRaster raster;
    private double[] pixels;
    private PictureType pictureType;
    private File outputImageFile;
    
    public void convertToGreyscale(String path) throws IOException{
        readImage(path);
        changeColors();
        writeGreyPicture();
    }
    
    private void readImage(String path) throws IOException{
        imageAsFile = new File(path);
        image = ImageIO.read(imageAsFile);    
        raster = image.getRaster();
        findImageType();
        int width = raster.getWidth();
        int height = raster.getHeight();
        
        //  read into array of pixels 
        double[] preArray = new double[(width * height) * pictureType.multyplier];
        pixels = raster.getPixels(0, 0, width, height, preArray);
    }
    
    private void findImageType(){
        pictureType = new PictureType();
        if (raster.getNumBands() == 3) {
            pictureType.bufferdImageType = 4;
            pictureType.fileType = "jpg";
            pictureType.multyplier = 3;
        }
        else if(raster.getNumBands() == 4){
            pictureType.bufferdImageType = 2;
            pictureType.fileType = "png";
            pictureType.multyplier = 4;
        }
    }
    
    private void changeColors(){
        if (pictureType.bufferdImageType == 2) {
            for (int i = 2; i < pixels.length; i += 4) {
                if (pixels[i + 1] > 250) {
                    pixels[i + 1] = 255 - pixels[i];
                    pixels[i] = 0;
                    pixels[i - 1] = 0;
                    pixels[i - 2] = 0;
                }
                else{
                    pixels[i] = 0;
                    pixels[i - 1] = 0;
                    pixels[i - 2] = 0;
                }
            }
        }
        else if(pictureType.bufferdImageType == 4){
            for (int i = 2; i < pixels.length; i += 3) {
                double grey = (pixels[i] + pixels[i - 1] + pixels[i - 2]) / 3;
                pixels[i - 2] = grey;
                pixels[i - 1] = grey;
                pixels[i] = grey;
            }
        }
    }
    
    private void writeGreyPicture() throws IOException{
        outputImageFile = new File("C:\\Downloads\\TestFolder\\output." + pictureType.fileType);
        
        //  change pixels in raster (changed colors)
        raster.setPixels(0, 0, raster.getWidth(), raster.getHeight(), pixels);
        
        //  write output
        outputImage = new BufferedImage(raster.getWidth(), raster.getHeight(), pictureType.bufferdImageType);
        outputImage.setData(raster);
        ImageIO.write(outputImage, pictureType.fileType, outputImageFile);
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
