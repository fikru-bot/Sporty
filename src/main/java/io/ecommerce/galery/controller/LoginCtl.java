package io.ecommerce.galery.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.ecommerce.galery.entity.UserEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;
import io.ecommerce.galery.form.LoginForm;
import io.ecommerce.galery.form.UserRegistrationForm;
import io.ecommerce.galery.service.UserServiceInt;
import io.ecommerce.galery.util.DataUtility;



@Controller
public class LoginCtl extends BaseCtl {

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";
	protected static final String OP_rese = "Logout";

	@Autowired
	private UserServiceInt service;

	@GetMapping("/login")
	public String display(@RequestParam(required = false) Long pid,@ModelAttribute("form") LoginForm form, HttpSession session, Model model) {

		System.out.println("In doget LoginCtl");

		if(DataUtility.getLong(String.valueOf(pid))>0) {
			session.setAttribute("PID",pid);
		}
		
		if (session.getAttribute("userLogin") != null) {
			session.invalidate();
			model.addAttribute("success", "You have logout Successfully!!!");
		}
		return "login";
	}

	@PostMapping("/login")
	public String display(@RequestParam String operation, HttpSession session,
			@Valid @ModelAttribute("form") LoginForm form, BindingResult result, Model model) {

		System.out.println("In dopost  LoginCtl");

		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:signUp";
		}
		
		
		if (result.hasErrors()) {
			System.out.println(result);
			return "login";
		}

		

		UserEntity bean = service.authenticate((UserEntity) form.getBean());
			
		if (bean != null) {
			System.out.println(bean.toString());
			session.setAttribute("userLogin", bean);
			Long pid=DataUtility.getLong(String.valueOf(session.getAttribute("PID")));
			if(bean.getRoleId()==2) {
			if(pid>0) {
				return "redirect:/prod/detail?pid="+pid;	
			}
			}else if(bean.getRoleId()==1) {
				return "redirect:/adminheader";
			}
			return "redirect:/userheader";
			
		}
		
		model.addAttribute("error", "Login Id Password Invalid");
		return "login";
	}
	

	@GetMapping("/signUp")
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		model.addAttribute("genderMap", genderMap);
		return "user-registration";
	}

	@PostMapping("/signUp")
	public String submit(@RequestParam String operation,@Valid @ModelAttribute("form") UserRegistrationForm form, BindingResult bindingResult,
			Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:signUp";
		}
		
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		model.addAttribute("genderMap", genderMap);

		try {
			if (OP_SAVE.equalsIgnoreCase(operation)) {
				System.out.println("in Save");
				if (bindingResult.hasErrors()) {
					System.out.println(bindingResult);
					return "user-registration";
				}
				
				UserEntity bean = (UserEntity) form.getBean();
				System.out.println(bean.toString());
				bean.setRoleId(2L);
				service.registerUser(bean);
				model.addAttribute("success", "User Registerd Successfully!!!!");
				return "user-registration";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "user-registration";
		}
		return "";
	}

}