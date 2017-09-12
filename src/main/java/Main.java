import algoTypes.Types;
import algorithms.ImageUtil;
import algorithms.BradlyConverter;
import algorithms.OtsuConverter;
import algorithms.SimpleConverter;


import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static algoTypes.Types.bradley;
import static algoTypes.Types.otsu;
import static algoTypes.Types.simple;


public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());


    private static String OUTPUT_FILE_NAME = "output";
    private static String OUTPUT_FILE_NAME_EXTENSION = "png";


    public static void main(String[] args) throws IOException {


        logger.log(Level.INFO , "examples of input commands:\n simple input.jpg 100\n otsu input.jpg\n bradley input.jpg");


        Scanner scanner = new Scanner(System.in);
        String[] commands = scanner.nextLine().split(" ");


        Types algoType = null;
        try {
            algoType = Types.valueOf(commands[0]);
        } catch (IllegalArgumentException e) {
            logger.log(Level.INFO, "imageUtil with name : " + commands[0] + " not found.\n " + "avalaible algo types : " + simple + ", " + bradley + ", " + otsu);
            System.exit(1);
        }


        String path = null;
        try {
            path = commands[1];
            System.out.println(path);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.INFO, "enter the path to the file!");
            System.exit(1);
        }


        BufferedImage bufferedImage;
        ImageUtil imageUtil;


        switch (algoType) {

            case simple: {

                int threshold = 0;
                try {
                    threshold = Integer.valueOf(commands[2]);
                    if (threshold < 0 || threshold > 255) throw new Exception();
                } catch (Exception e) {
                    logger.log(Level.INFO, "if you are using a type of imageUtil \"is simply\" you must specify a threshold value as the third parameter (1-255)");
                    System.exit(1);
                }

                imageUtil = new SimpleConverter();
                bufferedImage = imageUtil.loadImage(path);
                imageUtil.convertWithThreshold(bufferedImage, threshold);
                imageUtil.save(OUTPUT_FILE_NAME, OUTPUT_FILE_NAME_EXTENSION, bufferedImage);
                break;
            }

            case otsu: {
                imageUtil = new OtsuConverter();
                bufferedImage = imageUtil.loadImage(path);
                imageUtil.convert(bufferedImage);
                imageUtil.save(OUTPUT_FILE_NAME, OUTPUT_FILE_NAME_EXTENSION, bufferedImage);
                break;
            }

            case bradley: {
                imageUtil = new BradlyConverter();
                bufferedImage = imageUtil.loadImage(path);
                imageUtil.convert(bufferedImage);
                imageUtil.save(OUTPUT_FILE_NAME, OUTPUT_FILE_NAME_EXTENSION, bufferedImage);
                break;
            }

        }

    }

}


