
public class WaitingList 
{

	// Instance variables for tail, head and the number of customers in the queue
	private int tail;
	private int head;
	private int amountLeft;
	private int size;
	
	// Customer list
	private CustomerList[] customers;

	// Waiting queue defaulted to amount of chairs in barber shop
	public WaitingList(int size) 
	{
		head = 0;
		tail = 0;
		amountLeft = 0;
		customers = new CustomerList[size];
		this.size = size;

	}

	// Removes customer at the head, then places the next in queue to head
	public CustomerList removeCustomer() 
	{
		if (amountLeft == 0) 
		{
			return null;
		} 
		
		else 
		{
			CustomerList tempCustom = customers[head];
			customers[head] = null;
			head = (head + 1) % customers.length;
			amountLeft--;
			
			return tempCustom;
		}
	}

	// Method that add's a new customer when called
	public boolean addCustomer(CustomerList addCust) 
	{
		if (amountLeft == customers.length) 
		{
			return false;
		} 
		
		else 
		{
			customers[tail] = addCust;
			tail = (tail + 1) % customers.length;
			amountLeft++;
			return true;
		}
	}

	public CustomerList nextCust() 
	{
		if (amountLeft == 0) 
		{
			return null;
		}
		
		else if (tail == 0) 
		{
			return customers[customers.length - 1];
		}
		
		else 
		{
			return customers[tail - 1];
		}
	}

	// Checks if list is empty
	public boolean isListEmpty() 
	{
		return (amountLeft == 0);
	}

	// Checks if list is full
	public boolean isListFull() 
	{
		return (amountLeft == customers.length);
	}

	// Displays the waiting queue
	public void displayWaitingList() 
	{
		if (amountLeft == 0) 
		{
			return;
		} 
		
		else if (tail <= head) 
		{
			for (int i = head; i < customers.length; i++) 
			{
				CustomerList currCustom = customers[i];
				currCustom.printCustom();
				
			}

			for (int i = 0; i < tail; i++) 
			{
				CustomerList currCustom = customers[i];
				currCustom.printCustom();
				
			}
		}
		
		else 
		{
			for (int i = head; i < tail; i = (i + 1) % customers.length) 
			{
				CustomerList currCustom = customers[i];
				currCustom.printCustom();
				
			}
		}
	}
}
