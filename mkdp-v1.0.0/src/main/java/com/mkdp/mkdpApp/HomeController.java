package com.mkdp.mkdpApp;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//프로퍼티 읽는로직
		InputStream is = getClass().getResourceAsStream("/env/system.properties");
		System.out.println(getClass().getResourceAsStream("/env/system.properties"));//getClass : com.mkdp.mkdpApp.HomeController
		 
		
		Properties props = new Properties();
		
		try {
			props.load(is);
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(props.get("system.password"));
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)//get 
	public String loginForm() {
		System.out.println("TestController.loginForm get");
		return "loginForm";//viewResolver
		// /WEB-INF/views/   loginForm   .jsp 
	}
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)//
	public String login() {
		System.out.println("TestController.login Post");
		return "login";//login.jsp
	}
	
}
