import java.util.*;
import javax.swing.*;
import java.awt.*;

public class FourButtons extends JFrame {

	public static void main(String[] args) {
		// lhm is used for ordered key-value pairs (title, color)
		new FourButtons(new LinkedHashMap<String, Color>() {
			{
				put("Red", Color.RED);
				put("Green", Color.GREEN);
				put("Blue", Color.BLUE);
				put("Gray", Color.GRAY);
			}
		});
	}

	FourButtons(LinkedHashMap<String, Color> colors) {
		super("Four Buttons");
		colors.forEach((str, col) -> {
			JButton button = new JButton(str);
			button.addActionListener(l -> getContentPane().setBackground(col));
			add(button);
		});
		setLayout(new FlowLayout());
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}