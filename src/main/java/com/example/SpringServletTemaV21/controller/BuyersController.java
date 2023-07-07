package com.example.SpringServletTemaV21.controller;

import com.example.SpringServletTemaV21.database.BuyersDAO;
import com.example.SpringServletTemaV21.entities.Buyers;
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
public class BuyersController {
    int idOfBuyers=0;
    @Autowired
    private final BuyersDAO buyersDAO;
    @Autowired
    public BuyersController(BuyersDAO buyersDAO) {
        this.buyersDAO = buyersDAO;
    }


    @RequestMapping("/buyers")
    public String allviewBuyers(Model model) {
        model.addAttribute("buyerList", buildBuyersList());
        return "buyers";
    }
    private List<Buyers> buildBuyersList() {
        List<Buyers> buyersList = new ArrayList<>();
        buyersList = buyersDAO.findAll();
        return buyersList;
    }
    //insert buyers..............
    @GetMapping("/insert_buyers")
    public ModelAndView registerNewBuyers(@RequestParam("nume")String name,
                                          @RequestParam("adresa")String addressa
    ){
        ModelAndView modelAndView=new ModelAndView("insertBuyers");
        buyersDAO.insertNewBuyers(name, addressa);
        return new ModelAndView("redirect:buyers");
    }
    @GetMapping("insertBuyers")
    public ModelAndView registerBuyers(){
        return new ModelAndView("insertBuyers");
    }
    //update buyers.............
    @GetMapping("/getIdFromUpdateBuyers")
    public ModelAndView saveIdFromBuyers(@RequestParam("idBuyers") int idBuyers){
        ModelAndView modelAndView=new ModelAndView("buyers");
        idOfBuyers=idBuyers;
        return new ModelAndView("redirect:updateBuyers");
    }
    //second function for update
    @GetMapping("update_fromBuyers")
    public ModelAndView updateBuyers(@RequestParam("nume")String name,
                                     @RequestParam("adresa")String address){
        Buyers buyers=new Buyers();
        buyers.setId(idOfBuyers);
        buyers.setNameClient(name);
        buyers.setAddress(address);
        buyersDAO.updateBuyers(buyers);
        return new ModelAndView("redirect:buyers");
    }
    @GetMapping("updateBuyers")
    public ModelAndView editBuyersList(){
        return new ModelAndView("updateBuyers");
    }
    //delete buyers.........
    @GetMapping("/delete_buyers")
    public ModelAndView deleteBuyers(@RequestParam("idBuyers")int idBuyers){
        ModelAndView modelAndView=new ModelAndView("buyers");
        buyersDAO.deleteBuyers(idBuyers);
        return new ModelAndView("redirect:buyers");
    }
}
