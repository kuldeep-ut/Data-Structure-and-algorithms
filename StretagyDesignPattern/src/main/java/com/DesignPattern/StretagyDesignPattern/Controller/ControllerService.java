package com.DesignPattern.StretagyDesignPattern.Controller;

import com.DesignPattern.StretagyDesignPattern.Checkout.CheckOutInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class ControllerService {
    private final CheckOutInterface checkOutInterface;

    public ControllerService(CheckOutInterface checkOutInterface) {
        this.checkOutInterface = checkOutInterface;
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam String type, @RequestParam int amount){
        return checkOutInterface.checkout(type, amount);
    }

}
