package borsa;

import javax.swing.JFrame;

import java.awt.Color;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -6233651369256553377L;

	public static MainWindow frame;
	
	private int periodNum = 0;
	
	private Subject subject;
	
	private EnterSubjectIDScreen startScreen;
	private PeriodPanel periodScreen;
	private StockScreen stockScreen;
	private FinalQues finalQuesScreen;
	private AcceptAgreementScreen agreementScreen;
	private HelpScreen helpScreen;
	private background_questions_screen backQuesScreen;
	private SummaryWindow summaryScreen;
	private String passwordForSettings;
	private Settings settingsScreen;
	private FirstPeriodScreen firstPeriod;
	private ContinueWindow continueScreen;

	private SQLConnect sqlConn;

	public static void main(String[] args){
		try {
			frame = new MainWindow();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainWindow.frame.connectToDBServer();
	}

	public void connectToDBServer() {
		try{
			sqlConn = new SQLConnect();
			startScreen.getDatabaseStatus().setText(Cons.DATABASE_CONNECTED);
			startScreen.getDatabaseStatus().setForeground(Color.GREEN);
			startScreen.getStartButton().setEnabled(true);
		}catch(Exception e){
			e.printStackTrace();
			startScreen.getDatabaseStatus().setText(Cons.DATABASE_ERROR);
			startScreen.getDatabaseStatus().setForeground(Color.RED);
		}
	}

	public MainWindow() throws InterruptedException {
		
		passwordForSettings = "password";
		setTitle(" קבלת החלטות כלכליות ");
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		getContentPane().setLayout(null);

		startStartScreen();

		setLocationRelativeTo(null);
		setVisible(true);


	}

	public void startStartScreen() {
		startScreen = new EnterSubjectIDScreen();
		startScreen.setBackground(Color.WHITE);
		startScreen.setBounds(0, 0, 935, 678);
		getContentPane().add(startScreen);
	}

	public void createSubject(int id){
		try{
			sqlConn.saveSubjectID(id);
		}catch(Exception e){

		}
		subject = new Subject(id);
		startAgreementScreen();
	}

	private void startAgreementScreen() {
		agreementScreen = new AcceptAgreementScreen();
		agreementScreen.setBounds(0, 0, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		getContentPane().add(agreementScreen);
	}

	private void newPeriod() {
		periodNum++;
		if(periodNum<15){
//			periodScreen = new PeriodPanel(periodNum, subject, isDemo);
			periodScreen = new PeriodPanel(periodNum, subject);
			periodScreen.setBounds(Cons.WINDOW_RECT);
			getContentPane().add(periodScreen);
		}
	}

	public void startStockReview() {
//		stockScreen = new StockRatingW(subject, periodNum);
		stockScreen = new StockScreen(subject, periodNum);
		stockScreen.setBounds(0,0,Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		getContentPane().add(stockScreen);
		repaint();
	}

	public void startLastQuesScreen(){
		finalQuesScreen = new FinalQues(subject);
		finalQuesScreen.setBounds(0,0,Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		getContentPane().add(finalQuesScreen);
		repaint();
	}

	public boolean isIDAlreadyExsits(int id) throws Exception {
		return sqlConn.isIDExists(id);
	}

	public void nextPeriod() {
		newPeriod();
		repaint();
	}

	public void resetPeriodNum(){
		periodNum=-1;
	}

	public void startBackgroundQuesScreen(){
		backQuesScreen = new background_questions_screen(subject);
		backQuesScreen.setBounds(0, 0, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		getContentPane().add(backQuesScreen);
	}


	public void startHelpAndConfirm() {
//		helpScreen = new HelpScreen(isDemo);
		helpScreen = new HelpScreen();
		helpScreen.setBounds(0, 0, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		getContentPane().add(helpScreen);
		try{
			saveBackground();
		}catch(Exception e){
			e.printStackTrace();
		}
		repaint();
	}

	public void startWaitAndConfirm() {
//		resetPeriodNum();
//		resetSubjectBuys();
//		changeDemoToFalse();
		startHelpAndConfirm();
	}

	public void startFirstPeriodScreen(){
		periodNum++;
		firstPeriod = new FirstPeriodScreen(subject);
		firstPeriod.setBounds(Cons.WINDOW_RECT);
		getContentPane().add(firstPeriod);
	}

	public void saveDataToDatabase() throws Exception {
		sqlConn.savePerionds(subject);
		sqlConn.savePreffereds(subject);
		sqlConn.saveLastQuestions(subject);
	}

	public void startSummaryScreen() {
		summaryScreen = new SummaryWindow(subject);
		summaryScreen.setBounds(Cons.WINDOW_RECT);
		getContentPane().add(summaryScreen);
	}

	public void saveBackground() throws Exception {
		sqlConn.saveBackground(subject);
	}

	public void saveNewSettings(String ip, String port, String user, String pass) {
		String[] temp = {ip,port,user,pass};
		new Files().saveData(temp);
		SQLConnect.setIP(ip);
		SQLConnect.setPORT(port);
		SQLConnect.setUSER(user);
		SQLConnect.setPASS(pass);
	}
	
	public String getPasswordForSettings() {
		return passwordForSettings;
	}

	public void startSettingsScreen() {
		settingsScreen = new Settings();
		settingsScreen.setBounds(Cons.WINDOW_RECT);
		getContentPane().add(settingsScreen);
	}

	public String getIP() {
		return SQLConnect.getIP();
	}
	
	public String getPORT() {
		return SQLConnect.getPORT();
	}
	
	public String getUSER() {
		return SQLConnect.getUSER();
	}
	
	public String getPASS() {
		return SQLConnect.getPASS();
	}

	public void saveMail() throws Exception {
		sqlConn.saveEmail(subject);
	}

	public void startContinueScreen() {
		continueScreen = new ContinueWindow();
		continueScreen.setBounds(Cons.WINDOW_RECT);
		getContentPane().add(continueScreen);
	}
}
