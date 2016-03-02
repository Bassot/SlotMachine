package slotMachine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;


public class SlotMachine {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	ArrayList <String> img = new ArrayList <String>();	
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
		
		
		
		Button btnGira = new Button(shell, SWT.NONE);
		btnGira.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnGira.setBounds(405, 350, 75, 25);
		btnGira.setText("Gira");
		
		Label lblNewLabel = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel.setBounds(10, 95, 150, 150);
		
		Label lblNewLabel_1 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_1.setBounds(166, 95, 150, 150);
		
		Label lblNewLabel_2 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_2.setBounds(322, 95, 158, 150);


	}
}
