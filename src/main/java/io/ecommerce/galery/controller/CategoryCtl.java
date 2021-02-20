package io.ecommerce.galery.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.ecommerce.galery.entity.CategoryEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;
import io.ecommerce.galery.form.CategoryForm;
import io.ecommerce.galery.service.CategoryServiceInt;
import io.ecommerce.galery.util.DataUtility;



@Controller
@RequestMapping("/category")
public class CategoryCtl extends BaseCtl {

	@Autowired
	private CategoryServiceInt service;
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") CategoryForm form, Model model) {
		if (form.getId() > 0) {
			CategoryEntity bean=service.findByPk(id);
			form.populate(bean);
		}
		return "category-form";
	}
	
	@PostMapping
	public String submit(@RequestParam("image") MultipartFile file,@Valid @ModelAttribute("form")  CategoryForm form, BindingResult bindingResult,
			Model model) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:category";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "category-form";
				}
				
				CategoryEntity bean = (CategoryEntity) form.getBean();
				bean.setImage(file.getBytes());
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "Category update Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "Category Added Successfully!!!!");
				}
				return "category-form";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "category-form";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") CategoryForm form,
			@RequestParam(required = false) String operation,Long cidd,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/category/search";
		}

		
		if (OP_NEW.equals(operation)) {
			return "redirect:/category";
		}

		if (OP_DELETE.equals(operation)) {
			CategoryEntity cBean=new CategoryEntity();
			cBean.setId(DataUtility.getLong(String.valueOf(cidd)));
			service.delete(cBean);
		}
		CategoryEntity bean=(CategoryEntity)form.getBean();
		List<CategoryEntity> list =service.search(bean);
		model.addAttribute("list", list);
		
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}

		model.addAttribute("form", form);
		return "category-list";
	}
	
	@GetMapping("/getImage/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") Long id) throws Exception {
		response.setContentType("image/jpeg");

		Blob blb=service.getImageById(id);
		
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
}
