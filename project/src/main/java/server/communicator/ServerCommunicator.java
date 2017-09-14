package server.communicator;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import server.communicator.controllers.*;

public class ServerCommunicator {

	private static final int MAX_WAITING_CONNECTIONS = 12;

	private HttpServer server;

	public static void main(String[] args) {
		String portNumber = args[0];
		new ServerCommunicator().run(portNumber);
	}

	private void run(String portNumber) {

		System.out.println("Initializing HTTP Server");

		try {
			server = HttpServer.create(
						new InetSocketAddress(Integer.parseInt(portNumber)),
						MAX_WAITING_CONNECTIONS);
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}

		server.setExecutor(null);

		System.out.println("Creating contexts");

		server.createContext("/parseInteger", new ParseIntHandler());

		server.createContext("/toLowerCase", new ToLowerCaseHandler());

		server.createContext("/trim", new TrimHandler());

		System.out.println("Starting server");

		server.start();

		System.out.println("Server started");
	}
}
