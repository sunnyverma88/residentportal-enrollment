package org.residentportal.portal.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.Role;
import org.residentportal.portal.entity.User;

import org.residentportal.portal.repository.BlogRepository;

import org.residentportal.portal.repository.RoleRepository;
import org.residentportal.portal.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	BlogRepository blogRepository;
	
	
	
	
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	public User findOne(int id)
	{
		return userRepository.findOne(id);
	}
	public User findOneByName(String name)
	{
	  return userRepository.findByName(name);	
	
	}
        
        public User findOneByEmail(String email)
	{
	  return userRepository.findByEmail(email);	
	
	}
    @Transactional
	public User findOneWithBlogs(int id) {
		
    	
    	User user=findOne(id);
		List<Blog> blogs=blogRepository.findByUser(user);
		
		user.setBlogs(blogs);
		return user;
   	
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		
		user.setRoles(roles);
		userRepository.save(user);
		
	}

	public User findOneWithBlogs(String name) {
		// TODO Auto-generated method stub
		User user=userRepository.findByName(name);
		
		return findOneWithBlogs(user.getUserId());
	}
	public User findOneWithBlogsbyEmail(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		
		return findOneWithBlogs(user.getUserId());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	
}
