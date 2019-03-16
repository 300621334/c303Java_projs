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
		Double heightMeters = 0.0;
		Double weightKilos = 0.0;
		BMICalculator bmiCalculator = new BMICalculator();
		Double bmi = 0.0;
		String desc = "";

		try 
		{		
			heightMeters = Double.parseDouble(request.getParameter("heightMeters"));//must be in try-catch to catch NaN
			weightKilos = Double.parseDouble(request.getParameter("weightKilos"));
			
			bmiCalculator.setHeight(heightMeters);
			bmiCalculator.setWeight(weightKilos);
			bmi = bmiCalculator.calculateBMI();
			desc = bmiCalculator.getDescription(bmi);
		} 
		catch (ImpossibleWeightException | ImpossibleHeightException e) 
		{
			//e.printStackTrace();
			String errMsg =  "Value(s) provided are not reasonable for adults!";
			setErrMsgForRedirect(request, response, heightMeters, weightKilos, errMsg);
		}
		catch (NumberFormatException e)//if empty ht/wt or a NaN entered 
		{
			String errMsg = "Please enter numbers only and don't leave fields blank!";
			setErrMsgForRedirect(request, response, heightMeters, weightKilos, errMsg);
		}

		request.setAttribute("bmi", bmi);
		request.setAttribute("desc", desc);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/calcBMI.jsp");
		dispatcher.forward(request, response);
	}

	//fn to redirect back to form w errMsg in case of exceptions
	private void setErrMsgForRedirect(HttpServletRequest request, HttpServletResponse response, Double heightMeters, Double weightKilos, String errMsg) 
			throws ServletException, IOException 
	{
		String uri = ""; 
		uri = request.getRequestURI();//this includes the path for this very servelet
		uri = request.getContextPath();//this does NOT... rather only till name of the app i.e. Context-Root
		
		request.setAttribute("errMsg", errMsg);
		request.setAttribute("heightMeters", heightMeters);//send bk what user entered to prePopulate fields
		request.setAttribute("weightKilos", weightKilos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Assign_4_BMI/unitsMetric.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect( uri + "/Assign_4_BMI/unitsMetric.jsp");//a GET is requested//unable to pass params (.setAttribute) so use distapcher
	}

}
