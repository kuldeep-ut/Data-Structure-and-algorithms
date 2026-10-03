package com.DesignPattern.StretagyDesignPattern.PaymentInterface;


import org.springframework.stereotype.Component;

@Component("upiPayment")
public class UpiPyamentServiceImpl implements PaymentInterface{
    @Override
    public String payAmount(int payable) {
         return "Payment done via Upi Gateway";
    }
}
