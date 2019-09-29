package apps;

import annotations.ConditionalOnPropertyCustom;
import interfaces.IApp;

@ConditionalOnPropertyCustom(value = "aplicacao1")
public class App1Impl implements IApp {
	public String getName() {
		return this.getClass().getName();
	}

}
