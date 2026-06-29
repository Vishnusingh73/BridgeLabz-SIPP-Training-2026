abstract class LibraryMember {
    String memberName;
    String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public abstract double calculateFine(int overdueDays);

    public void printDetails() {
        System.out.println("Member: " + memberName + " (ID: " + memberId + ")");
    }
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 1.0;
    }
}

class FacultyMember extends LibraryMember {
    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 0.5;
    }
}

class GuestMember extends LibraryMember {
    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }
}

public class LibraryMembershipSystem {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Asha", "S101"),
            new FacultyMember("Dr. Patel", "F202"),
            new GuestMember("Victor", "G303")
        };

        printMemberDetails(members, 5);
        displayMemberById(members, "F202");
    }

    private static void printMemberDetails(LibraryMember[] members, int overdueDays) {
        for (LibraryMember member : members) {
            member.printDetails();
            System.out.printf("Fine for %d overdue days: %.2f%n", overdueDays, member.calculateFine(overdueDays));
            System.out.println();
        }
    }

    private static void displayMemberById(LibraryMember[] members, String searchId) {
        for (LibraryMember member : members) {
            if (member.memberId.equals(searchId)) {
                System.out.println("Member found:");
                member.printDetails();
                return;
            }
        }
        System.out.println("Member ID not found: " + searchId);
    }
}
