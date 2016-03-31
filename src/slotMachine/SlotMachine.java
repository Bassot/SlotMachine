package slotMachine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class SlotMachine {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	ArrayList<String> img = new ArrayList<String>();

	int n;
	int x[] = new int[10];
	private Text textCrediti;
	private Text textBet;
	private Text textWinnerPaid;
	private int crediti;
	private int bet;
	private int vincita = 0;
	private boolean vinto=false;

	private final int prob = 30; // PROBABILITA'
	private int i;

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
		shell.setSize(564, 509);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
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

		lbl1.setBounds(10, 140, 177, 170);

		Label lbl2 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl2.setBounds(193, 140, 181, 170);

		Label lbl3 = formToolkit.createLabel(shell, "", SWT.NONE);
		lbl3.setBounds(380, 140, 168, 170);

		Button btnGira = new Button(shell, SWT.NONE);
		btnGira.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					crediti = Integer.parseInt(textCrediti.getText());
					bet = Integer.parseInt(textBet.getText());
					if (crediti == 0 && bet == 0) {
						JOptionPane.showMessageDialog(null, "Hai finito i crediti!");
					} else {
						if (crediti != 0) {
							textCrediti.setText(Integer.toString(crediti - bet));
						}
						Thread t = new Thread() {
							public void run() {
								n = (int) (Math.random() * 100);
								for (i = 0; i < 10; i++) {

									Display.getDefault().asyncExec(new Runnable() {
										@Override
										public void run() {
											// TODO Auto-generated method stub
											if (i < 9) {
												x[1] = (int) (Math.random() * 8);
												lbl1.setImage(
														SWTResourceManager.getImage(SlotMachine.class, img.get(x[1])));
												x[1] = (int) (Math.random() * 8);
												lbl2.setImage(
														SWTResourceManager.getImage(SlotMachine.class, img.get(x[1])));
												x[1] = (int) (Math.random() * 8);
												lbl3.setImage(
														SWTResourceManager.getImage(SlotMachine.class, img.get(x[1])));
											} else {
												if (n < prob) {
													x[1] = (int) (Math.random() * 8);
													lbl1.setImage(SWTResourceManager.getImage(SlotMachine.class,
															img.get(x[1])));
													lbl2.setImage(SWTResourceManager.getImage(SlotMachine.class,
															img.get(x[1])));
													lbl3.setImage(SWTResourceManager.getImage(SlotMachine.class,
															img.get(x[1])));
													// JOptionPane.showMessageDialog(null,
													// "Hai vinto!");
													vinto = true;
												} else {
													x[1] = (int) (Math.random() * 8);
													x[2] = (int) (Math.random() * 8);
													x[3] = (int) (Math.random() * 8);

													if (x[1] == x[2] && x[1] == x[3]) {
														lbl1.setImage(SWTResourceManager.getImage(SlotMachine.class,
																img.get(6)));
														lbl2.setImage(SWTResourceManager.getImage(SlotMachine.class,
																img.get(2)));
														lbl3.setImage(SWTResourceManager.getImage(SlotMachine.class,
																img.get(5)));
													} else {
														lbl1.setImage(SWTResourceManager.getImage(SlotMachine.class,
																img.get(x[1])));
														lbl2.setImage(SWTResourceManager.getImage(SlotMachine.class,
																img.get(x[2])));
														lbl3.setImage(SWTResourceManager.getImage(SlotMachine.class,
																img.get(x[3])));
													}
												}
											}
											try {
												Thread.sleep(100); // 1000
																	// milliseconds
																	// is
																	// one
																	// second.
											} catch (InterruptedException ex) {
												Thread.currentThread().interrupt();

											}
										}
									});

								}
								if (vinto) {
									vincita = vincita + (bet * 2);
									textWinnerPaid.setText(Integer.toString(vincita));
								}else{
									if (crediti == 0) {
										bet = 0;
										crediti = 0;
										textBet.setText(Integer.toString(bet));
										textCrediti.setText(Integer.toString(crediti));
									}
								}
								

								
							};

						};
						t.start();
						
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Sei un .... Sbadato.. Ti sei dimenticato di qualcosa", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

		});
		btnGira.setBounds(444, 380, 81, 66);
		btnGira.setText("SPIN");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(SlotMachine.class, "/slotMachine/img/Casino.png"));
		lblNewLabel.setBounds(38, 10, 500, 124);
		formToolkit.adapt(lblNewLabel, true, true);

		Button btnReset = new Button(shell, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lbl1.setImage(null);
				lbl2.setImage(null);
				lbl3.setImage(null);
				textCrediti.setText("");
				textBet.setText("");
				vincita = 0;
				textWinnerPaid.setText(Integer.toString(vincita));
			}
		});
		btnReset.setBounds(21, 398, 75, 48);
		formToolkit.adapt(btnReset, true, true);
		btnReset.setText("Reset");

		Button btnPayTable = new Button(shell, SWT.NONE);
		btnPayTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JOptionPane.showMessageDialog(null, "Hai vinto " + vincita + "Euro!!");
				lbl1.setImage(null);
				lbl2.setImage(null);
				lbl3.setImage(null);
				textCrediti.setText("");
				textBet.setText("");
				vincita = 0;
				textWinnerPaid.setText(Integer.toString(vincita));
			}
		});
		btnPayTable.setBounds(123, 398, 75, 48);
		formToolkit.adapt(btnPayTable, true, true);
		btnPayTable.setText("Pay table");

		Button btnBetOne = new Button(shell, SWT.NONE);
		btnBetOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				crediti = Integer.parseInt(textCrediti.getText());
				bet = Integer.parseInt(textBet.getText());

			}
		});
		btnBetOne.setBounds(219, 398, 75, 48);
		formToolkit.adapt(btnBetOne, true, true);
		btnBetOne.setText("Bet one");

		Button btnBetMax = new Button(shell, SWT.NONE);
		btnBetMax.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					crediti = Integer.parseInt(textCrediti.getText());
					textBet.setText(Integer.toString(crediti));
					crediti = 0;
					textCrediti.setText(Integer.toString(crediti));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Sei un .... Sbadato.. Ti sei dimenticato di qualcosa", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnBetMax.setBounds(322, 398, 75, 48);
		formToolkit.adapt(btnBetMax, true, true);
		btnBetMax.setText("Bet max");

		textCrediti = new Text(shell, SWT.BORDER);
		textCrediti.setBounds(20, 328, 101, 21);
		formToolkit.adapt(textCrediti, true, true);

		Label lblCredits = new Label(shell, SWT.NONE);
		lblCredits.setBounds(41, 355, 55, 15);
		formToolkit.adapt(lblCredits, true, true);
		lblCredits.setText("Credits");

		textBet = new Text(shell, SWT.BORDER);
		textBet.setBounds(169, 328, 55, 21);
		formToolkit.adapt(textBet, true, true);

		Label lblBet = new Label(shell, SWT.NONE);
		lblBet.setBounds(179, 355, 33, 15);
		formToolkit.adapt(lblBet, true, true);
		lblBet.setText("Bet");

		textWinnerPaid = new Text(shell, SWT.BORDER);
		textWinnerPaid.setBounds(279, 328, 76, 21);
		textWinnerPaid.setText(Integer.toString(vincita));
		formToolkit.adapt(textWinnerPaid, true, true);

		Label lblWinnerPaid = new Label(shell, SWT.NONE);
		lblWinnerPaid.setBounds(289, 355, 66, 15);
		formToolkit.adapt(lblWinnerPaid, true, true);
		lblWinnerPaid.setText("Winner paid");

		Button btnQuote = new Button(shell, SWT.NONE);
		btnQuote.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell = new Shell();
				shell.setSize(564, 509);
				shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				shell.setText("SWT Application");

			}
		});
		btnQuote.setBounds(450, 328, 75, 25);
		formToolkit.adapt(btnQuote, true, true);
		btnQuote.setText("Quote");

	}
}
