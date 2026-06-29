interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("Tracking food order in progress.");
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customerName);

    default void trackOrder() {
        System.out.println("Tracking grocery order in progress.");
    }

    static String generateDeliveryCode() {
        return "DLV" + System.currentTimeMillis();
    }
}

public class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    @Override
    public void deliverFood(String customerName) {
        System.out.println("Delivering food to " + customerName);
    }

    @Override
    public void deliverGrocery(String customerName) {
        System.out.println("Delivering groceries to " + customerName);
    }

    @Override
    public void trackOrder() {
        System.out.println("Tracking combined food and grocery delivery.");
    }

    public static void main(String[] args) {
        String[] customers = {"Ravi", "Neelam", "Aditi"};
        DeliveryExecutive executive = new DeliveryExecutive();

        System.out.println("Delivery code: " + GroceryDelivery.generateDeliveryCode());
        executive.trackOrder();
        System.out.println();

        for (String customer : customers) {
            executive.deliverFood(customer);
            executive.deliverGrocery(customer);
            System.out.println();
        }
    }
}
