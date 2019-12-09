package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Settings extends JPanel {

	private static final long serialVersionUID = 8435249007456607610L;
	
	private static final int OK = 0;
	private static final int CANCEL = 1;

	
	private JLabel title, texts[];
	private JTextField inputs[];
	private JButton buttons[], saveData;
	
	public Settings() {
		
		setLayout(null);
		setBackground(Color.WHITE);
		
		initalizeLabels();
		
		initalizeInputs();
		
		buttons = new JButton[Cons.NUM_OF_SETTINGS_BUTTONS];
		for(int i=0;i<Cons.NUM_OF_SETTINGS_BUTTONS;i++){
			buttons[i]=new JButton(Cons.SETTINGS_BUTTON_TEXT[i]);
			if(i==0) buttons[i].setBounds(inputs[Cons.NUM_OF_SETTINGS_INPUTS-1].getX(), inputs[Cons.NUM_OF_SETTINGS_INPUTS-1].getHeight()+inputs[Cons.NUM_OF_SETTINGS_INPUTS-1].getY()+(int)(Cons.GAP*2.5), Cons.CONTINUE_BUTTON_WIDTH, Cons.CONTINUE_BUTTON_HEIGHT);
			else buttons[i].setBounds(buttons[i-1].getWidth()+buttons[i-1].getX()+(Cons.GAP*2), buttons[i-1].getY(),Cons.CONTINUE_BUTTON_WIDTH,Cons.CONTINUE_BUTTON_HEIGHT);
			add(buttons[i]);
		}
		buttons[OK].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow.frame.saveNewSettings(inputs[Cons.IP].getText(),inputs[Cons.PORT].getText(),inputs[Cons.USER].getText(),inputs[Cons.PASS].getText());
				goToMainWindow();
			}
		});
		buttons[CANCEL].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				goToMainWindow();
			}
		});
		
		saveData = new JButton("שמור מידע משרת");
		saveData.setBounds(Cons.BUTTON_RECT);
		saveData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SaveExcel().saveData();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "שגיאה! נא סגור את השאלון ונסה שוב");
					e1.printStackTrace();
				}
				goToMainWindow();
			}
		});
		add(saveData);
		
	}

	protected void goToMainWindow() {
		setVisible(false);
		MainWindow.frame.startStartScreen();
		MainWindow.frame.connectToDBServer();
	}

	public void initalizeInputs() {
		inputs = new JTextField[Cons.NUM_OF_SETTINGS_INPUTS];
		for(int i=0;i<Cons.NUM_OF_SETTINGS_INPUTS;i++){
			inputs[i] = new JTextField();
			if(i==0) inputs[i].setBounds(Cons.FIRST_INPUT_SETTINGS);
			else inputs[i].setBounds(Cons.FIRST_INPUT_SETTINGS.x, inputs[i-1].getY()+inputs[i-1].getHeight()+Cons.GAP,Cons.FIRST_INPUT_SETTINGS.width,Cons.FIRST_INPUT_SETTINGS.height);
			add(inputs[i]);
		}
		inputs[Cons.IP].setText(MainWindow.frame.getIP());
		inputs[Cons.PORT].setText(MainWindow.frame.getPORT());
		inputs[Cons.USER].setText(MainWindow.frame.getUSER());
		inputs[Cons.PASS].setText(MainWindow.frame.getPASS());
		
	}

	public void initalizeLabels() {
		title = new JLabel(Cons.SETTINGS_TITLE);
		title.setFont(Cons.TITLE);
		title.setBounds(Cons.TITLE_RECT);
		add(title);
		
		texts = new JLabel[Cons.NUM_OF_SETTINGS_INPUTS];
		for(int i=0;i<Cons.NUM_OF_SETTINGS_INPUTS;i++){
			texts[i]=new JLabel(Cons.SETTING_TEXTS[i]);
			texts[i].setHorizontalAlignment(SwingConstants.RIGHT);
			texts[i].setFont(Cons.BOLD);
			if(i==0) texts[i].setBounds(Cons.FIRST_LABEL_SETTINGS);
			else texts[i].setBounds(Cons.FIRST_LABEL_SETTINGS.x,texts[i-1].getY()+texts[i-1].getHeight()+Cons.GAP,Cons.FIRST_LABEL_SETTINGS.width,Cons.FIRST_LABEL_SETTINGS.height);
			add(texts[i]);
		}
	}

}
