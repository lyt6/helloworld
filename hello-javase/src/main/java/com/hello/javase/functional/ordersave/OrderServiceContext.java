package com.hello.javase.functional.ordersave;

public class OrderServiceContext {
    private final OrderService orderService;
    public OrderServiceContext(OrderService orderService) {
        this.orderService = orderService;
    }
    public void save(Long orderId){
        this.orderService.saveOrder(orderId);
    }
}
