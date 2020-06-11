import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {
	public static void main(String[] args) {
		new Test();
	}
	
	Test() {
		super("BoxLayout Example Alignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		JButton jb1 = new JButton("Button 1");
		JButton jb2 = new JButton("Button 2");		
		JButton jb3 = new JButton("Button 3");
		panel.add(jb1);
		panel.add(Box.createRigidArea(new Dimension(0, 80)));		
		panel.add(jb2);
		panel.add(Box.createRigidArea(new Dimension(0, 80)));
		panel.add(jb3);
		add(panel);
		pack();
		setVisible(true);
	}
}