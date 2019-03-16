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
@WebServlet("/") //@WebServlet("/display_menu")
public class display_menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display_menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		MenuManager menuManager = MenuManager.getInstance();//instead of constructor, get a singelton
		menuItems = menuManager.getMenu();
		
		//https://stackoverflow.com/questions/22623730/populating-a-select-list-from-servlet
		request.setAttribute("menuItems", menuItems);
		request.getRequestDispatcher("/display_menu.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append(menuItems.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
