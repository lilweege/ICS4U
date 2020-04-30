import javax.swing.*;
import java.awt.*;

public class SuperJava {
	public static void main(String[] args) {
		JFrame window = new JFrame("Labels: Exercise 3");
		
		// If compiling from cli, image.jpg should be in same dir as SuperJava.java
		// If compiling from eclipse, image.jpg should be in base dir of project

		JLabel info = new JLabel(
				"MUCH CODE, VERY WOW!",
				new ImageIcon(new ImageIcon("image.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_REPLICATE)),
				JLabel.CENTER);
		info.setForeground(Color.RED);
		info.setFont(new Font("Serif", Font.BOLD, 24));
		info.setVerticalTextPosition(JLabel.BOTTOM);
		info.setHorizontalTextPosition(JLabel.CENTER);
		
		window.add(info);
		window.setSize(new Dimension(400, 400));
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}