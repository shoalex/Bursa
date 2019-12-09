package borsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.ComponentOrientation;




public class background_questions_screen extends JPanel {

	private static final long serialVersionUID = 7508906878247997296L;
	private static final int MALE = 0;
	private static final int FEMALE = 1;
	private JTextField age;
	private JTextField birth;
	private JTextField year;
	private JTextField otherEduIn;
	private JTextField otherEconomy;
	private JTextField otherIncomeIn;
	ButtonGroup gender_group;
	ButtonGroup family_status_group;
	ButtonGroup education_group;
	ButtonGroup is_education_group;
	ButtonGroup income_group;
	ButtonGroup level_of_control_capital_market_group;
	ButtonGroup frequently_involved_capital_market_group;
	JButton submit_button;
	JRadioButton male,female;
	JRadioButton gender[];
	private JLabel chkData, backTitle;

	/**
	 * Create the panel.
	 * @param subject 
	 */
	public background_questions_screen(final Subject subject) {
		
		setLayout(null);
		
		setBackground(Color.WHITE);
		
		backTitle = new JLabel(Cons.BACK_TITLE);
		backTitle.setBounds((Cons.WINDOW_WIDTH/2)-(Cons.TITLE_WIDTH/2), Cons.TITLE_Y, Cons.TITLE_WIDTH, Cons.TITLE_HEIGHT);
		backTitle.setFont(Cons.TITLE);
		add(backTitle);
		
		JLabel label = new JLabel("\u05DE\u05D9\u05DF : ");
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 17));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(831, 86, 39, 23);
		add(label);
		
		male = new JRadioButton("\u05D6\u05DB\u05E8");
		male.setBackground(Color.WHITE);
		male.setActionCommand("male");
		male.setName("male");
		male.setFont(Cons.REGUALAR);
		male.setHorizontalAlignment(SwingConstants.RIGHT);
		male.setHorizontalTextPosition(SwingConstants.LEFT);
		male.setBounds(774, 86, 51, 23);
		add(male);
		
		female = new JRadioButton("\u05E0\u05E7\u05D1\u05D4");
		female.setBackground(Color.WHITE);
		female.setActionCommand("female");
		female.setName("female");
		female.setFont(Cons.REGUALAR);
		female.setHorizontalAlignment(SwingConstants.RIGHT);
		female.setHorizontalTextPosition(SwingConstants.LEFT);
		female.setBounds(660, 86, 109, 23);
		add(female);
		
		JLabel label_1 = new JLabel("\u05D2\u05D9\u05DC : ");
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 17));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(545, 89, 44, 17);
		add(label_1);
		
		age = new JTextField();
		age.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		age.setBackground(Color.WHITE);
		age.setHorizontalAlignment(SwingConstants.RIGHT);
		age.setBounds(449, 86, 86, 25);
		age.setText("");
		age.setColumns(10);
		add(age);
		
		
		JLabel lblNewLabel = new JLabel("\u05D0\u05E8\u05E5 \u05DC\u05D9\u05D3\u05D4: ");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(795, 129, 75, 17);
		add(lblNewLabel);
		
		birth = new JTextField();
		birth.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		birth.setBackground(Color.WHITE);
		birth.setHorizontalAlignment(SwingConstants.RIGHT);
		birth.setColumns(10);
		birth.setBounds(640, 124, 145, 25);
		birth.setText("");
		add(birth);
		
		JLabel label_2 = new JLabel("\u05E9\u05E0\u05EA \u05E2\u05DC\u05D9\u05D9\u05D4 : ");
		label_2.setBackground(Color.WHITE);
		label_2.setText("\u05E9\u05E0\u05EA \u05E2\u05DC\u05D9\u05D9\u05D4:");
		label_2.setFont(new Font("Arial", Font.BOLD, 17));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(544, 127, 86, 19);
		add(label_2);
		
		year = new JTextField();
		year.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		year.setBackground(Color.WHITE);
		year.setHorizontalAlignment(SwingConstants.RIGHT);
		year.setColumns(10);
		year.setBounds(459, 124, 86, 25);
		year.setText("");
		add(year);
		
		JLabel label_3 = new JLabel("\u05DE\u05E6\u05D1 \u05DE\u05E9\u05E4\u05D7\u05EA\u05D9 : ");
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.BOLD, 17));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(755, 160, 115, 19);
		add(label_3);
		
		JRadioButton radioButton = new JRadioButton("\u05E8\u05D5\u05D5\u05E7");
		radioButton.setBackground(Color.WHITE);
		radioButton.setActionCommand("single");
		radioButton.setName("single");
		radioButton.setFont(Cons.REGUALAR);
		radioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton.setBounds(692, 158, 57, 23);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u05E0\u05E9\u05D5\u05D9 \u05DC\u05DC\u05D0 \u05D9\u05DC\u05D3\u05D9\u05DD    ");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setActionCommand("married without");
		radioButton_1.setName("married without");
		radioButton_1.setFont(Cons.REGUALAR);
		radioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_1.setBounds(559, 158, 124, 23);
		add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\u05E0\u05E9\u05D5\u05D9 \u05E2\u05DD \u05D9\u05DC\u05D3\u05D9\u05DD ");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setActionCommand("married with");
		radioButton_2.setName("married with");
		radioButton_2.setFont(Cons.REGUALAR);
		radioButton_2.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_2.setBounds(423, 158, 131, 23);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\u05D2\u05E8\u05D5\u05E9");
		radioButton_3.setBackground(Color.WHITE);
		radioButton_3.setActionCommand("divorced");
		radioButton_3.setName("divorced");
		radioButton_3.setFont(Cons.REGUALAR);
		radioButton_3.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_3.setBounds(337, 160, 84, 23);
		add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("\u05D0\u05DC\u05DE\u05DF");
		radioButton_4.setBackground(Color.WHITE);
		radioButton_4.setActionCommand("widowed");
		radioButton_4.setName("widowed");
		radioButton_4.setFont(Cons.REGUALAR);
		radioButton_4.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_4.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_4.setBounds(271, 160, 64, 23);
		add(radioButton_4);
		
		JLabel label_4 = new JLabel("\u05D4\u05E9\u05DB\u05DC\u05D4 : ");
		label_4.setBackground(Color.WHITE);
		label_4.setFont(new Font("Arial", Font.BOLD, 17));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(804, 206, 66, 19);
		add(label_4);
		
		JRadioButton radioButton_5 = new JRadioButton("\u05EA\u05D5\u05D0\u05E8 \u05E8\u05D0\u05E9\u05D5\u05DF");
		radioButton_5.setBackground(Color.WHITE);
		radioButton_5.setActionCommand("first degree");
		radioButton_5.setName("first degree");
		radioButton_5.setFont(Cons.REGUALAR);
		radioButton_5.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_5.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_5.setBounds(608, 202, 111, 23);
		add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("\u05EA\u05D5\u05D0\u05E8 \u05E9\u05E0\u05D9");
		radioButton_6.setBackground(Color.WHITE);
		radioButton_6.setActionCommand("second degree");
		radioButton_6.setName("second degree");
		radioButton_6.setFont(Cons.REGUALAR);
		radioButton_6.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_6.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_6.setBounds(506, 202, 100, 23);
		add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("\u05EA\u05D5\u05D0\u05E8 \u05E9\u05DC\u05D9\u05E9\u05D9");
		radioButton_7.setBackground(Color.WHITE);
		radioButton_7.setActionCommand("third degree");
		radioButton_7.setName("third degree");
		radioButton_7.setFont(Cons.REGUALAR);
		radioButton_7.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_7.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_7.setBounds(389, 202, 115, 23);
		add(radioButton_7);
		
		JRadioButton radioButton_9 = new JRadioButton("\u05EA\u05D9\u05DB\u05D5\u05E0\u05D9\u05EA");
		radioButton_9.setBackground(Color.WHITE);
		radioButton_9.setActionCommand("highschool");
		radioButton_9.setName("high school");
		radioButton_9.setFont(Cons.REGUALAR);
		radioButton_9.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_9.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_9.setBounds(721, 202, 77, 23);
		add(radioButton_9);
		
		otherEduIn = new JTextField();
		otherEduIn.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		otherEduIn.setBackground(Color.WHITE);
		otherEduIn.setHorizontalAlignment(SwingConstants.RIGHT);
		otherEduIn.setColumns(10);
		otherEduIn.setBounds(206, 202, 100, 25);
		otherEduIn.setText("");
		add(otherEduIn);
		
		JLabel lblNewLabel_1 = new JLabel("\u05D0\u05DD \u05D4\u05E0\u05DA \u05D1\u05E2\u05DC \u05EA\u05D5\u05D0\u05E8 \u05D0\u05E7\u05D3\u05DE\u05D9, \u05D4\u05D0\u05DD \u05D4\u05E9\u05DB\u05DC\u05EA\u05DA \u05D4\u05D0\u05E7\u05D3\u05DE\u05D9\u05EA \u05DB\u05D5\u05DC\u05DC\u05EA \u05DC\u05D9\u05DE\u05D5\u05D3\u05D9 \u05DB\u05DC\u05DB\u05DC\u05D4 \u05D5/\u05D0\u05D5 \u05DE\u05E0\u05D4\u05DC \u05E2\u05E1\u05E7\u05D9\u05DD?");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(206, 251, 664, 23);
		add(lblNewLabel_1);
		
		JRadioButton yesEconomy = new JRadioButton("\u05DB\u05DF - \u05E4\u05E8\u05D8:");
		yesEconomy.setBackground(Color.WHITE);
		yesEconomy.setActionCommand("yes");
		yesEconomy.setName("yes");
		yesEconomy.setFont(Cons.REGUALAR);
		yesEconomy.setHorizontalTextPosition(SwingConstants.LEFT);
		yesEconomy.setHorizontalAlignment(SwingConstants.RIGHT);
		yesEconomy.setBounds(675, 279, 88, 23);
		add(yesEconomy);
		
		JRadioButton notEconomy = new JRadioButton("\u05DC\u05D0");
		notEconomy.setBackground(Color.WHITE);
		notEconomy.setActionCommand("no");
		notEconomy.setName("no");
		notEconomy.setFont(Cons.REGUALAR);
		notEconomy.setHorizontalTextPosition(SwingConstants.LEFT);
		notEconomy.setHorizontalAlignment(SwingConstants.RIGHT);
		notEconomy.setBounds(789, 279, 64, 23);
		add(notEconomy);
		
		otherEconomy = new JTextField();
		otherEconomy.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		otherEconomy.setBackground(Color.WHITE);
		otherEconomy.setHorizontalAlignment(SwingConstants.RIGHT);
		otherEconomy.setColumns(10);
		otherEconomy.setBounds(246, 277, 423, 25);
		add(otherEconomy);
		
		JLabel label_7 = new JLabel("\u05E6\u05D9\u05D9\u05DF \u05D0\u05EA \u05D4\u05DB\u05E0\u05E1\u05EA\u05DA \u05D1\u05E8\u05D5\u05D8\u05D5 \u05DC\u05D7\u05D5\u05D3\u05E9: ");
		label_7.setBackground(Color.WHITE);
		label_7.setFont(new Font("Arial", Font.BOLD, 17));
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(618, 323, 252, 23);
		add(label_7);
		
		JRadioButton radioButton_11 = new JRadioButton("\u05E4\u05D7\u05D5\u05EA \u05DE-4000 \u20AA ");
		radioButton_11.setBackground(Color.WHITE);
		radioButton_11.setActionCommand("a");
		radioButton_11.setName("a");
		radioButton_11.setFont(Cons.REGUALAR);
		radioButton_11.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_11.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_11.setBounds(699, 353, 153, 23);
		add(radioButton_11);
		
		JRadioButton radioButton_12 = new JRadioButton("4000-6000 \u20AA ");
		radioButton_12.setBackground(Color.WHITE);
		radioButton_12.setActionCommand("b");
		radioButton_12.setName("b");
		radioButton_12.setFont(Cons.REGUALAR);
		radioButton_12.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_12.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_12.setBounds(556, 353, 138, 23);
		add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("6000-8000 \u20AA ");
		radioButton_13.setBackground(Color.WHITE);
		radioButton_13.setActionCommand("c");
		radioButton_13.setName("c");
		radioButton_13.setFont(Cons.REGUALAR);
		radioButton_13.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_13.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_13.setBounds(416, 353, 138, 23);
		add(radioButton_13);
		
		JRadioButton radioButton_14 = new JRadioButton("8000-10000 \u20AA ");
		radioButton_14.setBackground(Color.WHITE);
		radioButton_14.setActionCommand("d");
		radioButton_14.setName("d");
		radioButton_14.setFont(Cons.REGUALAR);
		radioButton_14.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_14.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_14.setBounds(699, 381, 153, 23);
		add(radioButton_14);
		
		JRadioButton radioButton_15 = new JRadioButton("\u05D9\u05D5\u05EA\u05E8 \u05DE- 10000 \u20AA ");
		radioButton_15.setBackground(Color.WHITE);
		radioButton_15.setActionCommand("e");
		radioButton_15.setName("e");
		radioButton_15.setFont(Cons.REGUALAR);
		radioButton_15.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_15.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_15.setBounds(556, 381, 138, 23);
		add(radioButton_15);
		
		otherIncomeIn = new JTextField();
		otherIncomeIn.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		otherIncomeIn.setBackground(Color.WHITE);
		otherIncomeIn.setHorizontalAlignment(SwingConstants.RIGHT);
		otherIncomeIn.setColumns(10);
		otherIncomeIn.setBounds(357, 379, 123, 25);
		otherIncomeIn.setText("");
		add(otherIncomeIn);
		
		JLabel label_8 = new JLabel("\u05E8\u05DE\u05EA \u05E9\u05DC\u05D9\u05D8\u05EA\u05DA \u05D1\u05DE\u05E1\u05D7\u05E8 \u05D1\u05E9\u05D5\u05E7 \u05D4\u05D4\u05D5\u05DF:");
		label_8.setBackground(Color.WHITE);
		label_8.setFont(new Font("Arial", Font.BOLD, 17));
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(595, 419, 275, 23);
		add(label_8);
		
		JRadioButton radioButton_16 = new JRadioButton("\u05D0\u05D9\u05E0\u05D9 \u05DE\u05DB\u05D9\u05E8 \u05D0\u05EA \u05E9\u05D5\u05E7 \u05D4\u05D4\u05D5\u05DF ");
		radioButton_16.setBackground(Color.WHITE);
		radioButton_16.setActionCommand("none");
		radioButton_16.setFont(Cons.REGUALAR);
		radioButton_16.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_16.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_16.setBounds(679, 449, 173, 23);
		add(radioButton_16);
		
		JRadioButton radioButton_17 = new JRadioButton("\u05DE\u05DB\u05D9\u05E8 \u05D1\u05E8\u05DE\u05D4 \u05E1\u05D1\u05D9\u05E8\u05D4");
		radioButton_17.setBackground(Color.WHITE);
		radioButton_17.setActionCommand("average");
		radioButton_17.setFont(Cons.REGUALAR);
		radioButton_17.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_17.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_17.setBounds(635, 475, 217, 23);
		add(radioButton_17);
		
		JRadioButton radioButton_18 = new JRadioButton("\u05E8\u05DE\u05D4 \u05D2\u05D1\u05D5\u05D4\u05D4");
		radioButton_18.setBackground(Color.WHITE);
		radioButton_18.setActionCommand("high");
		radioButton_18.setFont(Cons.REGUALAR);
		radioButton_18.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_18.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_18.setBounds(497, 449, 109, 23);
		add(radioButton_18);
		
		JRadioButton radioButton_19 = new JRadioButton("\u05E8\u05DE\u05D4 \u05D2\u05D1\u05D5\u05D4\u05D4 \u05DE\u05D0\u05D5\u05D3 ");
		radioButton_19.setBackground(Color.WHITE);
		radioButton_19.setActionCommand("very high");
		radioButton_19.setFont(Cons.REGUALAR);
		radioButton_19.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_19.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_19.setBounds(389, 475, 217, 23);
		add(radioButton_19);
		
		JLabel label_9 = new JLabel("\u05EA\u05DB\u05D9\u05E4\u05D5\u05EA \u05D4\u05DE\u05E2\u05D5\u05E8\u05D1\u05D5\u05EA \u05E9\u05DC\u05DA \u05D1\u05E9\u05D5\u05E7 \u05D4\u05D4\u05D5\u05DF:");
		label_9.setBackground(Color.WHITE);
		label_9.setFont(new Font("Arial", Font.BOLD, 17));
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(499, 530, 371, 23);
		add(label_9);
		
		JRadioButton radioButton_20 = new JRadioButton("\u05DB\u05DC\u05DC \u05DC\u05D0 \u05DE\u05EA\u05E2\u05E1\u05E7 \u05D1\u05E9\u05D5\u05E7 \u05D4\u05D4\u05D5\u05DF ");
		radioButton_20.setBackground(Color.WHITE);
		radioButton_20.setActionCommand("none");
		radioButton_20.setFont(Cons.REGUALAR);
		radioButton_20.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_20.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_20.setBounds(635, 560, 217, 23);
		add(radioButton_20);
		
		JRadioButton radioButton_21 = new JRadioButton("\u05EA\u05DB\u05D9\u05E4\u05D5\u05EA \u05E0\u05DE\u05D5\u05DB\u05D4");
		radioButton_21.setBackground(Color.WHITE);
		radioButton_21.setActionCommand("low");
		radioButton_21.setFont(Cons.REGUALAR);
		radioButton_21.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_21.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_21.setBounds(728, 586, 123, 23);
		add(radioButton_21);
		
		JRadioButton radioButton_22 = new JRadioButton("\u05EA\u05DB\u05D9\u05E4\u05D5\u05EA \u05D1\u05D9\u05E0\u05D5\u05E0\u05D9\u05EA");
		radioButton_22.setBackground(Color.WHITE);
		radioButton_22.setActionCommand("medium");
		radioButton_22.setFont(Cons.REGUALAR);
		radioButton_22.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_22.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_22.setBounds(479, 560, 127, 23);
		add(radioButton_22);
		
		JRadioButton radioButton_23 = new JRadioButton("\u05EA\u05DB\u05D9\u05E4\u05D5\u05EA \u05D2\u05D1\u05D5\u05D4\u05D4");
		radioButton_23.setBackground(Color.WHITE);
		radioButton_23.setActionCommand("high");
		radioButton_23.setFont(Cons.REGUALAR);
		radioButton_23.setHorizontalTextPosition(SwingConstants.LEFT);
		radioButton_23.setHorizontalAlignment(SwingConstants.RIGHT);
		radioButton_23.setBounds(483, 586, 123, 23);
		add(radioButton_23);
		
		JRadioButton otherIncome = new JRadioButton("\u05D0\u05D7\u05E8: ");
		otherIncome.setBackground(Color.WHITE);
		otherIncome.setActionCommand("other");
		otherIncome.setName("f");
		otherIncome.setHorizontalTextPosition(SwingConstants.LEFT);
		otherIncome.setHorizontalAlignment(SwingConstants.RIGHT);
		otherIncome.setFont(Cons.REGUALAR);
		otherIncome.setBounds(490, 382, 64, 23);
		add(otherIncome);
		
		JRadioButton otherEdu = new JRadioButton("\u05D0\u05D7\u05E8: ");
		otherEdu.setBackground(Color.WHITE);
		otherEdu.setActionCommand("other");
		otherEdu.setName("other");
		otherEdu.setHorizontalTextPosition(SwingConstants.LEFT);
		otherEdu.setHorizontalAlignment(SwingConstants.RIGHT);
		otherEdu.setFont(Cons.REGUALAR);
		otherEdu.setBounds(312, 202, 70, 23);
		add(otherEdu);		
		
		gender = new JRadioButton[2];
		gender[MALE] = male;
		gender[FEMALE] = female;
		
		gender_group = new ButtonGroup();
		gender_group.add(male);
		gender_group.add(female);
		
		family_status_group=new ButtonGroup();
		family_status_group.add(radioButton);
		family_status_group.add(radioButton_1);
		family_status_group.add(radioButton_2);
		family_status_group.add(radioButton_3);
		family_status_group.add(radioButton_4);
		
		education_group=new ButtonGroup();
		education_group.add(radioButton_5);
		education_group.add(radioButton_6);
		education_group.add(radioButton_7);
		education_group.add(radioButton_9);
		education_group.add(otherEdu);
		
		is_education_group=new ButtonGroup();
		is_education_group.add(yesEconomy);
		is_education_group.add(notEconomy);
		
		income_group=new ButtonGroup();
		income_group.add(radioButton_11);
		income_group.add(radioButton_12);
		income_group.add(radioButton_13);
		income_group.add(radioButton_14);
		income_group.add(radioButton_15);
		income_group.add(otherIncome);
		
		level_of_control_capital_market_group=new ButtonGroup();
		level_of_control_capital_market_group.add(radioButton_16);
		level_of_control_capital_market_group.add(radioButton_17);
		level_of_control_capital_market_group.add(radioButton_18);
		level_of_control_capital_market_group.add(radioButton_19);
		
		frequently_involved_capital_market_group=new ButtonGroup();
		frequently_involved_capital_market_group.add(radioButton_20);
		frequently_involved_capital_market_group.add(radioButton_21);
		frequently_involved_capital_market_group.add(radioButton_22);
		frequently_involved_capital_market_group.add(radioButton_23);
		
		chkData = new JLabel();
		chkData.setBounds(231, 619, 230, 45);
		chkData.setFont(Cons.TITLE);
		add(chkData);
		
		submit_button = new JButton(Cons.CONTINUE);
		submit_button.setBounds(25, 619, Cons.CONTINUE_BUTTON_WIDTH, Cons.CONTINUE_BUTTON_HEIGHT);
		submit_button.setFont(Cons.REGUALAR);
		submit_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BackgroundQuestions backQus = new BackgroundQuestions();
				try{
					backQus.setGender(getGender());
					backQus.setAge(getAge());
					backQus.setCountry_of_birth(getBirthCountry());
					backQus.setYear_of_immigration(getYear());
					backQus.setEductionLevel(getEducation());
					backQus.setFamily_status(getFamilyStatus());
					backQus.setIs_academic_degree(getEconomy());
					backQus.setIncome(getIncome());
					backQus.setLevel_of_control_capital_market(getControl());
					backQus.setFrequently_involved_capital_market(getInvolvment());
					subject.setBackgroundQuestion(backQus);
					setVisible(false);
//					MainWindow.frame.startFirstPeriodScreen();
					MainWindow.frame.startHelpAndConfirm();
				}catch(Exception ex){
					chkData.setText(Cons.INPUT_ERROR_MESSAGE);
				}
			}
		});
		add(submit_button);
		
		

	}
	
	public String getInvolvment() {
		return frequently_involved_capital_market_group.getSelection().getActionCommand();
	}
	
	public String getControl() {
		return level_of_control_capital_market_group.getSelection().getActionCommand();
	}
	
	public String getIncome() throws Exception{
		String temp = income_group.getSelection().getActionCommand();
		if(temp.equals("other")){
			if(otherIncomeIn.getText().equals("")) throw new Exception("other Income"); 
			return Cons.cleanText(otherIncomeIn.getText());
		}
		return temp;
	}
	
	public String getEconomy() throws Exception{
		String temp = is_education_group.getSelection().getActionCommand();
		if(temp.equals("yes")){
			if(otherEconomy.getText().equals("")) throw new Exception("other EConomy"); 
			return Cons.cleanText(otherEconomy.getText());
		}
		return temp;
	}
	
	public String getEducation() throws Exception{
		String temp = education_group.getSelection().getActionCommand();
		if(temp.equals("other")){
			if(otherEduIn.getText().equals("")) throw new Exception("Other Eduction");
			return Cons.cleanText(otherEduIn.getText());
		}
		return temp;
	}

	public String getFamilyStatus(){
		return family_status_group.getSelection().getActionCommand();
	}

	public int getYear(){
		if(year.getText().equals("")) return 0;
		return Integer.parseInt(year.getText());
	}

	
	public String getBirthCountry(){
		return Cons.cleanText(birth.getText());
	}

	public double getAge() throws Exception{
		double temp =  Double.parseDouble(age.getText());
		temp = Math.floor(temp*100)/100;
		return temp;
	}
	
	public String getGender(){
		return gender_group.getSelection().getActionCommand();
	}
}
