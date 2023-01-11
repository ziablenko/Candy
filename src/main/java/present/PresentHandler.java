package present;

import candies.Candies;
import candies.ChocolateBar;
import candies.Lollipop;
import candies.Cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PresentHandler implements Box {


    public static void run() {
        boolean created = false;

        PresentHandler gift = new PresentHandler();
        ArrayList<Candies> present = null;
        do {
            try {
                present = createPresentBox();
                created = true;
            } catch (InputMismatchException e) {
                System.out.println("You entered an invalid value");
            }
        } while (!created);

        gift.sort(present);
        gift.priceBox(present);
        gift.weightBox(present);
        gift.searchCandy(present);
        createCandies();
        getRandomCandy();

    }

    public static Candies[] createCandies() {
        Candies[] candies = new Candies[10];

        candies[0] = new ChocolateBar("Mars                    ", "ChocolateBar       ", 25, 33, "Nut");
        candies[1] = new ChocolateBar("Sneakers                ", "ChocolateBar       ", 39, 40, "Nougat");
        candies[2] = new ChocolateBar("Twix                    ", "ChocolateBar       ", 39, 40, "Nougat");
        candies[3] = new Lollipop("Chupa Chups - Crimson   ", "Lollipop           ", 24, 30, "Crimson");
        candies[4] = new Lollipop("Chupa Chups - Strawberry", "Lollipop           ", 31, 31, "Strawberry");
        candies[5] = new Lollipop("Chupa Chups - Coca Cola ", "Lollipop           ", 14, 11, "Coca Cola");
        candies[6] = new Cookie("Oreo                    ", "Cookie             ", 29, 100, "Chocolate");
        candies[7] = new Cookie("TUC                     ", "Cookie             ", 26, 66, "Sandy");
        candies[8] = new Cookie("Grillage                ", "Cookie             ", 100, 30, "Ginger");
        candies[9] = new Cookie("Kinder                  ", "Cookie             ", 55, 200, "Puff");

        return candies;
    }

    public static Candies getRandomCandy() {
        int random = (int) Math.floor(Math.random() * createCandies().length);
        return createCandies()[random];
    }

    public static ArrayList<Candies> createPresentBox() {
        int count;
        Scanner countScanner = new Scanner(System.in);

        ArrayList<Candies> present;
        do {
            System.out.println("Enter the number of candies to generate a gift:");

            count = countScanner.nextInt();

            if (count <= 0 || count >= 11) {
                try {
                    throw new IOException();
                } catch (IOException a) {
                    System.out.println("You entered an invalid value. Valid values are from 1 to 10.");
                }
            }
        } while (count <= 0 || count >= 11);

        present = new ArrayList<>();

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

    public static boolean createPresentBox1(int count) {
        ArrayList<Candies> present;
        boolean created;
        if (count >= 1 && count <= 10) {
            created = true;
            present = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                present.add(getRandomCandy());
            }
            System.out.println("Gift: ");
            System.out.println("| NAME                     | TYPE                |PRICE|WEIGHT |");
            System.out.println("|--------------------------|---------------------|-----|-------|");

            for (Candies candy : present) {
                candy.showAllInfo(candy.name);
            }
        } else {
            try {
                throw new IOException();
            } catch (IOException a) {
                created=false;
                System.out.println("You entered an invalid value. Valid values are from 1 to 10.");
            }
        }

        return created;
    }


    public void sort(ArrayList<Candies> present) {

        Scanner paramScanner = new Scanner(System.in);
        System.out.println("Choose a parameter for sorting sweets in a gift (NAME,WEIGHT,PRICE,TYPE)");
        try {
            String a = paramScanner.nextLine();
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
        } catch (IllegalArgumentException a) {
            System.out.println("Invalid value. Valid values - NAME,WEIGHT,PRICE,TYPE");
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
        int x = 0;

        Scanner paramScanner = new Scanner(System.in);
        System.out.println("Select a parameter to search for sweets in a gift (NAME,WEIGHT,PRICE,TYPE)");
        try {
            String parameter = paramScanner.nextLine();
            Param param = Param.valueOf(parameter);

            switch (param) {
                case NAME -> {
                    Scanner valueScanner = new Scanner(System.in);
                    System.out.println("Enter a value for the field " + param);
                    String value = valueScanner.nextLine();
                    System.out.println("Search result for " + param + " with value " + value);
                    for (Candies candy : present) {
                        if (candy.getName().contains(value)) {
                            ++x;
                            System.out.println("- " + candy.name + "-" + candy.type);
                        }
                    }
                    if (x == 0) {
                        System.out.println("No result");
                    }
                }
                case WEIGHT -> {
                    Scanner minScanner = new Scanner(System.in);
                    System.out.println("Enter the min value to search by field " + param);
                    int min = minScanner.nextInt();
                    Scanner maxScanner = new Scanner(System.in);
                    System.out.println("Enter the max value to search by field " + param);
                    int max = maxScanner.nextInt();
                    if (min <= 0 || max <= 0 || max >= 1000 || max < min) {
                        try {
                            throw new IOException();
                        } catch (IOException a) {
                            System.out.println("Incorrect value for min/max(0-1000)");
                        }
                    }
                    System.out.println("Search result for " + param + " with a range of values from "
                            + min + " to " + max);

                    for (Candies candy : present) {
                        if (candy.getWeight() >= min && candy.getWeight() <= max) {
                            ++x;
                            System.out.println("- " + candy.name + "-" + candy.type);
                        }
                    }
                    if (x == 0) {
                        System.out.println("No result");
                    }
                }
                case PRICE -> {
                    Scanner minScanner = new Scanner(System.in);
                    System.out.println("Enter the min value to search by field " + param);
                    int min = minScanner.nextInt();
                    Scanner maxScanner = new Scanner(System.in);
                    System.out.println("Enter the max value to search by field " + param);
                    int max = maxScanner.nextInt();
                    if (min <= 0 || max <= 0 || max >= 1000 || max < min) {
                        try {
                            throw new IOException();
                        } catch (IOException a) {
                            System.out.println("Incorrect value for min/max(0-1000)");
                        }
                    }
                    System.out.println("Search result for " + param + " with a range of values from "
                            + min + " to " + max);

                    for (Candies candy : present) {
                        if (candy.getPrice() >= min && candy.getPrice() <= max) {
                            ++x;
                            System.out.println("- " + candy.name + "-" + candy.type);
                        }
                    }
                    if (x == 0) {
                        System.out.println("No result");
                    }
                }
                case TYPE -> {
                    Scanner valueScanner = new Scanner(System.in);
                    System.out.println("Enter a value for the field " + param);
                    String value = valueScanner.nextLine();
                    System.out.println("Search result for " + param + " with value " + value);
                    for (Candies candy : present) {
                        if (candy.getType().contains(value)) {
                            ++x;
                            System.out.println("- " + candy.name + "-" + candy.type);
                        }
                    }
                    if (x == 0) {
                        System.out.println("No result");
                    }
                }
            }

        } catch (IllegalArgumentException a) {
            System.out.println("Invalid value. Valid values - NAME,WEIGHT,PRICE,TYPE");
        }
    }
}
