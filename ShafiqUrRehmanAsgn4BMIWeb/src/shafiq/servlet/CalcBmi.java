package shafiq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bmi.exceptions.ImpossibleHeightException;
import bmi.exceptions.ImpossibleWeightException;
import bmi.model.BMICalculator;

/**
 * Servlet implementation class CalcBmi
 */
@WebServlet("/Assign_4_BMI/CalcBmiServlet")
public class CalcBmi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Double heightMeters = Double.parseDouble(request.getParameter("heightMeters"));
		Double weightKilos = Double.parseDouble(request.getParameter("weightKilos"));

		BMICalculator bmiCalculator = new BMICalculator();
		Double bmi = 0.0;

		try {
			bmiCalculator.setHeight(heightMeters);
			bmiCalculator.setWeight(weightKilos);
			bmi = bmiCalculator.calculateBMI();
		} catch (ImpossibleWeightException | ImpossibleHeightException e) {
			e.printStackTrace();
		}

		request.setAttribute ("bmi", bmi);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/calcBMI.jsp");
		dispatcher.forward(request, response);
	}

}
