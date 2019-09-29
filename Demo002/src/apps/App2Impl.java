package apps;
import annotations.ConditionalOnPropertyCustom;
import interfaces.IApp;

@ConditionalOnPropertyCustom(value = "aplicacao2")
public class App2Impl implements IApp {	
	public String getName() {
		return this.getClass().getName();
	}
}
