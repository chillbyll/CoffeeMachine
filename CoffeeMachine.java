package machine;
import java.util.Scanner;

// Idk
// Some random comment
// Another comment
// OMG


class Machine{
    private int[] supplies = new int[]{400, 540, 120, 9, 550};
    private int[] espresso = new int[]{250, 0, 16, 1, 4};
    private int[] latte = new int[]{350, 75, 20, 1, 7};
    private int[] cappuccino = new int[]{200, 100, 12, 1, 6};
    private String[] suppliesNames = new String[]{"water", "milk", "coffee beans", "disposable cups"};
    private Scanner scan = new Scanner(System.in);


    void input(String command) {
        switch (command) {
            case "remaining":
                System.out.println("The coffee machine has: ");
                System.out.println(supplies[0] + " of water");
                System.out.println(supplies[1] + " of milk");
                System.out.println(supplies[2] + " of coffee beans");
                System.out.println(supplies[3] + " of disposable cups");
                System.out.println(supplies[4] + " of money");
                break;

            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String coffeeNum = scan.next();
                int[] coffeeType;
                boolean enoughSupplies = true;

                switch (coffeeNum) {
                    case "1":
                        coffeeType = espresso;
                        break;
                    case "2":
                        coffeeType = latte;
                        break;
                    case "3":
                        coffeeType = cappuccino;
                        break;
                    case "back":
                        return;
                    default:
                        System.out.println("That doesn't exist");
                        return;
                }

                for (int i = 0; i < 4; i++) {
                    if (supplies[i] < coffeeType[i]) {
                        System.out.println("Sorry, not enough " + suppliesNames[i] + "!");
                        enoughSupplies = false;
                        break;
                    }
                }

                if (enoughSupplies) {
                    for (int i = 0; i < 4; i++) {
                        supplies[i] -= coffeeType[i];
                    }
                    supplies[4] += coffeeType[4];
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            case "fill":
                int[] refill = new int[4];
                System.out.println("Write how many ml of water do you want to add: ");
                refill[0] = scan.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                refill[1] = scan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                refill[2] = scan.nextInt();
                System.out.println("Write how many disposable cups do you want to add: ");
                refill[3] = scan.nextInt();

                for (int i = 0; i < 4; i++) {
                    supplies[i] += refill[i];
                }
                break;

            case "take":
                if (supplies[4] > 0) {
                    System.out.println("I gave you $" + supplies[4]);
                    supplies[4] = 0;
                } else {
                    System.out.println("No money in the machine");
                }
                break;

            case "exit":
                CoffeeMachine.running = false;
                break;

            default:
                System.out.println("That's not an option");
                break;
        }
    }
}

public class CoffeeMachine {
    static private Scanner scan = new Scanner(System.in);
    static boolean running = true;

    public static void main(String[] args) {
        Machine machine = new Machine();

        while(running){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            System.out.println(9 ^ 6);
            String command = scan.next();
            machine.input(command);
        }
    }
}
// Heey makarena
// Ou yeah 