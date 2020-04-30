import javax.swing.*;
import java.awt.*;

public class JavaGUI {
	
	static int count = 0;
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		window.setTitle("my cool window");
		window.setVisible(true);
		window.setSize(600, 400);

		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		window.setLayout(layout);
		
		JLabel coolLabel = new JLabel();
		coolLabel.setText("button has not been clicked");
		
		JButton coolButton = new JButton();
		coolButton.setText("click me");
		coolButton.addActionListener(l -> doSomething(coolLabel));
		
		window.add(coolButton);
		window.add(coolLabel);
	}
	
	public static void doSomething(JLabel coolLabel) {
		coolLabel.setText("button has been clicked " + (++count) + " times!");
	}
}
