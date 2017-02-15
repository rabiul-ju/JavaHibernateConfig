package com.rest.webService;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.UserDao;
import com.google.gson.Gson;
import com.model.User;

@Path("/webservice")
public class UserInfoService {
	@GET
	@Path("/userInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String allUsers(){
		String string=null;
		try {
			UserDao userDao=new UserDao();
			 Gson gson=new Gson();
			 List<User>users=userDao.getAllObjects();
			 string=gson.toJson(users);
		} finally {
			// TODO: handle finally clause
		}
		return string;
	}
}
