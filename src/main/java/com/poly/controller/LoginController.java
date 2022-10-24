package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.poly.Dao.AccountDao;
import com.poly.entity.Account;
import com.poly.modelDTO.AccountLoginDTO;
import com.poly.service.AccountService;
import com.poly.utilities.HashUlti;

@Controller
public class LoginController {
	@Autowired
	HttpServletRequest req;
	
	@Autowired 
	HttpSession session;
	
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountDao accountDao;
	@Autowired
	AccountLoginDTO accountLoginDTO;
	@GetMapping("/login")
	public String loginForm(Model model) {
	    session = req.getSession();
	    session.setAttribute("account", null);
	    model.addAttribute("AccountLoginDTO", new AccountLoginDTO());
		return "auth/login";
	}
	@PostMapping("login")
	public String login(
	        @Valid @ModelAttribute("AccountLoginDTO") AccountLoginDTO accountLoginDTO,
	        BindingResult result
	        ) {
	     
	    session = req.getSession();
	    if(result.hasErrors()) {
	        return "auth/login";
	    }
		List<Account> listAccount = accountService.fillAll();
		for (Account account : listAccount) {
			if(account.getUsername().equals(accountLoginDTO.getUsername()) &&
			   account.getPassword().equals(accountLoginDTO.getPassword())) {
				session.setAttribute("account", account);
				return "redirect:/home";
			}
		}
		session.setAttribute("errorLogin", "Đăng nhập thất bại!");
		return "auth/login";
	}
	@GetMapping("/logout")
	public String logout() {
	    session = req.getSession();
	    session.setAttribute("account", null);
        return "redirect:/login";
    }
	
//	@GetMapping("/login")
//	public String getLoginForm() {
//	    return "/auth/login";
//	}
//	
//	@PostMapping("/login")
//	public String login(
//	      @RequestParam("email") String email,
//	      @RequestParam("password") String password
//	) {
//	    HttpSession session = req.getSession();
//	    Account entity = this.accountDao.findByEmail(email);
//	    
//	    if(entity == null) {
//	        session.setAttribute("error", "Sai email hoặc mật khẩu!");
//            return "redirect:/login";
//	    }
//	    System.out.println(entity.getPassword());
//	    boolean checkPwd = HashUlti.verify(password, entity.getPassword());
//	   
//	    if(!checkPwd) {
//	        session.setAttribute("error", "Sai email hoặc mật khẩu!");
//	        return "redirect:/login";
//	    }
//	    System.out.println("ok");
//	    return "redirect:/home";
//	}
}
