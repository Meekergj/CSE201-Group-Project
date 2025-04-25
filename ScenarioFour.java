import java.util.Scanner;

/**
 * Class: ScenarioFour
 * @author: Andrew Finkelmeier
 * @version: 1.0
 * Course: CSE 201 Spring 2025
 * Written: 4/24/2025
 * 
 * Purpose: Provides the methods which will be randomly selected at the beginning of the fourth scenario. 
 */
public class ScenarioFour {
    Scanner scan = new Scanner(System.in);

    public void girlfriendBreakupStart() {
        System.out.println("Your girlfriend dumped you out of nowhere and you're pretty maaaaaddd.");
        System.out.println("Type 1 to vent to your employees or 2 to impulse buy a boat: ");
        girlfriendBreakup();
    }
    
    public void girlfriendBreakup() {
        String choice = scan.nextLine();

        if(choice.equals("1")) {
            for(Employee e : employees) {
                e.decreaseMorale(4);
            }
        }
        else if(choice.equals("2")) {
            Account.withdrawMoney(1000);
        }
        else {
            System.out.println("You're too distraught to do anything else, choose again: ");
            girlfriendBreakup();
        }
    }

    public void marketCollapseStart() {
        System.out.println("The stalk market is on fire! This could be the Great Incineration they've talked about!");
        System.out.println("Type 1 to liquidate everything, fire all employees, and take what you can or 2 to stick with the program: ");
        marketCollapse();
    }

    public void marketCollapse() {
        String choice = scan.nextLine();

        if(choice.equals("1")) {
            for(Employee e : employees) {
                e.fireEmployee();
            }

            Stock.cashout(); //withdraws all money accumulated from Stock class
            GameFunctions.endGame();
        }
        else if(choice.equals("2")) {
            GameFunctions.startCollapse(); //separate method that decreases stock value at beginning of each month
        }
        else {
            System.out.println("Is it hot in here to anyone else? I can't think straight. CHOOSE AGAIN: ");
            marketCollapse();
        }
    }

    public void rivalMercenariesStart() {
        System.out.println("A rival stock investor sent some unwanted company to sabotage you.");
        System.out.println("Type 1 to escort your employees out safely or 2 to stand your ground and fight: ");
        rivalMercenaries();
    }

    public void rivalMercenaries() {
        String choice = scan.nextLine();

        if(choice.equals("1")) {
            for(Employee e : employees) {
                e.increaseMorale(2.5);
            }

            Stock.deactivateStock(3); //deactivates 3 random stocks in the list
        }
        else if(choice.equals("2")) {
            Account.withdrawMoney(); //alt method that withdraws all money from account
        }
        else {
            System.out.println("You really feel the need to be a hero here, choose again: ");
            rivalMercenaries();
        }
    }
}
