package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AcceptAgreementScreen extends JPanel{
	
	private static final long serialVersionUID = -4092465639572250556L;
	private JLabel agreementText, agreementTitle;
	private JCheckBox agreeCheck;
	private JButton contionueButton;

	public AcceptAgreementScreen(){
		
		setLayout(null);
		setBackground(Color.white);
		setBounds(0, 0, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);		
		
		initalizeLabels();
		initalizeButton();
		
	}

	public void initalizeButton() {
		int x=agreementText.getX(), y=agreementText.getY()+agreementText.getHeight()+25,width=Cons.CONTINUE_BUTTON_WIDTH, height=Cons.CONTINUE_BUTTON_HEIGHT;
		contionueButton = new JButton(Cons.CONTINUE);
		contionueButton.setBounds(Cons.BUTTON_RECT);
		contionueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(agreeCheck.isSelected()){
					setVisible(false);
//					MainWindow.frame.startHelpAndConfirm();	//TODO - change to background questions
					MainWindow.frame.startBackgroundQuesScreen();
				}else{
					agreeCheck.setFont(Cons.BOLD);
				}
			}
		});
		add(contionueButton);
		
		height = 50;
		width = 300;
		x = agreementText.getX()+agreementText.getWidth()-width;
		y = contionueButton.getY()+(contionueButton.getHeight()/2)-(height/2);
		agreeCheck = new JCheckBox();
		agreeCheck.setBackground(Color.white);
		agreeCheck.setHorizontalAlignment(SwingConstants.RIGHT);
		agreeCheck.setHorizontalTextPosition(SwingConstants.LEFT);
		agreeCheck.setFont(Cons.REGUALAR);
		agreeCheck.setText(Cons.ACCEPT_TEXT);
		agreeCheck.setBounds(x, y, width, height);
		add(agreeCheck);
	}

	public void initalizeLabels() {
		int width=Cons.TITLE_WIDTH, height=Cons.TITLE_HEIGHT, x=(Cons.WINDOW_WIDTH/2)-(width/2), y=Cons.TITLE_Y;
		agreementTitle = new JLabel(Cons.AGREEMENT_TITLE);
		agreementTitle.setBounds(x, y, width, height);
		agreementTitle.setFont(Cons.TITLE);
		add(agreementTitle);
		
		width=Cons.WINDOW_WIDTH-50;
		height=Cons.WINDOW_HEIGHT-agreementTitle.getHeight()-200;
		x=(Cons.WINDOW_WIDTH/2)-(width/2);
		y=agreementTitle.getY()+agreementTitle.getHeight()+25;
		agreementText = new JLabel(Cons.alignTextRight(Cons.AGREEMENT_TEXT));
		agreementText.setHorizontalAlignment(SwingConstants.RIGHT);
		agreementText.setBounds(x, y, width, height);
		add(agreementText);
	}
	
}
