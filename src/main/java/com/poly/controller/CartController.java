package com.poly.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.Product;
import com.poly.modelDTO.CartItem;
import com.poly.service.AccountService;
import com.poly.service.CartService;
import com.poly.service.ProductService;

@Controller
@RequestMapping("/shoppingCart")
public class CartController {
    @Autowired
    HttpServletRequest req;
    
    @Autowired
    ProductService productService;
    @Autowired 
    CartService cartService;
    @Autowired
    AccountService accountService;
    
    @GetMapping("/list")
    public String showCart(Model model) {
//        HttpSession session = req.getSession();
//        System.out.println(cartService.getAmount());
//        Account accountSession = (Account) session.getAttribute("account");
//        Account account = accountService.fillById(accountSession.getUsername());
        Collection<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", cartService.getAmount());
        System.out.println(cartService.getAmount());
        model.addAttribute("NoOfItems", cartService.getCountQuantity());
        return "shoppingCart";
    }
    
    @GetMapping("/add/{productId}")
    public String addCart(
            Model model,
            @PathVariable("productId") Integer productId
    ) {
        Product product = productService.findProductById(productId);
        if(product != null) {
            CartItem item = new CartItem();
            item.setId(productId);
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setImage(product.getImage());
            item.setQuantity(1);
            item.setAvailable(product.getAvailable());
            item.setCategoryId(product.getCategory().getId());
            cartService.add(item);
        }
        return "redirect:/shoppingCart/list";
    }
    
    @GetMapping("/delete/{id}")
    public String remove(
            @PathVariable("id") Integer id
            ) {
        System.out.println(id);
        cartService.remove(id);
        return "redirect:/shoppingCart/list";
    }
    
    @PostMapping("update")
    public String update(
            @RequestParam("productId") Integer productId,
            @RequestParam("quantity") Integer quantity
            ) {
        cartService.update(productId, quantity);
        return "redirect:/shoppingCart/list";
    }
    
    
    @GetMapping("clear")
    public String clear(Model model) {
        return "cart/list";
    }
}
