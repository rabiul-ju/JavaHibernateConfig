package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.dao.UserDao;
import com.google.gson.Gson;
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
		String param=request.getParameter("param");
		System.out.println(param);
		if (param!=null && param.equals("jason")){
			 UserDao userDao=new UserDao();
			 response.setContentType("text/text;charset=utf-8");
			 response.setHeader("cach-content","no=cach");
			 Gson gson=new Gson();
			 List<User>users=userDao.getAllObjects();
			 String jason=gson.toJson(users);
			 request.setAttribute("data", jason);
			 System.out.println(jason);			 
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param=request.getParameter("param");
		System.out.println(param);
		 if (param!=null && param.equals("create")) {
			 try {
				 Integer i=null;
				 User user=new User();
				 Login login=new Login();
				 user.setFirstName(request.getParameter("firstName"));
				 user.setLastName(request.getParameter("lastName"));
				 user.setEmail(request.getParameter("email"));
				 login.setPassword(request.getParameter("password"));
				 login.setMobileNumber(request.getParameter("mobileNumber"));

				 LoginDao loginDao=new LoginDao();
				 i=loginDao.create(login);
				 if(i!=null){
					 login=(Login)loginDao.getObjetByMobile(login.getMobileNumber());
					 user.setLogin(login);
				 }
				 UserDao userDao=new UserDao();
				 userDao.create(user);
				 //doGet(request, response);
			 } catch (Exception e) {
				 // TODO: handle exception
				 e.printStackTrace();
				 System.out.println(e.getMessage());
			 }		
		 }
		 if (param!=null && param.equals("jason")){
			 UserDao userDao=new UserDao();
			 response.setContentType("text/text;charset=utf-8");
			 response.setHeader("cach-content","no=cach");
			 Gson gson=new Gson();
			 List<User>users=userDao.getAllObjects();
			 String jason=gson.toJson(users);
			 request.setAttribute("data", jason);
			 System.out.println(jason);			 
		 }
	}
}
