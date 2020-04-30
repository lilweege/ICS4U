import javax.swing.*;
import java.awt.*;

public class ClicketyClick extends JFrame {
	int cnt = 0;
	
	public static void main(String[] args) {
		new ClicketyClick();
	}
	
	ClicketyClick() {
		super("Clickety Click");
		JButton click = new JButton("You have clicked 0 times.");
		click.addActionListener(l -> {			
			click.setText("You have clicked " + ++cnt + " times.");
			if (cnt >= 10) {
				JOptionPane.showMessageDialog(null, "Press OK to exit.", "You are out of clicks.", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		add(click);
		setLayout(new FlowLayout());
		setSize(200, 75);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
