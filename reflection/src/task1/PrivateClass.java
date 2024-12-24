package task1;

public class PrivateClass {

    private String mPrivateString = null;

    public PrivateClass(String privateString) {
        this.mPrivateString = privateString;
    }

    private String getPrivateString() {
        return this.mPrivateString;
    }
}
