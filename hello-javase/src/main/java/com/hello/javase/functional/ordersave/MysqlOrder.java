package com.hello.javase.functional.ordersave;

public class MysqlOrder implements OrderService{
    @Override
    public void saveOrder(Long orderId) {
        System.out.println("save order to mysql");
    }
}
