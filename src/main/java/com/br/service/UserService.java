package com.br.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.domain.User;

@Service
public class UserService {
	
	private static List<User> listUsers = new ArrayList<>(Arrays.asList(new User("thiago","123"),
																		new User("paze","147")));
	
	public void addUser(User user) {
    	listUsers.add(user);
    }
    
    public List<User> allUsersList(){
    	return listUsers;
    }

}
