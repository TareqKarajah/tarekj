package WarOnGaza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Person person = new Martyr("1", "khaled", 70, "male", "rafah", "1/1/2002", "bomb", "rafah");
        Person person2 = new LivePerson("2", "Amal", 65, "female", "rafah");
        Person person3 = new Martyr("3", "ahmad", 25, "male", "rafah", "1/1/2021", "bomb", "rafah");
        Person person4 = new LivePerson("4", "farah", 17, "female", "rafah");
        Person amro = new LivePerson("442", "amro", 25, "male", "rafah");
        Family family1 = new Family("zaqout");
        family1.addParent(person);
        family1.addParent(person3);
        family1.addMember(person2, "son");
        family1.addMember(person4, "daughter");
        family1.addMember(amro, "son");
        manager.addFamily(family1);
        user_friendly_list(manager);
    }

    public static void print_menu() {
        System.out.println("1- Calculate Total Martyrs");
        System.out.println("2- Calculate Total Live Persons");
        System.out.println("3- Calculate Total Orphans");
        System.out.println("4- Caculate Global Statistics");
        System.out.println("5- Caclulate Familiy Statistics");
        System.out.println("6- Exit");
    }

    public static void user_friendly_list(Manager manager) {
        Scanner Scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            print_menu();
            choice = Scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Total Martyrs: " + manager.calculateTotalMartyrs());
                    break;
                case 2:
                    System.out.println("Total Live Persons: " + manager.calculateTotalLivePersons());
                    break;
                case 3:
                    System.out.println("Total Orphans: " + manager.calculateTotalOrphans());
                    break;
                case 4:
                    System.out.println("Global Statistics: ");
                    System.out.println(manager.calculateGlobalStatistics());
                    break;
                case 5:
                    System.out.println("Enter Family Name: ");
                    String family_name = Scanner.next();

                    System.out.println("Family Statistics: ");
                    List<Integer> x =manager.calculateFamilyStatistics(family_name);
                    System.out.println(x);
                    if (x == null) {
                        System.out.println("Family Not Found");
                        break;
                    }
                    System.out.println(manager.calculateFamilyStatistics(family_name));
                    break;
                case 6:
                    Scanner.close();
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

    }
}
