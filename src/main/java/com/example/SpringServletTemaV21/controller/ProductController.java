package com.example.SpringServletTemaV21.controller;

import com.example.SpringServletTemaV21.database.ProductDAO;
import com.example.SpringServletTemaV21.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    int idUpdateSave=0;
    @Autowired
    private final ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    //get all
    @RequestMapping("/product")
    public String allview(Model model) {
        model.addAttribute("productList", buildProductList());
        return "product";
    }

    private List<Product> buildProductList() {
        List<Product> productList = new ArrayList<>();
        productList = productDAO.fiindAll();
        return productList;
    }
    //insert

    @GetMapping("/insert-form")
    public ModelAndView registerNewProduct(@RequestParam("nume") String name,
                                           @RequestParam("descriere") String description,
                                           @RequestParam("stoc") int stock,
                                           @RequestParam("pret") double price
    ) {
        ModelAndView modelAndView = new ModelAndView("insertProduct");
        try {
            productDAO.insertNewProduct(name, description, stock, price);
        } catch (Exception e) {
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("redirect:product");
    }
    @GetMapping("insertProduct")
    public ModelAndView registerProduct(){return new ModelAndView("insertProduct");}
    //delete product
    @GetMapping("/delete_product")
    public ModelAndView deleteProduct(@RequestParam("productId")int productID){
        ModelAndView modelAndView=new ModelAndView("product");

        List<Product>productList=productDAO.fiindAll();
        modelAndView.addObject("productList", productList);

        productDAO.deleteProduct(productID);
        return new ModelAndView("redirect:product");
    }
    //update product

    @GetMapping("/saveId")
    public ModelAndView updateProduct(@RequestParam("productId")int productId){
        ModelAndView modelAndView=new ModelAndView("product");
            idUpdateSave=productId;
        return new ModelAndView("redirect:updateProduct");
    }

    @GetMapping("/updateproduct")
    public ModelAndView updateProduct(@RequestParam("nume")String name,
                                      @RequestParam("descriere")String description,
                                      @RequestParam("stoc")int stock,
                                      @RequestParam("pret")double price){
        ModelAndView modelAndView=new ModelAndView("updateProduct");
        try {
            Product product=new Product();
            product.setId(idUpdateSave);
            product.setNameProduct(name);
            product.setDescriptionProduct(description);
            product.setStock(stock);
            product.setPrice(price);
            productDAO.uodateProduct(product);
        }catch (Exception e){
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("redirect:product");
    }
    @GetMapping("updateProduct")
    public ModelAndView editProduct(){return new ModelAndView("updateProduct");}

}
