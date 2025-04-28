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

    // Constructor
    /*
     * 
     */
    public Employees(double moral, double productivity) {
        this.moral = moral;
        this.productivity = productivity;
    }

    // Methods


    // Getters and setters
    /*
     * 
     */
    public double getMoral() {
        return moral;
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
        return productivity + moral;
    }

    /*
     * 
     */
    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }
}
