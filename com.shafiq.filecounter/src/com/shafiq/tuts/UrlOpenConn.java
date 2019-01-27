package com.shafiq.tuts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlOpenConn {
	private static final String tinyUrl = "http://tinyurl.com/api-create.php?url=";
	private static final String anotherUrl = "http://www.vogella.com";
	
	public String tinyUrl(String url) throws IOException {
		URL urlObj = new URL(tinyUrl + url);
		
		//MIME type = media type = content type
		System.out.println(urlObj.openConnection().getContentType());
		
		//response code
		System.out.println(((HttpURLConnection)urlObj.openConnection()).getResponseCode());
		
		//read web page
		BufferedReader bReader = new BufferedReader(
				new InputStreamReader(
						new URL(anotherUrl).openStream()));
		
		int counter = 1, linesToPrint = 10;//print only 10 lines returned
		String line;
		while ((line = bReader.readLine()) != null && counter <= linesToPrint) {
			System.out.println(line);
			counter++;
		}
		
		//Tiny URL returned
		BufferedReader reader =
				/*use buffer for efficiency*/new BufferedReader(
						/*apply UTF encoding*/new InputStreamReader(
								/*open conn & get stream returned*/urlObj.openStream()));
		
		return "Tiny url is => " + reader.readLine();//tinyUrl returned
	}
	


}
