import javax.swing.*;
import java.awt.*;

public class ThreeButtonMonty extends JFrame {
	
	public static void main(String[] args) {
		new ThreeButtonMonty(3);
	}

	ThreeButtonMonty(int numButtons) {
		super("Three Button Monty");
		for (int i = 0; i < numButtons; i++) {
			JButton button = new JButton("" + i);
			button.addActionListener(l -> {
				boolean win = (int)(Math.random() * numButtons) == 0;
				getContentPane().setBackground(win ? Color.GREEN : Color.RED);
				JOptionPane.showMessageDialog(null, win ? "You won!" : "You lost.", "Press OK to try again.", JOptionPane.INFORMATION_MESSAGE);
			});
			add(button);
		}
		setLayout(new FlowLayout());
		setSize(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}