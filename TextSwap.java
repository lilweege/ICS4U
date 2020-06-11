import javax.swing.*;
import java.awt.*;

public class TextSwap extends JFrame {

	public static void main(String[] args) {
		new TextSwap();
	}

	TextSwap() {
		super("Echo Both Fields");
		JLabel prompt1 = new JLabel("Enter Your Text:");
		JLabel prompt2 = new JLabel("Enter Your Text:");
		JTextField input1 = new JTextField(10);
		JTextField input2 = new JTextField(10);
		JButton swap = new JButton("Swap");
		swap.addActionListener(l -> {
			String t = input1.getText();
			input1.setText(input2.getText());
			input2.setText(t);
		});
		add(prompt1); add(input1);
		add(prompt2); add(input2);
		add(swap);
		setLayout(new FlowLayout());
		setSize(235, 125);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}