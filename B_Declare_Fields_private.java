package reflection_API_Custom;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class B_Declare_Fields_private {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		//		System.out.println(Animals.class);
		
		Class<?> cls = Class.forName("reflection_API_Custom.Animals");
		
		Constructor<?> con = cls.getDeclaredConstructor();
		System.out.println(con.trySetAccessible());
		
		Animals ani = (Animals) con.newInstance();
		
		Field f = cls.getDeclaredField("speed");
		Field fi = cls.getDeclaredField("name");
		
//		f.setAccessible(true);
		System.out.println(f.trySetAccessible());
		fi.setAccessible(true);  // both way can try 
		
		fi.set(ani, "Tiger");
		f.set(ani, 123);
		System.out.println(fi.get(ani) + ":" + f.getInt(ani));
		
	}

}

class Animals{
	
	private int speed;
	private String name;
	
	Animals(){
		System.out.println("Animal object created!!");
	}
	
}