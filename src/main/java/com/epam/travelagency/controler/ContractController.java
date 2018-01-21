package com.epam.travelagency.controler;

import com.epam.travelagency.entity.Contract;
import com.epam.travelagency.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    private ContractServiceImpl contractService;

    @Autowired
    private TourServiceImpl tourService;

    @Autowired
    private DiscountServiceImpl discountService;

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String getContracts(Model model, Authentication authentication) {
        //model.addAttribute("order", new Contract());
        model.addAttribute("orders", contractService.getContractByCustomerLogin(authentication.getName()));
        return "contracts";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String saveContract(@ModelAttribute Contract contract,
                               @RequestParam("id") Long id, Authentication authentication) {
        contract.setDate(contractService.getContractById(1L).getDate());
        contract.setStatus("IN_PROCESS");
/*        for (GrantedAuthority authority : authentication.getAuthorities()) {
            authentication.getName().get;
        }*/
        contract.setCustomer(customerService.getCustomerByLogin(authentication.getName()));
        contract.setPayment(contractService.getContractById(1L).getPayment());
        contract.setDiscount(discountService.getDiscountById(1L));
        contract.setTour(tourService.getTourById(id));
        contractService.save(contract);
        return "redirect:/contracts";
    }

}
