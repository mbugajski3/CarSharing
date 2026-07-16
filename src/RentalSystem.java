import java.util.ArrayList;

public class RentalSystem {

    private ArrayList<Customer> customers;
    private ArrayList<Vehicle> vehicles;
    private RentalService service;

    public RentalSystem() {
        this.customers = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.service = new RentalService();
    }

    public boolean addCustomer(Customer customer) {
        if (customer != null && this.findCustomer(customer.getId()) == null) {
            this.customers.add(customer);
            return true;
        }
        return false;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle != null && this.findVehicle(vehicle.getId()) == null) {
            this.vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public Customer findCustomer(int id) {
        for (Customer customer : this.customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Vehicle findVehicle(int id) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public void printCustomers() {
        for (Customer customer : this.customers) {
            System.out.println(customer);
        }
    }

    public void printVehicles() {
        for (Vehicle vehicle : this.vehicles) {
            System.out.println(vehicle);
        }
    }

    public boolean makeRental(int rentalId, int customerId, int vehicleId, int plannedRentDays) {

        Customer customer = findCustomer(customerId);
        Vehicle vehicle = findVehicle(vehicleId);

        if (customer != null && vehicle != null) {
            return service.addRental(rentalId, customer, vehicle, plannedRentDays);
        }
        return false;
    }

    public boolean makeReturn(int rentalId, int actualRentDays, int kilometersDriven) {
        return this.service.returnRental(rentalId, actualRentDays, kilometersDriven);
    }

    public boolean cancelRental(int rentalId) {
        return this.service.cancelRent(rentalId);
    }

    public boolean customerPayDebt(int customerId, double amount) {
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            return false;
        }

        return customer.payDebt(amount);
    }

    public void printRentals() {
        service.getRentalHistory();

        this.service.rentHistory();
    }
}
