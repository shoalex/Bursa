package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JComboBox;

public class StockScreen extends JPanel implements ActionListener{

	private static final long serialVersionUID = 3565258843308964294L;
	
	private JLabel title, explainText, mapText, choiseHead;
	private JLabel[] texts;
	private JComboBox <String>[] stocks;
	private JButton continueBTN, graph;
	private Subject subject;
	private GraphWindow graphWindow;
	

	public StockScreen(Subject sub, final int periodNum){
		
		subject = sub;
		setLayout(null);
		setBackground(Color.WHITE);
		
		initalizeLabels();
		
		initalizeChoises();
		
		continueBTN = new JButton(Cons.CONTINUE);
		continueBTN.setBounds(40, 548, 89, 23);
		continueBTN.setEnabled(false);
		continueBTN.setBounds(Cons.BUTTON_RECT);
		continueBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				graphWindow.setVisible(false);
				subject.setStockRating(periodNum, getSelectedStocks());
				if(periodNum==(Cons.NUM_OF_PERIODS-1)){
					MainWindow.frame.startLastQuesScreen();
				}else{
					MainWindow.frame.nextPeriod();
				}
			}
		});
		add(continueBTN);
		
		graphWindow = new GraphWindow(periodNum);
		
		graph = new JButton(" вшу ");
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
		
	}


	protected StockRating getSelectedStocks() {
		StockRating temp = new StockRating();
		for(int i=0;i<Cons.NUM_OF_STOCKS;i++){
			temp.setStockRating(i, stocks[i].getSelectedItem().toString());
		}
		return temp;
	}


	@SuppressWarnings("unchecked")
	public void initalizeChoises() {
		choiseHead = new JLabel(Cons.CHOISE_HEAD);
		choiseHead.setLocation(344, 318);
		choiseHead.setSize(178, 32);
		choiseHead.setFont(Cons.BOLD);
		add(choiseHead);
		
		
		texts = new JLabel[Cons.NUM_OF_STOCKS];
		for(int i=0;i<texts.length;i++){
			texts[i] = new JLabel(Cons.STOCKS_LEVELS[i]);
			texts[i].setFont(Cons.BOLD);
			if(0==i) texts[i].setBounds(531, 359, 50, 40);
			else texts[i].setBounds(texts[i-1].getX(), texts[i-1].getY()+texts[i-1].getHeight()+2, texts[i-1].getWidth(),texts[i-1].getHeight() );
			texts[i].setFocusable(false);
			add(texts[i]);
		}
		
		
		stocks = new JComboBox[Cons.NUM_OF_STOCKS];
		for(int i=0;i<stocks.length;i++){
			stocks[i] = new JComboBox<String>(Cons.STOCKS);
			if(i==0) stocks[i].setBounds(344, 361, 178, 40);
			else stocks[i].setBounds(stocks[i-1].getX(),stocks[i-1].getY()+stocks[i-1].getHeight()+2,stocks[i-1].getWidth(),stocks[i-1].getHeight());
			stocks[i].setFocusable(false);
			stocks[i].setFont(Cons.BOLD);
			stocks[i].addActionListener(this);
			add(stocks[i]);
		}
	}


	public void initalizeLabels() {
		title = new JLabel(Cons.CONTINUE);
		title.setFont(Cons.TITLE);
		title.setBounds(Cons.TITLE_RECT);
		add(title);
		
		explainText = new JLabel(Cons.alignTextRight(Cons.STOCK_SCREEN_EXPLAIN_TEXT));
		int width = Cons.WINDOW_WIDTH-(2*Cons.GAP);
		explainText.setBounds(Cons.WINDOW_WIDTH-Cons.GAP-width, Cons.TITLE_Y+Cons.TITLE_HEIGHT, width, Cons.TITLE_HEIGHT);
		add(explainText);
		
		mapText = new JLabel(Cons.alignTextRight(Cons.MAP_TEXT_STOCK_SCREEN));
		mapText.setBounds(488, 121, 423, 198);
		add(mapText);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<stocks.length;i++){
			for(int j=i+1;j<stocks.length;j++){
				if(stocks[i].getSelectedItem().toString().equals(stocks[j].getSelectedItem().toString()) || stocks[i].getSelectedItem().equals(Cons.STOCKS[0]) || stocks[j].getSelectedItem().equals(Cons.STOCKS[0])){
					continueBTN.setEnabled(false);
					return;
				}
			}
		}
		continueBTN.setEnabled(true);
	}
}
