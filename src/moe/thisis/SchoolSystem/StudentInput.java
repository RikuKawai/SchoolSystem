package moe.thisis.SchoolSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentInput {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static String firstName() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter First Name: ");
			String firstName = in.readLine();
			switch (firstName.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			default:
				valid = true;
				return firstName;
			}
		}
		return null;
	}
	
	public static String lastName() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Last Name: ");
			String lastName = in.readLine();
			switch (lastName.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			default:
				valid = true;
				return lastName;
			}
		}
		return null;
	}
	
	public static String streetAddress() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Street Address: ");
			String streetAddress = in.readLine();
			switch (streetAddress.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			default:
				valid = true;
				return streetAddress;
			}
		}
		return null;
	}
	
	public static String city() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter City: ");
			String city = in.readLine();
			switch (city.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			default:
				valid = true;
				return city;
			}
		}
		return null;
	}
	
	public static String province() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Province: ");
			String province = in.readLine();
			switch (province.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			default:
				valid = true;
				return province;
			}
		}
		return null;
	}
	
	public static String postalCode() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Postal Code: ");
			String postalCode = in.readLine();
			postalCode = postalCode.toUpperCase();
			switch (postalCode.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			case 6:
				postalCode = postalCode.substring(0,3) + " " + postalCode.substring(3);
				valid = true;
				return postalCode;
			case 7:
				if (postalCode.charAt(3) != ' ') {
					postalCode = postalCode.substring(0,4) + ' ' + postalCode.substring(5);
					valid = true;
					return postalCode;
				}
				valid = true;
				return postalCode;
			default:
				System.out.println("Invalid postal code!");
				break;
			}
			
		}
		return null;
	}
	
	public static String phoneNumber() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pattern = "\\b\\d{3}[-.]?\\d{3}[-.]?\\d{4}\\b";
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Phone Number: ");
			String phoneNumber = in.readLine();
			if (!phoneNumber.matches(pattern)) {
				phoneNumber = "";
			}
			switch (phoneNumber.length()) {
			case 0:
				System.out.println("Invalid phone number!");
				break;
			case 10:
				phoneNumber = phoneNumber.substring(0,3) + "-" + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6);
				valid = true;
				return phoneNumber;
			case 12:
				phoneNumber = phoneNumber.substring(0,3) + '-' + phoneNumber.substring(4,7) + '-' + phoneNumber.substring(8);
				valid = true;
				return phoneNumber;
			default:
				System.out.println("Invalid phone number!");
				break;
			}
		}
		return null;
	}
	
	public static String birthDate() throws IOException {
		String birthYear = birthYear();
		String birthMonth = birthMonth();
		String birthDay = birthDay(Integer.parseInt(birthMonth), Integer.parseInt(birthYear));
		
		return birthMonth + "/" + birthDay + "/" + birthYear;
	}
	
	public static String birthYear() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Birth Year: ");
			String birthYear = in.readLine();
			switch (birthYear.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			case 2:
				birthYear = "19" + birthYear;
				valid = true;
				return birthYear;
			case 4:
				valid = true;
				return birthYear;
			default:
				System.out.println("Invalid year!");
				break;
			}
		}
		return null;
	}
	
	public static String birthMonth() throws IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Birth Month: ");
			String birthMonth = in.readLine();
			switch (birthMonth.length()) {
			case 0:
				System.out.println("This field is required!");
				break;
			case 1:
				birthMonth = "0" + birthMonth;
				valid = true;
				return birthMonth;
			case 2:
				valid = true;
				return birthMonth;
			default:
				if (monthNumber(birthMonth) != null) {
					valid = true;
					return monthNumber(birthMonth);
				}
				System.out.println("Invalid month, check your spelling or enter numerically!");
				break;
			}
		}
		return null;
	}
	
	public static String birthDay(int month, int year) throws NumberFormatException, IOException {
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter Birth Day: ");
			int birthDay = Integer.parseInt(in.readLine());
			if (birthDay > 0 && birthDay <= numDays(month,year)) {
				valid = true;
				String birthDayString = Integer.toString(birthDay);
				switch (birthDayString.length()) {
				case 1:
					return "0" + birthDayString;
				case 2:
					return birthDayString;
				}
			}
			System.out.println("This day is not valid for the specified month and/or year!");
		}
		return null;
	}
	
	public static int numDays(int month, int year) {
		switch (month) {
        case 1: case 3: case 5:
        case 7: case 8: case 10:
        case 12:
            return 31;
        case 4: case 6:
        case 9: case 11:
            return 30;
        case 2:
            if (((year % 4 == 0) && 
                 !(year % 100 == 0))
                 || (year % 400 == 0))
                return 29;
            else
                return 28;
        default:
            System.out.println("User should not see this error.");
            break;
		}
		return 0;
	}
	
	public static String monthNumber(String month) {
		switch (month.toLowerCase()) {
		case "january":
            return "01";
        case "february":
            return "02";
		case "march":
            return "03";
		case "april":
            return "04";
		case "may":
            return "05";
		case "june":
            return "06";
		case "july":
            return "07";
		case "august":
            return "08";
		case "september":
            return "09";
		case "october":
            return "10";
		case "november":
            return "11";
		case "december":
            return "12";
		default: 
            return null;
		}
	}
}