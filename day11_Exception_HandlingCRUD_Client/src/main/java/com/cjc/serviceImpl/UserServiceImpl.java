package com.cjc.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cjc.UserModel.User;
import com.cjc.exception.UserNotFoundException;
import com.cjc.repository.UserRepository;
import com.cjc.serviceI.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	
	@Autowired
	UserRepository ur;

	public User  getSingleUser1(int id) {
	Optional<User>u=ur.findById(id);
	  if(u.isPresent())
	     {
	    	 User user=u.get();
	    	 return user;
	     }
	     else {
	    	
	    	throw new UserNotFoundException("No Record Found For ID:- "+id);
	     }
	   
	}

	@Override
	public User getSingleUser(int id) {
		
	Optional<User> findById = ur.findById(id);
	User user = findById.get();
	return user;
	 
	}



	@Override
	public User saveUserData(User us) {
	ur.save(us);
		return null;
	}

	



	
}
	




	


