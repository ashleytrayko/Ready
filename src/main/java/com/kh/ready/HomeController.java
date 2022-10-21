package com.kh.ready;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(Model model, Principal principal) {
		
		if(principal != null) {
			System.out.println("타입정보 : " + principal.getClass());
			System.out.println("ID : " + principal.getName());
		}
		
		model.addAttribute("principal", principal);
		
		return "home";
	}
	
}
