package org.residentportal.portal.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.User;
import org.residentportal.portal.repository.BlogRepository;
import org.residentportal.portal.repository.UserRepository;

@Service
@Transactional
public class BlogService {
	
	@PersistenceContext
	EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	@Autowired
	private BlogRepository blogRepository;
    
	@Autowired
	private UserRepository userRepository;
	
	public void save(Blog blog,String email)
	{
		User user=userRepository.findByEmail(email);
		blog.setUser(user);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   //get current date time with Date()
		   Date date = new Date();
		  
		blog.setPublishedDate(date);
		blogRepository.save(blog);	
	}
	
	public void update(Blog blog)
	{
		blogRepository.save(blog);	
	}
	public void approveBlog(int id)
	{   
		blogRepository.approveBlog(id);
	}
	
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog")Blog blog) {
		blogRepository.delete(blog);
		
	}

	public Blog findOne(int id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

	

	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		return blogRepository.findAll();
		//return blogRepository.findAll(new PageRequest(0, 20,Direction.DESC, "publishedDate")).getContent();
	}
	
	public Page<Blog> getBlogsbyUser(User user,Integer pageNumber) {
		// TODO Auto-generated method stub
		  PageRequest request =
		            new PageRequest(pageNumber - 1, 5, Sort.Direction.DESC, "publishedDate");
		return blogRepository.findByUser(user,request);
		//return blogRepository.findAll(new PageRequest(0, 20,Direction.DESC, "publishedDate")).getContent();
	}
	
	public int countMembers()
	{
		return blogRepository.findAll().size();
	}

	public Page<Blog> getAllBlogs(Pageable pageable) {
		
		        Page<Blog> blogList = blogRepository.findByPublishedDateOrderByPublishedDateDesc(pageable);
		
		        return blogList;
		
		    }
	public Page<Blog> getApprovedBlogsbyPageNumber(Integer pageNumber) {
        PageRequest request =
            new PageRequest(pageNumber - 1, 5, Sort.Direction.DESC, "publishedDate");
       
        return blogRepository.findByisApproved(true, request);
    }
	
	public Page<Blog> getApprovedBlogsbyCategory(String Category,Integer pageNumber) {
        PageRequest request =
            new PageRequest(pageNumber - 1, 5, Sort.Direction.DESC, "publishedDate");
       
        return blogRepository.findByisApprovedByCategory(Category, request);
    }
	
	public List<Blog> searchBlogs(String searchString) {
       
       
        return blogRepository.findBlogs(searchString);
    }
	
	public Page<Blog> getUnApprovedBlogsbyPageNumber(Integer pageNumber) {
        PageRequest request =
            new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "publishedDate");
        
        return blogRepository.findByisApproved(false, request);
    }

	
}