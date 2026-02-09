package reflection_API_Custom;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class C_Declare_Method_private {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
//		Class<?> cls = Try_Meth.class;  // does not throw Exception
		Class<?> cl = Class.forName("reflection_API_Custom.Try_Meth"); // it throw exception
		
		  Constructor<?>[] con = cl.getDeclaredConstructors();   // import constructor and get array of Constructors in your class
		  
		  for(Constructor<?> c:con) {  // loop for to see constructors
			  System.out.println(c);  // print constructor name
			  
			   Parameter[] pa = c.getParameters();
			    for(Parameter p:pa) {   // loop for to see parameters also
			    	
			    	System.out.println(p);
			    }
			    System.out.println("_________________________________________");
		  }
		  Constructor<?> cons = cl.getDeclaredConstructor(int.class,String.class);  // declare the constructor you want
		  cons.setAccessible(true);  // get access to constructor and use it 
		  
		  System.out.println("_______________Constructors Invoke__________________________");
		  
		  Try_Meth obj =(Try_Meth) cons.newInstance(23,"Percy Jackson"); // create instance/ object to invoke 
		  
		 
		  
		  System.out.println("______________Fields______________________");
		  
		  Field[] fi =  cl.getDeclaredFields(); // import fields and get array of fields in your class
		  for(Field fe: fi) { // loop for to see fields
			  System.out.println(fe.getName());	  // getName for getting your class inside fields name   
		  }
		  
		  System.out.println("_____________Field invoke__________________");
		  
		  Field id = cl.getDeclaredField("id"); // get id of the field name which you want to work with
		  Field name = cl.getDeclaredField("name");
		  Field salary = cl.getDeclaredField("Salary");
		  Field dept  = cl.getDeclaredField("dept");
		  
		  id.setAccessible(true);  // set accessible for using if it is private
		  name.setAccessible(true);
		  salary.setAccessible(true);
		  dept.setAccessible(true);
		  
		  id.setInt(obj, 89); // set the value of variable in meth object
		  name.set(obj, "Jackob ");
		  salary.setDouble(obj, 3254.654);
		  dept.setChar(obj, 'A');
		  
		  System.out.print(id.get(obj) + " "); 
		  System.out.print(name.get(obj) + " ");
		  System.out.print( salary.getDouble(obj) + " ");    
		  System.out.println( dept.getChar(obj));
				  		  
 System.out.println("______________Method invoke_______________________");
		  
		  Method[] me = cl.getDeclaredMethods();
		  for(Method m:me) {
			  System.out.println(m.getName());
		  }
		  
		  Method met1 = cl.getDeclaredMethod("setName",String.class);
		  Method met2 = cl.getDeclaredMethod("getName");
		  
		  met1.setAccessible(true);
		  met2.setAccessible(true);
		  
		  Object o = met1.invoke(obj, "Java");
		  System.out.println(met2.invoke(obj));
		  
		  
	}

}

class Try_Meth {
	private int id;
	private String name;
	private double Salary;
	private char dept;
	
	private Try_Meth() {
		System.out.println("Default Constructor!!!");
	}
	
	private Try_Meth(int i) {
		this();
		this.id = i;
		System.out.println("One Parameter Constructor!! " + i);
	}
	
	private Try_Meth(int i,String name) {
		this(i);
		this.id = i;
		this.name = name;
		System.out.println("Two parameter constructor!!!" + i  + " " + name);
		
	}
	
	private void setName(String name) {
		 this.name = name;
	}
	
	private String getName() {
		return this.name;
	}
	
	private static String company;
	private static void show() {
		System.out.println("Show" + company);
	}
	
}
