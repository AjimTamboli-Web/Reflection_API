package reflection_API_Custom;

import java.lang.reflect.Method;

public class D_Declare_static_methods_var_private {

	public static void main(String[] args) throws Exception {
		
		Class<?> cls = Custom_Stat.class;
		
		Method me = cls.getDeclaredMethod("setName",String.class,int.class);
		
		 me.setAccessible(true);
	     Object o =	me.invoke(me, "John",90);
	     System.out.println(o);
	     
		Method meth = cls.getDeclaredMethod("getName");
		
		 meth.setAccessible(true);
		 meth.invoke(meth);
		
		Method m3 = cls.getDeclaredMethod("printA");
		
		m3.setAccessible(true);
		m3.invoke(meth);
		
	}

}

class Custom_Stat{
	
	private static String name  = null;
	private static int id = 0;
	
	Custom_Stat(){
		System.out.println("Object Created....");
	}
	
	private String printA() {
		return name + " " + id;
	}
	
	private static String setName(String name,int id) {
		return name + " " + id;
	}
	
	private static void getName() {
		System.out.println(name + " " + id);
	}
	
}
