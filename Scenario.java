/**
 * Class: Scenario
 *
 * @author Gavin Meeker
 * @version 0.2 Course: CSE 201 Spring 2025 Written: April 9, 2025
 *     <p>Purpose: Manages the 4 scenarios/rooms of the text adventure by being the parent class to
 *                 events that happen in each of the scenarios.
 */

public class Scenario {
    // Define attributes
    private boolean active;
    private String name;
    private int quarterOccurance;

    // Methods
    /*
     * Each child class will override this method to have unique text discriptions
     */
    public void description() {

    }

    // Getters and setters
    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public int getQuarterOccurance() {
        return quarterOccurance;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuarterOccurance(int quarterOccurance) {
        this.quarterOccurance = quarterOccurance;
    }
}
