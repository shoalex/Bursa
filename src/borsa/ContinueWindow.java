package borsa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ContinueWindow extends JPanel {

	private static final long serialVersionUID = 1129629762848439806L;
	
	public ContinueWindow(){
		
		JLabel title, text;
		JButton butt;
		
		setLayout(null);
		setBackground(Color.white);
		
		title = new JLabel(" המסחר הסתיים ");
		title.setFont(Cons.TITLE);
		title.setBounds(Cons.TITLE_RECT);
		add(title);
		
		text = new JLabel(" (הנך רשאי לעבור לדף הבא ע\"י לחיצה על כפתור המשך) ");
		text.setFont(Cons.TITLE);
		text.setBounds(10,title.getY()+title.getHeight()+20,Cons.WINDOW_WIDTH-20,400);
		add(text);
		
		butt =  new JButton(Cons.CONTINUE);
		butt.setBounds(Cons.BUTTON_RECT);
		butt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainWindow.frame.startStockReview();
			}
		});
		add(butt);
	}
	
}
