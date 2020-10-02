package com.sv.ar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value =  { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView  model= new ModelAndView();
		model.setViewName("homePage");
		return model;
	}

	@RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
	public String contactusPage(Model model) {
		model.addAttribute("address", "Vietnam");
		model.addAttribute("phone", "...");
		model.addAttribute("email", "...");
		return "contactusPage";
	}

}
