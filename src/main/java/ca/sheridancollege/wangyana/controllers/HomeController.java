package ca.sheridancollege.wangyana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.wangyana.beans.Customer;
import ca.sheridancollege.wangyana.database.DatabaseAccess;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private DatabaseAccess da;

    // method to load index.html
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // method to load addCustomer.html
    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        prepareModel(model);
        return "addCustomer";
    }

    // method to add Customer to database and reload addCustomer.html
    @PostMapping("/addCustomer")
    public String addCustomer(Model model, @ModelAttribute Customer customer) {
        da.addCustomer(customer.getCustName(), customer.getCustAddress(),
                customer.getCustRegion(), customer.getCustCountry());
        prepareModel(model);
        return "addCustomer";
    }

    // method to search Customers from database and load searchCustomers.html
    @GetMapping("/searchCustomers")
    public String searchCustomers(Model model,
            @RequestParam(name = "custRegion", required = false, defaultValue = "All") String custRegion) {

        List<Customer> customerList = da.getCustomerList();
        model.addAttribute("regions", da.getRegionList());
        if ("All".equals(custRegion) || custRegion.isEmpty()) {
            model.addAttribute("customerList", customerList);
        } else {
            model.addAttribute("customerList",
                    customerList.stream()
                            .filter(c -> c.getCustRegion().equals(custRegion))
                            .toList());
        }
        model.addAttribute("selectedRegion", custRegion);
        return "searchCustomers";
    }

    // method to reset form fields
    void prepareModel(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("regions", da.getRegionList());
        model.addAttribute("customerList", da.getCustomerList());
    }

}
