package org.github.mervyn.SSH.controller;



import org.github.mervyn.SSH.entity.User;
import org.github.mervyn.SSH.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller("HelloWorldController")
//@RequestMapping(value="/springMVCSpringHibernate-template")
//implements Controller
public class HelloWorldController {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/addUser.do")
	//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	public ModelAndView addUser(User user) { 
		logger.debug("进入handleRequest方法。");
		//1.收集参数、验证参数
		//2.绑定参数到命令行对象
		//User user = new User();
		//user.setUsername(request.getParameter("userName").trim());
		//3.将命令对象传入业务层进行逻辑处理
		userService.save(user);
		System.out.println("用户名："+user.getUsername());
		//4.选择下一个页面
		ModelAndView mav = new ModelAndView();
		//添加数据模型
		mav.addObject("message", user.getUsername());
		//设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面 
		mav.setViewName("index");  
	    return mav;  
	}

	

}
