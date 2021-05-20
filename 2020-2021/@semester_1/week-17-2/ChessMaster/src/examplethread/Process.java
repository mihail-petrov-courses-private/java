package examplethread;

import javax.swing.JPanel;

public class Process  extends Thread {

	protected JPanel layoutInstance;
	
	public Process(JPanel instance) {
		this.layoutInstance = instance;
	}
}
