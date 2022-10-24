package com.poly.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticateInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(
            HttpServletRequest req,
            HttpServletResponse resp,
            Object handler
            ) throws IOException {
        HttpSession session = req.getSession();
        
        if(session.getAttribute("account") == null) {
            session.setAttribute("error", "Vui lòng đăng nhập nào!");
            resp.sendRedirect("/login");
        }
        return true;
    }
}
