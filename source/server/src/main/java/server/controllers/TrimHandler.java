package server.controllers;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import util.StringProcessor;

public class TrimHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		String reqData = readString(exchange.getRequestBody());
		System.out.println("Processing string \'" + reqData + "\'");
		boolean success = false;

		try {
			if (exchange.getRequestMethod().toLowerCase().equals("post")) {

				Headers reqHeaders = exchange.getRequestHeaders();

				String respData = StringProcessor.getInstance().trim(reqData);

				exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);

				OutputStream respBody = exchange.getResponseBody();
				writeString(respData, respBody);
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

	private void writeString(String str, OutputStream os) throws IOException {
		OutputStreamWriter sw = new OutputStreamWriter(os);
		sw.write(str);
		sw.flush();
	}
}
