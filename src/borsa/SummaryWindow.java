package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class SummaryWindow extends JPanel {

	private static final long serialVersionUID = -361898085080223178L;
	private JLabel summaryTitle, subjectIDText, thankYou, mailText, phoneText;
	private JLabel [] stocks, stocksStats, sumsText, sums;
	private JTextField emailInput, phoneInput;
	private JButton saveMail;
	
	public SummaryWindow(final Subject subject){
		
		setLayout(null);
		
		setBackground(Color.WHITE);
		
		initalizeLabels(subject);
		
		try {
			MainWindow.frame.saveDataToDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		thankYou = new JLabel(Cons.alignTextRight(Cons.THANK_YOU_TEXT));
		thankYou.setBounds(sums[0].getX(), sums[0].getY()+sums[0].getHeight()+Cons.GAP-25, sums[0].getWidth()*3+Cons.GAP, (int)(sums[0].getHeight()*1.5));
		add(thankYou);
		
		saveMail = new JButton(Cons.SAVE_MAIL);
		saveMail.setFont(Cons.REGUALAR);
		saveMail.setBounds(thankYou.getX(),(int)(thankYou.getY()+thankYou.getHeight()+Cons.GAP*1.3)+(int)(Cons.BUTTON_RECT.getHeight()),(int)(Cons.BUTTON_RECT.getWidth()),(int)(Cons.BUTTON_RECT.getHeight()));
		add(saveMail);
		saveMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!emailInput.getText().equals("") && !Cons.chkMail(emailInput.getText())){
						emailInput.setText("");
						thankYou.setText(Cons.alignTextRight(Cons.INPUT_ERROR_MESSAGE));
						return;
					}
					subject.setEmail(emailInput.getText());
					subject.setPhone(phoneInput.getText());
					MainWindow.frame.saveMail();
					
					changeButtonToClose();
					emailInput.setVisible(false);
					mailText.setVisible(false);
					
					phoneInput.setVisible(false);
					phoneText.setVisible(false);
					
					thankYou.setFont(Cons.TITLE);
					thankYou.setText(Cons.alignTextRight(Cons.THANK_YOU_TEXT_2));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		emailInput = new JTextField();
		int height = (int)(Cons.BUTTON_RECT.getHeight()/1.5);
		emailInput.setHorizontalAlignment(SwingConstants.LEFT);
		emailInput.setBounds(saveMail.getX()+saveMail.getWidth()+Cons.GAP-10, saveMail.getY()+((saveMail.getHeight()-height)/2), sums[0].getWidth()+35, height);
		emailInput.setToolTipText(" הכנס כתובת מייל ");
		add(emailInput);
		
		phoneInput = new JTextField();
		phoneInput.setHorizontalAlignment(SwingConstants.LEFT);
		phoneInput.setBounds(emailInput.getX(),emailInput.getY()-emailInput.getHeight()-30, emailInput.getWidth(),emailInput.getHeight());
		phoneInput.setToolTipText(" הכנס מספר טלפון ");
		add(phoneInput);
		
		mailText = new JLabel(" הכנס כתובת מייל ");
		mailText.setBounds(emailInput.getX()+emailInput.getWidth()+Cons.GAP-10, emailInput.getY(), 120, 30);
		add(mailText);
		
		phoneText = new JLabel(" הכנס מס' טלפון ");
		phoneText.setBounds(phoneInput.getX()+phoneInput.getWidth()+Cons.GAP-10, phoneInput.getY(), mailText.getWidth(), mailText.getHeight());
		add(phoneText);
		
	}

	protected void changeButtonToClose() {
		saveMail.setText(" סיים שאלון ");
		saveMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow.frame.setVisible(false);
				MainWindow.frame.dispose();
				
//				test.test.setVisible(false);
//				test.test.dispose();
			}
		});
	}

	private void initalizeLabels(Subject subject) {
		summaryTitle = new JLabel(Cons.SUMMARY_TITLE);
		summaryTitle.setFont(Cons.TITLE);
		summaryTitle.setBounds(Cons.TITLE_RECT);
		add(summaryTitle);
		
		subjectIDText = new JLabel(" מספר שאלון: "+subject.getSubjectId());
		subjectIDText.setFont(Cons.TITLE);
		subjectIDText.setBounds(summaryTitle.getX(), summaryTitle.getY()+Cons.GAP, Cons.TITLE_WIDTH, Cons.TITLE_HEIGHT);
		add(subjectIDText);
		
		stocks = new JLabel[Cons.NUM_OF_STOCKS];
		stocksStats = new JLabel[Cons.NUM_OF_STOCKS];
		sumsText = new JLabel[Cons.NUM_OF_STOCKS/2];
		sums = new JLabel[Cons.NUM_OF_STOCKS/2];
		int x = 215, y=150, width = 70, height = 50, gap = 20;
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			stocks[i] = new JLabel(Character.toString((char)(65+i)));
			stocks[i].setBounds(x, y, width, height);
			stocks[i].setFont(Cons.BOLD);
			stocks[i].setBorder(new LineBorder(Color.BLACK, 2));
			x+=gap+width;
			add(stocks[i]);
		}
		y+=height+gap; x = 215;
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			stocksStats[i] = new JLabel(""+subject.getStock(i));
			stocksStats[i].setBounds(x, y, width, height);
			stocksStats[i].setBorder(new LineBorder(Color.BLACK, 1));
			add(stocksStats[i]);
			x+=gap+width;
		}
		y+=height+gap; x = 215; width += width+gap;
		for(int i=0;i<Cons.NUM_OF_STOCKS/2;i++){
			sumsText[i] = new JLabel(Cons.SUMMARY_TEXT[i]);
			sumsText[i].setFont(Cons.BOLD);
			sumsText[i].setBounds(x, y, width, height);
			sumsText[i].setBorder(new LineBorder(Color.BLACK, 2));
			add(sumsText[i]);
			x+=width+gap;
		}
		y+=height+gap; x = 215;
		for(int i=0;i<Cons.NUM_OF_STOCKS/2;i++){
			sums[i] = new JLabel();
			sums[i].setBounds(x, y, width, height);
			sums[i].setBorder(new LineBorder(Color.BLACK, 1));
			add(sums[i]);
			x+=width+gap;
		}
		
		sums[0].setText(""+subject.getSummary());
		sums[1].setText(""+subject.getCash());
		sums[2].setText(""+subject.getStocksSum());
	}
}
