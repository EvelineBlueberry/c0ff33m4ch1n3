import java.util.Scanner;

class Coffee {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int water = 200;
        final int milk = 50;
        final int beans = 15;
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterIn = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkIn = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansIn = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int water1 = waterIn / water;
        int milk1 = milkIn / milk;
        int beans1 = beansIn / beans;
        var numbers = new int[]{water1, milk1, beans1};
        var min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }

        if (min == cups) {
            System.out.print("Yes, I can make that amount of coffee");
        } else if (min > cups) {
            System.out.print("Yes, I can make that amount of coffee (and even " + (min - cups) + " more than that)");
        } else {
            System.out.print("No, I can make only " + min + " cup(s) of coffee");
        }
    }
}