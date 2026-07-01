public class ChargingStation {
    static int totalStations;
    static double electricityRate = 20.0;
    String stationId;
    double unitsConsumed;

    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station: " + stationId + ", Units: " + unitsConsumed + ", Bill: " + calculateBill());
    }
}

public class ChargingStationNetwork {
    public static void main(String[] args) {
        ChargingStation[] stations = {
            new ChargingStation("S001", 50),
            new ChargingStation("S002", 70),
            new ChargingStation("S003", 30),
            new ChargingStation("S004", 90),
            new ChargingStation("S005", 60)
        };

        System.out.println("Electricity rate: " + ChargingStation.electricityRate);
        for (ChargingStation station : stations) {
            station.displayStationDetails();
        }

        System.out.println();
        ChargingStation.electricityRate = 22.5;
        System.out.println("Updated electricity rate: " + ChargingStation.electricityRate);
        for (ChargingStation station : stations) {
            station.displayStationDetails();
        }
    }
}
