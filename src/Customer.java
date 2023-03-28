
@SuppressWarnings("rawtypes")
public class Customer implements Comparable{
	
	private String name;
	private boolean available;
	
	
	public Customer(String name) { //have a constructor
		this.name = name; //get the name
		available = true; //the customer is available
	}//Constructor 
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}


	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return available;
	}
	
	public void setAvailable(boolean available) {
		 this.available = available;
	}
	
	@Override
	public int compareTo(Object o) {//left as an object to keep it more generic
		
		if(o == null) {
			return 1; //means we are returning greater than the object cant be equal
		}
		else if (!(o instanceof Customer)) 
		{
			return 1; //means we are returning greater than the object can't be equal
		}
		Customer customer = (Customer) o; //typecasting o to a Video object
		
		return name.compareTo(customer.name);//compare video names
	}
	


	

}
