package com.scottcrossen42.stringprocessor.server.communicator.controllers;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import com.scottcrossen42.stringprocessor.common.util.StringProcessor;
import com.scottcrossen42.stringprocessor.common.util.Serializer;
import com.scottcrossen42.stringprocessor.common.structures.Result;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class ParseIntHandler implements HttpHandler {

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
					Integer respData = StringProcessor.getInstance().parseInteger(reqData);
					result = new Result(true, Integer.toString(respData), null);
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

	private void writeInt(Integer num, OutputStream os) throws IOException {
		OutputStreamWriter sw = new OutputStreamWriter(os);
		sw.write(Integer.toString(num));
		sw.flush();
	}
}
