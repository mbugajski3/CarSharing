import java.util.HashMap;

public class RentalService {

    private HashMap<Integer, Rental> rentalHistory;

    public RentalService() {
        this.rentalHistory = new HashMap<>();
    }

    public HashMap<Integer, Rental> getRentalHistory() {
        return this.rentalHistory;
    }

    public void rentHistory() {
        for (Rental rental : this.rentalHistory.values()) {
            System.out.println(rental);
        }
    }

    public boolean addRental(int id, Customer customer, Vehicle vehicle, int plannedRentDays) {
        if (this.rentalHistory.containsKey(id)) {
            return false;
        }
        if (customer == null) {
            return false;
        }
        if (vehicle == null) {
            return false;
        }
        if (plannedRentDays <= 0) {
            return false;
        }

        if (customer.customerCanRent() && vehicle.isAvailable() && vehicle.isActiveInSystem()) {
            Rental rental = new Rental(id, customer, vehicle, plannedRentDays);
            rental.rent();
            this.rentalHistory.put(id, rental);
            return true;
        }
        return false;

    }

    public boolean returnRental(int id, int actualRentDays, int kilometersDriven) {
        if (this.rentalHistory.containsKey(id)) {
            Rental rental = this.rentalHistory.get(id);

            if (rental.getRentStatus().equals("ACTIVE") && actualRentDays > 0 && kilometersDriven > 0) {
                rental.rentReturn();
                rental.getVehicle().addKilometers(kilometersDriven);
                rental.

            }
        }
    }

}
