import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombinationLock extends JFrame implements ActionListener {

	String currentCode = "";
	String targetCode = "1234";
	
	public static void main(String[] args) {
		new CombinationLock();
	}
	
	CombinationLock() {
		// for loop with ternary conditions to create number-pad
		for (int i = 7; i >= 0; i += i % 3 == 0 ? i == 3 ? -3 : -5 : 1) {
			JButton button = new JButton(String.valueOf(i));
			button.addActionListener(this);
			add(button);
		}
		setLayout(new FlowLayout());
		setSize(150, 165);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (getContentPane().getBackground().equals(Color.RED)) {
			getContentPane().setBackground(null);
			currentCode = "";
		}
		currentCode += e.getActionCommand(); // if action command is not set, the text member is used
		if (currentCode.equals(targetCode)) {
			System.exit(0);
		}
		if (targetCode.charAt(currentCode.length() - 1) != currentCode.charAt(currentCode.length() - 1)) {
			getContentPane().setBackground(Color.RED);
		}
	}
}
