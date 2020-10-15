package com.blogIn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
    private EsBlogService esBlogService;
	@GetMapping
	public String listEsBlogs(
			@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="keyword",required=false,defaultValue="" ) String keyword,
			@RequestParam(value="async",required=false) boolean async,
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
			Model model) {
 
		Page<EsBlog> page = null;
		List<EsBlog> list = null;
		boolean isEmpty = true; // no data at initialization
		try {
			if (order.equals("hot")) { // serch the most popular posts
				Sort sort = new Sort(Direction.DESC,"readSize","commentSize","voteSize","createTime"); 
				Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
				page = esBlogService.listHotestEsBlogs(keyword, pageable);
			} else if (order.equals("new")) { // find the latest posts
				Sort sort = new Sort(Direction.DESC,"createTime"); 
				Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
				page = esBlogService.listNewestEsBlogs(keyword, pageable);
			}
			
			isEmpty = false;
		} catch (Exception e) {
			Pageable pageable = new PageRequest(pageIndex, pageSize);
			page = esBlogService.listEsBlogs(pageable);
		}  
 
		list = page.getContent();	// data list of the current page
 

		model.addAttribute("order", order);
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		model.addAttribute("blogList", list);
		
		// Load at the first time
		if (!async && !isEmpty) {
			List<EsBlog> newest = esBlogService.listTop5NewestEsBlogs();
			model.addAttribute("newest", newest);
			List<EsBlog> hotest = esBlogService.listTop5HotestEsBlogs();
			model.addAttribute("hotest", hotest);
			List<TagVO> tags = esBlogService.listTop30Tags();
			model.addAttribute("tags", tags);
			List<User> users = esBlogService.listTop12Users();
			model.addAttribute("users", users);
		}
		
		return (async==true?"/index :: #mainContainerRepleace":"/index");
	}
 
	@GetMapping("/newest")
	public String listNewestEsBlogs(Model model) {
		List<EsBlog> newest = esBlogService.listTop5NewestEsBlogs();
		model.addAttribute("newest", newest);
		return "newest";
	}
	
	@GetMapping("/hotest")
	public String listHotestEsBlogs(Model model) {
		List<EsBlog> hotest = esBlogService.listTop5HotestEsBlogs();
		model.addAttribute("hotest", hotest);
		return "hotest";
	}
	

}
