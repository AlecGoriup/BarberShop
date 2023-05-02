
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arrivals 
{
	//Instance variables for the head and tail of the queue
	private CustomerList head, tail;

	// Checks if arrivals are empty
	public boolean isArrivalEmpty() 
	{
		return head == null;
	}

	// Method that takes in the name of customer, and their arrival time and service
	// time, then add's the customer to the end of the queue
	public void addCustQueue(String name, int arrivalTime, int serviceTime) 
	{
		CustomerList firstCust = new CustomerList(name, arrivalTime, serviceTime);
		// Checks if the arrival list is empty, if so the customer at the tail becomes
		// the head of the queue, if not the tail is set as the next in the queue
		if (isArrivalEmpty()) 
		{
			tail = firstCust;
			head = tail;
		} 
		else 
		{
			tail.setNext(firstCust);
			tail = firstCust;
		}
	}

	// Method that removes customer from the queue
	public CustomerList removeCustQueue() 
	{
		// If the arrival list is empty nothing happens, if not the head is set to the
		// next in the queue and the first customer is set as null
		if (isArrivalEmpty()) 
		{
			return null;
		} 
		
		else 
		{
			CustomerList firstCust = head;
			head = head.getNext();
			firstCust.setNext(null);
			return firstCust;
		}
	}

	// Returns the next customer in the list
	public CustomerList nextCust() 
	{
		return head;
	}

	// Displays the customers that are arriving
	public void displayArrivalList() 
	{
		if (isArrivalEmpty()) 
		{
			return;
		}
		
		else 
		{
			CustomerList headCust = head;
			headCust.printCustom();

			while (headCust.getNext() != null) 
			{
				headCust = headCust.getNext();
				headCust.printCustom();
			}
		}
	}

	// Reads in the Customer.txt file, and stores the customers arrival time,
	// service time, and name in variables and then adds the customer to the queue
	public void readFile(String fileName) 
	{
		File file = new File(fileName);
		Scanner scanner = null;
		
		try 
		{
			scanner = new Scanner(file);
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		while (scanner.hasNextLine()) 
		{

			String line = scanner.nextLine();
			Scanner nextLine = new Scanner(line);

			int arrival = nextLine.nextInt();
			int service = nextLine.nextInt();

			String custName = nextLine.next();

			addCustQueue(custName, arrival, service);

			nextLine.close();
		}
		scanner.close();
	}

}
