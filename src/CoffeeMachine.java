import java.util.Scanner;

public class CoffeeMachine {
    static boolean exit = false;
    static Scanner scanner = new Scanner(System.in);
    static int milkIn = 540;
    static int waterIn = 400;
    static int beansIn = 120;
    static int cupsIn = 9;
    static int cashIn = 550;

    public static void main(String[] args) {
        while (!exit) {
            System.out.print("Write action (buy, fill, take, remaining, exit): \n");
            String action = scanner.next();
            actionChoose(action);
        }
    }

    static void actionChoose(String act) {
        switch (act) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String coffee = scanner.next();
                choosingCoffee(coffee);
            }
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            case "exit" -> exit();
        }
    }

    static void choosingCoffee(String kindOf) {
        switch (kindOf) {
            case "1" -> makeCoffee(250, 0, 16, 4);
            case "2" -> makeCoffee(350, 75, 20, 7);
            case "3" -> makeCoffee(200, 100, 12, 6);
        }
    }

    static void makeCoffee(int waterForCoffee, int milkForCoffee, int beansForCoffee, int newMoney) {
        if (waterIn < waterForCoffee) {
            System.out.println("Sorry, not enough water!");
        } else if (milkIn < milkForCoffee) {
            System.out.println("Sorry, not enough milk!");
        } else if (beansIn < beansForCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cupsIn < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            waterIn -= waterForCoffee;
            milkIn -= milkForCoffee;
            beansIn -= beansForCoffee;
            cashIn += newMoney;
            cupsIn -= 1;
            System.out.print("I have enough resources, making you a coffee!\n");
        }
    }

    static void fill() {
        System.out.print("Write how many ml of water you want to add: \n");
        int addWater = scanner.nextInt();
        waterIn += addWater;
        System.out.print("Write how many ml of milk you want to add: \n");
        int addMilk = scanner.nextInt();
        milkIn += addMilk;
        System.out.print("Write how many grams of coffee beans you want to add: \n");
        int addBeans = scanner.nextInt();
        beansIn += addBeans;
        System.out.print("Write how many disposable cups of coffee you want to add: \n");
        int addCups = scanner.nextInt();
        cupsIn += addCups;
    }

    static void take() {
        System.out.println("I gave you $" + cashIn);
        cashIn = 0;
    }

    static void remaining() {
        System.out.print("The coffee machine has:\n" + waterIn + " ml of water\n" +
                milkIn + " ml of milk\n" + beansIn + " g of coffee beans\n" +
                cupsIn + " disposable cups\n" + "$" + cashIn + " of money\n");
    }
    static void exit() {
        exit = true;
    }
}