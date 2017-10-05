package main;


import algorithms.ImageUtil;
import algorithms.BradlyConverter;
import algorithms.OtsuConverter;
import algorithms.SimpleConverter;

import java.awt.image.BufferedImage;
import java.io.*;


public class Main {

    private static String OUTPUT_FILE_NAME = "output";
    private static String OUTPUT_FILE_NAME_EXTENSION = "png";

    public static void main(String[] args) throws IOException {

        InputParams inputParams = InputParamsUtil.obtain();
        ImageUtil imageUtil = null;

        switch (inputParams.getAlgoName()) {

            case Commands.SIMPLE: {
                imageUtil = new SimpleConverter(inputParams.getThresHold());
                break;
            }

            case Commands.OTSU: {
                imageUtil = new OtsuConverter();
                break;
            }

            case Commands.BRADLEY: {
                imageUtil = new BradlyConverter();
                break;
            }
        }

        BufferedImage bufferedImage = imageUtil.loadImage(inputParams.getPathToImage());
        imageUtil.convert(bufferedImage);
        imageUtil.save(OUTPUT_FILE_NAME, OUTPUT_FILE_NAME_EXTENSION, bufferedImage);
    }

}


