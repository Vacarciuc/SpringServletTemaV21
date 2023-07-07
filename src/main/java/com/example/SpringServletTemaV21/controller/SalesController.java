package com.example.SpringServletTemaV21.controller;

import com.example.SpringServletTemaV21.database.BuyersDAO;
import com.example.SpringServletTemaV21.database.SalesDAO;
import com.example.SpringServletTemaV21.entities.Product;
import com.example.SpringServletTemaV21.entities.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class SalesController {
    @Autowired
    private final SalesDAO salesDAO;
    private final BuyersDAO buyersDAO;
    @Autowired
    public SalesController(SalesDAO salesDAO, BuyersDAO buyersDAO) {
        this.salesDAO = salesDAO;
        this.buyersDAO = buyersDAO;
    }
    @RequestMapping("/sales")
    public String allview(Model model) {
        model.addAttribute("productList", buildProductListForSales());
        return "sales";
    }

    private List<Product> buildProductListForSales() {
        List<Product> productList = new ArrayList<>();
        productList = salesDAO.fiindAll();
        return productList;
    }
    @GetMapping("/addToCart")
    public ModelAndView saveQuantity(@RequestParam("mySelect")int quantity,
                                    @RequestParam("productId")int productId){
        salesDAO.addToCart(productId, quantity);
    return new ModelAndView("redirect:sales");
    }

    @GetMapping("/allSales")
    public String viewAllSales(Model model){
        List<Sales>salesList=salesDAO.viewAll();
        model.addAttribute("salesList", salesList);
        return "allSales";
    }

}
