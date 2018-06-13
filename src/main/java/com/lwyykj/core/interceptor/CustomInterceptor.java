package com.lwyykj.core.interceptor;

//import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lwyykj.common.Constants;

//import cn.itcast.common.utils.RequestUtils;
//import cn.itcast.core.service.user.SessionProvider;

/**
 * 拦截的是Controller层之前springMVC Handler处理器
 * 
 * @author john
 *
 */
public class CustomInterceptor implements HandlerInterceptor {
	// @Resource
	// private SessionProvider sessionProvider;
	// 执行controller之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 必须登录，判断是否判断
		HttpSession session = request.getSession(true);
		// String username =
		// sessionProvider.getAttributeForUsername(RequestUtils.getCSESSIONID(request,
		// response));
		// //放行true 不放行false
		// if(null== username){
		// //未登录不放行
		// //重定向到登录页面
		// response.sendRedirect("http://localhost:8082/login.aspx?returnUrl=http://localhost");
		// return false;
		// }
		// session中获取用户名信息
		Object obj = session.getAttribute(Constants.USER_NAME);
		if (obj == null || "".equals(obj.toString())) {
			// 设置跳转的页面
			response.sendRedirect(request.getSession().getServletContext().getContextPath() + Constants.LOGIN_URL);
			return false;
		}
		// 不为空就放行
		return true;
	}

	// 执行controller之后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	// 页面渲染后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
