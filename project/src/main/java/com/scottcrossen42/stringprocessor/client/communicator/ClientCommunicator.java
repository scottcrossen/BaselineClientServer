package com.scottcrossen42.stringprocessor.client.communicator;

import java.io.*;
import java.net.*;
import com.scottcrossen42.stringprocessor.common.util.Serializer;
import com.scottcrossen42.stringprocessor.common.structures.Result;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class ClientCommunicator {

	private static final String serverHost = "server";
	private static final String serverPort = "8080";
	private static final Serializer serializer = Serializer.getInstance();

	public static Result get(String urlSuffix, String query) throws IOException, ClassNotFoundException {
		URL url = new URL("http://" + serverHost + ":" + serverPort + urlSuffix + "?q=" + query);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();

		http.setRequestMethod("GET");
		http.setDoOutput(false);
		http.connect();

		return serializer.readResult(http.getInputStream());
	}

	public static Result post(String urlSuffix, Serializable object) throws IOException, ClassNotFoundException {
		URL url = new URL("http://" + serverHost + ":" + serverPort + urlSuffix);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();

		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.addRequestProperty("Accept", "application/json");
		http.connect();

		OutputStream reqBody = http.getOutputStream();
		serializer.write(reqBody, object);
		reqBody.close();

		return serializer.readResult(http.getInputStream());
	}

}
