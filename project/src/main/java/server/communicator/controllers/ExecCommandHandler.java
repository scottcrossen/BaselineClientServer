package server.communicator.controllers;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import common.util.StringProcessor;
import common.util.Serializer;
import common.structures.Result;
import common.command.ICommand;

public class ExecCommandHandler implements HttpHandler {

	private static final Serializer serializer = Serializer.getInstance();

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		boolean success = false;

		try {
			if (exchange.getRequestMethod().toLowerCase().equals("post")) {

				ICommand reqCommand = serializer.getInstance().readCommand(exchange.getRequestBody());
				System.out.println("Processing command \'" + reqCommand.getType() + "\'");

				Result result = reqCommand.execute();

				exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);

				OutputStream respBody = exchange.getResponseBody();
				serializer.write(respBody, result);
				respBody.close();

				success = true;
			}

			if (!success) {
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
				exchange.getResponseBody().close();
			}
		}
		catch (IOException e) {
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
			exchange.getResponseBody().close();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
			exchange.getResponseBody().close();
			e.printStackTrace();
		}
	}

	private String readString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStreamReader sr = new InputStreamReader(is);
		char[] buf = new char[1024];
		int len;
		while ((len = sr.read(buf)) > 0) {
			sb.append(buf, 0, len);
		}
		return sb.toString();
	}

	private void writeInt(Integer num, OutputStream os) throws IOException {
		OutputStreamWriter sw = new OutputStreamWriter(os);
		sw.write(Integer.toString(num));
		sw.flush();
	}
}
