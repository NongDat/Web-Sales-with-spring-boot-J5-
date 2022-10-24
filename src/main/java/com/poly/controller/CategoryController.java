package com.poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Dao.CategoryDao;
import com.poly.entity.Category;
import com.poly.service.CategoryService;
import com.poly.service.ProductService;

@Controller
//@RequestMapping("home/category")
public class CategoryController {
    @Autowired
    HttpServletRequest req;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("home/category/{id}")
    public String getProductByCategory(
            Model model,
            @PathVariable("id") String id) {
//        String sortBy = req.getParameter("sort_by");
//        String sortDirection = req.getParameter("sort_direction");
//        String pageParam = req.getParameter("page");
//        String limitParam = req.getParameter("limit");
//        String sortField = sortBy == null ? "id" : sortBy;
//        Sort sort = (sortDirection == null || sortDirection.equals("asc")) ?
//                    Sort.by(Direction.ASC, sortField) :
//                    Sort.by(Direction.DESC, sortField);
//        int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
//        int limit = limitParam == null ? 10 : Integer.parseInt(limitParam);
//        
//        Pageable pageable = PageRequest.of(page, limit, sort);
//        Page pageData = (Page) this.productService.findByCategoryId(id);
        model.addAttribute("listProduct", productService.findByCategoryId(id));
        List<Category> listCategory = categoryService.fillAllCategory();

        model.addAttribute("listCategory", listCategory);
        return "category/listCategory";
    }

}
