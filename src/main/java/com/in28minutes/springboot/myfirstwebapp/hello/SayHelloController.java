package com.in28minutes.springboot.myfirstwebapp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	// say-hello => "Hello! Have a good day"
	
	// logger
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! Have a good day";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Hello</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>");
		sb.append("<p>");
		sb.append("Hello! Have a good day");
		sb.append("</p>");
		sb.append("</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	// JSP
	
	// To start using jsp, the jsp should be placed under, src/main/resources/META-INF/resources/WEB-INF/jsp/your_view.jsp
	// Also we setup prefix and suffix in application properties
	
	// When @ResponseBody is not used, spring directly return a jsp, i.e prefix/file
	
	// say-hello-jsp?name=edgar (accessing query parameters)
	
	// NOTE: In order to pass anything from Controller to View, we use Model
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp(@RequestParam String name,ModelMap model) {
		model.put("name", name);
		
		logger.debug(name);
		logger.info(name);
		logger.warn(name);
		
		return "hello";
	}
	
	// A controller returns the view name and a model
	// Then the front controller(dispatcher servlet) uses the view resolver to find the view
	// The code in view is executed and html response is sent
}
