import bradly.Bradly;
import imageutils.ImageUtils;
import otsu.OtsuConverter;


import java.awt.image.BufferedImage;
import java.io.*;


public class Main {

    static String FILE_NAME = "111.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage img = ImageUtils.loadImage(FILE_NAME);

//        OtsuConverter.convertToBlackAndWhite(img);
//        ImageUtils.convertToBlackAndWhite(img, 120)  ;
        Bradly.convertToBlackAndWhite(img);

        ImageUtils.saveImage("outImage", img);
    }

}


