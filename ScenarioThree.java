public class ScenarioThree {

  public void batemanEvent() {
    // i could prolly make this one print statement but ill figure that out later
    System.out.println("Bahhtrick Bateman has mauled an employee of yours");
    System.out.println("and they are now in critical condition. Type 1 to");
    System.out.println("pay to get them the best doctors OR type 2 to forget");
    System.out.println("about them and hire Bateman instead.");

    System.out.print("> ");
    String choice = scan.nextLine();

    while (choice != "1" || choice != "2") {
      if (choice == "1") { // Pay for health
        System.out.println("Your employee made a swift recovery! (-$1000)");
        Account.withdrawMoney(1000);
      } else if (choice == "2") {

        // Add an employee to the array
        // and make him ass

      }
    }
  }

  // I changed this scenario a bit from the proposal but the effects it has are
  // the same
  public void carCrash() {
    System.out.println("You accidentally pulled out in front of a single");
    System.out.println("mother's minivan and caused an impact. It caused you");
    System.out.println("some injury. Type 1 to get out of your car and deal");
    System.out.println("with the consequences or type 2 to drive away and");
    System.out.println("act like nothing happened");

    System.out.print("> ");
    String choice = scan.nextLine();

    while (choice != "1" || choice != "2") {
      if (choice == "1") { // insurance and shit
        System.out.println("You pay the mother enough money to cover the");
        System.out.println("damages and keep quiet. (-$2000)");

        Account.withdrawMoney(2000);
      } else if (choice == "2") {
        Systen.out.println("There was a witness at the scene and word got");
        Systen.out.println("around to your employees.");
        for (Employee e : employees) {
          e.decreaseMorale(4);
        }
      }
    }
  }

  public void bullishTrend() {
    System.out.println("You accidentally pulled out in front of a single");
    System.out.println("mother's minivan and caused an impact. It caused you");
    System.out.println("some injury. Type 1 to get out of your car and deal");
    System.out.println("with the consequences or type 2 to drive away and");
    System.out.println("act like nothing happened");

    System.out.print("> ");
    String choice = scan.nextLine();

    while (choice != "1" || choice != "2") {
      if (choice == "1") { // insurance and shit
        System.out.println("You pay the mother enough money to cover the");
        System.out.println("damages and keep quiet. (-$2000)");

        Account.withdrawMoney(2000);
      } else if (choice == "2") {
        Systen.out.println("There was a witness at the scene and word got");
        Systen.out.println("around to your employees.");
        for (Employee e : employees) {
          e.decreaseMorale(4);
        }
      }
    }
  }
}
