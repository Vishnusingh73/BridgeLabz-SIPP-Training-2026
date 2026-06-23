public class OTPGenerator {

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length - 1; i++) {
            for (int j = i + 1; j < otps.length; j++) {

                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] otps = new int[10];

        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

   
        if (areOTPsUnique(otps)) {
            System.out.println("\nAll OTPs are unique.");
        } else {
            System.out.println("\nDuplicate OTP found.");
        }
    }
}