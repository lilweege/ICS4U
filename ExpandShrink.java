import javax.swing.*;
import java.awt.*;

public class ExpandShrink extends JFrame {
	
	public static void main(String[] args) {
		new ExpandShrink(10);
	}
	
	ExpandShrink(int percent) {
		super("Expand Shrink");
		JButton expand = new JButton("Expand");
		JButton shrink = new JButton("Shrink");
		expand.addActionListener(l -> resize(1 + percent * 0.01));
		shrink.addActionListener(l -> resize(1 - percent * 0.01));
		add(expand);
		add(shrink);
		setLayout(new FlowLayout());
		setSize(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void resize(double scl) {
		setSize((int)(getWidth() * scl), (int)(getHeight() * scl));
	}
}