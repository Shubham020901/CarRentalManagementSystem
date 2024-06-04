package encapsulationTask;

import java.time.LocalDate;
import java.util.Scanner;

public class CarRentalManagementSystem {



	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
        // Test Car class
        Car car = new Car("ABC123", "Corolla", "Toyota", 2020, false);
        System.out.println("Car license plate: " + car.getLicensePlate());
        System.out.println("Car Model:" + car.getModel());
        System.out.println();
        // Test Customer class
        Customer customer = new Customer("123", "John Doe", "john.doe@example.com", null);
        System.out.println("Customer ID: " + customer.getCustomerId());

        // Test Rental class
        LocalDate rentalDate = LocalDate.of(2022, 1, 1);
        Rental rental = new Rental(car, customer, rentalDate, null);
        System.out.println("Rental date: " + rental.getRentalDate());

        // Test returnCar method
        LocalDate returnDate = LocalDate.of(2022, 1, 5);
        rental.returnCar(returnDate);
        System.out.println("Return date: " + rental.getReturnDate());
*/
		
		
		 Scanner scanner = new Scanner(System.in);

	        // Create some cars
	        Car car1 = new Car("MH15CJ5650", "Fortuner", "Toyota", 2020, "White");
	        Car car2 = new Car("MH15CJ1213", "Thar", "Mahindra", 2022,"Black");

	        // Create some customers
	        Customer customer1 = new Customer("001", "Shubham Jagtap", "shubhamj9100@gmail.com","7057544659");
	        Customer customer2 = new Customer("002", "Shubh", "shubhi.020901@gmail.com","9356658174");

	        // Rental scenarios
	        System.out.println("** Renting a car (valid) **");
	        Rental rental = null;
	        try {
	             rental = new Rental(car1, customer1, LocalDate.now());
	            System.out.println("Rental created successfully:");
	            System.out.println("  Car: " + rental.getCar().getModel() + " (" + rental.getCar().getLicensePlate() + ")"+" "+rental.getCar().getBrand() + "(" +rental.getCar().getYear() +")" +" "+rental.getCar().getColor());
	            System.out.println("  Customer: " + rental.getCustomer().getName() + "(" +rental.getCustomer().getCustomerId() +")"+" "+rental.getCustomer().getEmail()+" "+rental.getCustomer().getPhoneNumber());
	            System.out.println("  Rental Date: " + rental.getRentalDate());
	        } catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }

	        System.out.println("\n** Renting a car (invalid date) **");
	        try {
	            Rental rental1= new Rental(car2, customer2, LocalDate.now());  // Future date
	            System.out.println("Rental2 created successfully:");
	            System.out.println("  Car: " + rental1.getCar().getModel() + " (" + rental.getCar().getLicensePlate() + ")"+" "+rental.getCar().getBrand() + "(" +rental.getCar().getYear() +")" +" "+rental.getCar().getColor());
	            System.out.println("  Customer: " + rental.getCustomer().getName() + "(" +rental.getCustomer().getCustomerId() +")"+" "+rental.getCustomer().getEmail()+" "+rental.getCustomer().getPhoneNumber());
	            System.out.println("  Rental Date: " + rental1.getRentalDate());
	        } catch (IllegalArgumentException e) {
	            System.err.println("Error: " + e.getMessage()); // Rental date in the future
	        }
	         catch (Exception e) {
	            System.err.println("UnexpectedError: " + e.getMessage()); // Rental date in the future
	        }

	        System.out.println("\n** Returning a car (valid) **");
	        if (rental != null) { 
	        try {
	            rental.returnCar(LocalDate.now().plusDays(5));
	          //  rental.returnCar(LocalDate.now());
	           // Car.returnCar(LocalDate.now());
	            System.out.println("Car returned successfully.");
	            System.out.println("Rental 1: Car "+rental.getCar().getModel()+" " + rental.getCar().getLicensePlate()+" "+ rental.getReturnDate() + " returned by"+" "+rental.getCustomer().getName());
	        } catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	        } else {
	            System.err.println("Error: No rental found to return.");
	        }

	        System.out.println("\n** Returning a car (invalid date) **");
	       if (rental != null) { 
	        try {
	          // Car.returnCar(LocalDate.now().minusDays(1)); // Before rental date
	        rental.returnCar(null);
	        //	rentalDate.isAfter(LocalDate.now());
	        
	        //   	Car.returnCar(LocalDate.now().plusDays(3));
	        //	Car.returnCar(LocalDate.now());
	        } catch (IllegalArgumentException e) {
	            System.err.println("Error: " + e.getMessage()); // Return date before rental date
	        }
	   /*     } else {
	            System.err.println("Error: No rental found to return.");
	        }

	     */   scanner.close();
	}

}
}
