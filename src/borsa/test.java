package borsa;

import javax.swing.JFrame;

public class test{

	public static JFrame test = new JFrame();
	
	public static void main(String[] args) throws Exception {
		
		Subject sub = new Subject(4);
		test.setBounds(100, 100, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);
		test.setResizable(false);
		
//		test.getContentPane().add(new PeriodPanel(2,sub));
//		test.getContentPane().add(new StockRatingW(sub, 1));
//		test.getContentPane().add(new SummaryWindow(sub));
//		test.getContentPane().add(new Settings());
//		test.getContentPane().add(new StockScreen(sub,1));
//		test.getContentPane().add(new FirstPeriodScreen(sub));
//		test.getContentPane().add(new HelpScreen());
//		test.getContentPane().add(new background_questions_screen(sub));
//		test.getContentPane().add(new EnterSubjectIDScreen());
//		test.getContentPane().add(new FinalQues(sub));
//		test.getContentPane().add(new ContinueWindow());
//		new GraphWindow(2);
//		new SQLConnect();
		
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
		
		
		new SaveExcel().saveData();
		
//		for(int i = 10051;i<10066;i++){
//			System.out.println("insert into subjects (subject_id) values ("+i+"); ");
//		}
	}

}
