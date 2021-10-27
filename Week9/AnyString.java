public class AnyString {

    private String storedStringValue;
    
    public AnyString(String storedStringValue) {
        this.storedStringValue = storedStringValue;
    }
    public String getString(){
        return this.storedStringValue;
    }
    public String lowercase(){
        return this.storedStringValue.toLowerCase();
    }
    public String uppercase(){
        return this.storedStringValue.toUpperCase();
    }
    public int getLength(){
        return this.storedStringValue.length();
    }
}
