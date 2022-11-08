package com.hello.javase.functional.ordersave;

public class NosqlOrder implements OrderService{
    @Override
    public void saveOrder(Long orderId) {
        System.out.println("save order to nosql");
    }
}
