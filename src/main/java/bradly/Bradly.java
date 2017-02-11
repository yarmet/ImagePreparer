package bradly;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bradly {

    static private float TRESHOLD = 0.85f;
    static private int PIECE = 20;

    public static void convertToBlackAndWhite(BufferedImage img) throws IOException {
        int widthPiece = img.getWidth() / PIECE;
        int heightPiece = img.getHeight() / PIECE;
        for (int i = 0; i < PIECE; i++) {
            for (int j = 0; j < PIECE; j++) {
                int y = i * heightPiece;
                int x = j * widthPiece;
                int y1 = (i + 1) * heightPiece;
                int x1 = (j + 1) * widthPiece;
                toBlackAndWhite(img, x, y, x1, y1);
            }
        }
    }

    private static void toBlackAndWhite(BufferedImage img, int x, int y, int x1, int y1) {
        float averageBright = calculateAverageBright(img, x, y, x1, y1);
        for (int i = y; i < y1; i++)
            for (int j = x; j < x1; j++) {
                float luminance = getPixelBright(img, i, j);
                Color resultColor = luminance > averageBright * TRESHOLD ? Color.WHITE : Color.BLACK;
                img.setRGB(j, i, resultColor.getRGB());
            }
    }


    private static float calculateAverageBright(BufferedImage img, int x, int y, int x1, int y1) {
        int pixelsCount = (x1 - x) * (y1 - y);
        float summPixelsBright = 0;
        for (int i = y; i < y1; i++)
            for (int j = x; j < x1; j++) {
                summPixelsBright += getPixelBright(img, i, j);
            }
        return summPixelsBright / pixelsCount;
    }


    private static float getPixelBright(BufferedImage img, int i, int j) {
        int rgb = img.getRGB(j, i);
        int red = (rgb) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = (rgb >> 16) & 0xFF;
        return 0.299f * red + 0.587f * green + 0.114f * blue;
    }
}
