package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.dao.UserDao;
import com.model.Login;
import com.model.User;

/**
 * Servlet implementation class UserController
 */

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer i=null;
		User user=new User();
		Login login=new Login();
		try {
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setEmail(request.getParameter("email"));
			login.setPassword(request.getParameter("password"));
			login.setMobileNumber(request.getParameter("mobileNo"));

			LoginDao loginDao=new LoginDao();
			i=loginDao.create(login);
			if(i!=null){
				login=(Login)loginDao.getObjetByMobile(login.getMobileNumber());
				user.setLogin(login);
			}
			UserDao userDao=new UserDao();
			userDao.create(user);
			doGet(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
	}
}
