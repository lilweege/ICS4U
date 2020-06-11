import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoWayConversion extends JFrame {

	public static void main(String[] args) {
		new TwoWayConversion();
	}

	TwoWayConversion() {
		this(2);
	}

	TwoWayConversion(int precision) {
		super("Two Way Conversion");
		
		JLabel prompt = new JLabel();
		JTextField input1 = new JTextField(10);
		JTextField input2 = new JTextField(10);
		
		input1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				prompt.setText("Enter temperature in Fahrenheit");
			}
			public void focusLost(FocusEvent e) {}
		});
		
		input2.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				prompt.setText("Enter temperature in Celcius      ");
			}
			public void focusLost(FocusEvent e) {}
		});
		
		input1.addActionListener(l -> {
			try {
				input2.setText(String.format("%." + precision + "f", (Double.parseDouble(input1.getText()) - 32) * 5 / 9.));
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(), "An error has occurred", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		input2.addActionListener(l -> {
			try {
				input1.setText(String.format("%." + precision + "f", Double.parseDouble(input2.getText()) * 9 / 5. + 32));
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(), "An error has occurred", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(prompt);
		add(input1); add(input2);
		setLayout(new FlowLayout());
		setSize(235, 100);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(
					JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ?
							JFrame.EXIT_ON_CLOSE : JFrame.DO_NOTHING_ON_CLOSE
				);
			}
		});
	}
}