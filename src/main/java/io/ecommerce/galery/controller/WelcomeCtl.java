package io.ecommerce.galery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.ecommerce.galery.entity.CategoryEntity;
import io.ecommerce.galery.form.CategoryForm;
import io.ecommerce.galery.service.CategoryServiceInt;


@Controller
public class WelcomeCtl extends BaseCtl {

	@Autowired
	private CategoryServiceInt service;
	
	@GetMapping("/welcome")
	public String getWelcome(@ModelAttribute("form") CategoryForm form,Model model) {
		CategoryEntity bean=(CategoryEntity)form.getBean();
		List<CategoryEntity> list =service.search(bean);
		model.addAttribute("list", list);
		model.addAttribute("form",form);
		
		if (list.size() == 0) {
			model.addAttribute("error","Record not found");
		}
		return "welcome";
	}
	@GetMapping("/adminheader")
	public String getAdminHeader(@ModelAttribute("form") CategoryForm form,Model model) {
		CategoryEntity bean=(CategoryEntity)form.getBean();
		List<CategoryEntity> list =service.search(bean);
		model.addAttribute("list", list);
		model.addAttribute("form",form);
		return "adminheader";
	}
	@GetMapping("/userheader")
	public String getUserHeader(@ModelAttribute("form") CategoryForm form,Model model) {
		CategoryEntity bean=(CategoryEntity)form.getBean();
		List<CategoryEntity> list =service.search(bean);
		model.addAttribute("list", list);
		model.addAttribute("form",form);
		return "userheader";
	}
	
}
