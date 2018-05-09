package assignment3.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment3.business.service.ArticleService;
import assignment3.business.service.WriterService;

@Component
public class Server {
	@Autowired
	ArticleService articleService;
	@Autowired
	WriterService writerService;

	public void startServer() throws IOException {
		System.out.println("The chat server is running.");
		ServerSocket listener = new ServerSocket(9000);
		try {
			while (true) {
				new ClientThread(listener.accept(), articleService, writerService).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class ClientThread extends Thread {
		private Socket socket = null;
		private BufferedReader in;
		private PrintWriter out;
		private String message;
		private ArticleService articleService;
		private WriterService writerService;

		public ClientThread(Socket socket, ArticleService articleService, WriterService writerService) {
			this.socket = socket;
			this.articleService = articleService;
			this.writerService = writerService;
		}

		public void run() {

			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				while (true) {
					message = in.readLine();
					if (message == null) {
						return;
					}
					if (message.equals("view articles")) {
						out.println(articleService.findAll());
					}
					if (message.equals("open article")) {
						String title = in.readLine();
						out.println(articleService.getArticle(title));
					}
					if (message.equals("writer authentication")) {
						String username = in.readLine();
						String password = in.readLine();
						out.println(writerService.writerLogin(username, password));
					}
					if (message.equals("create account")) {
						String writer = in.readLine();
						writerService.createAccount(writer);
						out.println("");
					}
					if (message.equals("update account")) {
						String writer = in.readLine();
						writerService.updateAccount(writer);
						out.println("");
					}
					if (message.equals("delete account")) {
						String writer = in.readLine();
						writerService.deleteAccount(writer);
						out.println("");
					}
					if (message.equals("write article")) {
						String article = in.readLine();
						String writer = in.readLine();
						articleService.saveArticle(article, writer);
						out.println("");
					}
				}

			} catch (IOException e) {

				try {
					out.close();
					in.close();
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} finally {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
