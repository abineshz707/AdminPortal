package com.adminPortal.service;

import java.util.List;
import java.util.Set;

import com.adminPortal.domain.User;
import com.adminPortal.domain.security.UserRole;

public interface UserService {
	User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
    
    void save (User user);
   
      
    User saveUser (User user); 
    
    User findById(Long id);
    
    List<User> findUserList();

    void enableUser (String username);

    void disableUser (String username);
    
    void actionOnUser(Long id);
}
