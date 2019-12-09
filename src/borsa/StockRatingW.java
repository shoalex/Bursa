package borsa;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;


public class StockRatingW extends JPanel {


	/**
	 * 
	 */
	private Handler d;
	private static final long serialVersionUID = 1L;
	static final int num_of_row = 6;
	static final int num_of_col = 6;
	JButton submit_button=new  JButton();
	JButton clear_button;
	private JLabel chkLabel, stockTitle;
	private JRadioButton [][] buttons;

	private ButtonGroup [] radioGroups;
	private Subject subject;
	private int periodNum;
	private JLabel[] letters;

	/**
	 * Create the panel.
	 */
	public StockRatingW(Subject sub, int periodNum) {
		
		setBackground(Color.WHITE);
		setLayout(null);

		subject=sub;
		d = new Handler();
		this.periodNum = periodNum;
		buttons = new JRadioButton[num_of_row][num_of_col];
		
		radioGroups = new ButtonGroup[Cons.NUM_OF_STOCKS];
		
		stockTitle = new JLabel(Cons.AGREEMENT_TITLE);
		stockTitle.setFont(Cons.TITLE);
		stockTitle.setBounds(Cons.TITLE_RECT);
		add(stockTitle);
		

		initializeLettersLabels();

		JLabel label = new JLabel("\u05D1\u05D4\u05EA\u05D1\u05E1\u05E1 \u05E2\u05DC \u05D4\u05DE\u05D9\u05D3\u05E2 \u05D4\u05E7\u05D9\u05D9\u05DD \u05D1\u05E8\u05E9\u05D5\u05EA\u05DA,");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(551, 120, 309, 30);
		add(label);

		JLabel label_1 = new JLabel("\u05D4\u05E2\u05D6\u05E8 \u05D1\u05DE\u05E7\u05E8\u05D0 \u05D4\u05D1\u05D0 \u05D5\u05DC\u05D9\u05D3 \u05DB\u05DC \u05E1\u05D9\u05DE\u05DF \u05E8\u05E9\u05D5\u05DD \u05D0\u05D9\u05D6\u05D4 \u05DE\u05E0\u05D9\u05D4");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(495, 152, 365, 20);
		add(label_1);

		JLabel lblaf = new JLabel("(A-F)");
		lblaf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaf.setBounds(448, 152, 78, 20);
		add(lblaf);

		JLabel label_2 = new JLabel("\u05DE\u05EA\u05D0\u05E8\u05EA \u05DC\u05D3\u05E2\u05EA\u05DA \u05D1\u05E6\u05D5\u05E8\u05D4 \u05D4\u05D8\u05D5\u05D1\u05D4 \u05D1\u05D9\u05D5\u05EA\u05E8");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(551, 177, 309, 30);
		add(label_2);

		JLabel label_3 = new JLabel("\u05D0\u05EA \u05E9\u05E6\u05E4\u05D5\u05D9 \u05DC\u05DB\u05DC \u05D0\u05D7\u05EA \u05DE\u05D4\u05DE\u05E0\u05D9\u05D5\u05EA \u05D1\u05E2\u05EA\u05D9\u05D3?");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(551, 213, 310, 20);
		add(label_3);

		JLabel label_4 = new JLabel("\u05D4\u05DE\u05E0\u05D9\u05D9\u05D4 \u05D4\u05DE\u05EA\u05D0\u05D9\u05DE\u05D4 \u05DC\u05D3\u05E2\u05EA\u05D9");
		label_4.setBounds(150, 226, 190, 30);
		add(label_4);

		JLabel label_5 = new JLabel("++  : \u05DE\u05E0\u05D9\u05D9\u05D4 \u05D1\u05E2\u05DC\u05EA \u05E1\u05D9\u05DB\u05D5\u05D9 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05D0\u05EA \u05DE\u05D2\u05DE\u05EA \u05D4\u05E2\u05DC\u05D9\u05D9\u05D4 \u05D4\u05D7\u05D6\u05E7\u05D4 \u05D1\u05D9\u05D5\u05EA\u05E8");
		label_5.setText("<html>\r\n\u05DE\u05E0\u05D9\u05D9\u05D4 \u05D1\u05E2\u05DC\u05EA \u05E1\u05D9\u05DB\u05D5\u05D9 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05D0\u05EA \u05DE\u05D2\u05DE\u05EA \r\n<strong>\r\n\u05D4\u05E2\u05DC\u05D9\u05D9\u05D4 \u05D4\u05D7\u05D6\u05E7\u05D4\r\n \u05D1\u05D9\u05D5\u05EA\u05E8\r\n</strong>\r\n</html>\r\n");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(418, 292, 436, 20);
		add(label_5);

		JLabel label_6 = new JLabel("+  : \u05DE\u05E0\u05D9\u05D9\u05D4 \u05D1\u05E2\u05DC\u05EA \u05E1\u05D9\u05DB\u05D5\u05D9 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05DE\u05D2\u05DE\u05EA \u05D4\u05E2\u05DC\u05D9\u05D9\u05D4 \u05D4\u05E9\u05E0\u05D9\u05D9\u05D4 \u05D4\u05D7\u05D6\u05E7\u05D4 \u05D1\u05D9\u05D5\u05EA\u05E8");
		label_6.setText("<html>\r\n\u05DE\u05E0\u05D9\u05D9\u05D4 \u05D1\u05E2\u05DC\u05EA \u05E1\u05D9\u05DB\u05D5\u05D9 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05DE\u05D2\u05DE\u05EA \r\n<strong>\r\n\u05D4\u05E2\u05DC\u05D9\u05D9\u05D4 \u05D4\u05D7\u05D6\u05E7\u05D4\r\n</strong>\r\n</html>");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(418, 323, 436, 20);
		add(label_6);

		JLabel label_7 = new JLabel("0  : \u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05DC\u05D0 \u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05E9\u05D9\u05E0\u05D5\u05D9 \u05D1\u05DE\u05D7\u05D9\u05E8");
		label_7.setText("\u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05DC\u05D0 \u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05E9\u05D9\u05E0\u05D5\u05D9 \u05D1\u05DE\u05D7\u05D9\u05E8");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(418, 354, 436, 20);
		add(label_7);

		JLabel label_8 = new JLabel("0  : \u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05DC\u05D0 \u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05E9\u05D9\u05E0\u05D5\u05D9 \u05D1\u05DE\u05D7\u05D9\u05E8");
		label_8.setText("\u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05DC\u05D0 \u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05E9\u05D9\u05E0\u05D5\u05D9 \u05D1\u05DE\u05D7\u05D9\u05E8");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(418, 385, 436, 20);
		add(label_8);

		JLabel label_9 = new JLabel("-  : \u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05D9\u05E8\u05D9\u05D3\u05D4 \u05D1\u05DE\u05D7\u05D9\u05E8");
		label_9.setText("<html>\r\n\u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \r\n<strong>\r\n\u05D9\u05E8\u05D9\u05D3\u05D4 \u05D1\u05DE\u05D7\u05D9\u05E8\r\n</strong>\r\n</html>");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(418, 416, 436, 20);
		add(label_9);

		JLabel label_10 = new JLabel("- - : \u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \u05D9\u05E8\u05D9\u05D3\u05D4 \u05D7\u05D6\u05E7\u05D4 \u05D1\u05D9\u05D5\u05EA\u05E8 \u05D1\u05DE\u05D7\u05D9\u05E8");
		label_10.setText("<html>\r\n\u05DE\u05E0\u05D9\u05D9\u05D4 \u05E9\u05E6\u05E4\u05D5\u05D9\u05D4 \u05DC\u05D4\u05E6\u05D9\u05D2 \r\n<strong>\r\n\u05D9\u05E8\u05D9\u05D3\u05D4 \u05D7\u05D6\u05E7\u05D4 \u05D1\u05D9\u05D5\u05EA\u05E8 \u05D1\u05DE\u05D7\u05D9\u05E8\r\n</strong>\r\n</html>");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(418, 447, 436, 23);
		add(label_10);

		chkLabel  = new JLabel();
		chkLabel.setFont(new Font("Arial", Font.BOLD, 17));
		chkLabel.setText(Cons.ERROR_STOCKS_WINDOW);
		chkLabel.setBounds(418, 528, 230, 23);
		add(chkLabel);

		submit_button.setBounds(238, 520, 102, 39);
		add(submit_button);
		submit_button.setText(Cons.CONTINUE);
		submit_button.addActionListener(d);
		submit_button.setEnabled(false);

		clear_button = new JButton();
		clear_button.setBounds(96, 520, 118, 39);
		clear_button.setText(Cons.CLEAR_FORM);
		clear_button.addActionListener(d);
		add(clear_button);

		JRadioButton radioButtonA1 = new JRadioButton("");
		radioButtonA1.setBackground(Color.WHITE);
		radioButtonA1.setBounds(96, 292, 21, 23);
		add(radioButtonA1);

		JRadioButton radioButtonA2 = new JRadioButton("");
		radioButtonA2.setBackground(Color.WHITE);
		radioButtonA2.setBounds(150, 292, 21, 23);
		add(radioButtonA2);

		JRadioButton radioButtonA3 = new JRadioButton("");
		radioButtonA3.setBackground(Color.WHITE);
		radioButtonA3.setBounds(208, 292, 21, 23);
		add(radioButtonA3);

		JRadioButton radioButtonA4 = new JRadioButton("");
		radioButtonA4.setBackground(Color.WHITE);
		radioButtonA4.setBounds(267, 292, 21, 23);
		add(radioButtonA4);

		JRadioButton radioButtonA5 = new JRadioButton("");
		radioButtonA5.setBackground(Color.WHITE);
		radioButtonA5.setBounds(322, 292, 21, 23);
		add(radioButtonA5);

		JRadioButton radioButtonA6 = new JRadioButton("");
		radioButtonA6.setBackground(Color.WHITE);
		radioButtonA6.setBounds(379, 292, 21, 23);
		add(radioButtonA6);


		JRadioButton radioButtonB6 = new JRadioButton("");
		radioButtonB6.setBackground(Color.WHITE);
		radioButtonB6.setBounds(379, 323, 21, 23);
		add(radioButtonB6);

		JRadioButton radioButtonB5 = new JRadioButton("");
		radioButtonB5.setBackground(Color.WHITE);
		radioButtonB5.setBounds(322, 323, 21, 23);
		add(radioButtonB5);

		JRadioButton radioButtonB4 = new JRadioButton("");
		radioButtonB4.setBackground(Color.WHITE);
		radioButtonB4.setBounds(267, 323, 21, 23);
		add(radioButtonB4);

		JRadioButton radioButtonB3 = new JRadioButton("");
		radioButtonB3.setBackground(Color.WHITE);
		radioButtonB3.setBounds(208, 323, 21, 23);
		add(radioButtonB3);

		JRadioButton radioButtonB2 = new JRadioButton("");
		radioButtonB2.setBackground(Color.WHITE);
		radioButtonB2.setBounds(150, 323, 21, 23);
		add(radioButtonB2);

		JRadioButton radioButtonB1 = new JRadioButton("");
		radioButtonB1.setBackground(Color.WHITE);
		radioButtonB1.setBounds(96, 323, 21, 23);
		add(radioButtonB1);


		JRadioButton radioButtonC6 = new JRadioButton("");
		radioButtonC6.setBackground(Color.WHITE);
		radioButtonC6.setBounds(379, 354, 21, 23);
		add(radioButtonC6);

		JRadioButton radioButtonC5 = new JRadioButton("");
		radioButtonC5.setBackground(Color.WHITE);
		radioButtonC5.setBounds(322, 354, 21, 23);
		add(radioButtonC5);

		JRadioButton radioButtonC4 = new JRadioButton("");
		radioButtonC4.setBackground(Color.WHITE);
		radioButtonC4.setBounds(267, 354, 21, 23);
		add(radioButtonC4);

		JRadioButton radioButtonC3 = new JRadioButton("");
		radioButtonC3.setBackground(Color.WHITE);
		radioButtonC3.setBounds(208, 354, 21, 23);
		add(radioButtonC3);

		JRadioButton radioButtonC2 = new JRadioButton("");
		radioButtonC2.setBackground(Color.WHITE);
		radioButtonC2.setBounds(150, 354, 21, 23);
		add(radioButtonC2);

		JRadioButton radioButtonC1 = new JRadioButton("");
		radioButtonC1.setBackground(Color.WHITE);
		radioButtonC1.setBounds(96, 354, 21, 23);
		add(radioButtonC1);

		JRadioButton radioButtonD6 = new JRadioButton("");
		radioButtonD6.setBackground(Color.WHITE);
		radioButtonD6.setBounds(379, 385, 21, 23);
		add(radioButtonD6);

		JRadioButton radioButtonD5 = new JRadioButton("");
		radioButtonD5.setBackground(Color.WHITE);
		radioButtonD5.setBounds(322, 385, 21, 23);
		add(radioButtonD5);

		JRadioButton radioButtonD4 = new JRadioButton("");
		radioButtonD4.setBackground(Color.WHITE);
		radioButtonD4.setBounds(267, 385, 21, 23);
		add(radioButtonD4);

		JRadioButton radioButtonD3 = new JRadioButton("");
		radioButtonD3.setBackground(Color.WHITE);
		radioButtonD3.setBounds(208, 385, 21, 23);
		add(radioButtonD3);

		JRadioButton radioButtonD2 = new JRadioButton("");
		radioButtonD2.setBackground(Color.WHITE);
		radioButtonD2.setBounds(150, 385, 21, 23);
		add(radioButtonD2);

		JRadioButton radioButtonD1 = new JRadioButton("");
		radioButtonD1.setBackground(Color.WHITE);
		radioButtonD1.setBounds(96, 385, 21, 23);
		add(radioButtonD1);


		JRadioButton radioButtonE6 = new JRadioButton("");
		radioButtonE6.setBackground(Color.WHITE);
		radioButtonE6.setBounds(379, 416, 21, 23);
		add(radioButtonE6);

		JRadioButton radioButtonE5 = new JRadioButton("");
		radioButtonE5.setBackground(Color.WHITE);
		radioButtonE5.setBounds(322, 416, 21, 23);
		add(radioButtonE5);

		JRadioButton radioButtonE4 = new JRadioButton("");
		radioButtonE4.setBackground(Color.WHITE);
		radioButtonE4.setBounds(267, 416, 21, 23);
		add(radioButtonE4);

		JRadioButton radioButtonE3 = new JRadioButton("");
		radioButtonE3.setBackground(Color.WHITE);
		radioButtonE3.setBounds(208, 416, 21, 23);
		add(radioButtonE3);

		JRadioButton radioButtonE2 = new JRadioButton("");
		radioButtonE2.setBackground(Color.WHITE);
		radioButtonE2.setBounds(150, 416, 21, 23);
		add(radioButtonE2);

		JRadioButton radioButtonE1 = new JRadioButton("");
		radioButtonE1.setBackground(Color.WHITE);
		radioButtonE1.setBounds(96, 416, 21, 23);
		add(radioButtonE1);


		JRadioButton radioButtonF6 = new JRadioButton("");
		radioButtonF6.setBackground(Color.WHITE);
		radioButtonF6.setBounds(379, 447, 21, 23);
		add(radioButtonF6);

		JRadioButton radioButtonF5 = new JRadioButton("");
		radioButtonF5.setBackground(Color.WHITE);
		radioButtonF5.setBounds(322, 447, 21, 23);
		add(radioButtonF5);

		JRadioButton radioButtonF4 = new JRadioButton("");
		radioButtonF4.setBackground(Color.WHITE);
		radioButtonF4.setBounds(267, 447, 21, 23);
		add(radioButtonF4);

		JRadioButton radioButtonF3 = new JRadioButton("");
		radioButtonF3.setBackground(Color.WHITE);
		radioButtonF3.setBounds(208, 447, 21, 23);
		add(radioButtonF3);

		JRadioButton radioButtonF2 = new JRadioButton("");
		radioButtonF2.setBackground(Color.WHITE);
		radioButtonF2.setBounds(150, 447, 21, 23);
		add(radioButtonF2);

		JRadioButton radioButtonF1 = new JRadioButton("");
		radioButtonF1.setBackground(Color.WHITE);
		radioButtonF1.setBounds(96, 447, 21, 23);
		add(radioButtonF1);


		buttons[0][0]=  radioButtonA1;
		buttons[0][1]=  radioButtonA2;
		buttons[0][2]=  radioButtonA3;
		buttons[0][3]=  radioButtonA4;
		buttons[0][4]=  radioButtonA5;
		buttons[0][5]=  radioButtonA6;
		buttons[1][0]=  radioButtonB1;
		buttons[1][1]=  radioButtonB2;
		buttons[1][2]=  radioButtonB3;
		buttons[1][3]=  radioButtonB4;
		buttons[1][4]=  radioButtonB5;
		buttons[1][5]=  radioButtonB6;
		buttons[2][0]=  radioButtonC1;
		buttons[2][1]=  radioButtonC2;
		buttons[2][2]=  radioButtonC3;
		buttons[2][3]=  radioButtonC4;
		buttons[2][4]=  radioButtonC5;
		buttons[2][5]=  radioButtonC6;
		buttons[3][0]=  radioButtonD1;
		buttons[3][1]=  radioButtonD2;
		buttons[3][2]=  radioButtonD3;
		buttons[3][3]=  radioButtonD4;
		buttons[3][4]=  radioButtonD5;
		buttons[3][5]=  radioButtonD6;
		buttons[4][0]=  radioButtonE1;
		buttons[4][1]=  radioButtonE2;
		buttons[4][2]=  radioButtonE3;
		buttons[4][3]=  radioButtonE4;
		buttons[4][4]=  radioButtonE5;
		buttons[4][5]=  radioButtonE6;
		buttons[5][0]=  radioButtonF1;
		buttons[5][1]=  radioButtonF2;
		buttons[5][2]=  radioButtonF3;
		buttons[5][3]=  radioButtonF4;
		buttons[5][4]=  radioButtonF5;
		buttons[5][5]=  radioButtonF6;



		radiobutton_init();

	}

	private void initializeLettersLabels() {
		letters = new JLabel[Cons.NUM_OF_STOCKS];
		int y = 260;
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			letters[i]=new JLabel(""+Character.toString((char)(65+i)));
			letters[i].setHorizontalAlignment(SwingConstants.LEFT);
			letters[i].setFont(Cons.BOLD);
			if(i==0){
				letters[i].setBounds(97, y, 21, 30);
			}else{
				letters[i].setBounds((letters[i-1].getX()+21+37), y, 21, 30);
			}
			add(letters[i]);
		}
	}

	public void radiobutton_init() {
		for (int i = 0; i < num_of_row; i++) {
			radioGroups[i] = new ButtonGroup();
			for (int j = 0; j < num_of_col; j++) {
				buttons[i][j].addActionListener(d);
				buttons[i][j].setName(Character.toString((char)(65+j)));
				radioGroups[i].add(buttons[i][j]);
			}
		}
	}

	public boolean chkTheRadio(){
		for(int col=0; col<num_of_col;col++){
			boolean selected = false;
			for(int row=0;row<num_of_row;row++){
				if(buttons[row][col].isSelected()){
					if(selected){
						return false;
					}
					selected = true;
				}
			}
		}
		for(int row=0;row<Cons.NUM_OF_STOCKS;row++){
			if(radioGroups[row].getSelection()==null){
				return false;
			}
		}
		return true;
	}

	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==submit_button){
				for(int row=0;row<Cons.NUM_OF_STOCKS;row++){
					if(radioGroups[row].getSelection()==null){
						return;
					}
				}
				subject.setStockRating(periodNum, getSelectedStocks());
				setVisible(false);
				if(periodNum==(Cons.NUM_OF_PERIODS-1)){
					MainWindow.frame.startLastQuesScreen();				
				}else{
					MainWindow.frame.nextPeriod();
				}
			}else if(e.getSource()==clear_button){
				for(int row=0;row<Cons.NUM_OF_STOCKS;row++){
					radioGroups[row].clearSelection();
				}
				submit_button.setEnabled(false);
			}
			if(chkTheRadio()){
				submit_button.setEnabled(true);
				chkLabel.setText("");
			}else{
				submit_button.setEnabled(false);
				chkLabel.setText(Cons.ERROR_STOCKS_WINDOW);
			}
		}
	}

	public StockRating getSelectedStocks() {
		StockRating temp = new StockRating();
		for(int row=0;row<Cons.NUM_OF_STOCKS;row++){
			for(int col=0;col<num_of_col;col++){
				if(buttons[row][col].isSelected()){
					temp.setStockRating(row, buttons[row][col].getName());
					break;
				}
			}
		}
		return temp;
	}
}
