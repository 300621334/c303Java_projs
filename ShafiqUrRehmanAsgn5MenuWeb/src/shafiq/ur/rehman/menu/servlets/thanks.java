package shafiq.ur.rehman.menu.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class thanks
 */
@WebServlet("/thanks")
public class thanks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = "";
		if(request.getParameter("Cancel") == null)//clicked name="Confirm"
		{
			msg = String.format("<h1>Thank you for visiting Shafiq-Ur-Rehman Restaurant!</h1>\n"
					+ "Order# <b>%s</b> will be ready in 20 minutes by <b>%s</b>"
					, request.getParameter("orderId")
					, getOrderFullfilmentTime());
		}
		else //clicked name="Cancel"
		{
			msg = String.format("Order# <b>%s</b> has been cancelled"
					, request.getParameter("orderId"));
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/thanks.jsp").forward(request, response);
		//response.getWriter().append("Thank you");//.append(request.getContextPath());
	}

	//Helper fn
	private Object getOrderFullfilmentTime() {
		Calendar calendar = Calendar.getInstance();
		//20 min = 1200 ms
/*		long time = 1200 + calendar.getTimeInMillis();
		DateFormat dFormat = DateFormat.getTimeInstance(DateFormat.LONG);
		return dFormat.format(new Date(time));*/
		
		SimpleDateFormat df = new SimpleDateFormat("hh:mm a z");//a=AM/PM z=zone
		calendar.add(Calendar.MINUTE, 20);
		return df.format(calendar.getTime());

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
