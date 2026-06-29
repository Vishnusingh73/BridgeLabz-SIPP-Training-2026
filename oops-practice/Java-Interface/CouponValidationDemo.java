interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() == 8;
    }
}

public class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        return code != null && CouponValidator.isLengthValid(code) && code.startsWith("SAVE");
    }

    public static void main(String[] args) {
        String[] coupons = {"SAVE2024", "DISCOUNT", "SAVE9999", "INVALID"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            String status = cart.validateCoupon(coupon) ? "valid" : "invalid";
            System.out.println(coupon + " is " + status);
        }
    }
}
