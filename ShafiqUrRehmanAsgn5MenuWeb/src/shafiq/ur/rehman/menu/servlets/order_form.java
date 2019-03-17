package shafiq.ur.rehman.menu.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shafiq.ur.rehman.menu.model.MenuItem;
import shafiq.ur.rehman.menu.model.MenuManager;

/**
 * Servlet implementation class order_form
 */
@WebServlet("/order_form") //formaction="/ShafiqUrRehmanAsgn5MenuWeb/order_form"
public class order_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at order-form: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String orderId = request.getParameter("orderId");
		
		//retrieve menu:
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		MenuManager menuManager = MenuManager.getInstance();
		menuItems = menuManager.getMenu();
		
		//get ALL <select> from many rows of tbl
		//selectedItemsMap.put(mapEntry.getKey(), mapEntry.getValue());
		Map<String, String[]> paramMap = request.getParameterMap();
		Map<String, String[]> selectedItemsMap = new HashMap<String, String[]>();
		
		for(Map.Entry<String, String[]> mapEntry : paramMap.entrySet())
		{
			if(mapEntry.getKey().contains("itemId_"))
			{
				String itemNoFromMapStr = mapEntry.getKey().substring(7);
				int itemNoFromMap = Integer.parseInt(itemNoFromMapStr);
				
				for(int i=0;i<menuItems.size();i++/*MenuItem item : menuItems*/)
				{
					int quantity = Integer.parseInt(mapEntry.getValue()[0]);
					int itemNoFromMenu = menuItems.get(i).getItemNo();
					
					if(itemNoFromMenu == itemNoFromMap /*Integer.parseInt(mapEntry.getKey().substring(7))*/)
					{
						menuItems.get(i).setQuantity(quantity);
					}
				}
			}
		}
		
			//pass menu items to order-form.JSP:
				request.setAttribute("menuItems", menuItems);
				request.setAttribute("orderId", orderId);
				request.getRequestDispatcher("/summary.jsp").forward(request, response);
	}
}
