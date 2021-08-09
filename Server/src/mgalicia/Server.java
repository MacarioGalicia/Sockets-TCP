package mgalicia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {

	private static final int PORT = 5010;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT, 120);
		Socket socket = null;

		DataInputStream dataInputStream;
		DataOutputStream dataOutputStream;

		System.out.println("Servidor iniciado ...");
		System.out.println("IP: " + serverSocket.getInetAddress());
		System.out.println("PORT: " + serverSocket.getLocalPort());
		Separator();

		while (true) {
			socket = serverSocket.accept();
			System.out.println("Cliente Conectado");

			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			String message = dataInputStream.readUTF();
			System.out.println("Mensaje recibido: " + message);

			dataOutputStream.writeUTF("Número de solicitud: " + UUID.randomUUID());
			socket.close();

			System.out.println("Cliente desconectado");
			Separator();

		}

	}
	
	private static void Separator() {
		System.out.println("-----------------------------------------------------");
	}

}
