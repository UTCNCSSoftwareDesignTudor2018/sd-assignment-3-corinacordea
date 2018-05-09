package assignment3.presentation.view;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;

public class ReaderView{
	private JFrame readerFrame;
	private JPanel readerPanel;
	private JFrame viewArticleFrame;
	private JPanel viewArticlePanel;
	private JTextArea articleTextArea;
	private JList<String> articleList;
	private DefaultListModel<String> listModel;
	public ReaderView() {
		initialize();
	}
	private void initialize() {
		readerFrame = new JFrame("Reader");
		readerFrame.setBounds(0, 0, 600, 400);
		readerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		readerFrame.setLocationRelativeTo(null);
		readerFrame.getContentPane().setLayout(null);
		
		readerPanel = new JPanel();
		readerPanel.setLayout(null);
		readerPanel.setBounds(0, 0, 600, 400);
		readerPanel.setVisible(true);
		
		listModel = new DefaultListModel<>();
		articleList = new JList<>(listModel);
		articleList.setBounds(40, 40, 500, 300);
		articleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		articleList.setLayoutOrientation(JList.VERTICAL);
		articleList.setVisibleRowCount(-1);
		articleList.setVisible(true);
		readerPanel.add(articleList);
		
		JScrollPane listScroller = new JScrollPane(articleList);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScroller.setBounds(40, 40, 500, 300);
		readerFrame.add(listScroller);
		readerFrame.add(readerPanel);
	}
	public void viewArticle() {
		viewArticleFrame = new JFrame("View Article");
		viewArticleFrame.setBounds(0, 0, 600, 400);
		viewArticleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewArticleFrame.setLocationRelativeTo(null);
		viewArticleFrame.getContentPane().setLayout(null);
		
		viewArticlePanel = new JPanel();
		viewArticlePanel.setLayout(null);
		viewArticlePanel.setBounds(0, 0, 600, 400);
		viewArticlePanel.setVisible(true);
				
		articleTextArea = new JTextArea();
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
	public JFrame getReaderFrame() {
		return readerFrame;
	}
	public void setReaderFrame(JFrame readerFrame) {
		this.readerFrame = readerFrame;
	}
	public JPanel getReaderPanel() {
		return readerPanel;
	}
	public void setReaderPanel(JPanel readerPanel) {
		this.readerPanel = readerPanel;
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
	public void  setArticlesListActionListener(ListSelectionListener listSelectionListener) {
		articleList.getSelectionModel().addListSelectionListener(listSelectionListener);
	}
}

