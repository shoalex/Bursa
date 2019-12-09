package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;;

public class HelpScreen extends JPanel {

	private static final long serialVersionUID = 4805700034808159726L;
	private JLabel helpTitle, helpText, picLabel;
	private JButton continueButton;
	private int textOnScreen = 0;

	public HelpScreen(){

		setLayout(null);
		setBackground(Color.white);

		initalizeLabels();
		initalizeButtons();

	}

	public void initalizeButtons() {
		int x=25, y=619, width=Cons.CONTINUE_BUTTON_WIDTH, height=Cons.CONTINUE_BUTTON_HEIGHT;
		continueButton = new JButton(Cons.CONTINUE);
		continueButton.setBounds(x, y, width, height);
		continueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(++textOnScreen==Cons.HELP_TEXT.length){
					setVisible(false);
//					MainWindow.frame.startFirstPeriodScreen();
					MainWindow.frame.nextPeriod();
				}
				else{
					helpText.setText(Cons.alignTextRight(Cons.HELP_TEXT[textOnScreen]));
					if(textOnScreen==1){
//						helpText.setBounds(helpText.getX(), helpText.getY(), helpText.getWidth(), 500);
					}else{
						int width = Cons.WINDOW_WIDTH-50, height = helpTitle.getHeight()+100, x = (Cons.WINDOW_WIDTH/2)-(width/2), y=helpTitle.getY()+helpTitle.getHeight();
						helpText.setBounds(x, y, width, height);
					}
					try{
						picLabel.setIcon(new ImageIcon(HelpScreen.class.getResource("/img/"+textOnScreen+".jpg")));
						picLabel.setBounds(helpText.getX(),helpText.getY()+helpText.getHeight(),helpText.getWidth(),400);
					}catch(Exception e1){
						picLabel.setIcon(null);
					}
				}
			}
		});
		add(continueButton);
	}

	public void initalizeLabels() {
		int width = Cons.TITLE_WIDTH, height = Cons.TITLE_HEIGHT, x=(Cons.WINDOW_WIDTH/2)-(width/2), y=Cons.TITLE_Y;
		helpTitle = new JLabel(Cons.AGREEMENT_TITLE);
		helpTitle.setFont(Cons.TITLE);
		helpTitle.setBounds(x, y, width, height);
		add(helpTitle);

		width = Cons.WINDOW_WIDTH-50; 
//		height = helpTitle.getHeight()+100;
		height = 500;
		x = (Cons.WINDOW_WIDTH/2)-(width/2); y=helpTitle.getY()+helpTitle.getHeight();

		helpText = new JLabel();
		helpText.setText(Cons.alignTextRight(Cons.HELP_TEXT[textOnScreen]));
		helpText.setHorizontalAlignment(SwingConstants.RIGHT);
//		helpText.setBounds(helpText.getX(), helpText.getY(), helpText.getWidth(), 500);
//		helpText.setText(Cons.alignTextRight(Cons.HELP_TEXT[textOnScreen]));
		helpText.setBounds(x, y, width, height);
		add(helpText);

		picLabel = new JLabel();
//		picLabel.setBounds(helpText.getX(),helpText.getY()+helpText.getHeight(),helpText.getWidth(),400);
		add(picLabel);
	}

}
