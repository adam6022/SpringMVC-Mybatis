package com.zgadam.springmvc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �쳣���������Զ����ʵ����
 * @author Apple
 *
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		//obj ����ĳ���쳣�ĵط� ���� ����+����+���������βΣ� �ַ���
		//��־ 1.������tomcat war 2.������tomcat ��������Linux Log4j
		ModelAndView mav=new ModelAndView();
		String msg;
		//Ԥ���쳣
		if(e instanceof CustomerException) {
			CustomerException ce=(CustomerException)e;
			mav.addObject("error", ce.getMsg());
		}else {
			// ���������ʱ�쳣����ȡ�����ջ���Ӷ�ջ�л�ȡ�쳣��Ϣ
			Writer out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			e.printStackTrace(s);
			msg = out.toString();
			mav.addObject("error", msg);
		}
		mav.setViewName("error");
		return mav;
	}

}
