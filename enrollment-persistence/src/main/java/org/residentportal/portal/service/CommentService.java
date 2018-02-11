package org.residentportal.portal.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.Comment;
import org.residentportal.portal.entity.User;
import org.residentportal.portal.repository.BlogRepository;
import org.residentportal.portal.repository.CommentRepository;
import org.residentportal.portal.repository.RoleRepository;
import org.residentportal.portal.repository.UserRepository;

@Service
@Transactional
public class CommentService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	BlogRepository blogRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	public void save(Comment comment,String email,int blogId)
	{
		User user=userRepository.findByEmail(email);
		Blog blog=blogRepository.findOne(blogId);
		comment.setUser(user);
		comment.setBlog(blog);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   //get current date time with Date()
		   Date date = new Date();
		  
		comment.setPublishedDate(date);
		commentRepository.save(comment);	
	}
	
	public List<Comment> findByBlogId(int blogId)
	{
		Blog blog=blogRepository.findOne(blogId);
		return commentRepository.findByBlog(blog);
		
	}
	
}
