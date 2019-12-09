package borsa;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.LineBorder;
import java.awt.Font;

public class PeriodPanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = -2420398630561938732L;

	private JLabel mainTable, buyOrSell, deltaStock, deltaCash, statusLabel, stockAfterChange, cashAfterChange, summaryAfterChange, periodTitle;
	private JLabel [] afterChangeLabels;
	private Subject subject;
	private JTextField [] inputs;
	private JButton continueButton, graph;
	private GraphWindow graphWindow;

	public PeriodPanel(final int periodNum, Subject sub) {
		this.subject = sub;

		graphWindow = new GraphWindow(periodNum);
		
		initalizeInputs();
		initalizeAfterChangeLabels();

		setBackground(Color.WHITE);
		setLayout(null);
		mainTable = new JLabel();
		mainTable.setBackground(Color.WHITE);
		mainTable.setBounds(8, 0, 950, 399);
		mainTable.setText(buildTable(periodNum));
		add(mainTable);

		buyOrSell = new JLabel(Cons.BUY_OR_SELL_TEXT);
		buyOrSell.setFont(new Font("Arial", Font.BOLD, 17));
		buyOrSell.setBorder(new LineBorder(new Color(0, 0, 0)));
		buyOrSell.setBounds(658, 345, 232, 45);
		add(buyOrSell);

		periodTitle = new JLabel(Cons.PERIOD_TITLE+periodNum);
//		if(isDemo){
//			periodTitle.setText(periodTitle.getText()+Constants.PERIOD_TITLE_DEMO);
//		}
		periodTitle.setFont(new Font("Arial", Font.BOLD, 22));
		int width = Cons.TITLE_WIDTH;
		periodTitle.setBounds((Cons.WINDOW_WIDTH/2)-(width/2), Cons.TITLE_Y, width, Cons.TITLE_HEIGHT);
		add(periodTitle);

		JLabel numInTheSide5 = new JLabel();
		numInTheSide5.setFont(new Font("Arial", Font.BOLD, 17));
		numInTheSide5.setBorder(new LineBorder(new Color(0, 0, 0)));
		numInTheSide5.setText("5");
		numInTheSide5.setBounds(894, 345, 23, 45);
		add(numInTheSide5);

		deltaStock = new JLabel("0");
		deltaStock.setBorder(new LineBorder(new Color(0, 0, 0)));
		deltaStock.setBounds(235, 345, 95, 45);
		add(deltaStock);

		deltaCash = new JLabel("0");
		deltaCash.setBorder(new LineBorder(new Color(0, 0, 0)));
		deltaCash.setBounds(136, 345, 95, 45);
		add(deltaCash);

		JLabel numInTheSide6 = new JLabel();
		numInTheSide6.setFont(new Font("Arial", Font.BOLD, 17));
		numInTheSide6.setText("6");
		numInTheSide6.setBorder(new LineBorder(new Color(0, 0, 0)));
		numInTheSide6.setBounds(894, 418, 23, 45);
		add(numInTheSide6);

		JLabel afterChangeText = new JLabel(Cons.AFTER_CHANGE_TEXT);
		afterChangeText.setFont(new Font("Arial", Font.BOLD, 17));
		afterChangeText.setBorder(new LineBorder(new Color(0, 0, 0)));
		afterChangeText.setBounds(658, 418, 232, 45);
		add(afterChangeText);

		stockAfterChange = new JLabel("0");
		stockAfterChange.setFont(new Font("Arial", Font.BOLD, 17));
		stockAfterChange.setBorder(new LineBorder(new Color(0, 0, 0)));
		stockAfterChange.setBounds(235, 418, 95, 45);
		add(stockAfterChange);

		cashAfterChange = new JLabel("0");
		cashAfterChange.setFont(new Font("Arial", Font.BOLD, 17));
		cashAfterChange.setBorder(new LineBorder(new Color(0, 0, 0)));
		cashAfterChange.setBounds(136, 418, 95, 45);
		add(cashAfterChange);

		summaryAfterChange = new JLabel("0");
		summaryAfterChange.setFont(new Font("Arial", Font.BOLD, 17));
		summaryAfterChange.setBorder(new LineBorder(new Color(0, 0, 0)));
		summaryAfterChange.setBounds(35, 418, 95, 45);
		add(summaryAfterChange);

		continueButton = new JButton();
		continueButton.setText(Cons.CONTINUE);
		continueButton.setBounds(25, 619, 150, 45);
		continueButton.setEnabled(false);
		continueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//buy or sell the stocks to the subject object
				for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
					subject.buyStock(i, getNumFromInput(i));
				}
				setVisible(false);
				graphWindow.setVisible(false);
//				if(!isDemo){
					//save the changes made in the period to the subject object
					int [] changes = new int[Cons.NUM_OF_STOCKS];
					for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
						changes[i]=getNumFromInput(i);
					}
					subject.savePeriod(periodNum, changes);
					
					//if it is the 1,7,14 period than show the stocks rating window
					if(periodNum==1||periodNum==7){
						MainWindow.frame.startStockReview();
					}
					else if(periodNum==14){
						MainWindow.frame.startContinueScreen();
					}
					else{
						MainWindow.frame.nextPeriod();
					}
//				}else{
//					if(periodNum==Constants.DEMO_NUM_OF_ROUNDS){
//						MainWindow.frame.startWaitAndConfirm();
//					}else{
//						MainWindow.frame.nextPeriod();
//					}
//				}
			}
		});
		add(continueButton);
		
		graph = new JButton(" גרף ");
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

		statusLabel = new JLabel();
		statusLabel.setBounds(334, 464, 350, 100);
		statusLabel.setFont(Cons.TITLE);
		add(statusLabel);

		updateLastRowNums();
		
		if(periodNum==1){
			JOptionPane.showConfirmDialog(null, " שים לב: בשורה הראשונה יופיעו שווי מניות ומזומן מתקופה קודמת. ", " לתשומת לבך ", JOptionPane.CLOSED_OPTION);
		}
		
	}

	public void initalizeAfterChangeLabels() {
		afterChangeLabels = new JLabel[Cons.NUM_OF_STOCKS];
		for(int index=Cons.NUM_OF_STOCKS-1;index>=0;index--){
			//			int index = afterChangeLabels.length-i-1;
			afterChangeLabels[index] = new JLabel();
			afterChangeLabels[index].setText(""+subject.getStock(index));
			afterChangeLabels[index].setBorder(new LineBorder(new Color(0, 0, 0)));
			if(index==Cons.NUM_OF_STOCKS-1)
				afterChangeLabels[index].setBounds(334, 418, 51, 45);
			else
				afterChangeLabels[index].setBounds(afterChangeLabels[index+1].getX()+54,418,52,45);
			add(afterChangeLabels[index]);
		}
	}

	public void initalizeInputs() {
		inputs = new JTextField[Cons.NUM_OF_STOCKS];
		for(int index=Cons.NUM_OF_STOCKS-1;index>=0;index--){
			//			int index = buyOrSellInputs.length-i-1;
			inputs[index] = new JTextField();
			inputs[index].setText("");
			inputs[index].setColumns(10);
			inputs[index].setBorder(new LineBorder(Color.BLACK, 2));
			inputs[index].addKeyListener(this);
			inputs[index].setHorizontalAlignment(SwingConstants.CENTER);
			if(index==Cons.NUM_OF_STOCKS-1){
				inputs[index].setBounds(333, 345, 52, 45);
			}else{
				inputs[index].setBounds(inputs[index+1].getX()+54,345,52,45);
			}
			add(inputs[index]);
		}
	}

	private void saveNewStocksHoldingsToSubject(int periodNum) {
		if(periodNum!=0){
			for(int stock=0;stock<Cons.NUM_OF_STOCKS;stock++){
				subject.setStock(stock, calcHoldings(stock, periodNum));
			}
		}
	}

	private String buildTable(int periodNum){
		String lastStockPriceText = " מחיר מניה קודם ", newStockPriceText = " מחיר מניה חדש ",
				stockSumText = " שווי המניות ", cashLeftText = " יתרת מזומן ", summaryText = " סה\"כ נכסים ", 
				lastRoundStockAndCash = " שווי מניות ומזומן מתקופה קודמת ", holdingValueText = " שווי החזקתך ";

		int stockSumInt = this.subject.getStocksSum(), cashLeftInt = this.subject.getCash(), summaryInt = this.subject.getSummary();

		String temp = "<html><head>"
				+ "<style> "
				+ "td{text-align: center; border: 1px solid black; padding: 5px; min-height: 100px } "
				+ "table{border: 1px solid black} "
				+ ".black{background-color: gray} "
				+ "td.stock{width: 40px; font-weight: bold}"
				+ ".head{font-weight: bold; font-size: 17pt}"
				+ "#separtor{height: 25px}"
				+ ".stockNum{font-weight: bold;}"
				+ "</style>"
				+ "</head><table>"
				//				+ "<tr><td colspan='3'>"+sumText+"</td><td rowspan='2' class='stock'>F</td><td rowspan='2' class='stock'>E</td><td rowspan='2' class='stock'>D</td><td rowspan='2' class='stock'>C</td><td rowspan='2' class='stock'>B</td><td rowspan='2' class='stock'>A</td><td rowspan='2'> </td><td rowspan='2'></td></tr>"
				+ "<tr><td colspan='3' class='head'>"+Cons.SUM_TEXT+"</td>";
		for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
			temp+="<td rowspan='2' class='stock'>"+Character.toString((char)(65+i))+"</td>";
		}
		temp+= "<tr><td class='head'>"+summaryText+"</td><td class='head'>"+cashLeftText+"</td><td class='head'>"+stockSumText+"</td></tr>";
		if(periodNum!=0){
			temp+= "<tr><td>"+summaryInt+"</td><td>"+cashLeftInt+"</td><td>"+stockSumInt+"</td>";
			//			for(int i=0;i<Constants.NUM_OF_STOCKS;i++){
			for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
				temp+="<td>"+subject.getStock(i)+"</td>";
			}
			temp+="<td class='head'>"+lastRoundStockAndCash+"</td><td class='head'>1</td></tr>";
			//					+ "<td>"+subject.getStock(Constants.F)+"</td><td>"+subject.getStock(Constants.E)+"</td><td>"+subject.getStock(Constants.D)+"</td><td>"+subject.getStock(Constants.C)+"</td><td>"+subject.getStock(Constants.B)+"</td><td>"+subject.getStock(Constants.A)+"</td><td class='head'>"+lastRoundStockAndCash+"</td><td class='head'>1</td></tr>"
			temp+="<tr><td class='black' colspan='3' rowspan='2' ></td>";
			for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
//				temp+="<td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[i]+"</td>";
				temp+="<td class='stockNum'>"+Cons.getBorsaChange(periodNum-1)[i]+"</td>";
			}
			temp+="<td class='head'>"+lastStockPriceText+"</td><td class='head'>2</td></tr>";
			//					+ "<td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[Constants.F]+"</td><td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[Constants.E]+"</td><td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[Constants.D]+"</td><td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[Constants.C]+"</td><td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[Constants.B]+"</td><td class='stockNum'>"+Constants.getBorsaChange(periodNum-1,isDemo)[Constants.A]+"</td><td class='head'>"+lastStockPriceText+"</td><td class='head'>2</td></tr>";
		}else{
			temp+= "<tr><td>"+summaryInt+"</td><td>"+cashLeftInt+"</td><td>"+stockSumInt+"</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td class='head'>"+lastRoundStockAndCash+"</td><td class='head'>1</td></tr>"
					+"<tr><td class='black' colspan='3' rowspan='2' ></td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td class='head'>"+lastStockPriceText+"</td><td class='head'>2</td></tr>";
		}

		//	"<td>"+Constants.getBorsaChange(periodNum,isDemo)[Constants.F]+"</td><td>"+Constants.getBorsaChange(periodNum,isDemo)[Constants.E]+"</td><td>"+Constants.getBorsaChange(periodNum,isDemo)[Constants.D]+"</td><td>"+Constants.getBorsaChange(periodNum,isDemo)[Constants.C]+"</td><td>"+Constants.getBorsaChange(periodNum,isDemo)[Constants.B]+"</td><td>"+Constants.getBorsaChange(periodNum,isDemo)[Constants.A]+"</td><td class='head'>"+newStockPriceText+"</td><td class='head'>3</td></tr>";
		temp+= "<tr>";
		for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
//			temp+="<td class='stockNum'>"+Constants.getBorsaChange(periodNum,isDemo)[i]+"</td>";
			temp+="<td class='stockNum'>"+Cons.getBorsaChange(periodNum)[i]+"</td>";
		}
		temp+="<td class='head'>"+newStockPriceText+"</td><td class='head'>3</td></tr>";

		saveNewStocksHoldingsToSubject(periodNum);

		temp+="<tr><td>"+(subject.getStocksSum()+subject.getCash())+"</td><td>"+subject.getCash()+"</td><td>"+subject.getStocksSum()+"</td>";
		for(int i=Cons.NUM_OF_STOCKS-1;i>=0;i--){
			temp+="<td>"+subject.getStock(i)+"</td>";
		}
		//				+ "<td>"+subject.getStock(Constants.F)+"</td><td>"+subject.getStock(Constants.E)+"</td><td>"+subject.getStock(Constants.D)+"</td><td>"+subject.getStock(Constants.C)+"</td><td>"+subject.getStock(Constants.B)+"</td><td>"+subject.getStock(Constants.A)+"</td><td class='head'>"+holdingValueText+"</td><td class='head'>4</td></tr>"
		temp+= "<td class='head'>"+holdingValueText+"</td><td class='head'>4</td></tr></table></html>";
		return temp;
	}

	private int calcHoldings(int stock, int periodNum) {
//		return (int) ((double)subject.getStock(stock)/(double)Constants.getBorsaChange(periodNum-1,isDemo)[stock]*(double)Constants.getBorsaChange(periodNum,isDemo)[stock]);
		return (int) ((double)subject.getStock(stock)/(double)Cons.getBorsaChange(periodNum-1)[stock]*(double)Cons.getBorsaChange(periodNum)[stock]);
	}

	private void updateDelta() {
		int sum = calcDeltaSum();
		int absSum = Math.abs(sum);
		if(sum<0){
			deltaStock.setText("-"+absSum);
			deltaCash.setText("+"+absSum);
		}else if(sum>0){
			deltaStock.setText("+"+absSum);
			deltaCash.setText("-"+absSum);
		}else{
			deltaStock.setText(""+absSum);
			deltaCash.setText(""+absSum);
		}
		updateLastRowNums();
	}

	private void updateLastRowNums() {
		for(int i=0;i<afterChangeLabels.length;i++){
			if(isInputCorrect(i)){
				afterChangeLabels[i].setText(""+(getNumFromInput(i)+subject.getStock(i)));
			}else if(inputs[i].getText().equals("")||inputs[i].getText().equals("-")||inputs[i].getText().equals("+")){
				afterChangeLabels[i].setText(""+subject.getStock(i));
			}
		}

		cashAfterChange.setText(""+(Integer.parseInt(deltaCash.getText())+subject.getCash()));
		stockAfterChange.setText(""+(Integer.parseInt(deltaStock.getText())+subject.getStocksSum()));
		summaryAfterChange.setText(""+(Integer.parseInt(cashAfterChange.getText())+Integer.parseInt(stockAfterChange.getText())));
	}


	//	private int calcDeltaSum() {
	//		int sum=0;
	//		int numInInput = 0;
	//		for(int i=0;i<buyOrSellInputs.length;i++){
	//			try{
	//				if(isInputCorrect(i)){
	//					if(buyOrSellInputs[i].getText().equals("")){
	//						numInInput = 0;
	//					}else{
	//						numInInput = Integer.parseInt(buyOrSellInputs[i].getText());
	//					}
	//				}
	//			}
	//			catch(Exception e){
	//				errors(i);
	//			}
	//			if(subject.getCash()-getChangeSum()>=0 && numInInput+subject.getStock(i)>=0){
	//				fixErrors(i);
	//				sum+=numInInput;
	//			}else{
	//				errors(i);
	//			}
	//		}
	//		return sum;
	//	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(Cons.contains(inputs,e)){
			updateDelta();
		}
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

	private int calcDeltaSum() {
		int sum=0;
		boolean allIsCorrect = true;
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			if(inputs[i].getText().equals("+") || inputs[i].getText().equals("-")){
				inputs[i].setBackground(Color.white);
				continue;
			}else if(inputs[i].getText().equals("")){
				inputs[i].setBackground(Color.white);
				continue;
			}else{
				int temp;
				try{
					temp = Integer.parseInt(inputs[i].getText());
				}catch(Exception e){
					allIsCorrect = false;
					errors(i,Cons.INPUTֹ_ERROR);
					continue;
				}
				if(Integer.parseInt(inputs[i].getText())==0){
					inputs[i].setBackground(Color.white);
				}
				if(isSumLowerThanOwn(i)){
					allIsCorrect = false;
					errors(i,Cons.STOCKֹ_ERROR);
					continue;
				}
				if(isOverCash()){
					allIsCorrect = false;
					errors(i,Cons.CASHֹ_ERROR);
					continue;
				}
				inputs[i].setBackground(Color.white);
				sum+=temp;
				chkForButtonUnlock();
			}
		}
		if(allIsCorrect){
			statusLabel.setText("");
		}
		return sum;
	}

	private boolean isOverCash() {
		if(subject.getCash()-getChangeSum()<0){
			return true;
		}
		return false;
	}

	private boolean isSumLowerThanOwn(int i) {
		if((subject.getStock(i)+Integer.parseInt(inputs[i].getText()))<0){
			return true;
		}
		return false;
	}

	//	private void inputError(int i) {
	//		showErrorLabel(Constants.INPUTֹ_ERROR);
	//		paintTextInputInRed(i);
	//		lockContinue();
	//	}


	public boolean isInputCorrect(int i){
		if(inputs[i].getText().equals("") || inputs[i].getText().equals("+") || inputs[i].getText().equals("-"))
			return false;
		Integer.parseInt(inputs[i].getText());
		return true;
	}

	private void errors(int i, int errorNum) {
		showErrorLabel(errorNum);
		paintTextInputInRed(i);
		lockContinue();
	}

	//	private void fixErrors(int i) {
	//		inputs[i].setBackground(Color.white);
	//		statusLabel.setText("");
	//	}
	//
	//	private void unlockContinueButotn() {
	//		for(int i=0;i<inputs.length;i++){
	//			if((getNumFromInput(i)+subject.getStock(i))<0)
	//				return;
	//		}
	//		hideErrorLabel();
	//		continueButton.setEnabled(true);
	//	}

	private void lockContinue() {
		continueButton.setEnabled(false);
	}

	private void paintTextInputInRed(int i) {
		inputs[i].setBackground(Color.red.brighter().brighter().brighter().brighter().brighter());
	}

	private int getChangeSum() {
		int sum = 0;
		for (int i = 0; i < inputs.length; i++) {
			if(isInputCorrect(i)){
				sum+=Integer.parseInt(inputs[i].getText());
			}
		}
		return sum;
	}

	private void showErrorLabel(int error) {
		statusLabel.setText(Cons.ERROR_MASSAGES[error]);
	}

	//	private void hideErrorLabel(){
	//		statusLabel.setText("");
	//	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyPressed(KeyEvent e) {

	}

	public int getNumFromInput(int i){
		int num = 0;
		try{
			num = Integer.parseInt(inputs[i].getText());
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
}
