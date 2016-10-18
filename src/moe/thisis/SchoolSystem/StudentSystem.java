package moe.thisis.SchoolSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import moe.thisis.SchoolSystem.StudRecsWrapper;

public class StudentSystem {
	/**
	 * StudentSystem.java
	 * Student Database System
	 * @author Quinlan McNellen
	 * @version 0.2.1
	 * @date 10/02/2016
	 */
	static ArrayList<Student> studRecs = new ArrayList<Student>();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static final String VERSION = "0.2";
	static File file = new File("studrecs.xml");
	
	public static void main(String[] args) throws IOException {
				
		System.out.println("StudentSystem v" + VERSION);
		System.out.println("Quinlan McNellen, ICS4U, 2016\n");
		
		boolean running = true;
		
		while(running) {
			System.out.print("Enter command (h for help): ");
			String command = in.readLine();
			
			switch (command.toLowerCase()) {
			case "h":
				System.out.println("1: Add new record\n2: Print a record by indice\n3: Print all records\n4: Remove a record by indice\n5: null\n6: null\n7: null\ns: Save Records\n9: null\nq: Quit\nh: Show this screen");
				break;
			case "1":
				createRecord();
				break;
			case "2":
				System.out.print("Enter record number: ");
				int i = Integer.parseInt(in.readLine());
				printRecord(i);
				break;
			case "3":
				printAllRecords();
				break;
			case "4":
				removeRecord();
				break;
			case "s":
				saveStudRecsToFile(file);
				break;
			case "q":
				System.out.println("Quitting...");
				running = false;
				break;
			default:
				System.out.println("Invalid command, enter h for help.");
				break;
			}
		}
	}
	
	
	public static void saveStudRecsToFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(StudRecsWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			StudRecsWrapper wrapper = new StudRecsWrapper();
			wrapper.setStudRecs(studRecs);
			
			m.marshal(wrapper, file);
			System.out.println("File saved!");
		} catch (Exception e) {
			System.out.println("Cannot save file, check write permissions!");
		}
	}
	
	public static void loadStudRecsFromFile(File file) {
		
	}
	
	/**
	 * Print a specified student record
	 * @param i index of the record to print
	 */
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
	
	/**
	 * Print all student records
	 */
	public static void printAllRecords() {
		for (int i = 0; i<studRecs.size(); i++) {
			printRecord(i);
		}
	}
	
	/**
	 * Create and append a new student record
	 * @throws IOException
	 */
	public static void createRecord() throws IOException {
		studRecs.add(new Student());
		int i = studRecs.size() - 1;
		Student tempRecord = studRecs.get(i);
		System.out.println("Creating Student " + i + " (" + tempRecord.getStudentID() + ")");
		tempRecord.setFirstName(StudentInput.firstName());
		tempRecord.setLastName(StudentInput.lastName());
		tempRecord.setStreetAddress(StudentInput.streetAddress());
		tempRecord.setCity(StudentInput.city());
		tempRecord.setProvince(StudentInput.province());
		tempRecord.setPostalCode(StudentInput.postalCode());
		tempRecord.setPhoneNumber(StudentInput.phoneNumber());
		tempRecord.setBirthDate(StudentInput.birthDate());
		System.out.println("Student " + i + " (" + tempRecord.getStudentID() + ")" + " Created!");
	}
	
	/**
	 * Remove a specified student record
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void removeRecord() throws NumberFormatException, IOException {
		System.out.print("Enter record number: ");
		int i = Integer.parseInt(in.readLine());
		System.out.print("Are you SURE you want to delete record " + i + "? (y/n): ");
		switch (in.readLine().toLowerCase()) {
		case "y":
			try {
				studRecs.remove(i);
				System.out.println("Record " + i + " removed, records following it have been shifted down 1!");
				break;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Invalid student! Aborting!");
				break;
			}
		case "n":
			System.out.println("Aborting!");
			break;
		default:
			System.out.println("Invalid input, aborting!");
			break;
		}
		return;
	}

}
