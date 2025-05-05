import java.util.Random;

/**
 * Represents a stock in the stock market simulation.
 * Each stock has a company name, current value, number of shares owned,
 * volatility, and a baseline used for simulating price changes.
 * 
 * @author Gavin Meeker
 * @version 1.0
 * @since 2025-04-24
 * Course: CSE 201 Spring 2025
 */
public class Stock {
    private String companyName;
    private double value;
    private double changeInValue;
    private double sharesOwned;
    private double volatility;
    private double baseline;

    Random r = new Random();

    /**
     * Constructs a new Stock with a given company name and initial value.
     * Volatility and baseline are randomly generated.
     *
     * @param companyName The name of the company.
     * @param initialValue The starting value of the stock.
     */
    public Stock(String companyName, double initialValue) {
        this.companyName = companyName;
        this.value = initialValue;
        this.sharesOwned = 0;
        this.volatility = r.nextDouble(5 - 0.5) + 0.5;
        this.baseline = r.nextDouble(5);
    }

    /**
     * Constructs a Stock with more detailed initial state including shares and value change.
     * Volatility and baseline are randomly generated.
     *
     * @param companyName The name of the company.
     * @param initialValue The starting value of the stock.
     * @param changeInValue The change in value since the last update.
     * @param sharesOwned The number of shares currently owned.
     */
    public Stock(String companyName, double initialValue, double changeInValue, double sharesOwned) {
        this.companyName = companyName;
        this.value = initialValue;
        this.sharesOwned = sharesOwned;
        this.changeInValue = changeInValue;
        this.volatility = r.nextDouble(10 - 0) + 0;
        this.baseline = r.nextDouble(5 + 5) - 5;
    }

    /**
     * Returns the name of the company.
     *
     * @return The company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Returns the current value of the stock.
     *
     * @return The stock's value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Returns the change in value of the stock as a decimal.
     *
     * @return The change in value.
     */
    public double getChangeInValue() {
        return changeInValue;
    }

    /**
     * Sets the change in value of the stock.
     *
     * @param changeInValue The new change in value.
     */
    public void setChangeInValue(double changeInValue) {
        this.changeInValue = changeInValue;
    }

    /**
     * Returns the number of shares owned.
     *
     * @return Shares currently owned.
     */
    public double getSharesOwned() {
        return sharesOwned;
    }

    /**
     * Sets the current value of the stock.
     *
     * @param value The new stock value.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Sets the number of shares owned.
     *
     * @param sharesOwned The number of shares to set.
     */
    public void setSharesOwned(double sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    /**
     * Calculates the total amount invested in this stock.
     *
     * @return The total investment (sharesOwned * value).
     */
    public double calculateAmountInvested() {
        return sharesOwned * value;
    }

    /**
     * Calculates the percent change in value between two prices.
     *
     * @param initialValue The initial value of the stock.
     * @param currentValue The current value of the stock.
     * @return The change as a decimal (e.g., 0.25 for 25% increase).
     */
    public double calculateChangeInValue(double initialValue, double currentValue) {
        return (currentValue - initialValue) / initialValue;
    }

    /**
     * Displays stock information in a formatted line.
     */
    public void displayStock() {
        System.out.printf("%s - Value: $%.2f | Shares: %.2f | Invested: $%.2f | Δ: %.2f%%\n",
                companyName, value, sharesOwned, calculateAmountInvested(), changeInValue * 100);
    }

    /**
     * Buys shares of this stock.
     *
     * @param numShares The number of shares to buy.
     * @return The total cost of the shares purchased.
     */
    public double buyShares(double numShares) {
        double cost = numShares * value;
        sharesOwned += numShares;
        return cost;
    }

    /**
     * Sells shares of this stock.
     *
     * @param numShares The number of shares to sell.
     * @return The revenue from selling the shares, or -1 if not enough shares.
     */
    public double sellShares(double numShares) {
        if (numShares > sharesOwned) {
            System.out.println("Not enough shares to sell.");
            return -1;
        }
        double revenue = numShares * value;
        sharesOwned -= numShares;
        return revenue;
    }

    /**
     * Simulates a new stock value using a pseudo-random sine-based model.
     * Takes into account volatility, a sine wave angle, and baseline shifts.
     *
     * @return The simulated new stock value.
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
