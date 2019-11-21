//package assignment2;

import java.util.Random;

/**
 * The purpose of this class is to model a ticket
 * 09/30/2018
 * @author Gabriel I Feliz
 * 
 */
public class Ticket {

	/**
	 * Instantiate Random object for generating random ticket number and day number of ticket date
	 */
	private Random rnd = new Random();

	/**
	 * The name of the violator
	 */
	private String name;

	/**
	 * The type of the ticket (either PAYABLE or MUST APPEAR)
	 */
	private String ticketType;

	/**
	 * The speed of violator
	 */
	private int speed;

	/**
	 * The speed limit that violator should have driven under
	 */
	private int speedLimit;

	/**
	 * The ticket number
	 */
	private int ticketNum;

	/**
	 * The value if true determines that the incident is in school zone, otherwise not in school zone if false
	 */
	private boolean schoolZone;

	/**
	 * The value if true determines that the incident is in work zone, otherwise not in work zone if false
	 */
	private boolean workZone;

	/**
	 * The constructor initializes a ticket with info provided by the user
	 * @param name The name of the violator
	 * @param speed The speed of violator
	 * @param speedLimit The speed limit that violator should have driven under
	 * @param school The value if true determines that the incident is in school zone, otherwise not in school zone if false
	 * @param work The value if true determines that the incident is in school zone, otherwise not in work zone if false
	 */
	public Ticket(String name, int speed, int speedLimit, boolean school, boolean work) {
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.schoolZone = school;
		this.workZone = work;
	}

	/**
	 * The constructor initializes a ticket with info provided by the user, excluding school and work zone conditions
	 * @param name The name of the violator
	 * @param speed The speed of violator
	 * @param speedLimit The speed limit that violator should have driven under
	 */
	public Ticket(String name, int speed, int speedLimit) {
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		schoolZone = workZone = false;
	}

	/**
	 * Gets the name of the violator
	 * @return The name of the violator
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establishes the name of the violator
	 * @param name The name of the violator
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the speed of the violator
	 * @return The speed of the violator
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Establishes the speed of the violator
	 * @param speed The speed of the violator
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Gets the speed limit the violator should have gone under
	 * @return The speed limit
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}

	/**
	 * Establishes the speed limit the violator should have gone under
	 * @param speedLimit The speed limit
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	/**
	 * Gets the ticket number
	 * @return The ticket number
	 */
	public int getTicketNum() {
		return ticketNum;
	}

	/**
	 * Establishes the ticket number
	 * @param ticketNum The ticket number
	 */
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	/**
	 * Gets whether violator was in school zone
	 * @return True if in school zone, false if not
	 */
	public boolean isSchoolZone() {
		return schoolZone;
	}

	/**
	 * Establishes if the violator was in school zone
	 * @param schoolZone If the violator was in school zone
	 */
	public void setSchoolZone(boolean schoolZone) {
		this.schoolZone = schoolZone;
	}

	/**
	 * Gets whether violator was in work zone
	 * @return True if in work zone, false if not
	 */
	public boolean isWorkZone() {
		return workZone;
	}

	/**
	 * Establishes if the violator was in school zone
	 * @param workZone If the violator was in school zone
	 */
	public void setWorkZone(boolean workZone) {
		this.workZone = workZone;
	}

	/**
	 * Calculate the speeding fine. Calculate the fine based on the following:
	 * 1 - 10 MPH over limit - $140 minimum
	 * school zone - $200
	 * work zone - $250
	 *
	 * 11 - 30 MPH over limit - $195 minimum
	 * school zone - $310
	 * work zone - $360
	 * surcharge of $300 for 21 - 30 MPH over
	 *
	 * 31 MPH + over limit - must appear personally
	 * surcharge of $450 for 31 - 40 MPH over
	 * surcharge of $675 for 41 MPH and up
	 * @return The speeding fine
0     */
	public double calculateFine() {
		if (speed - speedLimit >= 1 && speed - speedLimit <= 10)
			return (workZone ? 250.00 : (schoolZone ? 200.00 : 140.00));
		else if (speed - speedLimit >= 11 && speed - speedLimit <= 30) {
			if (speed - speedLimit >= 21 && speed - speedLimit <= 30) {
				return (workZone ? 660.00 : (schoolZone ? 610.00 : 495.00));
			}
			return (workZone ? 360.00 : (schoolZone ? 310.00 : 195.00));
		} else if (speed - speedLimit >= 31) {
			return (speed - speedLimit >= 41 ? 675.00 : 450.00);
		} else {
			return 0;
		}
	}

	/**
	 * Determines the ticket type (PAYABLE or MUST APPEAR)
	 * @return The ticket type
	 */
	public String determineTicketType() {
		if (speed - speedLimit >= 1 && speed - speedLimit <= 30) {
			return "PAYABLE";
		} else if (speed - speedLimit >= 31) {
			return "MUST APPEAR";
		}
		return "";
	}

	/**
	 * Gets the ticket type (PAYABLE or MUST APPEAR)
	 * @return The ticket type
	 */
	public String getTicketType() {
		ticketType = determineTicketType();
		return ticketType;
	}

	/**
	 * Generates random ticket number
	 * @return The ticket number
	 */
	public int generateTicketNum() {
		ticketNum = 100000 + rnd.nextInt(900000);
		return ticketNum;
	}

	/**
	 * Randomly generates a day between 1 and 31 inclusively.
	 * All court dates will take place in October 2018.
	 * @return The court date
	 */
	public String generateCourtDate() {
		return "October " + (1 + rnd.nextInt(31)) + ", 2018";
	}

	/**
	 * Prints a notice to be sent to the speeder Must follow exact format. See assignment description
	 * Note: There are no blank lines before "Department of Motor Vehicles"
	 * There are two blank lines between "Automated Traffic Enforcement" and the "Dear (name)"
	 * There is one black line between "Dear (name)" and "Please pay ..."
	 * @return The notice to be sent to the speeder
	 */
	public String printNotice() {
		String notice = "Department of Motor Vehicles\n" +
				"Automated Traffic Enforcement\n" +
				"\n" +
				"\n" +
				"Dear " + name + ",\n" +
				"\n" +
				"Please pay the following speeding fine of $" + String.format("%.2f", calculateFine()) + " to the DMV within 10 days of \n" +
				"receiving this notice to avoid a driver’s license suspension. You are being fined \n" +
				"for going " + speed + " MPH in a " + speedLimit + " MPH " + (schoolZone ? "school" : "work")+ " zone. \n" +
				"\n" +
				"Ticket Type: " + determineTicketType() + " \n" +
				"You must appear at the County Court House on " + generateCourtDate() + " \n" +
				"Ticket Number: " + generateTicketNum() + " \n" +
				"\n" +
				"Returned checks are subject to a returned check fee of $35.00. \n" +
				"\n" +
				"Sincerely, \n" +
				"Gabriel I Feliz ";
		return calculateFine() > 0.00 ? notice : "";
	}

	/**
	 * String representation of the ticket object
	 * No specific format
	 * Must include at a minimum Name, speed, speed limit, ticket number and ticket Type
	 * @return The String representation of the ticket
	 */
	@Override
	public String toString() {
		return "Name: " + name + " Speed: " + speed
				+ " Speed Limit: " + speedLimit
				+  " Ticket Number: " + ticketNum
				+ " Ticket Type: " + ticketType;
	}
}