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

	ArrayList<String> img = new ArrayList<String>();

	int n;

	/**
	 * Launch the application.
	 * 
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
		shell.setSize(564, 487);
		shell.setText("SWT Application");

		img.add("/slotMachine/img/Anguria.jpg");
		img.add("/slotMachine/img/Arancia.jpg");
		img.add("/slotMachine/img/Banana.jpg");
		img.add("/slotMachine/img/Bar.jpg");
		img.add("/slotMachine/img/Ciliegia.jpg");
		img.add("/slotMachine/img/Limone.jpg");
		img.add("/slotMachine/img/Mela.jpg");
		img.add("/slotMachine/img/Uva.jpg");

		Label lbl1 = formToolkit.createLabel(shell, "", SWT.NONE);

		lbl1.setBounds(10, 95, 177, 170);

		Label lbl2 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl2.setBounds(193, 95, 181, 170);

		Label lbl3 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl3.setBounds(380, 95, 168, 170);

		Button btnGira = new Button(shell, SWT.NONE);
		btnGira.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Thread t = new Thread() {
					public void run() {
						for (int i = 0; i < 10; i++) {
							
							Display.getDefault().asyncExec(	new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									n = (int) (Math.random() * 8);
									lbl1.setImage(SWTResourceManager.getImage(SlotMachine.class, img.get(n)));
									n = (int) (Math.random() * 8);
									lbl2.setImage(SWTResourceManager.getImage(SlotMachine.class, img.get(n)));
									n = (int) (Math.random() * 8);
									lbl3.setImage(SWTResourceManager.getImage(SlotMachine.class, img.get(n)));
									
								}
								
							});
							
							try {
								Thread.sleep(100); // 1000 milliseconds is one
													// second.
							} catch (InterruptedException ex) {
								Thread.currentThread().interrupt();
							}

						}
					}
				};
				t.start();
			}
		});
		btnGira.setBounds(405, 350, 75, 25);
		btnGira.setText("Gira");

	}
}
