package borsa;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FirstPeriodScreen extends JPanel implements KeyListener{

	private static final long serialVersionUID = 5384972630380487354L;
	private JTextField[] inputs;
	private JLabel[] stockTexts, priceText, sumsTexts, deltas;
	private JLabel stockPriceText, inputText, upperSumText, emptyLabel, status, title, helpText1, helpText2;
	private JButton continueButton, graph;
	private GraphWindow graphWindow;
	
	private Subject subject;
	
	private static final int SUM = 0;
	private static final int CASH = 1;
	private static final int STOCK = 2;
	private static final Rectangle ANCHOR = new Rectangle(370, 505, 50, 50);
	
	public FirstPeriodScreen(Subject sub){
		
		subject = sub;
		setLayout(null);
		setBackground(Color.WHITE);
		graphWindow = new GraphWindow(0);
		
		initalizeInputs();
		initalizeLabels();
		initalizeRightStaticLabels();
		initalizeSumsTexts();
		
		deltas = new JLabel[Cons.FRIST_PERIOD_TEXTS.length];
		for(int i=0;i<Cons.FRIST_PERIOD_TEXTS.length;i++){
			deltas[i] = new JLabel();
			deltas[i].setFont(Cons.BOLD);
			deltas[i].setBorder(Cons.LINE_BORDER_REGULAR);
			if(i==0) deltas[i].setBounds(sumsTexts[0].getX(),sumsTexts[0].getY()+sumsTexts[0].getHeight()+2,sumsTexts[0].getWidth(), sumsTexts[0].getHeight());
			else deltas[i].setBounds(deltas[i-1].getX()+deltas[i-1].getWidth()+2, deltas[i-1].getY(), deltas[i-1].getWidth(), deltas[i-1].getHeight());
			add(deltas[i]);
		}
		deltas[SUM].setText("10000");
		deltas[CASH].setText("10000");
		deltas[STOCK].setText("0");
		
		continueButton = new JButton(Cons.CONTINUE);
		continueButton.setBounds(Cons.BUTTON_RECT);
		continueButton.setEnabled(false);
		continueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
					subject.buyStock(i, getNumFromInput(i));
				}
				int [] changes = new int[Cons.NUM_OF_STOCKS];
				for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
					changes[i]=getNumFromInput(i);
				}
				graphWindow.setVisible(false);
				subject.savePeriod(0, changes);
				setVisible(false);
//				MainWindow.frame.startHelpAndConfirm();
				MainWindow.frame.nextPeriod();
			}
		});
		add(continueButton);
		
		graph = new JButton(" âøó ");
		graph.setBounds((int)(Cons.BUTTON_RECT.getX()+Cons.BUTTON_RECT.getWidth()+Cons.GAP), (int)(Cons.BUTTON_RECT.getY()), (int)(Cons.BUTTON_RECT.getWidth()), (int)(Cons.BUTTON_RECT.getHeight()));
		graph.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(graphWindow.isVisible()){
					graphWindow.setVisible(false);
				}else{
					graphWindow.setVisible(true);
				}
			}
		});
		add(graph);
		
		status = new JLabel();
		status.setFont(Cons.TITLE);
		status.setBounds(continueButton.getX()+continueButton.getWidth()+2, continueButton.getY(), upperSumText.getWidth(), continueButton.getHeight());
		add(status);
	}

	protected int getNumFromInput(int i) {
		return Integer.parseInt(inputs[i].getText());
	}

	public void initalizeSumsTexts() {
		sumsTexts = new JLabel[Cons.FRIST_PERIOD_TEXTS.length];
		for(int i=0;i<Cons.FRIST_PERIOD_TEXTS.length;i++){
			sumsTexts[i] = new JLabel(Cons.FRIST_PERIOD_TEXTS[i]);
			sumsTexts[i].setFont(Cons.BOLD);
			sumsTexts[i].setBorder(Cons.LINE_BORDER_REGULAR);
			if(i==0) sumsTexts[i].setBounds(priceText[5].getX()-306, priceText[5].getY(), 100, priceText[5].getHeight());
			else sumsTexts[i].setBounds(sumsTexts[i-1].getX()+sumsTexts[i-1].getWidth()+2, sumsTexts[i-1].getY(), sumsTexts[i-1].getWidth(),sumsTexts[i-1].getHeight());
			add(sumsTexts[i]);
		}
		
		upperSumText = new JLabel(Cons.SUM_TEXT);
		upperSumText.setFont(Cons.TITLE);
		upperSumText.setBorder(Cons.LINE_BORDER_REGULAR);
		upperSumText.setBounds(sumsTexts[0].getX(), (sumsTexts[0].getY()-sumsTexts[0].getHeight()-2), sumsTexts[0].getWidth()*3+4, sumsTexts[0].getHeight());
		add(upperSumText);
		
	}

	public void initalizeRightStaticLabels() {
		stockPriceText = new JLabel(Cons.CURRENT_STOCK_PRICE);
		stockPriceText.setFont(Cons.BOLD);
		stockPriceText.setBounds(priceText[0].getX()+priceText[0].getWidth()+2, priceText[0].getY(), 4*priceText[0].getWidth(), priceText[0].getHeight());
		stockPriceText.setBorder(Cons.LINE_BORDER_REGULAR);
		add(stockPriceText);

		inputText = new JLabel(Cons.INPUT_TEXT_FIRST_PERIOD);
		inputText.setFont(Cons.BOLD);
		inputText.setBorder(Cons.LINE_BORDER_REGULAR);
		inputText.setBounds(stockPriceText.getX(), stockPriceText.getY()+stockPriceText.getHeight()+2, stockPriceText.getWidth(), stockPriceText.getHeight());
		add(inputText);
		
		emptyLabel = new JLabel();
		emptyLabel.setBorder(Cons.LINE_BORDER_REGULAR);
		emptyLabel.setBounds(stockTexts[0].getX()+stockTexts[0].getWidth()+2, stockTexts[0].getY(), inputText.getWidth(), inputText.getHeight());
		add(emptyLabel);
	}
	
	private void initalizeLabels() {
		title = new JLabel(Cons.AGREEMENT_TITLE);
		title.setBounds(Cons.TITLE_RECT);
		title.setFont(Cons.TITLE);
		add(title);
		
		helpText1 = new JLabel(Cons.alignTextRight(Cons.FIRST_PERIOD_HELP1));
		int width = Cons.WINDOW_WIDTH-(2*Cons.GAP);
		helpText1.setBounds(Cons.GAP, title.getY()+title.getHeight()+Cons.GAP, width, 100);
		helpText1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(helpText1);
		
		helpText2 = new JLabel(Cons.alignTextRight(Cons.FIRST_PERIOD_HELP2));
		helpText2.setBounds(Cons.GAP, helpText1.getY()+helpText1.getHeight()+Cons.GAP, width, helpText1.getHeight());
		helpText2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(helpText2);
		
		priceText = new JLabel[Cons.NUM_OF_STOCKS];
		for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
			priceText[i] = new JLabel(""+Cons.getBorsaChange(0)[i]);
			if(i==(Cons.NUM_OF_STOCKS-1)) priceText[i].setBounds(inputs[i].getX(),inputs[i].getY()-inputs[i].getHeight()-2,inputs[i].getWidth(),inputs[i].getHeight());
			else priceText[i].setBounds(priceText[i+1].getX()+2+priceText[i+1].getWidth(), priceText[i+1].getY(), inputs[i].getWidth(), inputs[i].getHeight());
			priceText[i].setBorder(Cons.LINE_BORDER_REGULAR);
			add(priceText[i]);
		}

		stockTexts = new JLabel[Cons.NUM_OF_STOCKS];
		for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
			stockTexts[i] = new JLabel(Character.toString((char)(65+i)));
			stockTexts[i].setFont(Cons.TITLE);
			stockTexts[i].setBorder(Cons.LINE_BORDER_REGULAR);
			if(i==(Cons.NUM_OF_STOCKS-1)) stockTexts[i].setBounds(priceText[i].getX(),priceText[i].getY()-priceText[i].getHeight()-2, priceText[i].getWidth(), priceText[i].getHeight());
			else stockTexts[i].setBounds(stockTexts[i+1].getX()+stockTexts[i+1].getWidth()+2,stockTexts[i+1].getY(),inputs[5].getWidth(),inputs[i].getHeight());
			add(stockTexts[i]);
		}		
	}

	public void initalizeInputs() {
		inputs = new JTextField[Cons.NUM_OF_STOCKS];
		for(int index=Cons.NUM_OF_STOCKS-1;index>=0;index--){
			inputs[index] = new JTextField();
			inputs[index].setText("");
			inputs[index].setColumns(10);
			inputs[index].setBorder(Cons.LINE_BORDER_REGULAR);
			inputs[index].addKeyListener(this);
			inputs[index].setHorizontalAlignment(SwingConstants.CENTER);
			if(index==Cons.NUM_OF_STOCKS-1){
				inputs[index].setBounds(ANCHOR);
			}else{
				inputs[index].setBounds(inputs[index+1].getX()+inputs[index+1].getWidth()+2,inputs[index+1].getY(),inputs[index+1].getWidth(), inputs[index+1].getHeight());
			}
			add(inputs[index]);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Cons.contains(inputs,e)){
			updateDelta();
		}
	}

	private void updateDelta() {
		int sum = calcDelta();
		deltas[CASH].setText(""+(10000-sum));
		deltas[STOCK].setText(""+sum);
	}

	private int calcDelta() {
		int temp = 0;
		boolean allIsCorrect = true;
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			int num;
			try{
				if(inputs[i].getText().equals("")){
					inputs[i].setBackground(Color.WHITE);
					continue;
				}
				num = Integer.parseInt(inputs[i].getText());
				if(num<0){
					allIsCorrect = false;
					status.setText(Cons.ERROR_MASSAGES[Cons.STOCKÉ_ERROR]);
					inputs[i].setBackground(Color.RED);
					continue;
				}
				if(getInputsSum()>subject.getCash()){
					allIsCorrect = false;
					status.setText(Cons.ERROR_MASSAGES[Cons.CASHÉ_ERROR]);
					inputs[i].setBackground(Color.RED);
					continue;
				}
			}catch(Exception e){
				allIsCorrect = false;
				status.setText(Cons.ERROR_MASSAGES[Cons.INPUTÉ_ERROR]);
				inputs[i].setBackground(Color.RED);
				continue;
			}
			temp+=num;
			inputs[i].setBackground(Color.WHITE);
			chkForButtonUnlock();
		}
		if(allIsCorrect){
			status.setText("");
			
		}
		return temp;
	}

	private void chkForButtonUnlock() {
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			if(inputs[i].getText().equals("")){
				continueButton.setEnabled(false);
				return;
			}
		}
		continueButton.setEnabled(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	private int getInputsSum(){
		int sum = 0;
		for(int i=0;i<inputs.length;i++){
			if(inputs[i].getText().equals("")) continue;
			sum+=Integer.parseInt(inputs[i].getText());
		}
		return sum;
	}

}
