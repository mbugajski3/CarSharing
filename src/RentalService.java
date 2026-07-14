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

            if (rental.getRentStatus().equals("ACTIVE") &&
                    actualRentDays > 0 &&
                    kilometersDriven >= 0) {

                rental.getVehicle().addKilometers(kilometersDriven);
                rental.setActualRentDays(actualRentDays);
                rental.getCustomer().addRentalsEnded();
                double price = rental.getVehicle().calculateTotalPrice(actualRentDays);
                double timeOutFee = 0;


                if (actualRentDays > rental.getPlannedRentDays()) {
                    timeOutFee += (actualRentDays - rental.getPlannedRentDays()) * 50;
                    rental.addReturnPrice(price + timeOutFee);
                    rental.getCustomer().addDebt(price + timeOutFee);
                    rental.rentReturn();
                    return true;
                } else {
                    rental.addReturnPrice(price);
                    rental.getCustomer().addDebt(price);
                    rental.rentReturn();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean payment(int id, double amount) {
        if (this.rentalHistory.containsKey(id)) {
            Rental rental = this.rentalHistory.get(id);

            if (amount > 0 &&
                rental.getCustomer().getDebt() > 0) {
                if (amount > rental.getCustomer().getDebt()) {
                    rental.getCustomer().setDebt(0);
                    rental.paid();
                    rental.setTotalPrice(0);
                    return true;
                } else {
                    rental.getCustomer().payDebt(amount);
                    rental.makePayment(amount);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancelRent(int id) {
        if (this.rentalHistory.containsKey(id)) {
            Rental rental = this.rentalHistory.get(id);

            if (rental.getRentStatus().equals("ACTIVE")) {
                rental.setRentStatus("CANCELED");
                rental.getVehicle().makeAvailable();
                return true;
            }
        }
        return false;
    }

}
