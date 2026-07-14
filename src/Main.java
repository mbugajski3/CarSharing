public class Main {
    public static void main() {
        Customer customer = new Customer("Michał Bugajski", 19203, "michabugajski2@gmail.com", 20 , 12);
        Vehicle car = new Car(19203, "Ford", 200, 200);
        Vehicle scooter = new Scooter(11490, "Tesla", 80, 20);
        Vehicle bike = new Bike(12901, "Romet", 40, 10);
        Rental rentCar = new Rental(1, customer, car, 20);

        RentalService service = new RentalService();

        service.addRental(1, customer, car, 20);
        System.out.println(car);
        service.returnRental(1, 30, 100);
        service.rentHistory();
        System.out.println(car);

    }
}
