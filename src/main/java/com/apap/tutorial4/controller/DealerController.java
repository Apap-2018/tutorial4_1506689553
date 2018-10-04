package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.*;
import com.apap.tutorial4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private CarService carService;

    @RequestMapping("/")
    private String home() {
        return "home";
    }

    @RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute("dealer", new DealerModel());
        return "addDealer";
    }

    @RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
    private String addDealerSubmit(@ModelAttribute DealerModel dealer){
        dealerService.addDealer(dealer);
        return "add";
    }
    
    @RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
	private String viewDealer(String dealerId, Model model) {
    	DealerModel dealerModel = dealerService.getDealerDetailById(Long.parseLong(dealerId)).get();
		List<CarModel> carList = dealerModel.getListCar();
	
		model.addAttribute("listCar", carList);
		model.addAttribute("dealer", dealerModel);
		
		return "view-dealer";
    	
	}



}
