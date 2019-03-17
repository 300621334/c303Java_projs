package shafiq.ur.rehman.menu.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shafiq.ur.rehman.menu.model.MenuItem;
import shafiq.ur.rehman.menu.model.MenuManager;

/**
 * Servlet implementation class display_menu
 */
@WebServlet("/")
public class display_menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("lastNum", 12000);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		MenuManager menuManager = MenuManager.getInstance();
		menuItems = menuManager.getMenu();
		
		request.setAttribute("menuItems", menuItems);
		request.getRequestDispatcher("/display_menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String orderId = username + getServletContext().getAttribute("lastNum");
		incrementOrderNum();
		//retrieve menu:
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		MenuManager menuManager = MenuManager.getInstance();
		menuItems = menuManager.getMenu();
		//pass menu items to order-form.JSP:
		request.setAttribute("menuItems", menuItems);
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("/order-form.jsp").forward(request, response);
	}

	private void incrementOrderNum() {
		int orderNum = 0;
		synchronized (this) {
			orderNum = (int)getServletContext().getAttribute("lastNum");//setAttr in init()
			orderNum++;
			getServletContext().setAttribute("lastNum", orderNum);
		}
	}

}
