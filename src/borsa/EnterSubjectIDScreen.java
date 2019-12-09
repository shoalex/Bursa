package borsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class EnterSubjectIDScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3798370800031181998L;
	private JLabel enterIDText, agreementTitle;
	private JTextField textField;
	private JButton startButton, settingsButton;
	private JLabel databaseStatus;

	/**
	 * Create the panel.
	 */
	public EnterSubjectIDScreen() {
		setLayout(null);

		int width=Cons.TITLE_WIDTH, height=Cons.TITLE_HEIGHT, x=(Cons.WINDOW_WIDTH/2)-(width/2), y=Cons.TITLE_Y;
		agreementTitle = new JLabel(Cons.AGREEMENT_TITLE);
		agreementTitle.setBounds(x, y, width, height);
		agreementTitle.setFont(Cons.TITLE);
		add(agreementTitle);

		enterIDText = new JLabel(Cons.ENTER_ID);
		enterIDText.setBounds(396, 222, 156, 49);
		enterIDText.setFont(Cons.REGUALAR);
		add(enterIDText);

		textField = new JTextField();
		textField.setBounds(418, 304, 112, 35);
		textField.setFont(Cons.REGUALAR);
		add(textField);
		textField.setColumns(10);

		startButton = new JButton(Cons.START_BUTTON);
		startButton.setBounds(396, 396, 160, 45);
		startButton.setEnabled(false);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id;
				try{
					id = Integer.parseInt(textField.getText());
					if(id<10000 || id>40000){
						textField.setText("");
						JOptionPane.showMessageDialog(null, " מספר שאלון לא בטווח הנכון "," שגיאה ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(MainWindow.frame.isIDAlreadyExsits(id)){
						textField.setText("");
						JOptionPane.showMessageDialog(null, " מספר שאלון כבר קיים במערכת "," שגיאה ",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception err){
					err.printStackTrace();
					textField.setText("");
					JOptionPane.showMessageDialog(null, " נא להכניס מספר "," שגיאה ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				MainWindow.frame.createSubject(id);
				setVisible(false);
			}
		});
		add(startButton);

		databaseStatus = new JLabel(Cons.DATABASE_CONNECTING);
		databaseStatus.setBounds(225, 103, 500, 113);
		databaseStatus.setFont(Cons.TITLE);
		add(databaseStatus);

		settingsButton = new JButton(Cons.SETTINGS_BUTTON);
		settingsButton.setBounds(51, 580, (int)(Cons.CONTINUE_BUTTON_WIDTH/1.5), (int)(Cons.CONTINUE_BUTTON_HEIGHT/1.5));
		settingsButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				JPasswordField pwd = new JPasswordField(20);
				int action = JOptionPane.showConfirmDialog(null, pwd, " הכנס סיסמא ", JOptionPane.OK_CANCEL_OPTION);
				if(action==0 && pwd.getText().equals(MainWindow.frame.getPasswordForSettings())){
					setVisible(false);
					MainWindow.frame.startSettingsScreen();
				}else{
					return;
				}
			}
		});
		add(settingsButton);

	}

	public JButton getStartButton() {
		return startButton;
	}

	public JLabel getDatabaseStatus() {
		return databaseStatus;
	}
}
