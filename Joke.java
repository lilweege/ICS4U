import javax.swing.*;
import java.awt.*;

public class Joke extends JFrame {
	
	public static void main(String[] args) {
		new Joke("Why did the programmer lose his job?", "Because he didn't get arrays!");
	}
	
	Joke(String prompt, String answer) {
		super("Joke");
		JLabel joke = new JLabel(prompt);
		add(joke);
		JButton button = new JButton("Answer");
		button.setActionCommand("Answer");
		button.addActionListener(l -> {
			if (button.getActionCommand().equals("Answer")) {
				button.setActionCommand("Quit");
				button.setText("Quit");
				add(new JLabel(answer));
			}
			else if (button.getActionCommand().equals("Quit")) {
				System.exit(JOptionPane.showConfirmDialog(null, "Did you laugh?", "Choose an option.", JOptionPane.YES_NO_OPTION));
			}
		});
		add(button);
		setLayout(new FlowLayout());
		setSize(230, 120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}