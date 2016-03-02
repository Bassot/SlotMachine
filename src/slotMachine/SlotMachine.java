package slotMachine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class SlotMachine {

	protected Shell shell;
	ArrayList<String> img = new ArrayList<String>();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SlotMachine window = new SlotMachine();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		shell = new Shell();
		shell.setSize(506, 423);
		shell.setText("SWT Application");
		
		img.add("/img/Angurie.jpg");
		img.add("/img/Arancia.jpg");
		img.add("/img/Banana.jpg");
		img.add("/img/Bar.jpg");
		img.add("/img/Ciliegia.jpg");
		img.add("/img/Limone.jpg");
		img.add("/img/Mela.jpg");
		img.add("/img/Uva.jpg");
		
		


	}
}
