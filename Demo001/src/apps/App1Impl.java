package apps;

import annotations.MyAnnotation;
import interfaces.IApp;

@MyAnnotation
public class App1Impl implements IApp {
	public String getName() {
		return this.getClass().getName();
	}

}
