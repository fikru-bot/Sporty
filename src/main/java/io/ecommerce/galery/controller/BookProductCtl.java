package io.ecommerce.galery.controller;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.ecommerce.galery.entity.BookProductEntity;
import io.ecommerce.galery.entity.CartEntity;
import io.ecommerce.galery.entity.UserEntity;
import io.ecommerce.galery.form.BookProductForm;
import io.ecommerce.galery.service.BookProductServiceInt;
import io.ecommerce.galery.service.CartServiceInt;
import io.ecommerce.galery.service.ProductServiceInt;
import io.ecommerce.galery.util.DataUtility;





@Controller
@RequestMapping("/bookProd")
public class BookProductCtl extends BaseCtl {

	@Autowired
	private ProductServiceInt productService;
	
	@Autowired
	private BookProductServiceInt service;
	
	@Autowired
	private CartServiceInt cartService;
	
	@GetMapping
	public String display(HttpSession session,@ModelAttribute("form") BookProductForm form, Model model) {
		
		CartEntity cbean = new CartEntity();
		UserEntity uBean=(UserEntity)session.getAttribute("userLogin");
		cbean.setUserId(uBean.getId());
		List<CartEntity> list = cartService.search(cbean);
		model.addAttribute("list", list);

		

		long totalprice=0;
		Iterator<CartEntity> it=list.iterator();
		while (it.hasNext()) {
			CartEntity cartEntity = (CartEntity) it.next();
			totalprice=totalprice+DataUtility.getLong(cartEntity.getPrice());
		}
		
		model.addAttribute("totalAmt", totalprice);
		
		form.setMobileNo(uBean.getMobileNo());
		form.setName(uBean.getFirstName()+" "+uBean.getLastName());
		return "book-product-form";
	}
	
	
	
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form") BookProductForm form, BindingResult bindingResult,
			Model model,HttpSession session) {
		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/prod/search";
		}
		
		System.out.println(form.getOperation());
		
		UserEntity uBean=(UserEntity)session.getAttribute("userLogin");
		form.setMobileNo(uBean.getMobileNo());
		form.setName(uBean.getFirstName()+" "+uBean.getLastName());
		BookProductEntity bean=(BookProductEntity)form.getBean();
		
		try {
			System.out.println("In Book Prod "+form.getOperation());
			if (OP_PAYMENT.equalsIgnoreCase(form.getOperation())) {
			
				System.out.println("Before"+form.getOperation());
				
				if (bindingResult.hasErrors()) {
					System.out.println(bindingResult);
					CartEntity cbean = new CartEntity();
					cbean.setUserId(uBean.getId());
					List<CartEntity> list = cartService.search(cbean);
					model.addAttribute("list", list);
					long totalprice=0;
					Iterator<CartEntity> it=list.iterator();
					while (it.hasNext()) {
						CartEntity cartEntity = (CartEntity) it.next();
						totalprice=totalprice+DataUtility.getLong(cartEntity.getPrice());
					}
					model.addAttribute("totalAmt", totalprice);
					return "book-product-form";
				}
				session.setAttribute("pBDetail",bean);
				return "payment";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "book-product-form";
		} 
		
		return "payment";
	}
	
	
	@PostMapping("/payment")
	public String submit(@RequestParam("operation") String operation, BookProductForm form,
			Model model,HttpSession session) {
		
		try {
			if (OP_CONFIRM_PAYMENT.equalsIgnoreCase(operation)) {
				
				CartEntity cbean = new CartEntity();
				UserEntity uBean=(UserEntity)session.getAttribute("userLogin");
				cbean.setUserId(uBean.getId());
				List<CartEntity> list = cartService.search(cbean);
				model.addAttribute("list", list);
				long totalprice=0;
				Iterator<CartEntity> it=list.iterator();
				while (it.hasNext()) {
					CartEntity cartEntity = (CartEntity) it.next();
					totalprice=totalprice+DataUtility.getLong(cartEntity.getPrice());
				}
				model.addAttribute("totalAmt", totalprice);
				
				BookProductEntity bean=(BookProductEntity)session.getAttribute("pBDetail");
				
				
				Iterator<CartEntity> iit=list.iterator();
				while (iit.hasNext()) {
					CartEntity cartEntity = (CartEntity) iit.next();
					bean.setProductId(cartEntity.getProductId());
					bean.setUserId(uBean.getId());
					bean.setDate(DataUtility.getCurrentTimestamp());
					bean.setAnmount(cartEntity.getPrice());
					bean.setProductName(cartEntity.getProductName());
					bean.setQuantity(cartEntity.getQuantity());
					service.add(bean);
					cartService.delete(cartEntity);
				}
				model.addAttribute("success","Product Booked Successfully!!");
			
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "payment";
		} 
		return "success";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BookProductForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/bookProd/search";
		}

		if (OP_DELETE.equals(operation)) {
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					BookProductEntity bean = new BookProductEntity();
					bean.setId(id);
					service.delete(bean);
				}
				model.addAttribute("success","Deleted Successfully!!!");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		
		BookProductEntity bean=(BookProductEntity)form.getBean();
		UserEntity uBean=(UserEntity)session.getAttribute("userLogin");
		if(uBean.getRoleId()==2) {
			bean.setUserId(uBean.getId());
		}
		List<BookProductEntity> list =service.search(bean);
		model.addAttribute("list", list);
		
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}
;
		model.addAttribute("form", form);
		return "book-product-list";
	}
	
}
