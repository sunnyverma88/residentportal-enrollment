package org.residentportal.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.Document;


	
	public interface DocumentRepository extends JpaRepository<Document, Integer>{
		
		List<Document> findByBlog(Blog blog);
		Document findById(Integer id);
}
