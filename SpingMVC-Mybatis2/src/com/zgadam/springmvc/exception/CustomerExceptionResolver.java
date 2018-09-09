package com.zgadam.springmvc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器的自定义的实现类
 * @author Apple
 *
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		//obj 发生某个异常的地方 方法 包名+类名+方法名（形参） 字符串
		//日志 1.发布后tomcat war 2.发布的tomcat 服务器上Linux Log4j
		ModelAndView mav=new ModelAndView();
		String msg;
		//预期异常
		if(e instanceof CustomerException) {
			CustomerException ce=(CustomerException)e;
			mav.addObject("error", ce.getMsg());
		}else {
			// 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
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
