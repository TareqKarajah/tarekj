package WarOnGaza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
        Manager manager = new Manager();
        Family family = new Family();
        consoleList(manager);
    }

    private static void createParents(Manager manager) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter the family name");
        String familyName1 = Scanner.next();
        System.out.println("Enter the dad name");
        String dadName = Scanner.next();
        System.out.println("Enter 'm' if dad is martyr or 'l' if live person");
        String dadType = Scanner.next();
        System.out.println("Enter the id of the dad");
        String dadId = Scanner.next();
        System.out.println("Enter the dad age");
        int dadAge = Scanner.nextInt();
        System.out.println("enter the address ");
        String dadAddress = Scanner.next();
        System.out.println("enter the contact info");
        String dadContactInfo = Scanner.next();
        if (dadType.equalsIgnoreCase("m")) {
            System.out.println("Enter the date of martyrdom");
            String dateOfMartyrdom = Scanner.next();
            System.out.println("Enter the cause of death");
            String causeOfDeath = Scanner.next();
            System.out.println("Enter the place of death");
            String placeOfDeath = Scanner.next();
            Martyr dad = new Martyr(dadId, dadName, dadAge, "male", dadAddress, dadContactInfo, dateOfMartyrdom, causeOfDeath, placeOfDeath);
            manager.addParent(familyName1, dad);

        } else if (dadType.equalsIgnoreCase("l")) {
            LivePerson dad = new LivePerson(dadId, dadName, dadAge, "male", dadAddress, dadContactInfo);
            manager.addParent(familyName1, dad);


        } else {
            System.out.println("wrong input");
        }
        System.out.println("Enter the mom name");
        String momName = Scanner.next();
        System.out.println("Enter 'm' if mom is martyr or 'l' if mom is live person");
        String momType = Scanner.next();
        System.out.println("Enter the id of the mom");
        String momId = Scanner.next();
        System.out.println("Enter the mom age");
        int momAge = Scanner.nextInt();
        System.out.println("enter the address ");
        String momAddress = Scanner.next();
        System.out.println("enter the contact info");
        String momContactInfo = Scanner.next();
        if (momType.equalsIgnoreCase("m")) {
            System.out.println("Enter the date of martyrdom");
            String dateOfMartyrdom = Scanner.next();
            System.out.println("Enter the cause of death");
            String causeOfDeath = Scanner.next();
            System.out.println("Enter the place of death");
            String placeOfDeath = Scanner.next();
            Martyr mom = new Martyr(momId, momName, momAge, "female", momAddress, momContactInfo, dateOfMartyrdom, causeOfDeath, placeOfDeath);
            manager.addParent(familyName1, mom);

        } else if (momType.equalsIgnoreCase("l")) {
            LivePerson mom = new LivePerson(momId, momName, momAge, "female", momAddress, momContactInfo);
            manager.addParent(familyName1, mom);
        } else {
            System.out.println("wrong input");
        }
    }

    //this method will read from file and add the families and members to the system
    public static void ReadFromFile(Manager manager) {
        try {
//            this statement before the loop is to skip the first line in the file
//            the first line explain the pattern of the file
            File file = new File("source.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] data = line.split(" ");
                System.out.println(data);
                manager.addFamily(new Family(data[0]));
                if (data[1].equalsIgnoreCase("martyr")) {
                    Martyr dad = new Martyr(data[2]);
                    manager.addParent(data[0], dad);
                } else if (data[1].equalsIgnoreCase("liveperson")) {
                    LivePerson dad = new LivePerson(data[2]);
                    manager.addParent(data[0], dad);
                }
                if (data[3].equalsIgnoreCase("martyr")) {
                    Martyr mom = new Martyr(data[4]);
                    manager.addParent(data[0], mom);
                } else if (data[3].equalsIgnoreCase("liveperson")) {
                    LivePerson mom = new LivePerson(data[4]);
                    manager.addParent(data[0], mom);
                }
                for (int i = 5; i < data.length; i++) {
                    if (data[i].equalsIgnoreCase("martyr")) {
                        Martyr member = new Martyr(data[i + 2]);
                        manager.addMember(data[0], member, data[i + 1]);
                    } else if (data[i].equalsIgnoreCase("liveperson")) {
                        LivePerson member = new LivePerson(data[i + 2]);
                        manager.addMember(data[0], member, data[i + 1]);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

    }

    public static void WriteToFile(Manager manager) {
        try {
            PrintWriter writer = new PrintWriter("output.txt");
            Family family = new Family();
//make it with nested for loop to ensure that the family with the most martyrs will be printed first

            ArrayList<Family> sfamilies = new ArrayList<>();
            sfamilies = family.sortByMartyrs(manager.getFamilies());
            for (Family family1 : sfamilies) {
                writer.println(family1.getFamilyName() + ":  number of martyrs (" + family1.numberOfMartyrs() + ")");
                writer.println("Parents : " + family1.getParents().get(0).getName() + ", " + family1.getParents().get(1).getName());
                writer.print("Members : ");
                for (int i = 0; i < family1.getMembers().size(); i++) {
                    writer.print(family1.getMembers().get(i).getName() + ", ");
                    writer.println(".......................................................");
                    writer.flush();
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    //    method to print the menu with the most common function for the user
    public static void printMenu() {
        System.out.println("Choose one of the following options: ");
        System.out.println("1- Create Family");
        System.out.println("2- Add parents ");
        System.out.println("3- Remove a family");
        System.out.println("4- Add a family members");
        System.out.println("5- Remove a family members");
        System.out.println("6- Calculate Total Orphans");
        System.out.println("7- Caculate Global Statistics");
        System.out.println("8- Caclulate Familiy Statistics");
        System.out.println("9- Print all families and their members to the file");
        System.out.println("10- Copy an object of type Martyr");
        System.out.println("10- Exit");
    }

    public static void consoleMenu() {
        System.out.println("Choose one of the following options: ");
        System.out.println("1- Read From file");
        System.out.println("2- Read From console");
        System.out.println("3- Write to file");
        System.out.println("4- Exit");
    }

    public static void consoleList(Manager manager) throws FileNotFoundException {
        Scanner Scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            try {
                consoleMenu();
                choice = Scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input ,try again");
                Scanner.next();
                continue;
            }
            switch (choice) {
                case 1:
                    ReadFromFile(manager);
                    break;
                case 2:
                    userList(manager);
                    break;
                case 3:
                    WriteToFile(manager);
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);

            }
        }

    }


    //  method to print the menu and implement the method on the choice of user
    public static void userList(Manager manager) {
        Scanner Scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 10) {
            try {
                printMenu();
                choice = Scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input ,try again");
                Scanner.next();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter the family name");
                    String familyName = Scanner.next();
                    Family family = new Family(familyName);
                    System.out.println(family.sortByMartyrs(manager.getFamilies()));
                    manager.addFamily(family);
                    break;
                case 2:
                    createParents(manager);
                    break;
                case 3:
                    System.out.println("Enter the family name");
                    String familyName2 = Scanner.next();
                    System.out.println("Enter the member name");
                    String memberName = Scanner.next();
                    System.out.println("Enter m if member is martyr or l if live person");
                    String memberType = Scanner.next();
                    if (memberType.equalsIgnoreCase("m")) {
                        Martyr member = new Martyr(memberName);
                        System.out.println("Enter the relation, son or daughter");
                        String roleInFamily = Scanner.next();
                        while (!roleInFamily.equalsIgnoreCase("son") && !roleInFamily.equalsIgnoreCase("daughter")) {
                            System.out.println("wrong input, try again: son or daughter");
                            roleInFamily = Scanner.next();
                        }
                        manager.addMember(familyName2, member, roleInFamily);

                    } else if (memberType.equalsIgnoreCase("l")) {
                        LivePerson member = new LivePerson(memberName);
                        System.out.println("Enter the relation, son or daughter");
                        String roleInFamily = Scanner.next();
                        while (!roleInFamily.equalsIgnoreCase("son") && !roleInFamily.equalsIgnoreCase("daughter")) {
                            System.out.println("wrong input, try again: son or daughter");
                            roleInFamily = Scanner.next();
                        }
                        manager.addMember(familyName2, member, roleInFamily);
                    } else {
                        System.out.println("wrong input");
                    }
                    break;
                case 4:
                    System.out.println("Total live persons: ");
                    System.out.print(manager.calculateTotalLivePersons());
                    break;
                case 5:
                    System.out.println("Enter the family name");
                    String familyName4 = Scanner.next();
                    manager.calculateTotalOrphans();
                    break;
                case 6:
                    System.out.println(manager.calculateGlobalStatistics());
                    break;
                case 7:
                    System.out.println("Enter the family name");
                    String familyName5 = Scanner.next();
                    manager.calculateFamilyStatistics(familyName5);
                    break;
                case 8:
                    //try the sort method here

                    break;
                case 9:
                    System.out.println("Enter the martyr name to copy");
                    String martyrName = Scanner.next();
                    manager.copyMartyr(martyrName);
                    break;
                case 10:
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("wrong input try again");
                    break;
            }


        }


    }

}
