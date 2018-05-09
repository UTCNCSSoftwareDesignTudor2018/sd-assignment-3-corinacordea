package assignment3;

import assignment3.communication.Client;
import assignment3.presentation.controller.MainController;
import assignment3.presentation.view.MainView;

public class ClientApplication {
	
	public static void main(String[] args) {
		Client client = new Client();
		MainView mainView = new MainView();
		@SuppressWarnings("unused")
		MainController controller = new MainController(mainView, client);
		mainView.getFrame().setVisible(true);
	}

}
