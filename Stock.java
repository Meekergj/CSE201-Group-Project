public class Stock {
    // Define attributes
    private String name;
    private double value;
    private double changeInValue;
    private double amountInvested;

    // Constructors
    /*
     * 
     */
    public Stock(String name, double value) {
        this.name = name;
        this.value = value;
    }

    /*
     * 
     */
    public Stock(String name, double value, double changeInValue, double amountInvested) {
        this.name = name;
        this.value = value;
        this.changeInValue = changeInValue;
        this.amountInvested = amountInvested;
    }

    // Methods
    public double calculateChangeInValue(double initialValue, double currentValue) {
        return (currentValue - initialValue) / initialValue;
    }

    // Getters and Setters
    /*
     * 
     */
    public String getName() {
        return name;
    }

    /*
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * 
     */
    public double getValue() {
        return value;
    }

    /*
     * 
     */
    public void setValue(double value) {
        this.value = value;
    }

    /*
     * 
     */
    public double getChangeInValue() {
        return changeInValue;
    }

    /*
     * 
     */
    public void setChangeInValue(double changeInValue) {
        this.changeInValue = changeInValue;
    }

    /*
     * 
     */
    public double getAmountInvested() {
        return amountInvested;
    }

    /*
     * 
     */
    public void setAmountInvested(double amountInvested) {
        this.amountInvested = amountInvested;
    }    
}
