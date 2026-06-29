abstract class Subscription {
    String subscriberName;
    String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public abstract double calculateMonthlyCharge();
}

class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 9.99;
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 15.99;
    }
}

class FamilyPlan extends Subscription {
    public FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 19.99;
    }
}

public class SubscriptionAnalyzer {
    public static void main(String[] args) {
        Subscription[] subscriptions = {
            new BasicPlan("Amit", "SUB100"),
            new PremiumPlan("Meera", "SUB200"),
            new FamilyPlan("Rohan", "SUB300")
        };

        System.out.println("Total revenue: " + calculateTotalRevenue(subscriptions));
        displaySubscribersByLetter(subscriptions, 'M');
        searchBySubscriptionId(subscriptions, "SUB200");
        System.out.println("Most expensive subscription: " + findMostExpensiveSubscription(subscriptions));
    }

    private static double calculateTotalRevenue(Subscription[] subscriptions) {
        double total = 0;
        for (Subscription subscription : subscriptions) {
            total += subscription.calculateMonthlyCharge();
        }
        return total;
    }

    private static void displaySubscribersByLetter(Subscription[] subscriptions, char prefix) {
        System.out.println("Subscribers starting with " + prefix + ":");
        for (Subscription subscription : subscriptions) {
            if (subscription.subscriberName.startsWith(String.valueOf(prefix))) {
                System.out.println(subscription.subscriberName + " (" + subscription.subscriptionId + ")");
            }
        }
    }

    private static void searchBySubscriptionId(Subscription[] subscriptions, String subscriptionId) {
        for (Subscription subscription : subscriptions) {
            if (subscription.subscriptionId.equals(subscriptionId)) {
                System.out.println("Found subscriber: " + subscription.subscriberName);
                return;
            }
        }
        System.out.println("Subscription ID not found: " + subscriptionId);
    }

    private static String findMostExpensiveSubscription(Subscription[] subscriptions) {
        Subscription highest = null;
        for (Subscription subscription : subscriptions) {
            if (highest == null || subscription.calculateMonthlyCharge() > highest.calculateMonthlyCharge()) {
                highest = subscription;
            }
        }
        return highest == null ? "None" : highest.subscriberName + " (" + highest.subscriptionId + ")";
    }
}
