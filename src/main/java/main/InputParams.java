package main;

public class InputParams {

    private String algoName;
    private int thresHold;
    private String pathToImage;

    public InputParams(String algoName, int thresHold, String pathToImage) {
        this.algoName = algoName;
        this.thresHold = thresHold;
        this.pathToImage = pathToImage;
    }


    public String getAlgoName() {
        return algoName;
    }

    public int getThresHold() {
        return thresHold;
    }

    public String getPathToImage() {
        return pathToImage;
    }
}
