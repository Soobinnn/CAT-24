package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.cat24.service.UsersService;
import com.cafe24.cat24.vo.UsersVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	/*@Autowired
	private UsersService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("------->");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		ApplicationContext ac = 
//		WebApplicationContextUtils.
//		getWebApplicationContext(request.getServletContext());
//		UserService userService = ac.getBean(UserService.class);
		
		UsersVo userVo = new UsersVo();
		userVo.setEmail(email);
		userVo.setPassword(password);
		
		UsersVo authUser = userService.getUser(userVo);
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// session 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect( request.getContextPath() );

		return false;
	}*/

}
