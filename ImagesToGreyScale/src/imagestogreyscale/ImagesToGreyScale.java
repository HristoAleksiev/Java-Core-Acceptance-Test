package imagestogreyscale;

import java.io.IOException;

public class ImagesToGreyScale {

    public static void main(String[] args) throws IOException {
        ProcessImage image = new ProcessImage();
        String filePath = "C:\\Downloads\\TestFolder\\john-romero.jpg";
        
        image.convertToGreyscale(filePath);
    }
}
