package com.poly.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.modelDTO.CartItem;
import com.poly.service.CartService;
import com.poly.service.OrderDetailService;
import com.poly.service.OrderService;
import com.poly.service.ProductService;

@Controller
@RequestMapping("/home/order")
public class OrderController {

    @Autowired
    HttpServletRequest req;
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/showOrder")
    public String showOrder(
            Model model) {
        HttpSession session = req.getSession();
        Collection<CartItem> listCartItem = cartService.getCartItems();
        model.addAttribute("listCartItem", listCartItem);
        model.addAttribute("total", cartService.getAmount());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        session.setAttribute("date", sdf.format(date));
        model.addAttribute("NoOfItems", cartService.getCountQuantity());
        return "order/order_cart";
    }
//      Order of User
    @GetMapping("/showOrderByAccount")
    private String showOrderByAccount(
            Model model) {
        HttpSession session = req.getSession();
        Account a = (Account) session.getAttribute("account");
        List<Order> orders = orderService.listOrderByUsername(a.getUsername());
        model.addAttribute("listOrder", orders);
        return "order/listOrder";
    }

    @GetMapping("/admin/list-order")
    private String listOrder(
            Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("listOrder", orders);
        return "order/listOrder";
    }

//              Xoá trạng thái all order By Admin
    @GetMapping("/admin/list-order/delete")
    private String deleteListOrder(
//            @PathVariable("id") Order order
    ) {
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        Order order = orderService.findOrderByID(Integer.parseInt(id));
        System.out.println("hello 1");
        switch (action) {
            case "byadmin":
                System.out.println("hello");
                orderService.deleteOrder(order);
                return "redirect:/home/order/admin/list-order";
            case "byuser":
                orderService.deleteOrder(order);
                return "redirect:/home/order/showOrderByAccount";
            default:
                break;
        }
        return "redirect:/home";
    }

//  Xác nhận trạng thái order
    @PostMapping("/admin/list-order/confirmOrder/{id}")
    private String confirmOrder(
            @PathVariable("id") Order order) {
        orderService.confirmOrder(order);
        return "redirect:/home/order/admin/list-order";
    }

//  Xác nhận trạng thái pay order
    @PostMapping("/admin/list-order/payOrder/{id}")
    private String payOrder(
            @PathVariable("id") Order order) {
        orderService.payOrder(order);
        return "redirect:/home/order/admin/list-order";
    }

    @GetMapping("/showOrderByAccount/detailOrder/{id}")
    private String showOrderDetailByOrder(
            Model model,
            @PathVariable("id") Integer id) {
        List<OrderDetail> orderDetails = orderDetailService.listOrderDetailByOrder(id);
        model.addAttribute("listOrderDetail", orderDetails);
        return "order/listOrderDetail";
    }

    @PostMapping("/pay")
    public String pay(
            Model model) {
        HttpSession session = req.getSession();
        Collection<CartItem> listCart = cartService.getCartItems();
        if (listCart.size() <= 0) {
            session.setAttribute("orderDetail", "Xin mời chọn sản phẩm!");
            return "redirect:/home/order/showOrder";
        }
        String address = req.getParameter("address");
        Account account = (Account) session.getAttribute("account");

        // Order
        Date date = new Date();
        Order order = new Order();
        order.setAccount(account);
        order.setAddress(req.getParameter("address"));
        order.setCreateDate(date);
        orderService.save(order);

        // Order Detail
        List<Order> listOrders = orderService.findAll();
        Order orderId = listOrders.get(listOrders.size() - 1); // Lấy order object vừa thêm
        List<Product> products = productService.findAllProduct();
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        for (CartItem cartItem : listCart) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(orderId);
            for (Product p : products) {
                if (p.getId() == cartItem.getId()) {
                    orderDetail.setProduct(p);
                }
            }
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setPrice(cartItem.getPrice());
            listOrderDetail.add(orderDetail);
        }
        orderDetailService.save(listOrderDetail);
        cartService.clear(); // làm sạch giỏ hàng

        // Thông báo
        session.setAttribute("orderDetail", "Chúc Mừng Bạn Đã Mua Hàng Thành Công! \n"
                + "Xin mời tới trang lịch sử mua hàng để xác nhận \n"
                + "<a href=\"/home/order/showOrderByAccount"
                + "\" type=\"submit\"\r\n"
                + "class=\"btn btn-success text-white btn-outline-primary\">\r\n"
                + "Lịch Sử Order</a>");

        return "redirect:/home/order/showOrder";
    }
}
