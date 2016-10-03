package moe.thisis.SchoolSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentSystem {
	
	static ArrayList<Student> studRecs = new ArrayList<Student>();
	static final String VERSION = "0.2";
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("StudentSystem v" + VERSION);
		System.out.println("Quinlan McNellen, ICS4U, 2016");
		
		boolean running = true;
		
		while(running) {
			System.out.print("Enter command (h for help): ");
			String command = in.readLine();
			
			switch (command.toLowerCase()) {
			case "h":
				System.out.println("1: Add new record\n2: Print a record\n3: Print all records\n4: null\n5: null\n6: null\n7: null\n8: null\n9: null\n10: Quit\nh: Show this screen");
				break;
			case "1":
				createRecord();
				break;
			case "2":
				System.out.print("Enter record number: ");
				int i = Integer.parseInt(in.readLine());
				printRecord(i);
			case "3":
				printAllRecords();
				break;
			case "10":
				System.out.println("Quitting...");
				running = false;
				break;
			default:
				System.out.println("Invalid command, enter h for help.");
				break;
			}
		}
	}
	
	public static void printRecord(int i) {
		try {
			Student tempRecord = studRecs.get(i);
			System.out.println("Printing information for student " + i);
			System.out.println("First Name: " + tempRecord.getFirstName());
			System.out.println("Last Name: " + tempRecord.getLastName());
			System.out.println("Street Address: " + tempRecord.getStreetAddress());
			System.out.println("City: " + tempRecord.getCity());
			System.out.println("Province: " + tempRecord.getProvince());
			System.out.println("Postal Code: " + tempRecord.getPostalCode());
			System.out.println("Phone Number: " + tempRecord.getPhoneNumber());
			System.out.println("Birth Date: " + tempRecord.getBirthDate());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid student!");
		}
	}
	public static void printAllRecords() {
		for (int i = 0; i<studRecs.size(); i++) {
			printRecord(i);
		}
	}
	public static void createRecord() throws IOException {
		studRecs.add(new Student());
		int i = studRecs.size() - 1;
		Student tempRecord = studRecs.get(i);
		System.out.println("Creating Student " + i);
		tempRecord.setFirstName(StudentInput.firstName());
		tempRecord.setLastName(StudentInput.lastName());
		tempRecord.setStreetAddress(StudentInput.streetAddress());
		tempRecord.setCity(StudentInput.city());
		tempRecord.setProvince(StudentInput.province());
		tempRecord.setPostalCode(StudentInput.postalCode());
		tempRecord.setPhoneNumber(StudentInput.phoneNumber());
		tempRecord.setBirthDate(StudentInput.birthDate());
		System.out.println("Student " + i + " Created!");
	}

}
