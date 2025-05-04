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
    private double morale;
    private double productivity;
    private int employeeCount = 0; // Optional: if you want to track number of employees

    // Constructor
    /*
     * 
     */
    public Employees(double morale, double productivity, int employeeCount) {
        this.morale = morale;
        this.productivity = productivity;
        this.employeeCount = employeeCount;
    }

    public Employees() {
        this.morale = 0.0;
        this.productivity = 0.0;
        this.employeeCount = 0;
    }  

    // Methods
    /*
     * 
     */
    public double valueOut() {
        return productivity + morale;
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
    public void changeMorale(double change) {
        this.morale = morale + change;
    }

    // Getters and setters
    /*
     * 
     */
    public double getMorale() {
        return morale;
    }

    /*
     * 
     */
    public void setMorale(double morale) {
        this.morale = morale;
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

    public void fireEmployees() {
        productivity = 0;
        morale = 0;
        employeeCount = 0;
    }
}
