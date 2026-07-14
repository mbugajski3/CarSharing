public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Michał",
                1,
                "michal@example.com",
                0,
                0
        );

        Vehicle car = new Car(
                101,
                "Toyota Corolla",
                200,
                50000
        );

        RentalService rentalService = new RentalService();

        rentalService.addRental(1, customer, car, 20);
        rentalService.rentHistory();
        System.out.println(customer);


        rentalService.cancelRent(1);


//        rentalService.returnRental(1, 30, 12500);
//        rentalService.payment(1, 20);
        rentalService.rentHistory();
        System.out.println(customer);
    }
}