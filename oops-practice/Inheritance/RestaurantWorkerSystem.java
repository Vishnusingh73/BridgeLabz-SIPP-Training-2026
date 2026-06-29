interface Worker {
    void performDuties();
}

class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is cooking meals.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is serving customers.");
    }
}

public class RestaurantWorkerSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", "C101");
        Waiter waiter = new Waiter("Maya", "W102");

        chef.performDuties();
        waiter.performDuties();
    }
}
