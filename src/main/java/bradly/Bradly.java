package bradly;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bradly {

    static private double TRESHOLD = 0.85;
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
                toGray(img, x, y, x1, y1);
            }
        }
    }


    private static BufferedImage toGray(BufferedImage img, int x, int y, int x1, int y1) {
        double average = calculateAverageColor(img, x, y, x1, y1);
        for (int i = y; i < y1; i++)
            for (int j = x; j < x1; j++) {
                int rgb = img.getRGB(j, i);
                int red = (rgb) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = (rgb >> 16) & 0xFF;
                double luminance = (0.299 * red + 0.587 * green + 0.114 * blue);
                Color resultColor = luminance > average * TRESHOLD ? Color.WHITE : Color.BLACK;
                img.setRGB(j, i, resultColor.getRGB());
            }
        return img;
    }


    private static double calculateAverageColor(BufferedImage img, int x, int y, int x1, int y1) {
        int pixelsCount = (x1 - x) * (y1 - y);
        double summColor = 0;
        for (int i = y; i < y1; i++)
            for (int j = x; j < x1; j++) {
                int rgb = img.getRGB(j, i);
                int red = (rgb) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = (rgb >> 16) & 0xFF;
                double luminance = (0.299 * red + 0.587 * green + 0.114 * blue);
                summColor += luminance;
            }
        return summColor / pixelsCount;
    }
}
