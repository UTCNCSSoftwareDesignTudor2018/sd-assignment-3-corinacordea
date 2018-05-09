package assignment3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainView {
	private JFrame frame;
	private JPanel panel;
	private JRadioButton readerButton;
	private JRadioButton writerButton;
	private ButtonGroup group;
	private JButton continueButton;
	private JLabel username;
	private JLabel password;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JButton createAccountButton;
	
	public MainView() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
	    panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(100, 100, 600, 400);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		username = new JLabel("Username");
		username.setBounds(70, 30, 100, 15);
		password = new JLabel("Password");
		password.setBounds(70, 60, 100, 15);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(170, 30, 100, 15);
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(170, 60, 100, 15);
		
		readerButton = new JRadioButton("Reader");
		readerButton.setBounds(70, 0, 100, 15);
		
		writerButton = new JRadioButton("Writer");
		writerButton.setBounds(170, 0, 100, 15);
		
		continueButton = new JButton("Continue");
		continueButton.setBounds(85, 90, 170, 25);
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(85, 130, 170, 25);
		
		group = new ButtonGroup();
		group.add(readerButton);
		group.add(writerButton);
		panel.add(username);
		panel.add(password);
		panel.add(usernameTextField);
		panel.add(passwordField);
		panel.add(readerButton);
		panel.add(writerButton);
		panel.add(continueButton);
		panel.add(createAccountButton);
		frame.repaint();
	}

	public void setContinueButtonActionListener(ActionListener actionListener) {
		continueButton.addActionListener(actionListener);
	}
	public void setCreateAccountButtonActionListener(ActionListener actionListener) {
		createAccountButton.addActionListener(actionListener);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JRadioButton getReaderButton() {
		return readerButton;
	}
	public void setReaderButton(JRadioButton readerButton) {
		this.readerButton = readerButton;
	}
	public JRadioButton getWriterButton() {
		return writerButton;
	}
	public void setWriterButton(JRadioButton writerButton) {
		this.writerButton = writerButton;
	}
	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}
	public JButton getContinueButton() {
		return continueButton;
	}
	public void setContinueButton(JButton continueButton) {
		this.continueButton = continueButton;
	}
	public JLabel getUsername() {
		return username;
	}
	public void setUsername(JLabel username) {
		this.username = username;
	}
	public JLabel getPassword() {
		return password;
	}
	public void setPassword(JLabel password) {
		this.password = password;
	}
	public JTextField getUsernameTextField() {
		return usernameTextField;
	}
	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public JButton getCreateAccountButton() {
		return createAccountButton;
	}
	public void setCreateAccountButton(JButton createAccountButton) {
		this.createAccountButton = createAccountButton;
	}
}


