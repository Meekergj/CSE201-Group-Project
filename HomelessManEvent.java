/**
 * Class: HomelessManEvent
 *
 * @author Gavin Meeker
 * @version 0.1 Course: CSE 201 Spring 2025 Written: April 11, 2025
 *     <p>Purpose: 
 */
public class HomelessManEvent extends Scenario {
    // Methods
    /*
     * Give some money to homeless guy
     */
    public void giveMoney() {
        Account.setBalance(Account.getBalance() - (Math.random() * 100); // Assuming a fixed amount of $100 is given
        System.out.println("You decided to give the homeless man $100.");
    }

    /*
     * Fuck it just take what little the homeless guy has
     */
    public void stealFromMan() {
        Account.setBalance(Account.getBalance() + (Math.random() * 100));
        System.out.println("You stole from the homeless man, and found $100");
    }
    
    /*
     * Texual description of the event
     */
    @Override
    public void description() {
        super.description();
    }
}
