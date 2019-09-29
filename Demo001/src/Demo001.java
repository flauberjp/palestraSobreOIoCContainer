import java.util.ArrayList;
import java.util.List;

import annotations.MyAnnotation;
import interfaces.IApp;

public class Demo001 {
	IApp myApp;
	
	Demo001(IApp myApp) {
		this.myApp = myApp;
	}
	
	String getName() {
		return this.myApp.getName();
	}
	
	public static void main(String[] args) throws Exception {
		
		IApp myApp = null;
		
		List<Class> myClasses = new ArrayList<>();
		myClasses.add(Demo001.class.getClassLoader().loadClass("apps.App1Impl"));
		myClasses.add(Demo001.class.getClassLoader().loadClass("apps.App2Impl"));
		
		for (Class myClass : myClasses) {
			if(!IApp.class.isAssignableFrom(myClass)) {
				continue;
			}
			if(myClass.isAnnotationPresent(MyAnnotation.class)) {
				myApp = (IApp)myClass.newInstance(); 
			}
		}
		
		if(myApp == null) {
			throw new Exception("Nenhuma app configurada");
		}
		
		Demo001 demo = new Demo001(myApp);
		
		System.out.println(demo.getName());
		
	}

}
