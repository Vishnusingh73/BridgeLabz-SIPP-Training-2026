interface LuggageScanner {
    boolean scanLuggage(String luggageId);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage scanning is required before boarding.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z0-9]{7,9}");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport verification is required before boarding.");
    }
}

public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    @Override
    public boolean scanLuggage(String luggageId) {
        return luggageId != null && luggageId.length() >= 3;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return LuggageScanner.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public static void main(String[] args) {
        String[] passengerNames = {"Ankit", "Sara", "Rita"};
        String[] passportNumbers = {"A1234567", "123", "B9876543"};
        String[] luggageIds = {"LUG1", "L2", "LUG3"};

        AirportSecuritySystem system = new AirportSecuritySystem();
        system.displaySecurityGuidelines();
        System.out.println();

        for (int i = 0; i < passengerNames.length; i++) {
            String name = passengerNames[i];
            String passport = passportNumbers[i];
            String luggage = luggageIds[i];
            boolean validPassport = system.verifyPassport(passport);
            boolean luggageOk = system.scanLuggage(luggage);
            System.out.printf("Passenger: %s, Passport valid: %b, Luggage scanned: %b%n",
                    name, validPassport, luggageOk);
            if (validPassport && luggageOk) {
                System.out.println("Can board flight.");
            } else {
                System.out.println("Cannot board flight.");
            }
            System.out.println();
        }
    }
}
