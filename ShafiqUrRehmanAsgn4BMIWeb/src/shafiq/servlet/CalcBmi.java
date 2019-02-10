package shafiq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcBmi
 */
@WebServlet("/Assign_4_BMI/CalcBmiServlet")
public class CalcBmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String heightMeters = request.getParameter("heightMeters");
	String weightKilos = request.getParameter("weightKilos");
	
	
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/calcBMI.jsp");
	dispatcher.forward(request, response);
	}

}
