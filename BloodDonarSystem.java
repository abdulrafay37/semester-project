import java.util.Scanner;

public class BloodDonarSystem {
    static String[] names = new String[100];
    static String[] bloodGroups = new String[100];
    static String[] cities = new String[100];
    static int donorCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        while (true) {
            System.out.println("\nBLOOD DONOR SYSTEM");
            System.out.println("1. Add Donor");
            System.out.println("2. View Donors");
            System.out.println("3. Search by Blood Group");
            System.out.println("4. Emergency Request");
            System.out.println("5. Total Donors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDonor();
                    break;
                case 2:
                    viewDonors();
                    break;
                case 3:
                    searchByBloodGroup();
                    break;
                case 4:
                    emergencyRequest();
                    break;
                case 5:
                    totalDonors();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addDonor() {
        if (donorCount >= names.length) {
            System.out.println("Donor list is full.");
            return;
        }

        System.out.print("Enter name: ");
        names[donorCount] = scanner.nextLine();
        System.out.print("Enter blood group: ");
        bloodGroups[donorCount] = scanner.nextLine();
        System.out.print("Enter city: ");
        cities[donorCount] = scanner.nextLine();
        donorCount++;
        System.out.println("Donor added successfully.");
    }

    static void viewDonors() {
        if (donorCount == 0) {
            System.out.println("No donors found.");
            return;
        }

        System.out.println("\nDonor list:");
        for (int i = 0; i < donorCount; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + bloodGroups[i] + " - " + cities[i]);
        }
    }

    static void searchByBloodGroup() {
        System.out.print("Enter blood group: ");
        String group = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < donorCount; i++) {
            if (bloodGroups[i].equalsIgnoreCase(group)) {
                System.out.println(names[i] + " - " + bloodGroups[i] + " - " + cities[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No donors found with blood group " + group);
        }
    }

    static void emergencyRequest() {
        System.out.print("Required blood group: ");
        String group = scanner.nextLine();
        System.out.println("Available donors:");
        searchRecursive(group, 0);
    }

    static void searchRecursive(String group, int index) {
        if (index == donorCount) {
            return;
        }

        if (bloodGroups[index].equalsIgnoreCase(group)) {
            System.out.println(names[index] + " - " + cities[index]);
        }

        searchRecursive(group, index + 1);
    }

    static void totalDonors() {
        System.out.println("Total donors: " + donorCount);
    }
}
    