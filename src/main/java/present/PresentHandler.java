package present;

import candies.Candies;
import candies.ChocolateBar;
import candies.Lollipop;
import candies.Cookie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PresentHandler implements Box {

    public static void run() {

        PresentHandler gift = new PresentHandler();
        ArrayList<Candies> present = createPresentBox();
        gift.sort(present);
        gift.priceBox(present);
        gift.weightBox(present);
        gift.searchCandy(present);
        createCandies();
        getRandomCandy();

    }

    public static Candies[] createCandies() {
        Candies[] candies = new Candies[10];

        candies[0] = new ChocolateBar("Mars                    ", "ChocolateBar       ",
                25, 33, "Nut");
        candies[1] = new ChocolateBar("Sneakers                ", "ChocolateBar       ",
                39, 40, "Nougat");
        candies[2] = new ChocolateBar("Twix                    ", "ChocolateBar       ",
                39, 40, "Nougat");
        candies[3] = new Lollipop("Chupa Chups - Crimson   ", "Lollipop           ",
                24, 30, "Crimson");
        candies[4] = new Lollipop("Chupa Chups - Strawberry", "Lollipop           ",
                31, 31, "Strawberry");
        candies[5] = new Lollipop("Chupa Chups - Coca Cola ", "Lollipop           ",
                14, 11, "Coca Cola");
        candies[6] = new Cookie("Oreo                    ", "Cookie             ",
                29, 100, "Chocolate");
        candies[7] = new Cookie("TUC                     ", "Cookie             ",
                26, 66, "Sandy");
        candies[8] = new Cookie("Grillage                ", "Cookie             ",
                100, 30, "Ginger");
        candies[9] = new Cookie("Kinder                  ", "Cookie             ",
                55, 200, "Puff");

        return candies;
    }

    public static Candies getRandomCandy() {
        int random = (int) Math.floor(Math.random() * createCandies().length);
        return createCandies()[random];
    }

    public static ArrayList<Candies> createPresentBox() {

        Scanner countScaner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the number of candies to generate a gift:");
        int count = countScaner.nextInt();

        ArrayList<Candies> present = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            present.add(getRandomCandy());
        }
        System.out.println("Gift: ");
        System.out.println("| NAME                     | TYPE                |PRICE|WEIGHT |");
        System.out.println("|--------------------------|---------------------|-----|-------|");

        for (Candies candy : present) {
            candy.showAllInfo(candy.name);
        }
        return present;
    }

    public void sort(ArrayList<Candies> present) {

        Scanner paramScaner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choose a parameter for sorting sweets in a gift (NAME,WEIGHT,PRICE,TYPE)");
        String a = paramScaner.nextLine();
        Param param = Param.valueOf(a);

        switch (param) {
            case NAME -> present.sort(Comparator.comparing(Candies::getName));
            case WEIGHT -> present.sort(Comparator.comparing(Candies::getWeight));
            case PRICE -> present.sort(Comparator.comparing(Candies::getPrice));
            case TYPE -> present.sort(Comparator.comparing(Candies::getType));
        }

        System.out.println("Gift set sorted by " + param + ":");
        System.out.println("| NAME                     | TYPE                |PRICE|WEIGHT |");
        System.out.println("|--------------------------|---------------------|-----|-------|");

        for (Candies candy : present) {
            candy.showAllInfo(candy.name);
        }
    }

    @Override
    public void priceBox(ArrayList<Candies> present) {
        int sum = 0;
        for (Candies candy : present) {
            sum += candy.getPrice();
        }
        System.out.println("Gift price: " + sum);
    }

    @Override
    public void weightBox(ArrayList<Candies> present) {
        int sum = 0;
        for (Candies candy : present) {
            sum += candy.getWeight();
        }
        System.out.println("Gift weight: " + sum);
    }

    @Override
    public void searchCandy(ArrayList<Candies> present) {

        Scanner paramScaner = new Scanner(System.in);
        System.out.println("Select a parameter to search for sweets in a gift (NAME,WEIGHT,PRICE,TYPE)");
        String parameter = paramScaner.nextLine();
        Param param = Param.valueOf(parameter);

        switch (param) {
            case NAME -> {
                Scanner valueScaner = new Scanner(System.in);
                System.out.println("Enter a value for the field " + param);
                String value = valueScaner.nextLine();
                System.out.println("Search result for " + param + " with value " + value);
                for (Candies candy : present) {
                    if (candy.getName().equals(value)) {
                        System.out.println("- " + candy.name + "-" + candy.type);
                    }
                }
            }
            case WEIGHT -> {
                Scanner minScaner = new Scanner(System.in);
                System.out.println("Enter the min value to search by field " + param);
                int min = minScaner.nextInt();
                Scanner maxScaner = new Scanner(System.in);
                System.out.println("Enter the max value to search by field " + param);
                int max = maxScaner.nextInt();
                System.out.println("Search result for " + param + " with a range of values from " + min + " to " + max);
                for (Candies candy : present) {
                    if (candy.getWeight() >= min && candy.getWeight() <= max) {
                        System.out.println("- " + candy.name + "-" + candy.type);
                    }
                }
            }
            case PRICE -> {
                Scanner minScaner = new Scanner(System.in);
                System.out.println("Enter the min value to search by field " + param);
                int min = minScaner.nextInt();
                Scanner maxScaner = new Scanner(System.in);
                System.out.println("Enter the max value to search by field " + param);
                int max = maxScaner.nextInt();
                System.out.println("Search result for " + param + " with a range of values from " + min + " to " + max);
                for (Candies candy : present) {
                    if (candy.getPrice() >= min && candy.getPrice() <= max) {
                        System.out.println("- " + candy.name + "-" + candy.type);
                    }
                }
            }
            case TYPE -> {
                Scanner valueScaner = new Scanner(System.in);
                System.out.println("Enter a value for the field " + param);
                String value = valueScaner.nextLine();
                System.out.println("Search result for " + param + " with value " + value);
                for (Candies candy : present) {
                    if (candy.getType().equals(value)) {
                        System.out.println("- " + candy.name + "-" + candy.type);
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + param);
        }

    }
}
