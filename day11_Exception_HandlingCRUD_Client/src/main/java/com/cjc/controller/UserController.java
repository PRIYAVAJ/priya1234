package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.UserModel.User;

import com.cjc.serviceI.UserServiceI;

@RestController
public class UserController
{
	@Autowired
	UserServiceI usi;
	
	@PostMapping("/regdata")
public ResponseEntity <User> postdata(@RequestBody User us) 
{
	User us1=usi.saveUserData(us);
	return new ResponseEntity <User>(us1,HttpStatus.CREATED);
}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> exposeUser(@PathVariable int id)
	{
		 User us=usi.getSingleUser(id);
		
		
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	
}
