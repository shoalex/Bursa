package borsa;

public class JButton extends javax.swing.JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5094319385095578849L;

	public JButton(String text){
		setFocusable(false);
		setSize(160, 45);
		setText(text);
		init();
	}
	
	public JButton(){
		init();
	}

	private void init() {
		setFont(Cons.REGUALAR);
	}
}
