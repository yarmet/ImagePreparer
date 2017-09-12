package algoTypes;

public enum Types {

    simple("simple"), otsu("otsu"), bradley("bradley");


    private final String text;

    Types(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
