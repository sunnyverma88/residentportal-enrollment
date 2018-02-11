package org.residentportal.portal.controller;

import java.util.List;

import org.residentportal.portal.entity.Blog;
import org.residentportal.portal.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.env.Environment;

@Controller
public class IndexController {
	@Autowired
	private BlogService bs;
	
	 @Autowired
	    private Environment environment;
	 
	 @Value("${author.name}")
	 String authorName;
	
	@RequestMapping("/index/{pageNumber}")
	public String indexHomePage(Model model,@PathVariable Integer pageNumber)
	{   
		
		Page<Blog> blogs=bs.getApprovedBlogsbyPageNumber(pageNumber);
		int current = blogs.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, blogs.getTotalPages());
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		model.addAttribute("blogs",blogs);
		return "index";
		
		}
		
	
	@RequestMapping(value= {"/index" ,"/"})
	public String index(Model model)
	{   System.out.println(authorName);
		return "index";
		}
	
	@RequestMapping(value= {"/dashboard"})
	public String dashboard(Model model)
	{   
		return "dashboard";
		}
	@RequestMapping(value = "/search" , method = RequestMethod.GET)
	public String searchbyPage(@RequestParam(value="searchString",required=false) String searchString, Model model) {
        System.out.println("Search string"+searchString);
	    if(searchString != null){
	    	List<Blog> blogs=bs.searchBlogs(searchString.toLowerCase());
	    	
			model.addAttribute("blogs",blogs);
			
	    }

	    return "search"; 
	}
	
	@RequestMapping("/category/{categoryStr}/{pn}")
	public String searchByCategory(@PathVariable("categoryStr")String categoryString, Model model,@PathVariable("pn") Integer pageNumber) {
        System.out.println("Search string"+categoryString);
	    if(categoryString != null){
	    	Page<Blog> blogs=bs.getApprovedBlogsbyCategory(categoryString.toLowerCase(),pageNumber);
	    	int current = blogs.getNumber() + 1;
		    int begin = Math.max(1, current - 5);
		    int end = Math.min(begin + 10, blogs.getTotalPages());
		    model.addAttribute("beginIndex", begin);
		    model.addAttribute("endIndex", end);
		    model.addAttribute("currentIndex", current);
			model.addAttribute("blogs",blogs);
			model.addAttribute("categoryStr", categoryString);
			
	    }

	    return "category"; 
	}
}