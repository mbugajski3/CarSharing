public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Michał", 1, "customer001@example.com", 0, 1);
        Customer customer2 = new Customer("Mathew", 2, "customer002@example.com", 0, 12);
        Customer customer3 = new Customer("Blocked Client", 3, "blocked@example.com", 0, 0);

        customer3.deactivate();

        Vehicle car = new Car(101, "Toyota Corolla", 200, 50000);
        Vehicle bike1 = new Bike(201, "Yamaha NMAX", 80, 12000);
        Vehicle bike2 = new Bike(301, "Kross Hexagon", 40, 1000);

        RentalSystem system = new RentalSystem();

        system.addCustomer(customer1);
        system.addCustomer(customer2);
        system.addCustomer(customer3);

        system.addVehicle(car);
        system.addVehicle(bike1);
        system.addVehicle(bike2);

        System.out.println(system.makeRental(1, customer1.getId(), 101, 10));
        system.printRentals();
        System.out.println(system.makeRental(2, customer2.getId(), 101, 10));
        system.printRentals();
        System.out.println(system.makeReturn(1,12, 800));
        System.out.println(customer1);
        System.out.println(car);
        System.out.println(system.customerPayDebt(1,1000));
        System.out.println(customer1);
        System.out.println(system.makeRental(3, customer1.getId(), 201, 30));
        System.out.println(system.customerPayDebt(1,2000));
        System.out.println(system.makeRental(4, customer1.getId(), 201, 2));
        System.out.println(system.makeReturn(4, 2, 50));
        System.out.println(customer1);
        System.out.println(system.makeRental(5, customer2.getId(), 301, 8));
        System.out.println(system.makeReturn(5,8,30));
        System.out.println(customer2);
        System.out.println(system.makeRental(6, customer3.getId(), 101, 3));
        System.out.println(customer2);
        System.out.println(system.makeRental(7, customer2.getId(), 101, 3));
        System.out.println(system.cancelRental(7));
        System.out.println(customer2);
        System.out.println(car);

        System.out.println(system.customerPayDebt(1, -100));
        System.out.println(system.customerPayDebt(1, 0));
        System.out.println(system.customerPayDebt(999, 100));
    }
}