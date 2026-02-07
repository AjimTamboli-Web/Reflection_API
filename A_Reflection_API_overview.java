package reflection_API_Custom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class A_Reflection_API_overview {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// this way you can get a class name
		System.out.println("Class Name:: "+ Custom.class); // o/p => class reflection_API_Custom.Custom

		//  we get Class object using Class.forName command
		Class<?> cla = Class.forName("reflection_API_Custom.Custom");  // throws ClassNotFoundException 
		
		Constructor<?>[] con = cla.getDeclaredConstructors();
		
		for(Constructor<?> c:con) {
			System.out.println(c);
			System.out.println(c.getParameterCount());
			Class<?>[] para = c.getParameterTypes();
			
			for(Class<?> p:para) {
				System.out.println(p);
			}
			System.out.println("____________________________________");
		}
		
		Constructor<?> con2 = cla.getDeclaredConstructor(int.class,String.class);
		System.out.println(con2);
		
		
//		con2.setAccessible(true);  this way also work by passing flag 
	     System.out.println(con2.trySetAccessible());  // this is try to set flag true if possible otherwise return false if not set.
	     
	     Custom cu = (Custom) con2.newInstance(21,"Jerry");
	     
	     
	     System.out.println(cu.name);
	     
	     
		
	}

}


class Custom{
	
	private int id;
	String name;
	
  private Custom(){
		System.out.println("Default Constructor!!");
	}
	
  private Custom(int id,String name){
		this.id = id;
		this.name = name;
		System.out.println("Parameterized Constructor!!");
	}
  
  private Custom(int i) {
	  this.id = i;
	  System.out.println("Int constructor invoked!!");
	  
  }
	
	public String toString() {
		return this.id + " " + this.name;
	}
  
}