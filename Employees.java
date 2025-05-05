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
    public double getMoral() {
        return moral;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    /*
     * 
     */
    public void setMoral(double moral) {
        this.moral = moral;
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
}
