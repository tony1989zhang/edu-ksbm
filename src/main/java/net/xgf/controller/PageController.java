package net.xgf.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		System.out.println("page:" + page);
		return page;
	}
}
