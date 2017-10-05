package algorithms;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface ImageUtil {


    void convert(BufferedImage img);




    default void save(String fileName, String extension, BufferedImage bufferedImage) throws IOException {
        File outputfile = new File(fileName.concat(".").concat(extension));
        ImageIO.write(bufferedImage, extension, outputfile);
    }

    default BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }


}
