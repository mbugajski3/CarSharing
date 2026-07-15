public class Main {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Customer customer = new Customer("Michał", 1, "email@example.com", 0, 3);
        Customer customer1 = new Customer("Adam", 2, "name@example.com", 0, 20);

        Vehicle car = new Car(190, "Ford", 200, 4000);
        Vehicle bike = new Car(190, "Audi", 200, 200);

        system.addCustomer(customer);
        system.addCustomer(customer1);

        system.addVehicle(car);
        system.addVehicle(bike);
        system.printVehicles();
        system.printCustomers();
    }
}