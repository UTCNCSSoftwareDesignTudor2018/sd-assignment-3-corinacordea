package assignment3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;

public class WriterView {
	private JFrame writerFrame;
	private JPanel writerPanel;
	private JFrame viewArticleFrame;
	private JPanel viewArticlePanel;
	private JTextArea articleTextArea;
	
	private JButton viewButton;
	private JButton writeButton;
	private JButton updateButton;
	private JButton deleteButton;
	
	private JFrame viewFrame;
	private JPanel viewPanel;
	
	private JFrame accountFrame;
	private JPanel accountPanel;
	private JLabel writerName;
	private JTextField writerNameTextField;
	private JButton saveDataButton;
	private JLabel username;
	private JTextField usernameTextField;
	private JLabel password;
	private JPasswordField passwordTextField;
	
	private JList<String> articleList;
	private DefaultListModel<String> listModel;
	
	private JFrame updateFrame;
	private JPanel updatePanel;
	private JButton updateDataButton;
	
	private JTextArea articleTitleTextArea;
	private JTextArea articleAbstractTextArea;
	private JTextArea articleBodyTextArea;
	private JFrame writeFrame;
	private JPanel writePanel;
	private JButton saveArticleButton;
	private JLabel articleTitle;
	private JLabel articleAbstract;
	private JLabel articleBody;
	
	private JList<String> relatedArticleList;
	private JLabel relatedArticles;
	
	public WriterView() {
		initialize();
	}
	private void initialize() {
		writerFrame = new JFrame("Writer");
		writerFrame.setBounds(0, 0, 600, 400);
		writerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		writerFrame.setLocationRelativeTo(null);
		writerFrame.getContentPane().setLayout(null);
		
		writerPanel = new JPanel();
		writerPanel.setLayout(null);
		writerPanel.setBounds(0, 0, 600, 400);
		writerPanel.setVisible(true);
		
		updateButton = new JButton("Update Account");
		updateButton.setBounds(200, 100, 150, 20);
		writerPanel.add(updateButton);
		
		deleteButton = new JButton("Delete Account");
		deleteButton.setBounds(200, 130, 150, 20);
		writerPanel.add(deleteButton);
		
		viewButton = new JButton("View Articles");
		viewButton.setBounds(200, 160, 150, 20);
		writerPanel.add(viewButton);
		
		writeButton = new JButton("Write Article");
		writeButton.setBounds(200, 190, 150, 20);
		writerPanel.add(writeButton);
		
		writerFrame.add(writerPanel);
		
		saveDataButton = new JButton("Save Data");
		listModel = new DefaultListModel<>();
		articleList = new JList<>(listModel);
		articleTextArea = new JTextArea();
		updateDataButton = new JButton("Update Data");
		articleTitleTextArea = new JTextArea();
		articleAbstractTextArea = new JTextArea();
		articleBodyTextArea = new JTextArea();
		saveArticleButton = new JButton("Save Article");
		relatedArticleList = new JList<>(listModel);
	}
	public void viewArticle() {
		viewFrame = new JFrame("View Article");
		viewFrame.setBounds(0, 0, 600, 400);
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewFrame.setLocationRelativeTo(null);
		viewFrame.getContentPane().setLayout(null);
		
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBounds(0, 0, 600, 400);
		viewPanel.setVisible(true);
		
		articleList.setBounds(40, 40, 500, 300);
		articleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		articleList.setLayoutOrientation(JList.VERTICAL);
		articleList.setVisibleRowCount(-1);
		articleList.setVisible(true);
		viewPanel.add(articleList);
		
		JScrollPane listScroller = new JScrollPane(articleList);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScroller.setBounds(40, 40, 500, 300);
		viewFrame.add(listScroller);
	}
	public void viewArticleContent() {
		viewArticleFrame = new JFrame("View Article Content");
		viewArticleFrame.setBounds(0, 0, 600, 400);
		viewArticleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewArticleFrame.setLocationRelativeTo(null);
		viewArticleFrame.getContentPane().setLayout(null);
		
		viewArticlePanel = new JPanel();
		viewArticlePanel.setLayout(null);
		viewArticlePanel.setBounds(0, 0, 600, 400);
		viewArticlePanel.setVisible(true);
				
		articleTextArea.setBounds(50, 50, 500, 300);
		articleTextArea.setVisible(true);	
		
		viewArticlePanel.add(articleTextArea);
		JScrollPane scrollPane = new JScrollPane(articleTextArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 50, 500, 300);
		viewArticleFrame.add(scrollPane);
		viewArticleFrame.add(viewArticlePanel);	
		
	}
	public void updateAccount() {
		updateFrame = new JFrame("Update");
		updateFrame.setBounds(0, 0, 600, 400);
		updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateFrame.setLocationRelativeTo(null);
		updateFrame.getContentPane().setLayout(null);
		updateFrame.setVisible(true);
		
		updatePanel = new JPanel();
		updatePanel.setLayout(null);
		updatePanel.setBounds(0, 0, 600, 400);
		updatePanel.setVisible(true);
		
		writerName = new JLabel("Name");
		writerName.setBounds(170, 100, 90, 20);
		updatePanel.add(writerName);
		
		writerNameTextField = new JTextField();
		writerNameTextField.setBounds(270, 100, 100, 20);
		updatePanel.add(writerNameTextField);
		
		username = new JLabel("Username");
		username.setBounds(170, 130, 90, 20);
		updatePanel.add(username);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(270, 130, 100, 20);
		updatePanel.add(usernameTextField);
		
		password = new JLabel("Password");
		password.setBounds(170, 160, 90, 20);
		updatePanel.add(password);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(270, 160, 100, 20);
		updatePanel.add(passwordTextField);
		
		updateDataButton.setBounds(210, 40, 130, 20);
		updatePanel.add(updateDataButton);
		
		updateFrame.getContentPane().add(updatePanel);
	}
	public void createAccount() {
		accountFrame = new JFrame("Writer");
		accountFrame.setBounds(0, 0, 600, 400);
		accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		accountFrame.setLocationRelativeTo(null);
		accountFrame.getContentPane().setLayout(null);
		accountFrame.setVisible(true);
		
		accountPanel = new JPanel();
		accountPanel.setLayout(null);
		accountPanel.setBounds(0, 0, 600, 400);
		accountPanel.setVisible(true);
		
		writerName = new JLabel("Name");
		writerName.setBounds(170, 100, 90, 20);
		accountPanel.add(writerName);
		
		writerNameTextField = new JTextField();
		writerNameTextField.setBounds(270, 100, 100, 20);
		accountPanel.add(writerNameTextField);
		
		username = new JLabel("Username");
		username.setBounds(170, 130, 90, 20);
		accountPanel.add(username);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(270, 130, 100, 20);
		accountPanel.add(usernameTextField);
		
		password = new JLabel("Password");
		password.setBounds(170, 160, 90, 20);
		accountPanel.add(password);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(270, 160, 100, 20);
		accountPanel.add(passwordTextField);
		
		saveDataButton.setBounds(210, 40, 130, 20);
		accountPanel.add(saveDataButton);
		
		accountFrame.getContentPane().add(accountPanel);
	}
	
	public void writeArticle() {
		writeFrame = new JFrame("Write Article");
		writeFrame.setBounds(0, 0, 600, 400);
		writeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		writeFrame.setLocationRelativeTo(null);
		writeFrame.getContentPane().setLayout(null);
		writeFrame.setVisible(true);
		
		writePanel = new JPanel();
		writePanel.setLayout(null);
		writePanel.setBounds(0, 0, 600, 400);
		writePanel.setVisible(true);
		
		articleTitle = new JLabel("Title");
		articleTitle.setBounds(30, 15, 50, 10);
		writePanel.add(articleTitle);
		
		articleTitleTextArea.setBounds(30, 30, 300, 30);
		articleTitleTextArea.setVisible(true);	
		
		writePanel.add(articleTitleTextArea);
		JScrollPane scrollPane = new JScrollPane(articleTitleTextArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(30, 30, 300, 30);
		writeFrame.add(scrollPane);
		
		articleAbstract = new JLabel("Abstract");
		articleAbstract.setBounds(30, 65, 50, 10);
		writePanel.add(articleAbstract);
		
		articleAbstractTextArea.setBounds(30, 80, 300, 60);
		articleAbstractTextArea.setVisible(true);	
		
		writePanel.add(articleAbstractTextArea);
		JScrollPane scrollPaneAbstract = new JScrollPane(articleAbstractTextArea);
		scrollPaneAbstract.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneAbstract.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneAbstract.setBounds(30, 80, 300, 60);
		writeFrame.add(scrollPaneAbstract);
		
		articleBody = new JLabel("Body");
		articleBody.setBounds(30, 145, 50, 15);
		writePanel.add(articleBody);
		
		articleBodyTextArea.setBounds(30, 160, 300, 150);
		articleBodyTextArea.setVisible(true);	
		
		writePanel.add(articleBodyTextArea);
		JScrollPane scrollPaneBody = new JScrollPane(articleBodyTextArea);
		scrollPaneBody.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneBody.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneBody.setBounds(30, 160, 300, 150);
		writeFrame.add(scrollPaneBody);
		
		relatedArticles = new JLabel("Related articles");
		relatedArticles.setBounds(350, 30, 150, 15);
		writePanel.add(relatedArticles);
		
		relatedArticleList.setBounds(350, 50, 200, 200);
		relatedArticleList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		relatedArticleList.setLayoutOrientation(JList.VERTICAL);
		relatedArticleList.setVisibleRowCount(-1);
		relatedArticleList.setVisible(true);
		writeFrame.add(relatedArticleList);
		
		JScrollPane listScroller = new JScrollPane(relatedArticleList);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScroller.setBounds(350, 50, 200, 200);
		writeFrame.add(listScroller);
		
		saveArticleButton.setBounds(350, 270, 200, 20);
		writePanel.add(saveArticleButton);
		
		writeFrame.add(writePanel);	
	}
	public JFrame getViewFrame() {
		return viewFrame;
	}
	public void setViewFrame(JFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	public JPanel getViewPanel() {
		return viewPanel;
	}
	public void setViewPanel(JPanel viewPanel) {
		this.viewPanel = viewPanel;
	}
	public JFrame getWriterFrame() {
		return writerFrame;
	}
	public void setWriterFrame(JFrame writerFrame) {
		this.writerFrame = writerFrame;
	}
	public JPanel getWriterPanel() {
		return writerPanel;
	}
	public void setWriterPanel(JPanel writerPanel) {
		this.writerPanel = writerPanel;
	}
	public JButton getViewButton() {
		return viewButton;
	}
	public void setViewButton(JButton viewButton) {
		this.viewButton = viewButton;
	}
	public JButton getWriteButton() {
		return writeButton;
	}
	public void setWriteButton(JButton writeButton) {
		this.writeButton = writeButton;
	}
	public JButton getUpdateButton() {
		return updateButton;
	}
	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}
	public JButton getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}
	public JList<String> getArticleList() {
		return articleList;
	}
	public void setArticleList(JList<String> articleList) {
		this.articleList = articleList;
	}
	public DefaultListModel<String> getListModel() {
		return listModel;
	}
	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}
	public JFrame getViewArticleFrame() {
		return viewArticleFrame;
	}
	public void setViewArticleFrame(JFrame viewArticleFrame) {
		this.viewArticleFrame = viewArticleFrame;
	}
	public JPanel getViewArticlePanel() {
		return viewArticlePanel;
	}
	public void setViewArticlePanel(JPanel viewArticlePanel) {
		this.viewArticlePanel = viewArticlePanel;
	}
	public JTextArea getArticleTextArea() {
		return articleTextArea;
	}
	public void setArticleTextArea(JTextArea articleTextArea) {
		this.articleTextArea = articleTextArea;
	}
	public JFrame getAccountFrame() {
		return accountFrame;
	}
	public void setAccountFrame(JFrame accountFrame) {
		this.accountFrame = accountFrame;
	}
	public JPanel getAccountPanel() {
		return accountPanel;
	}
	public void setAccountPanel(JPanel accountPanel) {
		this.accountPanel = accountPanel;
	}
	public JLabel getWriterName() {
		return writerName;
	}
	public void setWriterName(JLabel writerName) {
		this.writerName = writerName;
	}
	public JTextField getWriterNameTextField() {
		return writerNameTextField;
	}
	public void setWriterNameTextField(JTextField writerNameTextField) {
		this.writerNameTextField = writerNameTextField;
	}
	public JButton getSaveDataButton() {
		return saveDataButton;
	}
	public void setSaveDataButton(JButton saveDataButton) {
		this.saveDataButton = saveDataButton;
	}
	public JLabel getUsername() {
		return username;
	}
	public void setUsername(JLabel username) {
		this.username = username;
	}
	public JTextField getUsernameTextField() {
		return usernameTextField;
	}
	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}
	public JLabel getPassword() {
		return password;
	}
	public void setPassword(JLabel password) {
		this.password = password;
	}
	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}
	public void setPasswordTextField(JPasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
	public JFrame getUpdateFrame() {
		return updateFrame;
	}
	public void setUpdateFrame(JFrame updateFrame) {
		this.updateFrame = updateFrame;
	}
	public JPanel getUpdatePanel() {
		return updatePanel;
	}
	public void setUpdatePanel(JPanel updatePanel) {
		this.updatePanel = updatePanel;
	}
	public JButton getUpdateDataButton() {
		return updateDataButton;
	}
	public JTextArea getArticleTitleTextArea() {
		return articleTitleTextArea;
	}
	public void setArticleTitleTextArea(JTextArea articleTitleTextArea) {
		this.articleTitleTextArea = articleTitleTextArea;
	}
	public JTextArea getArticleAbstractTextArea() {
		return articleAbstractTextArea;
	}
	public void setArticleAbstractTextArea(JTextArea articleAbstractTextArea) {
		this.articleAbstractTextArea = articleAbstractTextArea;
	}
	public JTextArea getArticleBodyTextArea() {
		return articleBodyTextArea;
	}
	public void setArticleBodyTextArea(JTextArea articleBodyTextArea) {
		this.articleBodyTextArea = articleBodyTextArea;
	}
	public JFrame getWriteFrame() {
		return writeFrame;
	}
	public void setWriteFrame(JFrame writeFrame) {
		this.writeFrame = writeFrame;
	}
	public JPanel getWritePanel() {
		return writePanel;
	}
	public void setWritePanel(JPanel writePanel) {
		this.writePanel = writePanel;
	}
	public JButton getSaveArticleButton() {
		return saveArticleButton;
	}
	public void setSaveArticleButton(JButton saveArticleButton) {
		this.saveArticleButton = saveArticleButton;
	}
	public void setUpdateDataButton(JButton updateDataButton) {
		this.updateDataButton = updateDataButton;
	}
	public JLabel getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(JLabel articleTitle) {
		this.articleTitle = articleTitle;
	}
	public JLabel getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(JLabel articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	public JLabel getArticleBody() {
		return articleBody;
	}
	public void setArticleBody(JLabel articleBody) {
		this.articleBody = articleBody;
	}
	public JList<String> getRelatedArticleList() {
		return relatedArticleList;
	}
	public void setRelatedArticleList(JList<String> relatedArticleList) {
		this.relatedArticleList = relatedArticleList;
	}
	public JLabel getRelatedArticles() {
		return relatedArticles;
	}
	public void setRelatedArticles(JLabel relatedArticles) {
		this.relatedArticles = relatedArticles;
	}
	public void  setArticlesListActionListener(ListSelectionListener listSelectionListener) {
		articleList.getSelectionModel().addListSelectionListener(listSelectionListener);
	}
	public void  setSaveDataButtonActionListener(ActionListener actionListener) {
		saveDataButton.addActionListener(actionListener);
	}
	public void  setUpdateDataButtonActionListener(ActionListener actionListener) {
		updateDataButton.addActionListener(actionListener);
	}
	public void  setViewButtonActionListener(ActionListener actionListener) {
		viewButton.addActionListener(actionListener);
	}
	public void  setUpdateButtonActionListener(ActionListener actionListener) {
		updateButton.addActionListener(actionListener);
	}
	public void  setDeleteButtonActionListener(ActionListener actionListener) {
		deleteButton.addActionListener(actionListener);
	}
	public void  setWriteButtonActionListener(ActionListener actionListener) {
		writeButton.addActionListener(actionListener);
	}
	public void  setSaveArticleButtonActionListener(ActionListener actionListener) {
		saveArticleButton.addActionListener(actionListener);
	}
}
