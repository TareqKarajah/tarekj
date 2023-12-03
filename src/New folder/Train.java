public class Train {
    private static final Seat[][] seats = new Seat[23][];

    public Train() {
        int s = 1;
        for (int i = 0; i <= 22; i++) {
            if (i == 0 || i == 22) {
                seats[i] = new Seat[2];
            } else {
                seats[i] = new Seat[4];
            }
            for (int j = 0; j < 4; j++) {
                if (s == 3 || s == 4 || s == 89 || s == 90)
                    continue;
                seats[i][j] = new Seat(s);
                s++;
            }
        }
    }

    public boolean reserve(int seatNumber, String passenger) {

        if (Seat.isValid(seatNumber) && Seat.isEmpty(passenger)) {
            seats[Seat.getRow(seatNumber)][Seat.getColumn(seatNumber)].setPassenger(passenger);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteSeat(int seatNumber) {
        if (Seat.isEmpty(seats[Seat.getRow(seatNumber)][Seat.getColumn(seatNumber)].getPassenger())) {
            return false;
        }
        seats[Seat.getRow(seatNumber)][Seat.getColumn(seatNumber)].setPassenger(null);
        return true;
    }

    public void deleteAll() {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j].setPassenger(null);
            }
        }
    }
}

//    public String toString(){
//        for(int i=0; i<23; i++){
//            for (int j=0; j<4; j++)
//                seats[i][j].getSeatNumber();


