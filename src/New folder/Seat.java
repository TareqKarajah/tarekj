// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Seat {
        private int seatNumber;
        private String passenger;

        public void setSeatNumber(int seatNumber) {
                this.seatNumber = seatNumber;
        }

        public int getSeatNumber() {
                return seatNumber;
        }

        public void setPassenger(String passenger) {
                this.passenger = passenger;
        }

        public String getPassenger() {
                return passenger;
        }

        public Seat(int seatNumber) {
                this.seatNumber = seatNumber;
        }

        public static boolean isEmpty(String passenger) {
                if (passenger == null) {
                        return true;
                } else {
                        return false;
                }

        }

        public static boolean isValid(int seatNumber) {
                if (seatNumber < 1 && seatNumber > 92 && (seatNumber == 4 || seatNumber == 3 || seatNumber == 89 || seatNumber == 90)) {
                        System.out.println("this seat number is not valid please enter number between 1-92");
                        return false;
                }
                else {
                        return true;
                }
        }
        public static int getRow(int seatNumber) {
            if (isValid(seatNumber)) {
                int r = (seatNumber % 4);
                if (r == 0) {
                    System.out.println("row =");
                    return seatNumber / 4;
                } else {
                    return (seatNumber / 4 + 1);
                }
            }
                    return 0;
        }
        public static int getColumn(int seatNumber) {
            if (isValid(seatNumber)) {
                int g = (seatNumber % 4);
                if (g == 0) {
                    System.out.println("Column =");
                    return 4;
                } else {
                    System.out.println("Column =");
                    return seatNumber % 4;
                }
            }
                    return 0;
        }



}
