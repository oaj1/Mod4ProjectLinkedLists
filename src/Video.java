
@SuppressWarnings("rawtypes")
public class Video implements Comparable{
	//instance variables of name and available
	private String name;
	private boolean available;
	
	//constructor
	public Video(String name) { 
		this.name = name; //get the name
		available = true; //available default will be true
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isAvailable() { //isAvailable returns boolean available (true)
		return available;
	}
	
	public void makeAvailable() { //make available used to set available to true
		available = true;
	}
	
	
	public void notAvailable() { //not available used to set available to false
		available = false;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	@Override
	public String toString() { //This method will return the video and availability
		return "Video [name=" + name + ", available=" + available + "]";
	}


	@Override
	public int compareTo(Object o) {//left as an object to keep it more generic
		
		if(o == null) {
			return 1; //means we are returning greater than the object cant be equal
		}
		else if (!(o instanceof Video)) 
		{
			return 1; //means we are returning greater than the object can't be equal
		}
		Video video = (Video) o; //typecasting o to a Video object
		
		return name.compareTo(video.name);//compare video names
	}
	
	 

}
