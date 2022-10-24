package com.poly.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.mapper.AccountMapper;
import com.poly.modelDTO.AccountDTO;
import com.poly.service.AccountService;
import com.poly.service.OrderService;

@Controller
@RequestMapping("/home/account") 
public class AccountController {

    @Autowired
    HttpServletRequest req;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountDTO accountDTO;
    @Autowired
    OrderService orderService;

    @GetMapping("/listAccount")
    public String showAccounts(
            Model model) {
        model.addAttribute("listAccount", accountService.fillAll());
        return "account/listAccount";
    }

//    @GetMapping("/EditProfile/{username}")
//    public String myAccount(
//            @PathVariable("username") String username,
//            Model model) {
//        HttpSession session = req.getSession();
//        Account account = accountService.fillById(username);
//        AccountDTO accountDTO = accountMapper.convertToDTO(account);
//        model.addAttribute("AccountDTO", accountDTO);
//        return "account";
//    }

//
    @GetMapping("/EditProfile")
    public String editAccount(
            Model model
        ) {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        String username = req.getParameter("username");
        switch (action) {
            case "AddOrEdit":
                if (username == null) {
                    model.addAttribute("AccountDTO", new AccountDTO());
                } else {
                    Account account = accountService.fillById(username);
                    AccountDTO accountDTO = accountMapper.convertToDTO(account);
                    model.addAttribute("AccountDTO", accountDTO);
                }
                break;
            case "Delete":
                List<Order> orders = orderService.findAll();
                Account account = accountService.fillById(username);
                for (Order order : orders) {
                    if (order.getAccount() == account) {
                        session.setAttribute("errorAcount", "Không thể xóa tài khoản đã đặt hàng");
                        return "redirect:/home/account/listAccount";
                    }
                }
                session.setAttribute("errorAcount", "Xóa tài khoản thành công!");
                accountService.delete(account);
                return "redirect:/home/account/listAccount";
            default:
                break;
        }

        return "account/accountProfile";
    }

    @GetMapping("/newAccount")
    public String showFormNewACcount(
            Model model) {
        model.addAttribute("AccountDTO", new AccountDTO());
        return "account/accountProfile";
    }

//    @PostMapping("/newAccount")
//    public String addCcount(
//            Model model,
//            @ModelAttribute("AccountDTO") AccountDTO accountDTO) {
//        Account account = accountMapper.convertToEntity(accountDTO);
//        accountService.save(account);
//        return "account";
//    }

    @PostMapping("/Save")
    public String UpdateAccount(
            Model model,
            @Valid @ModelAttribute("AccountDTO") AccountDTO accountDTO,
            BindingResult result
    ) {
        HttpSession session = req.getSession();
       
        System.out.println("img: " + req.getParameter("img"));
        if(accountDTO.getPhoto() == null || accountDTO.getPhoto().equals("")) {
            accountDTO.setPhoto(req.getParameter("img"));
            
        }
        if(result.hasErrors()) {
            return "account/accountProfile";
        }
        Account account = accountMapper.convertToEntity(accountDTO);
        accountService.update(account);
        Account accountLoginning = (Account) session.getAttribute("account");
        if(accountLoginning.getUsername().equals(account.getUsername()) ) {
        session.setAttribute("account", account);
        }
        return "redirect:/home/account/listAccount";
    }

    @GetMapping("/register")
    public String register(
            Model model
            ) {
        model.addAttribute("AccountDTO", new AccountDTO());
        return "account/register";
    }
    
    @PostMapping("/register")
    public String saveRegister(
            Model model,
            @Valid @ModelAttribute("AccountDTO") AccountDTO accountDTO,
            BindingResult result
    ) {
        HttpSession session = req.getSession();
        
        if(result.hasErrors()) {
            System.err.println("hello  có lỗi");
            return "account/register";
        }
        List<Account> accounts = accountService.fillAll();
        for (Account account : accounts) {
            if(account.getUsername().equals(accountDTO.getUsername()) ||
               account.getEmail().equals(accountDTO.getEmail())
            ) {
                session.setAttribute("msgRegister", "Tài khoản/ email đã được sử dụng!");
                model.addAttribute("AccountDTO", new AccountDTO());
                return "redirect:/home/account/register";
            }
        }
        Account account = accountMapper.convertToEntity(accountDTO);
        accountService.save(account);
        model.addAttribute("AccountDTO", new AccountDTO());
        session.setAttribute("msgRegister", "Chúc mừng bạn đã đăng ký thành công!");
        return "redirect:/home/account/register";
    }
    
    
    
//    @GetMapping("/delete/{username}")
//    public String deleteAccount(
//            Model model,
//            @PathVariable("username") Account account) {
//        HttpSession session = req.getSession();
//        List<Order> orders = orderService.findAll();
//        for (Order order : orders) {
//            if (order.getAccount() == account) {
//                session.setAttribute("errorAcount", "Không thể xóa tài khoản đã đặt hàng");
//                return "redirect:/home/account/listAccount";
//            }
//        }
//        accountService.delete(account);
//        return "redirect:/home/account/listAccount";
//    }
}
