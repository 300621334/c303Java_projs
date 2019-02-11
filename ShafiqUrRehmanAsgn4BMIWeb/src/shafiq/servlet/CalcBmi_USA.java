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
import bmi.model.MetricConverter;

/**
 * Servlet implementation class CalcBmi
 */
@WebServlet("/Assign_4_BMI/CalcBmiServletUSA")
public class CalcBmi_USA extends HttpServlet {
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
		Double heightInches = Double.parseDouble(request.getParameter("heightInches"));
		Double weightPounds = Double.parseDouble(request.getParameter("weightPounds"));
	
	BMICalculator bmiCalculator = new BMICalculator();
	Double bmi = 0.0;
	String desc = "";


	try {
		bmiCalculator.setHeight(MetricConverter.inchToMeter(heightInches));
		bmiCalculator.setWeight(MetricConverter.poundToKg(weightPounds));
		bmi = bmiCalculator.calculateBMI();
		desc = bmiCalculator.getDescription(bmi);
	} catch (ImpossibleWeightException | ImpossibleHeightException e) {
		e.printStackTrace();
	}
	
	request.setAttribute ("bmi", bmi);
	request.setAttribute ("desc", desc);

	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/calcBMI_USA.jsp");
	dispatcher.forward(request, response);
	}

}
