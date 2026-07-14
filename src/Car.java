public class Car extends Vehicle {

    public Car(int id, String brand, double pricePerDay, double kilometersDriven) {
        super(id, brand, pricePerDay, kilometersDriven);
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public double calculateTotalPrice(int days) {
        if (days > 0) {
            if (days > 7) {
                return (this.getPricePerDay() * days * 0.9) + 100;
            } else {
                return (this.getPricePerDay() * days) + 100;
            }
        }
        return 0;
    }
}
