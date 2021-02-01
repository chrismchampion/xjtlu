import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 1024);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			out.println("Hello from the client");
			System.out.println("echo: " + in.readLine());
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {

		}
	}
}