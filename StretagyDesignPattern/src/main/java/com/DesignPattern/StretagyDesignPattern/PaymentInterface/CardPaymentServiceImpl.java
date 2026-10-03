package com.DesignPattern.StretagyDesignPattern.PaymentInterface;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("cardPayment")
public class CardPaymentServiceImpl implements PaymentInterface{
    @Override
    public String payAmount(int payable) {
        return "Payment done via CardPayment Gateway";
    }
}
