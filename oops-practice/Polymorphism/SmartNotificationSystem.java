class Notification {
    String recipientName;
    String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() {
        System.out.println("Sending generic notification to " + recipientName);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Push notification sent to " + recipientName + ": " + message);
    }
}

public class SmartNotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Alice", "Your order has shipped."),
            new SMSNotification("Bob", "Your OTP is 839201."),
            new PushNotification("Charlie", "New app update available.")
        };

        sendAllNotifications(notifications);
    }

    private static void sendAllNotifications(Notification[] notifications) {
        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}
