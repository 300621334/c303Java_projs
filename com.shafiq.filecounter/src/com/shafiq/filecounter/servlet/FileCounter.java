package com.shafiq.filecounter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shafiq.filecounter.dao.FileDao;

@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	//
	int count;
	FileDao dao;//data access obj (to access a file)
       
//constructor - works wout it!
/*    public FileCounter() {super();}*/
	
//when server starts, before ath else, this init() is run
    	@Override
	public void init() throws ServletException 
    {
		super.init();
		dao = new FileDao();//try-catch this file reading/writing call
		try 
		{
			count = dao.getCount();//init to count '0'
		} catch (Exception e) 
		{

			e.printStackTrace();
		}
	}
    	
//before destroying this, save visit-count to file or release any resources, such as a database connection 	
@Override
		public void destroy() 
		{
			super.destroy();
			try 
			{
				dao.save(count);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	//GET req handled here
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(5);//session expire aft 5 sec
		response.setContentType("text/plain");
		PrintWriter out= response.getWriter();//for sending PRINT (chars) <> to send binary data use .getOutputStream() & ServletOutputStream obj
		
		if (session.isNew()) count++;
			
		out.println("Site accessed "+count+" times");
	}
/*
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
*/

}
