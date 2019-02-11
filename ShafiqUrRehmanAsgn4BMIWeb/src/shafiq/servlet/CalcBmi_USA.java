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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	Double heightInches = 0.0;
	Double weightPounds = 0.0;
	BMICalculator bmiCalculator = new BMICalculator();
	Double bmi = 0.0;
	String desc = "";
	RequestDispatcher dispatcher;

	try {
		heightInches = Double.parseDouble(request.getParameter("heightInches"));
		weightPounds = Double.parseDouble(request.getParameter("weightPounds"));
		
		bmiCalculator.setHeight(MetricConverter.inchToMeter(heightInches));
		bmiCalculator.setWeight(MetricConverter.poundToKg(weightPounds));
		bmi = bmiCalculator.calculateBMI();
		desc = bmiCalculator.getDescription(bmi);
	} 
	catch (ImpossibleWeightException | ImpossibleHeightException e) 
	{
		//e.printStackTrace();
		String errMsg =  "Value(s) provided are not reasonable for adults!";
		setErrMsgForRedirect(request, response, heightInches, weightPounds, errMsg);
	}
	catch (NumberFormatException e)//if empty ht/wt or a NaN entered 
	{
		String errMsg = "Please enter numbers only and don't leave fields blank!";
		setErrMsgForRedirect(request, response, heightInches, weightPounds, errMsg);
	}
	
	request.setAttribute ("bmi", bmi);
	request.setAttribute ("desc", desc);

	dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/calcBMI_USA.jsp");
	dispatcher.forward(request, response);
	}
	
	//fn to redirect back to form w errMsg in case of exceptions
	private void setErrMsgForRedirect(HttpServletRequest request, HttpServletResponse response, Double heightInches, Double weightPounds, String errMsg) 
			throws ServletException, IOException 
	{
		String uri = ""; 
		uri = request.getRequestURI();//this includes the path for this very servelet
		uri = request.getContextPath();//this does NOT... rather only till name of the app
		
		request.setAttribute("errMsg", errMsg);
		request.setAttribute("heightInches", heightInches);//send bk what user entered to prePopulate fields
		request.setAttribute("weightPounds", weightPounds);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/unitsUSA.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect( uri + "/Assign_4_BMI/unitsMetric.jsp");//a GET is requested//unable to pass params so use distapcher
	}
}
