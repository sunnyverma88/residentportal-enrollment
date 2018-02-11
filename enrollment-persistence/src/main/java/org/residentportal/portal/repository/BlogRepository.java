package org.residentportal.portal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	Page<Blog> findByUser(User user,Pageable pageable);
	List<Blog>  findByUser(User user);
	Page<Blog> findByPublishedDateOrderByPublishedDateDesc(Pageable pageable);
	 
	 Page<Blog> findByisApproved(Boolean bl,Pageable pageable);
	
	 @Query("SELECT b FROM Blog b WHERE b.isApproved=true and LOWER(b.category) = ?1")
	 Page<Blog> findByisApprovedByCategory(@Param("categoryStr")String category,Pageable pageable);
	 
	 @Transactional
	 @Query(value="SELECT * FROM Blog b WHERE b.isApproved=true and LOWER(b.name) like %?1%", 
			 nativeQuery = true)
	 List<Blog> findBlogs(@Param("searchString") String searchString);
	 
	 
	 @Modifying
	 @Transactional
	 @Query("update Blog b set b.isApproved = true where b.blogId = ?1")
	 void approveBlog(int id);
	 
	 
	 

}