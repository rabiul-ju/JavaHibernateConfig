package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoginSpringDao;
import com.dao.UserSpringDao;
import com.model.Login;
import com.model.User;

@Controller
public class UserSpringController {

	@Autowired
	UserSpringDao userSpringDao;
	LoginSpringDao loginSpringDao;
	
	@RequestMapping("/userForm")
	public ModelAndView showForm(){
		
		return new ModelAndView("welcome","command",new User());
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveForm(@ModelAttribute("userForm") User user){
		Integer i=null;
		Login login=new Login();
		login=null;
		login=user.getLogin();
		i=loginSpringDao.insert(login);
		if(i!=null){
			login= (Login) loginSpringDao.getObjectById(login.getMobileNumber());
			user.setLogin(login);
			userSpringDao.insert(user);
			System.out.println(login.getMobileNumber());
		}
		//System.out.println(user.getLog().getMobileNumber());
		
		return new ModelAndView("redirect:/showlist");
	}
	@RequestMapping("/showList")
	public ModelAndView showUserList(){
		List<User>users=(List<User>) userSpringDao.getAllObjects();
		return new ModelAndView("showList","users",users);
	}
}
