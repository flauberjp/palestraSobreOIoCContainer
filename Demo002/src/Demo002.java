import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import annotations.ConditionalOnPropertyCustom;
import interfaces.IApp;

public class Demo002 {
	IApp myApp;
	
	Demo002(IApp myApp) {
		this.myApp = myApp;
	}
	
	String getName() {
		return this.myApp.getName();
	}
	
	public static void main(String[] args) throws Exception {
		IApp myApp = null;
		
		List<Class> myClasses = new ArrayList<>();
		myClasses.add(Demo002.class.getClassLoader().loadClass("apps.App1Impl"));
		myClasses.add(Demo002.class.getClassLoader().loadClass("apps.App2Impl"));
		
		for (Class myClass : myClasses) {
			if(!IApp.class.isAssignableFrom(myClass)) {
				continue;
			}
			if(myClass.isAnnotationPresent(ConditionalOnPropertyCustom.class)) {
				ConditionalOnPropertyCustom annotation = (ConditionalOnPropertyCustom) myClass.getAnnotation(ConditionalOnPropertyCustom.class);
				if(annotation.value().equalsIgnoreCase(getValueFromPropertiesFile())) {
					myApp = (IApp)myClass.newInstance();
					break;
				} 
			}
		}
		
		if(myApp == null) {
			throw new Exception("Nenhuma app configurada");
		}
		
		Demo002 demo = new Demo002(myApp);
		
		System.out.println(demo.getName());
		
	}
	
	public static String getValueFromPropertiesFile() throws FileNotFoundException, IOException {
		Properties appProps = new Properties();
		appProps.load(
				Demo002.class.getResourceAsStream("/application.properties"));
		 
		return appProps.getProperty("app-to-use");
	}

}
