package imagestogreyscale;

import java.io.IOException;

public class ImagesToGreyScale {

    public static void main(String[] args) throws IOException {
        ProcessImage image = new ProcessImage();
        String filePath = "C:\\Downloads\\TestFolder\\blind-date-murderer.png";
        
        image.convertToGreyscale(filePath);
        
//        System.out.println(image.pixels.length);
//        
        // System.out.println(image.readPixelsArray());
                
    }
}
