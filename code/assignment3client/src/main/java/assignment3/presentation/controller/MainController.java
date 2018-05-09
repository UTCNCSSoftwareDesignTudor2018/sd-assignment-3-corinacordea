package assignment3.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import assignment3.communication.Client;
import assignment3.presentation.view.MainView;
import assignment3.presentation.view.ReaderView;
import assignment3.presentation.view.WriterView;

public class MainController {

	private MainView mainView;
	private Client client;

	public MainController(MainView mv, Client client) {
		super();
		this.mainView = mv;
		this.client = client;
		mainView.setContinueButtonActionListener(new ContinueButtonActionListener());
		mainView.setCreateAccountButtonActionListener(new CreateAccountButtonActionListener());
	}

	private class ContinueButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (mainView.getReaderButton().isSelected()) {
				try {
					try {
						client.startClient();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ReaderView readerView = new ReaderView();
					readerView.getReaderFrame().setVisible(true);
					ReaderController readerController = new ReaderController(readerView, client);
					readerController.createClient();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(mainView.getFrame(), "Error");
				}
			} else if (mainView.getWriterButton().isSelected()) {
				try {
					try {
						client.startClient();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					WriterView writerView = new WriterView();
					WriterController writerController = new WriterController(writerView, client);		
					@SuppressWarnings("deprecation")
					String res = writerController.createClient(mainView.getUsernameTextField().getText(), mainView.getPasswordField().getText());
					if(res.equals("success")) {
						writerView.getWriterFrame().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(mainView.getFrame(), "Invalid username or password");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(mainView.getFrame(), "Error");
				}
			}
		}
	}
	private class CreateAccountButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			WriterView writerView = new WriterView();
			writerView.createAccount();
			@SuppressWarnings("unused")
			WriterController writerController = new WriterController(writerView, client);
		}
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

}
