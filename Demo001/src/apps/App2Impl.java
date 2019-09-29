package apps;
import annotations.MyAnnotation;
import interfaces.IApp;


public class App2Impl implements IApp {	
	public String getName() {
		return this.getClass().getName();
	}
}
