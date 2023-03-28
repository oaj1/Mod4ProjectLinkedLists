import java.util.Iterator;
/**
 * 
 * ListInterface will possess all the abstract methods
 *
 * @param <T>
 */
public interface ListInterface<T>  { //T indicates whatever made up data type i.e. VIDEO or CUSTOMER
	
	public void add(T t);//add gets a video or customer, using generic type T
	public void delete(T t); //delete gets a video or customer, using generic type T
	public void print();//used to print either customers or videos
	T get(T t);
	public Iterator <T> iterator();
}
