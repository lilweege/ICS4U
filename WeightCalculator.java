import java.util.*;
import javax.swing.*;
import java.awt.*;

public class WeightCalculator extends JFrame {
	
	int inchesTall = 62;
	boolean isMale = true;
	
	public static void main(String[] args) {
		new WeightCalculator();
	}

	WeightCalculator() {
		super("Ideal Weight");
		
		JPanel resultPanel = new JPanel(),
			   genderPanel = new JPanel(),
			   heightPanel = new JPanel();
		
		ButtonGroup genderGroup = new ButtonGroup(),
					heightGroup = new ButtonGroup();
		
		
		// result
		resultPanel.add(new JLabel("Ideal Weight"));
		JTextField resultText = new JTextField(5);
		resultText.setEditable(false);
		resultPanel.add(resultText);


		// gender
		genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.Y_AXIS));
		genderPanel.add(new JLabel("Your Gender"));
		for (int g = 0; g <= 1; ++g) {
			boolean m = g == 0; 
			JRadioButton button = new JRadioButton(m ? "Male" : "Female", m);
			button.setActionCommand(Boolean.toString(m));
			
			button.addActionListener(l -> {
				isMale = Boolean.parseBoolean(button.getActionCommand());
				updateWeightText(resultText);
			});
			genderGroup.add(button);
			genderPanel.add(button);
		}
		
		
		// height
		heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.Y_AXIS));
		heightPanel.add(new JLabel("Your Height"));
		for (int h = 62; h <= 78; h += 4) {
			JRadioButton button = new JRadioButton((h - 2) + " to " + (h + 2) + " inches", h == 62);
			button.setActionCommand(Integer.toString(h));
			
			button.addActionListener(l -> {
				inchesTall = Integer.parseInt(button.getActionCommand());
				updateWeightText(resultText);
			});
			heightGroup.add(button);
			heightPanel.add(button);
		}
		
		
		// content pane
		setLayout(new BorderLayout());
		add(genderPanel, BorderLayout.WEST);
		add(heightPanel, BorderLayout.EAST);
		add(resultPanel, BorderLayout.SOUTH);

		// frame
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		updateWeightText(resultText);
	}
	
	void updateWeightText(JTextField out) {
		out.setText(String.format("%.1f", getIdealWeight()));
	}

	double getIdealWeight() {
		return Math.round(Math.pow(inchesTall, 2) / (isMale ? 28. : 30.));
	}
	
	
	void addGroupToPanel(ButtonGroup group, JPanel panel) {
		Enumeration<AbstractButton> buttons;
		AbstractButton button;

		buttons = group.getElements();
		while (buttons.hasMoreElements()) {
			button = buttons.nextElement();
			panel.add(button);
		}
	}
}
