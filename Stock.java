import java.util.Random;

/**
 * Class: Stock
 * @author: Gavin Meeker
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 * 
 * Purpose: To create Stock objects that represent individual stocks in the stock market.
 */
public class Stock {
    private String companyName;
    private double value;
    private double changeInValue;
    private double sharesOwned;
    private double volatility;
    private double baseline;

    Random r = new Random();

    public Stock(String companyName, double initialValue) {
        this.companyName = companyName;
        this.value = initialValue;
        this.sharesOwned = 0;
        this.volatility = r.nextDouble(5 - 0.5) + 0.5;
        this.baseline = r.nextDouble(5);
    }

    public Stock(String companyName, double initialValue, double changeInValue, double sharesOwned) {
        this.companyName = companyName;
        this.value = initialValue;
        this.sharesOwned = sharesOwned;
        this.changeInValue = changeInValue;
        this.volatility = r.nextDouble(10 - 0) + 0;
        this.baseline = r.nextDouble(5 + 5) - 5;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getValue() {
        return value;
    }   

    public double getChangeInValue() {
        return changeInValue;
    }

    public double getSharesOwned() {
        return sharesOwned;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setSharesOwned(double sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    // Derived value
    public double calculateAmountInvested() {
        return sharesOwned * value;
    }

    public double calculateChangeInValue(double initialValue, double currentValue) {
        return (currentValue - initialValue) / initialValue;
    }

    public void displayStock() {
        System.out.printf("%s - Value: $%.2f | Shares: %.2f | Invested: $%.2f | Δ: %.2f%%\n",
                companyName, value, sharesOwned, calculateAmountInvested(), changeInValue * 100);
    }

    public double buyShares(double numShares) {
        double cost = numShares * value;
        sharesOwned += numShares;
        return cost;
    }

    // Sell shares: returns the total revenue or -1 if not enough shares
    public double sellShares(double numShares) {
        if (numShares > sharesOwned) {
            System.out.println("Not enough shares to sell.");
            return -1;
        }
        double revenue = numShares * value;
        sharesOwned -= numShares;
        return revenue;
    }

    /*
     * 
     */
    public double tickFowardValue() {
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        double volRand = r1.nextDouble();
        double baseRand = r2.nextDouble();
        double angRand = r3.nextDouble(Math.PI * 2);
        
        double newValue = (volatility * volRand * Math.sin(angRand)) + (baseline * baseRand) + volatility;
        
        return newValue;
    }

}
