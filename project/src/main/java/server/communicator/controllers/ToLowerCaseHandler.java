package server.communicator.controllers;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import common.util.StringProcessor;
import common.util.Serializer;
import common.structures.Result;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class ToLowerCaseHandler implements HttpHandler {

	private static final Serializer serializer = Serializer.getInstance();

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		boolean success = false;

		try {
			if (exchange.getRequestMethod().toLowerCase().equals("post")) {

				String reqData = serializer.readString(exchange.getRequestBody());
				System.out.println("Processing string \'" + reqData + "\'");

				Result result;
				try {
					String respData = StringProcessor.getInstance().toLowerCase(reqData);
					result = new Result(true, respData, null);
				} catch (Exception e) {
					result = new Result(false, null, e);
				}

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
		} catch (IOException e) {
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

	private void writeString(String str, OutputStream os) throws IOException {
		OutputStreamWriter sw = new OutputStreamWriter(os);
		sw.write(str);
		sw.flush();
	}
}
