import java.util.*;

class Bike {
    String model;
    double pricePerDay;
    boolean isAvailable;

    Bike(String model, double pricePerDay) {
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

    void rentBike() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(model + " is rented.");
        } else {
            System.out.println(model + " is not available.");
        }
    }

    void returnBike() {
        isAvailable = true;
        System.out.println(model + " is returned.");
    }
}
 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Bike> bikes = new ArrayList<>();

        bikes.add(new Bike("Yamaha FZ", 30));
        bikes.add(new Bike("Royal Enfield", 45));

        while (true) {
            System.out.println("\nBike Rental System");
            System.out.println("1. View Bikes");
            System.out.println("2. Rent Bike");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Available Bikes:");
                    for (Bike bike : bikes) {
                        if (bike.isAvailable) {
                            System.out.println(bike.model + " - $" + bike.pricePerDay + " per day");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter bike model: ");
                    String model = scanner.nextLine();
                    boolean found = false;
                    for (Bike bike : bikes) {
                        if (bike.model.equalsIgnoreCase(model) && bike.isAvailable) {
                            bike.rentBike();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Bike not available.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
