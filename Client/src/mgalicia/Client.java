package mgalicia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static final String HOST = "172.20.144.177";
	private static final int PORT = 5010;

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket(HOST, PORT);

		DataInputStream dataInputStream;
		DataOutputStream dataOutputStream;

		dataInputStream = new DataInputStream(socket.getInputStream());
		dataOutputStream = new DataOutputStream(socket.getOutputStream());

		dataOutputStream.writeUTF("EF34A3C31B21F41A0");
		String message = dataInputStream.readUTF();

		System.out.println("Mensaje recibido: " + message);
		socket.close();
	}

}
