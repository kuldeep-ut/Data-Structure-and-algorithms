package com.DesignPattern.StretagyDesignPattern.PaymentInterface;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("payPal")
public class PayPalPaymentServiceImpl implements PaymentInterface{
    @Override
    public String payAmount(int payable) {
        return "Payment done via PayPal Gateway";
    }
}
