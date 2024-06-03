package encapsulationTask;

import java.time.LocalDate;

public class Rental {
/*
	private Car car;
	private Customer customer;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	
	public Rental() {
		}

	public Rental(Car car, Customer customer, LocalDate rentalDate, LocalDate returnDate) {
		super();
		validateCar(car);
		validateCustomer(customer);
		validateRentalDate(rentalDate);
		this.car = car;
		this.customer = customer;
		this.rentalDate = rentalDate;
		this.returnDate = null;
		car.markAsRented();
        customer.addRentedCar(car);

	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	private void validateCar(Car car) {
	    if (car == null) {
	        throw new NullPointerException("Car cannot be null.");
	    }
	}

	private void validateCustomer(Customer customer) {
	    if (customer == null) {
	        throw new NullPointerException("Customer cannot be null.");
	    }
	}

	private void validateRentalDate(LocalDate rentalDate) {
	    if (rentalDate == null || rentalDate.isAfter(LocalDate.now())) {
	        throw new IllegalArgumentException("Rental date cannot be in the future.");
	    }
	}
	public void returnCar(LocalDate returnDate) {
        if (returnDate == null || returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return date must be after rental date");
        }
        this.returnDate =returnDate;
        car.markAsReturned();
        customer.removeRentedCar(car);
    }
*/
	
	 private final Car car;
	    private final Customer customer;
	    private final LocalDate rentalDate;
	    private LocalDate returnDate;

	    public Rental(Car car, Customer customer, LocalDate rentalDate) {
	        validateRentalDate(rentalDate);
	        this.car = car;
	        this.customer = customer;
	        this.rentalDate = rentalDate;
	        customer.addCar(car); // Add car to customer's rentals
	    }

	    private void validateRentalDate(LocalDate rentalDate) {
	        if (rentalDate.isAfter(LocalDate.now())) {
	            throw new IllegalArgumentException("Rental date cannot be in the future.");
	        }
	    }

	    public Car getCar() {
	        return car;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public LocalDate getRentalDate() {
	        return rentalDate;
	    }

	    public LocalDate getReturnDate() {
	        return returnDate;
	    }

	    public void returnCar(LocalDate returnDate) {
	        validateReturnDate(returnDate);
	        this.returnDate = returnDate;
	        customer.removeCar(car); // Remove car from customer's rentals
	    }

	    private void validateReturnDate(LocalDate returnDate) {
	        if (returnDate == null || returnDate.isBefore(rentalDate)) {
	            throw new IllegalArgumentException("Return date cannot be before rental date or null.");
	        }
	    }

		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}
}
