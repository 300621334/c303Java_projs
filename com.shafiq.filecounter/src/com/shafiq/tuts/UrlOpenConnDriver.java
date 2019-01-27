package com.shafiq.tuts;

import java.io.IOException;
import java.net.URL;

public class UrlOpenConnDriver {

	public static void main(String[] args) throws IOException {
		String url = "http://www.vogella.com";
		System.out.println(new UrlOpenConn().tinyUrl(url));
	}

}
