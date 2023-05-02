
public class CustomerList 
{
	// Instance Variables for the next customer, their service and arrival time, and
	// their name.
	private CustomerList next;
	
	private String name;
	
	private int serviceTime;
	private int arrivalTime;

	public CustomerList(String custName, int arrival, int service) 
	{
		arrivalTime = arrival;
		serviceTime = service;
		name = custName;
		next = null;
	}
	
	// Prints the customer's time of service and arrival
	public void printCustom() 
	{
		System.out.println("	" + name + ": Arrival = " + arrivalTime + ": Service = " + serviceTime);
	}

	// Returns arrival time
	public int getArrivalTime() 
	{
		return arrivalTime;
	}

	// Sets time of arrival
	public void setArrivalTime(int newAr) 
	{
		arrivalTime = newAr;
	}

	// Sets time of service
	public void setServiceTime(int newServ) 
	{
		serviceTime = newServ;
	}
	
	// Returns time of service
	public int getServiceTime() 
	{
		return serviceTime;
	}

	// Returns customer's name
	public String getName() 
	{
		return name;
	}

	// Sets customer's name
	public void setName(String newName) {
		name = newName;
	}

	// Sets next customer
	public void setNext(CustomerList newNext) 
	{
		next = newNext;
	}
	
	// Returns next customer
	public CustomerList getNext() 
	{
		return next;
	}

}
