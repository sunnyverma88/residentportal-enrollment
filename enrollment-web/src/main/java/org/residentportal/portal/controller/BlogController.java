package org.residentportal.portal.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.entity.Comment;
import org.residentportal.portal.entity.Document;
import org.residentportal.portal.entity.User;
import org.residentportal.portal.service.BlogService;
import org.residentportal.portal.service.CommentService;
import org.residentportal.portal.service.DocumentService;
import org.residentportal.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

	@Autowired
	private UserService us;
	
	@Autowired
	private BlogService bs;
	
	@Autowired
	private CommentService cs;
	
	@Autowired
	private DocumentService ds;
	
	
	@ModelAttribute
	public User constructUser()
	{
		return new User();
	}
	@ModelAttribute
	public Blog constructBlog()
	{
		return new Blog();
	}
	@ModelAttribute
	public Comment constructComment()
	{
		return new Comment();
	}
	@ModelAttribute("document") 
	public Document constructDocument()
	{
		return new Document();
	}
	

	@RequestMapping("/account/{pageNumber}")
	public String showAccount(Model model,Principal principal,@PathVariable Integer pageNumber)
	{
		model.addAttribute("user",us.findOneWithBlogsbyEmail(principal.getName()));
		Page<Blog> userblogs=bs.getBlogsbyUser(us.findOneWithBlogsbyEmail(principal.getName()),pageNumber);
		int current = userblogs.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, userblogs.getTotalPages());
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		model.addAttribute("blogs",userblogs);
		return "account";
		
	}
	
	@RequestMapping(value="/account/{pageNumber}",method=RequestMethod.POST)
	public String doAddBlog(@Valid @ModelAttribute("blog")Blog blog,Principal principal,BindingResult result,Model model,RedirectAttributes rdr,@PathVariable Integer pageNumber)
	{   
		if(result.hasErrors())
		{   
		    System.out.println("Isnide Error "+result.getAllErrors().toString());
			return "redirect:/account/"+pageNumber;
			
		}
		String email=principal.getName();
		System.out.println("inside save blog");
		blog.setApproved(false);
		bs.save(blog,email);
		rdr.addFlashAttribute("message", "Thanks for submitting the Blog.It will be reviewed by the admin and then posted on the site");
		return "redirect:/account/"+pageNumber; 
		
	}
	
	
	@RequestMapping(value="/unapproved/{pageNumber}")
	public String unapprovedBlogs(Model model,@PathVariable Integer pageNumber)
	{   
		Page<Blog> blogs=bs.getUnApprovedBlogsbyPageNumber(pageNumber);
		int current = blogs.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, blogs.getTotalPages());
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		model.addAttribute("blogs",blogs);
		return "unapproved";
	}
	
	@RequestMapping(value="/unapproved")
	public String unapprovedBlogsHome(Model model)
	{  
		return unapprovedBlogs(model,1);
	}
	
	@RequestMapping(value="/blog/remove/{userId}/{id}")
	public String removeBlog(Model model,@PathVariable("id") int id ,@PathVariable("userId") int userId)
	{   Blog blog=bs.findOne(id);
		bs.delete(blog);
		return "redirect:/account/"+userId;
	}
	
	@RequestMapping(value="/blog/approve/{id}")
	public String approveBlog(Model model,@PathVariable("id") int id)
	{   
	    
		bs.approveBlog(id);
		return "redirect:/unapproved";
	}
	
	@RequestMapping(value="/blog/{id}" ,method=RequestMethod.GET)
	public String blogWithId(Model model,@PathVariable("id") int id)
	{   
		Blog blog= bs.findOne(id);
		List<Comment> comments=cs.findByBlogId(id);
		List<Document> documents=ds.findByBlogId(id);
		model.addAttribute("blog", blog);
		model.addAttribute("comments", comments);
		model.addAttribute("documents", documents);
		return "blog";
	}
	
	@RequestMapping(value="/blog/edit/{id}")
	public String editBlogWithId(Model model,@PathVariable("id") int id)
	{   
		Blog blog= bs.findOne(id);
		model.addAttribute("blog", blog);
		return "editblog";
	}
	
	@RequestMapping(value="/blog/edit/{id}" ,method=RequestMethod.POST)
	public String editBlogWithIdSucess(Model model,@ModelAttribute("blog")Blog blog,@PathVariable("id") int id)
	{   boolean response;
		Blog tmpblog= bs.findOne(id);
		System.out.println("test"+blog.getName());
		tmpblog.setName(blog.getName());
		tmpblog.setDescription(blog.getDescription());
		tmpblog.setUrl(blog.getUrl());
		tmpblog.setCategory(blog.getCategory());
		tmpblog.setVurl(blog.getVurl());
		bs.update(tmpblog);
		response=true;
	    return "redirect:/blog/edit/"+id+"?success="+response;
	}
	
}