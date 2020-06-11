import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FourButtonsAlternative extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new FourButtonsAlternative();
	}

	FourButtonsAlternative() {
		super("Four Buttons");
		JButton redBtn = new JButton("Red");
		JButton grnBtn = new JButton("Green");
		JButton bluBtn = new JButton("Blue");
		JButton gryBtn = new JButton("Gray");
		redBtn.addActionListener(this);
		grnBtn.addActionListener(this);
		bluBtn.addActionListener(this);
		gryBtn.addActionListener(this);
		add(redBtn);
		add(grnBtn);
		add(bluBtn);
		add(gryBtn);
		setLayout(new FlowLayout());
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Red": getContentPane().setBackground(Color.RED); break;
			case "Green": getContentPane().setBackground(Color.GREEN); break;
			case "Blue": getContentPane().setBackground(Color.BLUE); break;
			case "Gray": getContentPane().setBackground(Color.GRAY); break;
			default: break;
		}
	}
}