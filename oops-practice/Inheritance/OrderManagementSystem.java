class Order {
    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OrderManagementSystem {
    public static void main(String[] args) {
        Order order = new Order("O1001", "2026-06-29");
        ShippedOrder shippedOrder = new ShippedOrder("O1002", "2026-06-28", "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("O1003", "2026-06-27", "TRK54321", "2026-06-29");

        System.out.println(order.getOrderId() + " - " + order.getOrderStatus());
        System.out.println(shippedOrder.getOrderId() + " - " + shippedOrder.getOrderStatus() + " (Tracking: " + shippedOrder.getTrackingNumber() + ")");
        System.out.println(deliveredOrder.getOrderId() + " - " + deliveredOrder.getOrderStatus() + " (Delivery Date: " + deliveredOrder.getDeliveryDate() + ")");
    }
}
