package com.DesignPattern.StretagyDesignPattern.Checkout;

import com.DesignPattern.StretagyDesignPattern.PaymentInterface.PaymentInterface;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckOutService implements CheckOutInterface{
    private final Map<String, PaymentInterface> strategies;

    public CheckOutService(Map<String, PaymentInterface> paymentInterface) {
        this.strategies = paymentInterface;
    }

    @Override
    public String checkout(String type, int amount) {
        PaymentInterface paymentInterface = strategies.get(type);
        if(paymentInterface == null){
            return "Payment method not defined";
        } else {
            return paymentInterface.payAmount(amount);
        }
    }
}
