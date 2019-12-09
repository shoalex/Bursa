package borsa;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GraphWindow extends JFrame{

	private static final long serialVersionUID = -5010705834767608223L;

	public GraphWindow(int period){
		
		JLabel img = new JLabel();
		setTitle(" גרף לתקופה מס' "+period);
		ImageIcon imgIcon = new ImageIcon(GraphWindow.class.getResource("/img/g"+period+".jpg"));
		img.setIcon(imgIcon);
		getContentPane().add(img);
		setResizable(false);
		setBounds(50,50,imgIcon.getIconWidth()+15,imgIcon.getIconHeight()+35);
		setVisible(true);
	}
}
