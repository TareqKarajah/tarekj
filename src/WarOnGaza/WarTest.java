package WarOnGaza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class WarTest {
    public static void main(String[] args) {
//        Manager manager = new Manager();
//        Person person = new Martyr("1", "khaled", 70, "male", "rafah", "1/1/2002", "bomb", "rafah");
//        Person person2 = new LivePerson("2", "Amal", 65, "female", "rafah");
//        Person person3 = new Martyr("3", "ahmad", 25, "male", "rafah", "1/1/2021", "bomb", "rafah");
//        Person person4 = new LivePerson("4", "farah", 17, "female", "rafah");
//        Person amro = new LivePerson("442", "amro", 25, "male", "rafah");
//        Family family1 = new Family("zaqout");
//        family1.addParent(person);
//        family1.addParent(person3);
//        family1.addMember(person2, "son");
//        family1.addMember(person4, "daughter");
//        family1.addMember(amro, "son");
//        manager.addFamily(family1);
        user_friendly_list();
    }

    public static void user_friendly_list() {
        Scanner Scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            System.out.println("1. add a family");
            System.out.println("2. add a parent to a family");
            System.out.println("3. add a member to a family");
            System.out.println("4. remove a member from a family");
            System.out.println("5. remove a family");
            System.out.println("6. calculate family statistics");
            System.out.println("7. calculate global statistics");
            System.out.println("8. print total number of orphans");
            System.out.println("9. print total number of martyrs");
            System.out.println("10. print total number of live people");
            System.out.println("11. exit");
            System.out.println("Enter your choice: ");
            choice = Scanner.nextInt();
        }

    }
}
