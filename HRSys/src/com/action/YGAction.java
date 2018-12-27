package com.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Yuangong;
import com.opensymphony.xwork2.ActionSupport;
import com.service.YuangongService;

@Namespace("/")
public class YGAction extends ActionSupport implements ServletRequestAware {
	@Autowired
	private YuangongService ygservice;
	
	private Yuangong yg;
	
	public Yuangong getYg() {
		return yg;
	}
	public void setYg(Yuangong yg) {
		this.yg = yg;
	}
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	
	
	@Action(value="getyg",results={@Result(location="/getyg.jsp"),
			@Result(name="error",location="/index.jsp")})
	public String getuser(){
		List<Yuangong> yglist = ygservice.getYg();
		System.out.println(yglist.size());
		session.setAttribute("yglist", yglist);
		if(yglist.size()>0)
		return SUCCESS;
		else
			return ERROR;
	}
	
	@Action(value="addyh",results={@Result(location="/getyg.jsp")})
	public String adduser(){
		ygservice.addYuangong(yg);
		return getuser();
	}
	@Action(value="getbyname",results={@Result(location="/getbyname.jsp")})
	public String getbyname(){
		List<Yuangong> ygnlist = ygservice.getygByname(yg);
		session.setAttribute("ygnlist", ygnlist);
		return SUCCESS;
	}
	
	@Action(value="deleteById",results= {@Result(location="/getyg.jsp")})
	public String deleteById() {
		System.out.println(yg.getAttendld());
		ygservice.deleteById(yg);
		return getuser();
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
		this.application = session.getServletContext();
	}
	
}
