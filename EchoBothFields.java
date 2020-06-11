import javax.swing.*;
import java.awt.*;

public class EchoBothFields extends JFrame {
	
	public static void main(String[] args) {
		new EchoBothFields();
	}

	EchoBothFields() {
		super("Echo Both Fields");
		JLabel prompt1 = new JLabel("Enter Your Text:");
		JLabel prompt2 = new JLabel("Enter Your Text:");
		JTextField input1 = new JTextField(10);
		JTextField input2 = new JTextField(10);
		input1.addActionListener(l -> echo(input1, input2));
		input2.addActionListener(l -> echo(input2, input1));
		add(prompt1); add(input1);
		add(prompt2); add(input2);
		setLayout(new FlowLayout());
		setSize(235, 95);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void echo(JTextField fr, JTextField to) {
		to.setText(fr.getText());
	}
}