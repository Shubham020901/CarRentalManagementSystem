package encapsulationTask;

import java.time.LocalDate;

public class Car {
/*
	private String licensePlate;
	private String model;
	private String brand;
	private int year;
	private boolean available;

//Default Constructor
public Car() {	
}

//Parameterized Constructor
public Car(String licensePlate, String model, String brand, int year, boolean available) {
	super();
	validateLicensePlate(licensePlate);
	validateYear(year);
	this.licensePlate = licensePlate;
	this.model = model;
	this.brand = brand;
	this.year = year;
	this.available = true;
}

//Getter and Setter methods
public String getLicensePlate() {
	return licensePlate;
}

public void setLicensePlate(String licensePlate) {
	this.licensePlate = licensePlate;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public boolean isAvailable() {
	return available;
}

public void setAvailable(boolean available) {
	this.available = available;
}

public void markAsRented() {
	available = false;	
}

public void markAsReturned() {
	available = true;
	
}

public void validateLicensePlate(String licensePlate) {
    if (licensePlate == null || licensePlate.isEmpty()) {
        throw new IllegalArgumentException("License plate cannot be null or empty.");
    }
}

public void validateYear(int year) {
    if (year <= 0) {
        throw new IllegalArgumentException("Year must be a positive number.");
    }
}
*/
	
	 private final String licensePlate;
	    private final String model;
	    private final String brand;
	    private final int year;
	    private static boolean available;
	    private String color;
	   

	    public Car(String licensePlate, String model, String brand, int year, String color) {
	        validateLicensePlate(licensePlate);
	        validateYear(year);
	        this.licensePlate = licensePlate;
	        this.model = model;
	        this.brand = brand;
	        this.year = year;
	        this.available = true; 
	        this.color= color;
	    }

	    private void validateLicensePlate(String licensePlate) {
	        if (licensePlate == null || licensePlate.isEmpty()) {
	            throw new IllegalArgumentException("License plate cannot be null or empty.");
	        }
	    }

	    private void validateYear(int year) {
	        if (year <= 0) {
	            throw new IllegalArgumentException("Year must be a positive number.");
	        }
	    }

	    public String getLicensePlate() {
	        return licensePlate;
	    }

	    public String getModel() {
	        return model;
	    }

	    public String getBrand() {
	        return brand;
	    }

	    public int getYear() {
	        return year;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public void rentCar() {
	        available = false;
	    }

	    public static void returnCar(LocalDate localDate) {
	        available = true;
	    }
	
}
