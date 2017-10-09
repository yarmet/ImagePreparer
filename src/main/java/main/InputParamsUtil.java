package main;

import java.io.File;
import java.util.Scanner;


public class InputParamsUtil {


    public static InputParams obtain() {

        String algoType;
        int threshold = 0;
        String inputImagePath;

        Scanner scanner = new Scanner(System.in);

        algoType = obtainAlgoName(scanner);

        if (algoType.equals(Commands.SIMPLE)) {
            threshold = obtainThresholdValue(scanner);
        }

        inputImagePath = obtainInputImagePath(scanner);

        return new InputParams(algoType, threshold, inputImagePath);
    }


    private static String obtainInputImagePath(Scanner scanner) {
        String inputImagePath = null;
        boolean askAgain = true;

        do {
            System.out.println("enter path to image");
            String inputLine = scanner.nextLine();

            if (inputLine.equals(Commands.EXIT)) System.exit(0);

            File f = new File(inputLine);
            if (f.exists() && !f.isDirectory()) {
                inputImagePath = inputLine;
                askAgain = false;
            } else {
                System.out.println("file not found");
            }
        } while (askAgain);

        return inputImagePath;
    }


    private static int obtainThresholdValue(Scanner scanner) {
        boolean askAgain = true;
        int threshold = 0;

        do {
            System.out.println("enter threshold value");
            String inputLine = scanner.nextLine();

            if (inputLine.equals(Commands.EXIT)) System.exit(0);

            try {
                threshold = Integer.parseInt(inputLine);
                if (threshold > 255 || threshold < 0) throw new NumberFormatException();
                askAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("value not correct");
            }
        } while (askAgain);

        return threshold;
    }


    static String obtainAlgoName(Scanner scanner) {
        boolean askAgain = true;
        String algoType = null;

        do {
            System.out.println("enter algo type [simple, otsu, bradley]");
            String inputLine = scanner.nextLine();

            if (inputLine.equals(Commands.SIMPLE) || inputLine.equals(Commands.OTSU) || inputLine.equals(Commands.BRADLEY)) {
                algoType = inputLine;
                askAgain = false;
            } else if (inputLine.equals(Commands.EXIT)) {
                System.exit(0);
            } else {
                System.out.println("algo name's not correct");
            }
        } while (askAgain);

        return algoType;
    }

}
