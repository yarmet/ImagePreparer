package imageutils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by ruslan-PC on 10.01.2017.
 */
public class ImageUtils {

    private static String OUTPUT_IMAGE_FORMAT = "jpg";


    public static BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public static void saveImage(String fileName, BufferedImage bufferedImage) throws IOException {
        File outputfile = new File(fileName.concat(".").concat(OUTPUT_IMAGE_FORMAT));
        ImageIO.write(bufferedImage, OUTPUT_IMAGE_FORMAT, outputfile);
    }


    public static BufferedImage convertToBlackAndWhite(BufferedImage bufferedImage, int threshold) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++) {
                int rgb = bufferedImage.getRGB(i, j);
                int red = (rgb) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = (rgb >> 16) & 0xFF;
                double luminance = (0.299 * red + 0.0f + 0.587 * green + 0.0f + 0.114 * blue + 0.0f);
                Color resultColor = luminance > threshold ? Color.WHITE : Color.BLACK;
                bufferedImage.setRGB(i, j, resultColor.getRGB());
            }
        return bufferedImage;
    }


}
