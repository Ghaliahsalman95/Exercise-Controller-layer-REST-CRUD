package com.example.banksystem.Controller;

import com.example.banksystem.APIResponse.ApiRespone;
import com.example.banksystem.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    //---------------

    ArrayList<Customer> customers = new ArrayList<>();

    //--------------------Get all the customers
    @GetMapping("/getAll")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //---------------------Add new customers
    @PostMapping("/addCustomer")
    public ApiRespone addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ApiRespone("added Successfully 200");
    }

    //-----------------------Update customers
    @PutMapping("/updateCustomer/{index}")
    public ApiRespone updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        if (index < customers.size()) {
            customers.set(index, customer);
            return new ApiRespone("Updated Successfully 200");
        } else return new ApiRespone("Index not Valid ");
    }

    //-----------------Delete customers
    @DeleteMapping("deleteCutomer/{index}")
    public ApiRespone deleteCustomer(@PathVariable int index) {
        if (index < customers.size()) {
            customers.remove(index);
            return new ApiRespone("Deleted Successfully 200");
        } else return new ApiRespone("Index not Valid ");
    }

    //-------------------Deposit money to customer
    @PutMapping("/deposit/{index}/{amount}")
    public ApiRespone deposit(@PathVariable int index, @PathVariable double amount) {
        if (index < customers.size()) {
            customers.get(index).setBalance(customers.get(index).getBalance() + amount);
            return new ApiRespone("Deposited Successfully 200");
        } else return new ApiRespone("Index not Valid ");

    }

    //-----------------Withdraw money from customers
    @PutMapping("/withdraw/{index}/{amount}")
    public ApiRespone withdraw(@PathVariable int index, @PathVariable double amount) {
        if (index < customers.size()) {
            if (customers.get(index).getBalance() >= amount) {
                customers.get(index).setBalance(customers.get(index).getBalance() - amount);
                return new ApiRespone("Withdraw Successfully 200");
            } else {
                return new ApiRespone("The Balance not enough");
            }
        } else return new ApiRespone("Index not Valid ");

    }
}
