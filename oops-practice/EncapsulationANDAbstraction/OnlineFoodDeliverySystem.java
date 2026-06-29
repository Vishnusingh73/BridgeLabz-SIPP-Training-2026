abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    abstract double calculateTotalPrice();

    void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem {
    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem();
        vegItem.setItemName("Paneer Tikka");
        vegItem.setPrice(220.0);
        vegItem.setQuantity(2);

        NonVegItem nonVegItem = new NonVegItem();
        nonVegItem.setItemName("Chicken Biryani");
        nonVegItem.setPrice(280.0);
        nonVegItem.setQuantity(1);
        nonVegItem.setServiceCharge(30.0);

        System.out.println("Veg Item Details:");
        vegItem.displayItemDetails();
        System.out.println("Total Price: " + vegItem.calculateTotalPrice() + "\n");

        System.out.println("Non-Veg Item Details:");
        nonVegItem.displayItemDetails();
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());
    }
}
