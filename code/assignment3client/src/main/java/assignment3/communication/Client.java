package assignment3.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	BufferedReader in;
	PrintWriter out;

	public void startClient() throws IOException {

		@SuppressWarnings("resource")
		Socket socket = new Socket("localhost", 9000);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

	}

	public String communicate(String... message) throws IOException {
		String line = "";
		while (true) {
			for (String s : message) {
				if (s != null) {
					out.println(s);
				}
			}
			line = in.readLine();
			return line;
		}
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

}
