package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class FinalQues extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final int START_X_OF_RADIO_BUTTONS = 50;
	private static final int START_Y_OF_RADIO_BUTTONS = 325;
	private static final int WIDTH_OF_RADIO = 25;
	private static final int HEIGHT_OF_RADIO = 34;
	private static final int LAST_QUES_GAP = 20;
	
	private JRadioButton [][] radioButtons;
	private ButtonGroup [] radioGroups;
	private JLabel overTheButtonsLabels[], questions[], screenTitle, screenText;
	private Subject subject;
	private JButton continueButton, clearButton;

	public FinalQues(Subject subject) {
		setLayout(null);
		this.subject = subject;
		setBackground(Color.WHITE);
		initalizeRadioButtons();
		initalizeOverTheButtonsLabels();
		initalizeQuestionsLabels();
		initalizeButtons();
		initalizeLabels();
	}

	public void initalizeLabels() {
		screenTitle = new JLabel(Cons.LAST_TITLE);
		int height=30, width=300,x=(Cons.WINDOW_WIDTH/2)-(width/2),y=10;
		screenTitle.setBounds(x, y, width, height);
		screenTitle.setFont(Cons.TITLE);
		add(screenTitle);
		
		screenText = new JLabel(Cons.alignTextRight(Cons.LAST_TEXT));
		height=200;
		width=700;
		x=(Cons.WINDOW_WIDTH/2)-(width/2);
		y=screenTitle.getY()+screenTitle.getHeight();
		screenText.setBounds(x, y, width, height);
		add(screenText);
	}

	private void initalizeButtons() {
		continueButton = new JButton(Cons.CONTINUE);
//		continueButton.setBounds(clearButton.getX()+clearButton.getWidth()+LAST_QUES_GAP, clearButton.getY(), 130, 40);
		continueButton.setBounds(Cons.BUTTON_RECT);
		continueButton.setEnabled(false);
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int answers[] = new int[Cons.NUM_OF_LAST_QUES];
				for(int row=0;row<Cons.NUM_OF_LAST_QUES;row++){
					for(int col=0;col<Cons.NUM_OF_LAST_CHOICES;col++){
						if(radioButtons[row][col].isSelected()){
							answers[row]=col+1;
							break;
						}
					}
				}
				subject.setLastQuesAnswers(answers);
				setVisible(false);
				MainWindow.frame.startSummaryScreen();
			}
		});
		add(continueButton);
		
		clearButton = new JButton(Cons.CLEAR_FORM);
//		clearButton.setBounds(radioButtons[6][0].getX(), radioButtons[6][0].getY()+radioButtons[6][0].getHeight()+LAST_QUES_GAP, 130, 40);
		clearButton.setBounds(continueButton.getX()+continueButton.getWidth()+Cons.GAP,continueButton.getY(),continueButton.getWidth(), continueButton.getHeight());
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int que=0;que<Cons.NUM_OF_LAST_QUES;que++){
					radioGroups[que].clearSelection();
				}
				continueButton.setEnabled(false);
			}
		});
		add(clearButton);
		
	}

	private void initalizeQuestionsLabels() {
		questions = new JLabel[Cons.NUM_OF_LAST_QUES];
		int x=radioButtons[0][4].getX()+radioButtons[0][4].getWidth()+15,y=radioButtons[0][4].getY(),height=radioButtons[0][4].getHeight(),width=550;
		for(int i=0;i<Cons.NUM_OF_LAST_QUES;i++){
			questions[i] = new JLabel(Cons.alignTextRight(Cons.LAST_QUES[i]));
			questions[i].setHorizontalAlignment(SwingConstants.RIGHT);
			questions[i].setBounds(x, y, width, height);
			add(questions[i]);
			y+=height+LAST_QUES_GAP;
		}
	}

	private void initalizeOverTheButtonsLabels() {
		overTheButtonsLabels = new JLabel[Cons.NUM_OF_LAST_CHOICES];
		int width=radioButtons[0][0].getWidth()-1,height=radioButtons[0][0].getHeight(),x=radioButtons[0][0].getX(), y=radioButtons[0][0].getY()-height-10;
		for(int i=0;i<Cons.NUM_OF_LAST_CHOICES;i++){
			overTheButtonsLabels[i] = new JLabel(""+(i+1));
			overTheButtonsLabels[i].setBounds(x, y, width, height);
			overTheButtonsLabels[i].setFont(Cons.BOLD);
			add(overTheButtonsLabels[i]);
			x+=width+40;
		}
	}
	/**
	 * this method sets the initial location of all the other components on the screen
	 * if you want to move something in this screen use the FINALS 
	 * they move the radioButtons[0][0] and the other move accordinly 
	 * the first button is the anchor that moves the other stuff on the screen
	 */
	private void initalizeRadioButtons() {
		radioGroups = new ButtonGroup[Cons.NUM_OF_LAST_QUES];
		radioButtons = new JRadioButton[Cons.NUM_OF_LAST_QUES][Cons.NUM_OF_LAST_CHOICES];
		int y=START_Y_OF_RADIO_BUTTONS,width=WIDTH_OF_RADIO,height=HEIGHT_OF_RADIO;
		for(int row=0;row<Cons.NUM_OF_LAST_QUES;row++){
			int x=START_X_OF_RADIO_BUTTONS;
			radioGroups[row]= new ButtonGroup();
			for(int col=0;col<Cons.NUM_OF_LAST_CHOICES;col++){
				radioButtons[row][col]=new JRadioButton();
				radioButtons[row][col].setBounds(x, y, width, height);
				radioButtons[row][col].setBackground(Color.WHITE);
				radioButtons[row][col].addActionListener(this);
				add(radioButtons[row][col]);
				radioGroups[row].add(radioButtons[row][col]);
				x+=width+40;
			}
			y+=height+LAST_QUES_GAP;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkRadioButtons();
	}

	public void checkRadioButtons() {
		for(int row=0;row<Cons.NUM_OF_LAST_QUES;row++){
			if(radioGroups[row].getSelection()==null){
				return;
			}
		}
		continueButton.setEnabled(true);
	}
}
