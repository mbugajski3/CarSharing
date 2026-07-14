public class Bike extends Vehicle {

    public Bike(int id, String brand, double pricePerDay, int kilometersDriven) {
        super(id, brand, pricePerDay, kilometersDriven);
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }

    @Override
    public double calculateTotalPrice(int days) {
        if (days > 0) {
            if (days <= 5) {
                return this.getPricePerDay() * days;
            } else {
                return (5 * getPricePerDay()) + ((days - 5) * getPricePerDay() * 0.5);
            }
        }
        return 0;
    }
}
