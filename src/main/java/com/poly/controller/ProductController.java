package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Dao.CategoryDao;
import com.poly.Dao.ProductDao;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.mapper.ProductMapper;
import com.poly.modelDTO.ProductDTO;
import com.poly.service.ProductService;

@Controller
@RequestMapping("/home/product")
public class ProductController {
    @Autowired
    HttpServletRequest req;
    @Autowired
    ProductService pService;
    @Autowired
    ProductDao productDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping()
    public String showProduct(Model model) {
        List<Product> listProduct = pService.findAllProduct();
        model.addAttribute("listProduct", listProduct);
        return "product/list";
    }


    @GetMapping("/edit")
    public String updateFormProduct(
            Model model
    ) {
        String action = req.getParameter("action");
        String id = (req.getParameter("id"));
        switch (action) {
            case "AddOrEdit":
                model.addAttribute("listCategory", categoryDao.findAll());
                if (id == null) {
                    model.addAttribute("ProductDTO", new ProductDTO());
                } else {
                    Product product = pService.findProductById(Integer.parseInt(id));
                    ProductDTO productDTO = productMapper.convertToDTO(product);
                    model.addAttribute("ProductDTO", productDTO);
                }
                return "product/formProduct";
            case "Delete":
                Product product = pService.findProductById(Integer.parseInt(id));
                pService.delete(product);
                return "redirect:/home/product";
            default:
                break;
        }
        return "redirect:/home/product";
    }

    @PostMapping("/save")
    public String updateProduct(
            @Valid @ModelAttribute("ProductDTO") ProductDTO productDTO,
            BindingResult result,
            Model model
            
    ) {
        if(result.hasErrors()) {
            model.addAttribute("listCategory", categoryDao.findAll());
            return "product/formProduct";
        }
        Product product = productMapper.convertToEntity(productDTO);
        if (productDTO.getImage() == null || productDTO.getImage().equals("")) {
            product.setImage(req.getParameter("img"));
        }
        System.out.println(product.getName());
        pService.saveProduct(product);
        return "redirect:/home/product";
    }



    @GetMapping("/detail/{id}")
    public String showDetail(
            @PathVariable("id") Integer productId,
            Model model) {
        Product product = pService.findProductById(productId);
        model.addAttribute("product", product);
        List<Product> listProductByCategory = pService.findByCategoryId(product.getCategory().getId());
        model.addAttribute("listProductRelationShip", listProductByCategory);
        return "detailProduct";
    }
}

//          Dòng 45 form thêm sửa sản phẩm
//@GetMapping("edit/{id}")
//public String updateFormProduct(
//      Model model,
//      @PathVariable("id") Product product) {
//  model.addAttribute("listCategory", categoryDao.findAll());
//  ProductDTO pb = productMapper.convertToDTO(product);
//  model.addAttribute("ProductDTO", pb);
//  return "product/formProduct";
//}

//      Dòng 85 xóa sản phẩm
//@GetMapping("/delete/{id}")
//public String delete(
//      @PathVariable("id") Integer id) {
//  Product product = pService.findProductById(id);
//  pService.delete(product);
//  return "redirect:/home/product";
//}