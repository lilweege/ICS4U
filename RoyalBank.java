import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoyalBank extends JFrame {
	
	/* A secure way to store passwords would have to include some kind of authentication/encryption
	 * Below is a link to an example of how this could be implemented in java.
	 * https://www.quickprogrammingtips.com/java/how-to-securely-store-passwords-in-java.html
	 * */

	private static HashMap<String /*username*/,
						   String /*password*/> database = new HashMap<>();
	
	public static void main(String[] args) {
		database.put("username", "password");
		database.put("luigi", "pass");
		database.put("451912345678987", "1234567");
		new RoyalBank();
	}
	
	public RoyalBank() {
		super("RBC Royal Bank");
		
		JPanel inputPanel = new JPanel(),
			   buttonPanel = new JPanel(),
			   interfacePanel = new JPanel(),
			   mainPanel = new JPanel(),
			   wrapperPanel = new JPanel();
		
		Dimension vertSpacer = new Dimension(0, 2),
				  horzSpacer = new Dimension(8, 0),
				  interfaceSize = new Dimension(160, 120),
				  wrapperSize = new Dimension(300, 150),
				  windowSize = new Dimension(325, 200);
		
		JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png"))),
			   promptUsername = new JLabel("Username (Card Number):"),
			   promptPassword = new JLabel("Password:");
		
		logo.setToolTipText("Resize the window!");
		
		JTextField inputUsername = new JTextField(1);
		JPasswordField inputPassword = new JPasswordField(1);

		inputUsername.addActionListener(l -> signIn(inputUsername.getText(), new String(inputPassword.getPassword())));
		inputPassword.addActionListener(l -> signIn(inputUsername.getText(), new String(inputPassword.getPassword())));
		
		JButton signButton = new JButton("SIGN IN"),
				exitButton = new JButton("EXIT");
		
		signButton.addActionListener(l -> signIn(inputUsername.getText(), new String(inputPassword.getPassword())));
		exitButton.addActionListener(l -> windowAdapter.windowClosing(null));
		
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(promptUsername);
		inputPanel.add(Box.createRigidArea(vertSpacer));
		inputPanel.add(inputUsername);
		inputPanel.add(Box.createRigidArea(vertSpacer));
		inputPanel.add(promptPassword);
		inputPanel.add(Box.createRigidArea(vertSpacer));
		inputPanel.add(inputPassword);
		inputPanel.add(Box.createRigidArea(vertSpacer));
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(signButton);
		buttonPanel.add(Box.createRigidArea(horzSpacer));
		buttonPanel.add(exitButton);
		
		interfacePanel.setPreferredSize(interfaceSize);
		interfacePanel.add(inputPanel);
		interfacePanel.add(buttonPanel);
		
		mainPanel.add(logo);
		mainPanel.add(interfacePanel);
		
		wrapperPanel.setMaximumSize(wrapperSize);
		wrapperPanel.add(mainPanel);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(Box.createVerticalGlue());
		add(wrapperPanel);
		add(Box.createVerticalGlue());
		
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				logo.setVisible(getWidth() >= wrapperSize.width - 15);
			}
		});
		addWindowListener(windowAdapter);
		setSize(windowSize);
		setVisible(true);
	}
	
	private void signIn(String user, String pass) {
		if (trySign(user, pass))
			JOptionPane.showMessageDialog(null, "You have successfully logged in!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "The username/password you entered is incorrect!", getTitle(), JOptionPane.ERROR_MESSAGE); 
	}
	
	private static boolean trySign(String user, String pass) {
		return database.containsKey(user) && database.get(user).equals(pass);
	}
	
	private WindowAdapter windowAdapter = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(null, "Thank you for choosing Royal Bank!", getTitle(), JOptionPane.INFORMATION_MESSAGE);
//			System.exit(0);
			dispose();
		}
	};
}



/* Alternative database implementation using prefix tree.
 * Prefix trees are useful for large databases, usually
 * implementing some kind of autocompletion functionality.
 * An example of trie usage would be google search.
 * This structure wouldn't be useful in this case because no bank would use autofill for a username.
 */
/*
class Trie {
	private String password = null;
	private HashMap<Character, Trie> child = new HashMap<>();

	Trie() {}

	void setUser(String user, String pass) {
		Trie node = this;
		for (int i = 0, n = user.length(); i < n; ++i) {
			node.child.putIfAbsent(user.charAt(i), new Trie());
			node = node.child.get(user.charAt(i));
		}
		node.password = pass;
	}

	Trie getUser(String user) {
		Trie node = this;
		for (int i = 0, n = user.length(); i < n; ++i) {
			if (!node.child.containsKey(user.charAt(i)))
				return null;
			node = node.child.get(user.charAt(i));
		}
		return node;
	}

	boolean userExist(String user) {
		return getUser(user) != null;
	}
	
	String getPass(String user) {
		return getUser(user).password;
	}
}
*/