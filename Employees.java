/**
 * Class: Employees
 * Author: Gavin Meeker
 * Version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/28/2025
 * 
 * Purpose: Represents the employees of the player's company, abstracted as a single object instead of
 *          individual employees. This class models morale and productivity to determine value output
 *          and manage growth or downsizing based on gameplay events.
 */
public class Employees {
    // Attributes

    /** The overall morale of the employee group. */
    private double morale;

    /** The overall productivity level of the employees. */
    private double productivity;

    /** Number of employees currently hired. */
    private int employeeCount = 0;

    /** Cached value of total production. */
    private double totalProduction = 0;

    /**
     * Constructs an Employees object with custom morale, productivity, and employee count.
     *
     * @param morale the morale level
     * @param productivity the productivity level
     * @param employeeCount the number of employees
     */
    public Employees(double morale, double productivity, int employeeCount) {
        this.morale = morale;
        this.productivity = productivity;
        this.employeeCount = employeeCount;
    }

    /**
     * Constructs an Employees object with default values (zeroed).
     */
    public Employees() {
        this.morale = 0.0;
        this.productivity = 0.0;
        this.employeeCount = 0;
    }

    /**
     * Calculates and returns the value output of the employees,
     * defined as the sum of morale and productivity.
     *
     * @return the combined value of productivity and morale
     */
    public double valueOut() {
        return productivity + morale;
    }

    /**
     * Modifies the current productivity by the specified amount.
     *
     * @param change the amount to change productivity by (positive or negative)
     */
    public void changeProductivity(double change) {
        this.productivity += change;
    }

    /**
     * Modifies the current morale by the specified amount.
     *
     * @param change the amount to change morale by (positive or negative)
     */
    public void changeMorale(double change) {
        this.morale += change;
    }

    /**
     * Returns the current morale level.
     *
     * @return morale value
     */
    public double getMorale() {
        return morale;
    }

    /**
     * Returns the number of employees.
     *
     * @return employee count
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     * Sets the number of employees.
     *
     * @param employeeCount the new number of employees
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    /**
     * Sets the morale to a specific value.
     *
     * @param morale the new morale level
     */
    public void setMorale(double morale) {
        this.morale = morale;
    }

    /**
     * Returns the current productivity level.
     *
     * @return productivity value
     */
    public double getProductivity() {
        return productivity;
    }

    /**
     * Sets the productivity to a specific value.
     *
     * @param productivity the new productivity level
     */
    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    /**
     * Hires a given number of employees, increasing productivity and morale accordingly.
     * Returns the total cost of hiring based on a fixed per-employee rate.
     *
     * @param count the number of employees to hire
     * @return the cost of hiring the employees
     */
    public double hireEmployees(int count) {
        double costPerEmployee = 50.0; 
        employeeCount += count;
        productivity += 10 * count;
        morale += 2.5 * count;
        setTotalProduction();
        return count * costPerEmployee;
    }

    /**
     * Updates and returns the total production value,
     * calculated as productivity multiplied by morale.
     *
     * @return the new total production value
     */
    public double setTotalProduction() {
        totalProduction = productivity * morale;
        return totalProduction;
    }

    /**
     * Fires all employees, resetting productivity, morale, and employee count to zero.
     */
    public void fireEmployees() {
        productivity = 0;
        morale = 0;
        employeeCount = 0;
    }
}
