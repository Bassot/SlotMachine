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
import org.eclipse.wb.swt.SWTResourceManager;


public class SlotMachine {


	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	ArrayList <String> img = new ArrayList <String>();	

	int n;

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
		
		img.add("/img/Anguria.jpg");
		img.add("/img/Arancia.jpg");
		img.add("/img/Banana.jpg");
		img.add("/img/Bar.jpg");
		img.add("/img/Ciliegia.jpg");
		img.add("/img/Limone.jpg");
		img.add("/img/Mela.jpg");
		img.add("/img/Uva.jpg");
		
		Label lbl1 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl1.setImage(SWTResourceManager.getImage(SlotMachine.class, "/slotMachine/img/Anguria.jpg"));
		lbl1.setBounds(10, 95, 150, 150);
		
		Label lbl2 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl2.setBounds(166, 95, 150, 150);
		
		Label lbl3 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl3.setBounds(322, 95, 158, 150);
		
		Button btnGira = new Button(shell, SWT.NONE);
		btnGira.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				n = (int)(Math.random()*8);
				//lbl1.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
			}
		});
		btnGira.setBounds(405, 350, 75, 25);
		btnGira.setText("Gira");


		
	}
}
