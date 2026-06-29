abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    abstract int getLoanDuration();

    void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Book extends LibraryItem {
    @Override
    int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    @Override
    int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    @Override
    int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book();
        book.setItemId("B001");
        book.setTitle("Fundamentals of Java");
        book.setAuthor("Anita Singh");

        Magazine magazine = new Magazine();
        magazine.setItemId("M001");
        magazine.setTitle("Tech Monthly");
        magazine.setAuthor("Ravi Kapoor");

        DVD dvd = new DVD();
        dvd.setItemId("D001");
        dvd.setTitle("Learn Java in 24 Hours");
        dvd.setAuthor("Pooja Verma");

        System.out.println("Book Details:");
        book.displayItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days\n");

        System.out.println("Magazine Details:");
        magazine.displayItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days\n");

        System.out.println("DVD Details:");
        dvd.displayItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
    }
}
