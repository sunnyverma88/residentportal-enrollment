package org.residentportal.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.Comment;
import org.residentportal.portal.entity.User;


	
	public interface CommentRepository extends JpaRepository<Comment, Integer>{
		
		List<Comment> findByBlog(Blog blog);
}
