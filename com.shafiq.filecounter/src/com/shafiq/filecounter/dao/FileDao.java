package com.shafiq.filecounter.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.layout.Region;

//dao = Data Access Object = to read and write the counter value to and from the file
//http://www.vogella.com/tutorials/EclipseWTP/article.html

public class FileDao 
{
private static final String fileName = "FileCounter.initial";//where site-visit-count will be saved/retreived

//get site-visit-count
	public int getCount()
	{
		int count = 0;//num of site-visits
		FileReader fileReader=null;//which file to read
		BufferedReader bufferedReader = null;//opens file to read
		//
		FileWriter fileWriter=null;//which file to write
		PrintWriter printWriter=null;//opens file to write
		//
		File file = new File(fileName);//import java.io.File;
		
		try 
		{
			//if file NOT exists, create & write '0' to file
			fileWriter = new FileWriter(fileName);//which file to write
			printWriter = new PrintWriter(fileWriter);
			if(!file.exists())
			{
				file.createNewFile();
				printWriter.println(0);
			}
			if (printWriter != null) printWriter.close();
			
			//now read count from file
			fileReader = new FileReader(fileName);//which file to read
			bufferedReader = new BufferedReader(fileReader);//opens file to read
			String line = bufferedReader.readLine();
			count = Integer.parseInt(line);
			
			if (bufferedReader != null) bufferedReader.close();
		} 
		catch (IOException e) 
		{
			if (printWriter != null) printWriter.close();
			if (bufferedReader != null)try {bufferedReader.close();} catch (IOException e1) {e1.printStackTrace();}
		}
	return count;	
	}
	
	//save site-visit-count to file
	public void save(int count) throws IOException 
	{
		FileWriter fileWriter = new FileWriter(fileName);//opens a file for writing
		PrintWriter printWriter = new PrintWriter(fileWriter);//writes to the file
		printWriter.println(count);
		if(printWriter != null)printWriter.close();//close the file
	}

}
