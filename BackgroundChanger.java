import javax.swing.*;
import java.awt.*;

public class BackgroundChanger extends JFrame {
	
//	boolean b = true;
	int cnt = 0;
	Color colors[] = { Color.BLUE, Color.RED, Color.GREEN };
	
	public static void main(String[] args) {
		new BackgroundChanger();
	}
	
	BackgroundChanger() {
		super("Background Changer");
		JButton change = new JButton("Change");

		// method 1, check background color
//		change.addActionListener(l -> getContentPane().setBackground((getContentPane().getBackground() == Color.RED) ? Color.BLUE : Color.RED));

		// method 2 use boolean to store state
//		change.addActionListener(l -> getContentPane().setBackground((b = !b) ? Color.BLUE : Color.RED));
		
		// method 3 cyclic using array and modulo
		change.addActionListener(l -> getContentPane().setBackground(colors[++cnt % colors.length]));
		
		add(change);
		getContentPane().setBackground(colors[0]);
		setLayout(new FlowLayout());
		setSize(200, 75);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}