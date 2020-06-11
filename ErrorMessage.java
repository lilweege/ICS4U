import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ErrorMessage extends JFrame {
	
	public static void main(String[] args) {
		new ErrorMessage();
	}

	JLabel prompt1 = new JLabel("Enter Your Text:");
	JLabel prompt2 = new JLabel("Enter Your Text:");
	JTextField input1 = new JTextField(10);
	JTextField input2 = new JTextField(10);
	
	ErrorMessage() {
		super("Error Message");
		input1.addActionListener(l -> echoOrWarn(l));
		input2.addActionListener(l -> echoOrWarn(l));
		add(prompt1); add(input1);
		add(prompt2); add(input2);
		setLayout(new FlowLayout());
		setSize(235, 95);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void echoOrWarn(ActionEvent e) {
		if (e.getSource() == input2)
			JOptionPane.showMessageDialog(null, "Enter text in the top field.", "Press OK to continue.", JOptionPane.ERROR_MESSAGE);
		input2.setText(input1.getText());
	}
}