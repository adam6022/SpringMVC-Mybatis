package com.zgadam.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor{

	// controllerִ�к�����ͼ���غ���ô˷���
	// ����ɵõ�ִ��controllerʱ���쳣��Ϣ
	// ����ɼ�¼������־
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor2....afterCompletion");
	}
	
	// controllerִ�к�δ������ͼǰ���ô˷���
	// ������ڷ����û�ǰ��ģ�����ݽ��мӹ���������������빫����Ϣ�Ա�ҳ����ʾ
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("HandlerInterceptor2....postHandle");
	}

	// Controllerִ��ǰ���ô˷���
	// ����true��ʾ����ִ�У�����false��ִֹ��
	// ������Լ����¼У�顢Ȩ�����ص�
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("HandlerInterceptor2....preHandle");
		return true;
	}

}
