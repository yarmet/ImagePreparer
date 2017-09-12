package algorithms;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ruslan-PC on 10.01.2017.
 */
public class SimpleConverter implements ImageUtil {


    @Override
    public void convert(BufferedImage img) {
        throw new UnsupportedOperationException("method is not supported in this algorithm");
    }

    @Override
    public void convertWithThreshold(BufferedImage bufferedImage, int threshold) {
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
    }
}
