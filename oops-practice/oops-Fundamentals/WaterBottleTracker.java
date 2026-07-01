public class WaterBottle {
    String ownerName;
    int dailyTarget;

    public WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    public void displayBottleInfo() {
        System.out.println("Owner: " + ownerName + ", Daily target: " + dailyTarget + " ml");
    }

    public static void main(String[] args) {
        WaterBottle bottle1 = new WaterBottle("Riya", 2000);
        WaterBottle bottle2 = new WaterBottle("Aman", 1800);

        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}
