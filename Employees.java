/**
 * Class: Employees
 * @author: Gavin Meeker
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/28/2025
 * 
 * Purpose: Represents the employees of the player's company, abstracted as a single object instead of one for
 *          each person, generate money whose quantity is effected by in game events.
 */
public class Employees {
    // Attributes
    private double moral;
    private double productivity;
    private int employeeCount = 0; // Optional: if you want to track number of employees
    private double totalProduction = 0;

    // Constructor
    /*
     * 
     */
    public Employees(double moral, double productivity, int employeeCount) {
        this.moral = moral;
        this.productivity = productivity;
        this.employeeCount = employeeCount;
    }

    public Employees() {
        this.moral = 0.0;
        this.productivity = 0.0;
        this.employeeCount = 0;
    }  

    // Methods
    /*
     * 
     */
    public double valueOut() {
        return productivity + moral;
    }

    /*
     * 
     */
    public void changeProductivity(double change) {
        this.productivity = productivity + change;
    }

    /*
     * 
     */
    public void changeMoral(double change) {
        this.moral = moral + change;
    }

    // Getters and setters
    /*
     * 
     */
    public double getMorale() {
        return moral;
    }

    /*
     * 
     */
    public void setMorale(double morale) {
        this.moral = morale;
    }

    /*
     * 
     */
    public double getProductivity() {
        return productivity;
    }

    /*
     * 
     */
    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    public void hireEmployees() {
        employeeCount ++;
        productivity += 10; // Example: each new employee adds 10 to productivity
        morale += 2.5; // Example: each new employee adds 5 to morale
        setTotalProduction();
    }

    public double setTotalProduction() {
        totalProduction = productivity * morale;
        return totalProduction;
    }

    public void fireEmployees() {
        productivity = 0;
        morale = 0;
        employeeCount = 0;
    }
}
