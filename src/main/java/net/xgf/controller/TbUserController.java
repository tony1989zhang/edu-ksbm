package net.xgf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.xgf.service.TbUserService;
import net.xgf.utils.FjnyResult;

@Controller
public class TbUserController {
	
	@Autowired
	private TbUserService tbUserService;
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public FjnyResult doLogin(HttpSession session,String username,String password){
		return tbUserService.doLogin( session,username, password);
	}
	
	
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request,HttpSession session) {
		session.removeAttribute("userInfo");
		return "login";
	}
}
