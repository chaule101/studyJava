package poly.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Login;


 
@Controller
public class LoginController {
 
	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login", "command", new Login());
	}
 
	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("login") Login login) {
 
		String userName = login.getUserName();
		String password = login.getPassword();
 
		if ("admin".equalsIgnoreCase(userName)
				&& "admin123".equalsIgnoreCase(password)) {
			ModelAndView mv = new ModelAndView("success");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("error");
			return mv;
		}
 
	}
}
	

//	@RequestMapping(value = "processLogin",  method = RequestMethod.GET )
//	public ModelAndView processLogin(@ModelAttribute("login") Login login) {
//	}


