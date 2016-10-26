package moe.thisis.SchoolSystem;

import javafx.beans.property.*;

public class Student {
	/**
	 * Student.java
	 * Student Object
	 * @author Quinlan McNellen
	 * @version 1.1
	 * @date 10/13/2016
	 */
	private final StringProperty studentID;
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty streetAddress;
	private final StringProperty city;
	private final StringProperty province;
	private final StringProperty postalCode;
	private final StringProperty phoneNumber;
	private final StringProperty birthDate;
	
	private static int counter = 300000000;
	
	/**
	 * Create a new student when no information is known
	 */
	public Student() {
		this.studentID = new SimpleStringProperty(Integer.toString(counter++));
		this.firstName = new SimpleStringProperty("");
		this.lastName = new SimpleStringProperty("");
		this.streetAddress = new SimpleStringProperty("");
		this.city = new SimpleStringProperty("");
		this.province = new SimpleStringProperty("");
		this.postalCode = new SimpleStringProperty("");
		this.phoneNumber = new SimpleStringProperty("");
		this.birthDate = new SimpleStringProperty("");
	}
	
	/**
	 * Create a new student when the Student ID is known
	 * @param studentID Known Student ID
	 */
	public Student(String studentID){
		this.studentID = new SimpleStringProperty(studentID);
		this.firstName = new SimpleStringProperty("");
		this.lastName = new SimpleStringProperty("");
		this.streetAddress = new SimpleStringProperty("");
		this.city = new SimpleStringProperty("");
		this.province = new SimpleStringProperty("");
		this.postalCode = new SimpleStringProperty("");
		this.phoneNumber = new SimpleStringProperty("");
		this.birthDate = new SimpleStringProperty("");
	}
	/**
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName.get();
	}
	/**
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	/**
	 * @return the last name
	 */
	public String getLastName() {
		return lastName.get();
	}
	/**
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return studentID.get();
	}

	/**
	 * @return the street address
	 */
	public String getStreetAddress() {
		return streetAddress.get();
	}
	/**
	 * @param streetAddress the street address to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress.set(streetAddress);
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city.get();
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city.set(city);
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province.get();
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province.set(province);
	}
	/**
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode.get();
	}
	/**
	 * @param postalCode the postal code to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode.set(postalCode);
	}
	/**
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber.get();
	}
	/**
	 * @param phoneNumber the phone number to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}
	/**
	 * @return the birth date
	 */
	public String getBirthDate() {
		return birthDate.get();
	}
	/**
	 * @param birthDate the birth date to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate.set(birthDate);
	}
}
