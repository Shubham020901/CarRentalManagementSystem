package encapsulationTask;

import java.time.LocalDate;
import java.util.Arrays;

public class Customer {
/*
	private String customerId;
	private String name;
	private String email;
	private Car[] rentedCars;
//	private int rentedCarsCount;
	
	//Default Constructor
public Customer() {
}
	//parameterized Constructor
	public Customer(String customerId, String name, String email, Car[] rentedCars) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.rentedCars = new Car[0];
//		this.rentedCarsCount =0;
		
	}

	//Getter and Setter Methods
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Car[] getRentedCars() {
		return rentedCars;
	}

	public void setRentedCars(Car[] rentedCars) {
		this.rentedCars = rentedCars;
	}
/*
    public void addRentedCar(Car car) {
        if (car == null) {
            throw new NullPointerException("Car cannot be null");
        }
        for (Car rentedCar : rentedCars) {
            if (rentedCar.equals(car)) {
                throw new IllegalArgumentException("Customer already has this car rented");
            }
        }
   
		if (rentedCar >= rentedCars.length) {
            increaseRentedCarsCapacity();
        }
        
		rentedCars[rentedCarsCount++] = car;
    }

    private void increaseRentedCarsCapacity() {
        Car[] newRentedCars = new Car[rentedCars.length * 2];
        System.arraycopy(rentedCars, 0, newRentedCars, 0, rentedCars.length);
        rentedCars = newRentedCars;
    }
*/

/* correct code	
	public void addRentedCar(Car car) {
        if (car == null) {
            throw new NullPointerException("Car cannot be null");
        }
        for (Car rentedCar : rentedCars) {
            if (rentedCar.equals(car)) {
                throw new IllegalArgumentException("Customer already has this car rented");
            }
        }
        Car[] newRentedCars = new Car[rentedCars.length + 1];
        System.arraycopy(rentedCars, 0, newRentedCars, 0, rentedCars.length);
        newRentedCars[rentedCars.length] = car;
        rentedCars = newRentedCars;
    }
    public void removeRentedCar(Car car) {
        if (car == null) {
            throw new NullPointerException("Car cannot be null");
        }
        int index = -1;
        for (int i = 0; i < rentedCars.length; i++) {
            if (rentedCars[i].equals(car)) {
                index = i;
                break;
            }
        }
        if (index!= -1) {
            Car[] newRentedCars = new Car[rentedCars.length - 1];
            System.arraycopy(rentedCars, 0, newRentedCars, 0, index);
            System.arraycopy(rentedCars, index + 1, newRentedCars, index, rentedCars.length - index - 1);
            rentedCars = newRentedCars;
        }
    }
*/ 
	
	
	private final String customerId;
    private final String name;
    private final String email;
    private final Car[] rentedCars;
    private int rentedCarCount; 
	private String phoneNumber;
	

    public Customer(String customerId, String name, String email,String phoneNumber) {
        validateCustomerId(customerId);
        validateEmail(email);
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.rentedCars = new Car[10]; // Max 10 rentals initially (adjustable)
        this.rentedCarCount = 0;
        this.phoneNumber =phoneNumber;
    }

    
	private void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
    }

    private void validateEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@' symbol.");
        }
    }

    

	public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    

    public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	
    public Car[] getRentedCars() {
        return Arrays.copyOf(rentedCars, rentedCarCount);
    }

    public void addCar(Car car) {
        if (rentedCarCount == rentedCars.length) {
            throw new IllegalStateException("Customer has reached maximum rental capacity.");
        }
        if (isCarRented(car)) {
            throw new IllegalStateException("This car is already rented to this customer.");
        }
        car.rentCar(); // Mark car as rented
        rentedCars[rentedCarCount++] = car;
    }

    private boolean isCarRented(Car car) {
        for (int i = 0; i < rentedCarCount; i++) {
            if (rentedCars[i] == car) {
                return true;
            }
        }
        return false;
    }

    public void removeCar(Car car) {
        int index = -1;
        for (int i = 0; i < rentedCarCount; i++) {
            if (rentedCars[i] == car) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Car not found in customer's rentals.");
        }
        car.returnCar(LocalDate.now()); // Mark car as returned
        System.arraycopy(rentedCars, index + 1, rentedCars, index, rentedCarCount - index - 1);
        rentedCarCount--;
    }
/*    
    public void addPhoneNumber(String phoneNumber) {
    // Step 1: Check for null or empty phone number
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return; // No need to update if phone number is null or empty
        }
	 // Step 2: Validate phone number format
        validatePhoneNumber(phoneNumber); // Ensure valid format

        // If the customer already has a phone number, consider replacing or appending based on your logic
        // Step 3: Handle existing phone number (replace)
	if (this.phoneNumber != null) {
            // Choose an appropriate strategy for handling existing phone number (e.g., replace, append with separator)
            // You can implement your desired behavior here

     // Option 1: Replace existing phone number
            System.out.println("Customer already has a phone number: " + this.phoneNumber);
        } else {
	// Step 4: Store new phone number (if no existing number)
            this.phoneNumber = phoneNumber; // Store the new phone number
        }
    }
*/
    public void addPhoneNumber(String phoneNumber) {
        
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return;  
        } 
      //  addPhoneNumber(phoneNumber);  
        validatePhoneNumber(phoneNumber);
        if (this.phoneNumber != null) {
            this.phoneNumber = phoneNumber;  // Replace existing phone number
        } else {
            this.phoneNumber = phoneNumber;  // Store the new phone number
        }
    }
   // private void validatePhoneNumber(String phoneNumber) {
    public void validatePhoneNumber(String phoneNumber) { 
    if (phoneNumber != null && !phoneNumber.matches("^[\\d\\+\\-\\(\\)]+$")) {
            throw new IllegalArgumentException("Invalid phone number format. Only digits, +, -, (, and ) allowed.");
        }
    }

}


