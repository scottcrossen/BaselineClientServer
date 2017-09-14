package client;

import java.io.*;
import java.net.*;

public class ClientCommunicator {

	private static final String serverHost = "server";
	private static final String serverPort = "8080";

	public static String getString(String urlSuffix, String requestInfo) throws Exception {
		return readString(post(urlSuffix, requestInfo));
	}

	public static Integer getInteger(String urlSuffix, String requestInfo) throws Exception {
		return readInt(post(urlSuffix, requestInfo));
	}

	private static InputStream get(String urlSuffix, String query) throws IOException {
		URL url = new URL("http://" + serverHost + ":" + serverPort + urlSuffix + "?q=" + query);

		HttpURLConnection http = (HttpURLConnection)url.openConnection();

		http.setRequestMethod("GET");
		http.setDoOutput(false);
		http.connect();

		return http.getInputStream();
	}

	public static InputStream post(String urlSuffix, String requestInfo) throws IOException {
		URL url = new URL("http://" + serverHost + ":" + serverPort + urlSuffix);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();

		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.addRequestProperty("Accept", "application/json");
		http.connect();

		String reqData = requestInfo;

		OutputStream reqBody = http.getOutputStream();
		writeString(reqData, reqBody);
		reqBody.close();

		return http.getInputStream();
	}

	private static String readString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStreamReader sr = new InputStreamReader(is);
		char[] buf = new char[1024];
		int len;
		while ((len = sr.read(buf)) > 0) {
			sb.append(buf, 0, len);
		}
		return sb.toString();
	}

	private static Integer readInt(InputStream is) throws IOException {
			StringBuilder sb = new StringBuilder();
			InputStreamReader sr = new InputStreamReader(is);
			char[] buf = new char[1024];
			int len;
			while ((len = sr.read(buf)) > 0) {
				sb.append(buf, 0, len);
			}
			return Integer.parseInt(sb.toString());
		}

	private static void writeString(String str, OutputStream os) throws IOException {
		OutputStreamWriter sw = new OutputStreamWriter(os);
		sw.write(str);
		sw.flush();
	}

}
