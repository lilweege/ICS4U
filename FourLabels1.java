import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FourLabels1 {
	public static void main(String[] args) {
		String title = "Labels: Exercise 1";
		Dimension dimension = new Dimension(300, 100);
		FlowLayout layout = new FlowLayout();
		
		Component[] components = {
			new CoolLabel(
				"Red label",
				new Dimension(100, 20),
				Color.RED,
				BorderFactory.createRaisedBevelBorder()
			),
			new CoolLabel(
				"Blue label",
				new Dimension(100, 20),
				Color.BLUE,
				BorderFactory.createEtchedBorder(Color.BLACK, Color.ORANGE)
			),
			new CoolLabel(
				"Orange label",
				new Dimension(100, 20),
				Color.ORANGE,
				BorderFactory.createLineBorder(Color.BLACK, 2)
			),
			new CoolLabel(
				"Magenta label",
				new Dimension(100, 20),
				Color.MAGENTA,
				BorderFactory.createLoweredBevelBorder()
			)
		};
		
		new CoolWindow(title, layout, dimension, components);
	}
}

class CoolLabel extends JLabel {
	CoolLabel(String s, Dimension d, Color c, Border b) {
		super(s);
		setOpaque(true);
		setBackground(c);
		setBorder(b);
		setPreferredSize(d);
	}
}

class CoolWindow extends JFrame {
	CoolWindow(String s, LayoutManager l, Dimension d, Component[] a) {
		super(s);
		for (Component c : a)
			add(c);
		setLayout(l);
		setSize(d);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}