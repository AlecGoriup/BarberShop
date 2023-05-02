
public class Main 
{
	// Static Instance variable for time
	private static int time = 0;

	public static void main(String[] args) 
	{

		Arrivals arrivalList = new Arrivals();
		
		// Object that checks available chairs
		WaitingList waiting = new WaitingList(3);
		
		// Setting the chair Object to null
		CustomerList chair = null;

		System.out.println("Opening and Reading File Customers.txt");
		
		// Reads in the text file
		arrivalList.readFile("src/customers.txt");

		System.out.println("Finished reading file");
		// While loop that contains conditionals for the barbershop
		while (chair != null || !waiting.isListEmpty() || !arrivalList.isArrivalEmpty()) {

			System.out.println("Time = " + time);

			if (chair == null) {
				// Checks if the waiting list isn't empty, if a customer is added to the chair
				if (!waiting.isListEmpty()) {
					chair = waiting.removeCustomer();
				} else {
					// If empty the barber takes a break
					System.out.println("Barber takes a break");
				}
			} else {
				// Subtracts from the customer's service time, and when it's 0 they leave from
				// the barbers chair
				int serviceTime = chair.getServiceTime();
				serviceTime--;

				chair.setServiceTime(serviceTime);

				if (serviceTime == 0) {
					chair = null;
				}
			}
			// If the arrival list is empty and the time equals the next customer's arrival
			// time that customer is added to the waiting list
			if (!arrivalList.isArrivalEmpty() && (time == arrivalList.nextCust().getArrivalTime())) 
			{

				CustomerList nextCust = arrivalList.removeCustQueue();

				if (waiting.addCustomer(nextCust)) 
				{

					System.out.println("A chair is available");

					System.out.println("	" + waiting.nextCust().getName() + " sits");

					System.out.println("Chairs");
					waiting.displayWaitingList();
				} 
				
				else 
				{
					System.out.println("All chairs are full");

				}
			} 
			
			else 
			{
				System.out.println("Chairs");
				waiting.displayWaitingList();
				
			}
			
			// Checks if the waiting list is empty
			if (waiting.isListEmpty()) 
			{
				System.out.println("Chairs are empty");
			}
			
			// Checks if the chair and waiting list is empty
			if (chair == null && waiting.isListEmpty()) 
			{
				System.out.println("Barber's chair is empty\n");
			}
			
			// If the chair is null the next customer in the waiting list is added to the
			// barbers chair
			if (chair == null) 
			{
				chair = waiting.removeCustomer();

			} 
			
			else 
			{
				System.out.println("Barber");
				System.out.println("	" + chair.getName() + " is chair " + chair.getServiceTime() + " left");
			}
			System.out.println("Arrival List");

			arrivalList.displayArrivalList();

			System.out.println("--------------------------------");
			
			// Adds to the time count
			time++;
		}
		// If empty and there are no more customers the program ends
		if (arrivalList.isArrivalEmpty() && waiting.isListEmpty() && chair == null) 
		{
			System.out.println("Process Completed");

		}
	}
}
