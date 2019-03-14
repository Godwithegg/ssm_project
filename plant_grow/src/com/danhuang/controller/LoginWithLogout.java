package com.danhuang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danhuang.crop.ClientCustom;
import com.danhuang.service.StatusService;

@Controller
public class LoginWithLogout
{
	@Autowired
	private StatusService statusService;

	//登陆
	@RequestMapping("/login")
	public String doLogin(HttpSession session,String username,String password) throws Exception
	{
		if(statusService.findPasswordByUsername(username)==null)return "login";
		
		if(statusService.findPasswordByUsername(username).equals(password))
		{
			session.setAttribute("username", username);
			return "redirect:crop/queryStatus.action";
		}
	
		session.invalidate();
		
		//重定向到商品列表页面
		return "login";
	}
	
	@RequestMapping("/register")
	public String doRegister(HttpSession session,String username, String password) throws Exception
	{
		ClientCustom clientCustom = new ClientCustom();
		clientCustom.setUsername(username);
		clientCustom.setPassword(password);
		System.out.println(username);
		statusService.insertNewUser(clientCustom);
		return "login";
	}
	
	//退出
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) throws Exception
	{
		//清除session用户的登陆状态
		session.invalidate();
		
		//重定向到登陆页面
		//return "redirect:crop/queryStatus.action";
		return "redirect:login.action";
	}
}
