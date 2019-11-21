//package assignment2;

import java.util.Scanner;

public class TicketDriver {

	public static void main(String[] args) {
		// Create Scanner object to read user input
		Scanner sc = new Scanner(System.in);
		// Declare Ticket object
		Ticket ticket;
		// Declare String variables for violator's name and responses for school zone, workZone, and another ticket questions
		String violatorName, schoolZone, workZone, anotherTicket;
		// Declare int variables for violator's speed and speed limit
		int speed, speedLimit;
		// Declare boolean to determine whether the incident was in a school zone or work zone
		boolean isSchoolZone, isWorkZone;

		// Print the purpose of the program
		System.out.println("\nTicket Manager");

		// Enter info for a single ticket and repeat processing different ticket reports until the user does not enter y or Y
		do {
			// Prompt user for violator's name
			System.out.print("\nPlease enter the name of the violator: ");
			// Read what the user enters as the violator's name
			violatorName = sc.nextLine();

			// Prompt user for speed of the violator
			System.out.print("Please enter the speed of the violator (>0): ");
			// Read what the user enters as speed of the violator
			speed = sc.nextInt();

			// Repeat until the speed of the violator was positive
			while (speed <= 0) {
				System.out.print("Invalid input. Please enter the speed of the violator (>0): ");
				speed = sc.nextInt();
			}

			// Prompt user for speed limit
			System.out.print("Please enter the speed limit (>0,<=80): ");
			// Read what the user enters as speed limit
			speedLimit = sc.nextInt();

			// Repeat until the speed limit is between 0 (exclusive) and 80 (inclusive)
			while (speedLimit <= 0 || speedLimit > 80) {
				System.out.print("Invalid input. Please enter the speed limit (>0): ");
				speedLimit = sc.nextInt();
			}

			// Prompt user for whether the incident was in a school zone
			System.out.print("Did this happen in a school zone (Y/N): ");
			sc.nextLine(); // Read extra newline character from previously entering a number
			// Read what the user enters as a response to the school zone question
			schoolZone = sc.nextLine();
			// Repeat until the user enters y, Y, n, or N
			while (!schoolZone.equalsIgnoreCase("Y")) {
				if (!schoolZone.equalsIgnoreCase("N")) {
					System.out.print("Invalid input. Did this happen in a school zone (Y/N): ");
					schoolZone = sc.nextLine();
				} else break;
			}
			// Assign the value of isSchoolZone based on whether the user answered that it was in a school zone
			isSchoolZone = schoolZone.equalsIgnoreCase("Y");

			// Prompt user for whether the incident was in a work zone
			System.out.print("Did this happen in a work zone (Y/N): ");
			// Read what the user enters as a response to the work zone question
			workZone = sc.nextLine();
			// Repeat until the user enters y, Y, n, or N
			while (!workZone.equalsIgnoreCase("Y")) {
				if (!workZone.equalsIgnoreCase("N")) {
					System.out.print("Invalid input. Did this happen in a work zone (Y/N): ");
					workZone = sc.nextLine();
				} else break;
			}
			// Assign the value of isSchoolZone based on whether the user answered that it was in a work zone
			isWorkZone = workZone.equalsIgnoreCase("Y");

			// Instatiate Ticket object with the info provided by the user
			ticket = new Ticket(violatorName, speed, speedLimit, isSchoolZone, isWorkZone);

			// Print message that will be sent to the violator
			System.out.println("\n\n" + ticket.printNotice() + "\n\n");

			// Prompt user for permission to enter another ticket
			System.out.print("Do you want to enter another ticket (Y/N): ");
			// Read what the user entered for the user's response
			anotherTicket = sc.nextLine();
			// Repeat until the user enters y, Y, n, or N
			while (!anotherTicket.equalsIgnoreCase("Y")) {
				if (!anotherTicket.equalsIgnoreCase("N")) {
					System.out.print("Invalid input. Do you want to enter another ticket (Y/N): ");
					anotherTicket = sc.nextLine();
				} else break;
			}

		} while (anotherTicket.equalsIgnoreCase("Y"));

		// Print exit message for the program
		System.out.println("\n" + "Exiting the Ticket Manager");

		sc.close(); // Close Scanner object to solve resource leak warning
	}

}
