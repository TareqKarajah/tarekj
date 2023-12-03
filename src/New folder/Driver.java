import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Train train = new Train();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number from this menu :" +
                "\n\t 1. Read passenger file." +
                "\n\t 2. Reserve a new empty seat." +
                "\n\t 3. Delete a reserved seat." +
                "\n\t 4. Delete all reserved seats." +
                "\n\t 5. Update passenger file." +
                "\n\t 6. Quit.");

        int order = in.nextInt();
        while (order != 6) {
            switch (order) {
                case 1: {
                    try {

                        File pass = new File("passenger.txt");
                        Scanner reader = new Scanner(pass);
                        while (reader.hasNextLine()) {
                            int n=reader.nextInt();
                            String name = reader.next();
                            System.out.println(name);
                            train.reserve(n,name);
                            }
                        reader.close();
                    } catch (FileNotFoundException e) {
                        e.getStackTrace();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the seat number to reserve");
                    int num = in.nextInt();
                    System.out.println("Enter the name of the passenger");
                    String psg = in.next();
                    train.reserve(num, psg);
                    break;
                }
                case 3: {
                    System.out.println("Enter the number of the seat you want to delete");
                    int seat=in.nextInt();
                    train.deleteSeat(seat);
                    break;
                }
                case 4: {
                    train.deleteAll();
                    System.out.println("All reserved seats had been deleted");
                    break;
                }
                case 5: {

                }
                default :
                    System.out.println("This number is invalid , try again \n ");
                    break;
            }
        }
    }
}

