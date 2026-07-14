public class Scooter extends Vehicle {

    public Scooter(int id, String brand, double pricePerDay, double kilometersDriven) {
        super(id, brand, pricePerDay, kilometersDriven);
    }

    @Override
    public String getVehicleType() {
        return "Scooter";
    }

    @Override
    public double calculateTotalPrice(int days) {
        if (days > 0) {
            if (days <= 3) {
                return (this.getPricePerDay() * days) + 20 + 30;
            } else {
                return (this.getPricePerDay() * days) + 20;
            }
        }
        return 0;
    }
}
