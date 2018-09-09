package com.zgadam.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor{

	// controllerִ�к�����ͼ���غ���ô˷���
	// ����ɵõ�ִ��controllerʱ���쳣��Ϣ
	// ����ɼ�¼������־
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor1....afterCompletion");
	}
	
	// controllerִ�к�δ������ͼǰ���ô˷���
	// ������ڷ����û�ǰ��ģ�����ݽ��мӹ���������������빫����Ϣ�Ա�ҳ����ʾ
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("HandlerInterceptor1....postHandle");
	}

	// Controllerִ��ǰ���ô˷���
	// ����true��ʾ����ִ�У�����false��ִֹ��
	// ������Լ����¼У�顢Ȩ�����ص�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("HandlerInterceptor1....preHandle");
		HttpSession session=request.getSession();
		Object username = session.getAttribute("username");
		String url = request.getRequestURI();
		if(!url.contains("/toLogin")) {
			if(username == null) {
				response.sendRedirect(request.getContextPath()+"/user/toLogin.action");
				return false;
			}
		}
		return true;
	}

}
