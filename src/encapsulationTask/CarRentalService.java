package encapsulationTask;

import java.time.LocalDate;
import java.util.Map;

public class CarRentalService {

	private final Map<String, Rental> activeRentals = null;

    public Rental createRental(Car car, Customer customer, LocalDate rentalDate) {
        // Create and store rental in activeRentals map
        Rental rental = new Rental(car, customer, rentalDate);
        activeRentals.put(rental.getId(), rental);  // Replace with actual ID generation
        return rental;
    }

    public Rental getRental(String rentalId) {
        return activeRentals.get(rentalId);
    }

    public void returnCar(String rentalId, LocalDate returnDate) {
        Rental rental = getRental(rentalId);
        if (rental != null) {
            rental.returnCar(returnDate);
            activeRentals.remove(rentalId);
        } else {
            throw new IllegalArgumentException("Rental not found with ID: " + rentalId);
        }
    }

}
