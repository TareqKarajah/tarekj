package ghaied;
import java.util.Date;
import java.util.Random;

public class Driver {
    public static final int SEEDVALUE = 0;
    public static void main(String[] args) {
        Room[] rooms = new Room[3];
        Random random = new Random(SEEDVALUE);
        Chair[] chairs = new Chair[random.nextInt(31) + 20];
Date date = new Date();
        for (int i = 0; i < chairs.length; i++) {
            chairs[i] = new Chair();
            chairs[i].setWeight(20);
            chairs[i].setDateOfManufacture(date);
            chairs[i].setDistaanceFromFrontWall(random.nextInt(chairs.length));
            int color = random.nextInt(3);
            if (color == 0) {
                chairs[i].setColor("red");
            } else if (color == 1) {
                chairs[i].setColor("yellow");
            } else {
                chairs[i].setColor("white");
            }
        }
            rooms[0] = new Room(201, random.nextInt(11) + 20, random.nextInt(11) + 20);
            rooms[1] = new Room(202, random.nextInt(11) + 20, random.nextInt(11) + 20);
            rooms[2] = new Room(203, random.nextInt(11) + 20, random.nextInt(11) + 20);
            rooms[0].setChairs(chairs);
            rooms[1].setChairs(chairs);
            rooms[2].setChairs(chairs);
        displayRooms(rooms);
    }

    public static void displayRooms(Room[] rooms) {
        System.out.println("\tnumber\tlength\twidth\ttotal chairs\tred\t\tyellow\twhite");
        for (Room room : rooms) {
            room.displayRoomInfo();
}

    }


}
