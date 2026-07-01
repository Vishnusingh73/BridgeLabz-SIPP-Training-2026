public class SpaceTourist {
    static int totalReservations;
    static String missionName = "Lunar Expedition";
    String touristName;
    int seatNumber;

    public SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayDetails() {
        System.out.println("Tourist: " + touristName + ", Seat: " + seatNumber + ", Mission: " + missionName);
    }

    public static void main(String[] args) {
        SpaceTourist tourist1 = new SpaceTourist("Arjun", 2);
        SpaceTourist tourist2 = new SpaceTourist("Neha", 4);
        SpaceTourist tourist3 = new SpaceTourist("Sara", 6);

        tourist1.updateSeatNumber(10).updateSeatNumber(15);
        tourist2.updateSeatNumber(8);
        tourist3.updateSeatNumber(12);

        tourist1.displayDetails();
        tourist2.displayDetails();
        tourist3.displayDetails();

        System.out.println("Total reservations: " + SpaceTourist.totalReservations);
    }
}
