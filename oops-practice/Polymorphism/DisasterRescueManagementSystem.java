abstract class RescueTeam {
    String teamId;
    String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public abstract void performDuty();
}

class MedicalTeam extends RescueTeam {
    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Medical team " + teamId + " is treating patients at " + location);
    }
}

class FireRescueTeam extends RescueTeam {
    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Fire rescue team " + teamId + " is extinguishing fires at " + location);
    }
}

class FoodSupplyTeam extends RescueTeam {
    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Food supply team " + teamId + " is distributing food at " + location);
    }
}

public class DisasterRescueManagementSystem {
    public static void main(String[] args) {
        RescueTeam[] teams = {
            new MedicalTeam("M1", "Zone A"),
            new FireRescueTeam("F1", "Zone B"),
            new FoodSupplyTeam("S1", "Zone A"),
            new MedicalTeam("M2", "Zone C")
        };

        performAllDuties(teams);
        findTeamByLocation(teams, "Zone A");
        displayTeamsByPrefix(teams, "M");
        countTeamsByCategory(teams);
    }

    private static void performAllDuties(RescueTeam[] teams) {
        for (RescueTeam team : teams) {
            team.performDuty();
        }
    }

    private static void findTeamByLocation(RescueTeam[] teams, String location) {
        System.out.println("Teams at " + location + ":");
        for (RescueTeam team : teams) {
            if (team.location.equals(location)) {
                System.out.println(team.teamId + " - " + team.getClass().getSimpleName());
            }
        }
    }

    private static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("Teams starting with " + prefix + ":");
        for (RescueTeam team : teams) {
            if (team.teamId.startsWith(prefix)) {
                System.out.println(team.teamId + " at " + team.location + " (" + team.getClass().getSimpleName() + ")");
            }
        }
    }

    private static void countTeamsByCategory(RescueTeam[] teams) {
        int medical = 0;
        int fire = 0;
        int food = 0;
        for (RescueTeam team : teams) {
            if (team instanceof MedicalTeam) medical++;
            else if (team instanceof FireRescueTeam) fire++;
            else if (team instanceof FoodSupplyTeam) food++;
        }

        System.out.println("Medical teams: " + medical);
        System.out.println("Fire rescue teams: " + fire);
        System.out.println("Food supply teams: " + food);
        System.out.println("Max deployed: " + findMaxCategory(medical, fire, food));
    }

    private static String findMaxCategory(int medical, int fire, int food) {
        if (medical >= fire && medical >= food) {
            return "MedicalTeam";
        } else if (fire >= medical && fire >= food) {
            return "FireRescueTeam";
        } else {
            return "FoodSupplyTeam";
        }
    }
}
