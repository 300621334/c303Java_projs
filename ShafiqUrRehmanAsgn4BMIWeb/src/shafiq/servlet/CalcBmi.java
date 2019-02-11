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


@WebServlet("/Assign_4_BMI/CalcBmiServlet")
public class CalcBmi extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		Double heightMeters = Double.parseDouble(request.getParameter("heightMeters"));
		Double weightKilos = Double.parseDouble(request.getParameter("weightKilos"));

		BMICalculator bmiCalculator = new BMICalculator();
		Double bmi = 0.0;
		String desc = "";

		try 
		{
			bmiCalculator.setHeight(heightMeters);
			bmiCalculator.setWeight(weightKilos);
			bmi = bmiCalculator.calculateBMI();
			desc = bmiCalculator.getDescription(bmi);
		} 
		catch (ImpossibleWeightException | ImpossibleHeightException e) 
		{
			e.printStackTrace();
		}

		request.setAttribute("bmi", bmi);
		request.setAttribute("desc", desc);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/calcBMI.jsp");
		dispatcher.forward(request, response);
	}

}
