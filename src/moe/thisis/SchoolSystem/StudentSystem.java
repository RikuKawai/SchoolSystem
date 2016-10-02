package moe.thisis.SchoolSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentSystem {
	
	static ArrayList<Student> studRecs = new ArrayList<Student>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
				if (printRecord(i) == 1) {
					System.out.println("Invalid Student!");
					break;
				}
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
	
	public static int printRecord(int i) {
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
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return 1;
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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Student tempRecord = studRecs.get(i);
		System.out.println("Creating Student " + i);
		System.out.print("Enter First Name: ");
		tempRecord.setFirstName(in.readLine());
		System.out.print("Enter Last Name: ");
		tempRecord.setLastName(in.readLine());
		System.out.print("Enter Street Address: ");
		tempRecord.setStreetAddress(in.readLine());
		System.out.print("Enter City: ");
		tempRecord.setCity(in.readLine());
		System.out.print("Enter Province: ");
		tempRecord.setProvince(in.readLine());
		System.out.print("Enter Postal Code: ");
		tempRecord.setPostalCode(in.readLine());
		System.out.print("Enter Phone Number: ");
		tempRecord.setPhoneNumber(in.readLine());
		System.out.print("Enter Birth Date: ");
		tempRecord.setBirthDate(in.readLine());
		System.out.println("Student " + i + " Created!");
	}

}
