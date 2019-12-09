package borsa;

import javax.swing.SwingConstants;

public class JLabel extends javax.swing.JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3211325516041713422L;

	public JLabel(String text){
		super();
		setText(text);
		init();
	}

	public JLabel(){
		init();
	}
	
	private void init() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(Cons.REGUALAR);
	}
	
}
